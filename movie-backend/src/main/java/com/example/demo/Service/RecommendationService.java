package com.example.demo.Service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.Modal.Movie;
import com.example.demo.Modal.User;
import com.example.demo.Modal.WatchLater;
import com.example.demo.Repository.MovieRepository;
import com.example.demo.Repository.WatchLaterRepository;

@Service
public class RecommendationService {

    private final WatchLaterRepository watchLaterRepository;
    private final MovieRepository movieRepository;

    public RecommendationService(WatchLaterRepository watchLaterRepository, MovieRepository movieRepository) {
        this.watchLaterRepository = watchLaterRepository;
        this.movieRepository = movieRepository;
    }

    // Get recommended movies for a user
    public List<Movie> getRecommendations(Long userId) {
        // 1️⃣ Get all movies the user has added
        List<WatchLater> userWatchLater = watchLaterRepository.findAll()
                .stream()
                .filter(wl -> wl.getUser().getId().equals(userId))
                .collect(Collectors.toList());

        if (userWatchLater.isEmpty()) {
            return Collections.emptyList();
        }

        // 2️⃣ Collect genres and directors from user list
        Set<String> preferredGenres = new HashSet<>();
        Set<String> preferredDirectors = new HashSet<>();
        for (WatchLater wl : userWatchLater) {
            String[] genres = wl.getMovie().getGenres().split(","); // assuming comma-separated
            preferredGenres.addAll(Arrays.asList(genres));
            preferredDirectors.add(wl.getMovie().getDirector());
        }

        // 3️⃣ Get all movies not already in user's Watch Later
        Set<Long> userMovieIds = userWatchLater.stream()
                .map(wl -> wl.getMovie().getId())
                .collect(Collectors.toSet());

        List<Movie> candidateMovies = movieRepository.findAll()
                .stream()
                .filter(m -> !userMovieIds.contains(m.getId()))
                .collect(Collectors.toList());

        // 4️⃣ Score movies based on matching genre/director
        Map<Movie, Integer> movieScores = new HashMap<>();
        for (Movie m : candidateMovies) {
            int score = 0;

            // match genres
            String[] genres = m.getGenres().split(",");
            for (String g : genres) {
                if (preferredGenres.contains(g.trim())) score += 2; // genre weight
            }

            // match director
            if (preferredDirectors.contains(m.getDirector())) score += 3; // director weight

            if (score > 0) movieScores.put(m, score);
        }

        // 5️⃣ Sort by score descending
        return movieScores.entrySet()
                .stream()
                .sorted(Map.Entry.<Movie, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(10) // return top 10 recommendations
                .collect(Collectors.toList());
    }
}
