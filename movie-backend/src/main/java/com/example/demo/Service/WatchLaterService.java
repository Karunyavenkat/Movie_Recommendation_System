<<<<<<< HEAD
package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Modal.Movie;
import com.example.demo.Modal.User;
import com.example.demo.Modal.WatchLater;
import com.example.demo.Repository.MovieRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.WatchLaterRepository;

@Service
public class WatchLaterService {
	@Autowired
    private WatchLaterRepository watchLaterRepository;

    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private UserRepository userRepository;

    // Add a movie to watch later
    public String addToWatchLater(Long userId, Long movieId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        boolean exists = watchLaterRepository.findByMovieIdAndUserId(movieId, userId).isPresent();
        if (exists) return "Movie already in Watch Later";

        WatchLater wl = new WatchLater();
        wl.setMovie(movie);
        wl.setUser(user);
        watchLaterRepository.save(wl);

        return "Added to Watch Later";
    }

//    // Get all movies in watch later list for a specific user
//    public List<Movie> getWatchLaterMovies(Long userId) {
//        return watchLaterRepository.findByUserId(userId)
//                .stream()
//                .map(WatchLater::getMovie)
//                .collect(Collectors.toList());
//    }
    
 // Get all movies in watch later list for a specific user
    public List<Movie> getWatchLaterMoviesByUser(Long userId) {
        return watchLaterRepository.findAll()
                .stream()
                .filter(wl -> wl.getUser().getId().equals(userId)) // only this user
                .map(WatchLater::getMovie)
                .collect(Collectors.toList());
    }


    
 // Remove a movie from a user's watch later list
    public String removeFromWatchLater(Long movieId, Long userId) {
        // Fetch the entry for this user and movie
        WatchLater watchLater = watchLaterRepository
                .findByMovieIdAndUserId(movieId, userId)
                .orElseThrow(() -> new RuntimeException("Movie not found in your Watch Later list"));

        // Delete it
        watchLaterRepository.delete(watchLater);
        return "Movie removed from Watch Later successfully";
    }
}
=======
package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Modal.Movie;
import com.example.demo.Modal.User;
import com.example.demo.Modal.WatchLater;
import com.example.demo.Repository.MovieRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.WatchLaterRepository;

@Service
public class WatchLaterService {
	@Autowired
    private WatchLaterRepository watchLaterRepository;

    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private UserRepository userRepository;

    // Add a movie to watch later
    public String addToWatchLater(Long userId, Long movieId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        boolean exists = watchLaterRepository.findByMovieIdAndUserId(movieId, userId).isPresent();
        if (exists) return "Movie already in Watch Later";

        WatchLater wl = new WatchLater();
        wl.setMovie(movie);
        wl.setUser(user);
        watchLaterRepository.save(wl);

        return "Added to Watch Later";
    }

//    // Get all movies in watch later list for a specific user
//    public List<Movie> getWatchLaterMovies(Long userId) {
//        return watchLaterRepository.findByUserId(userId)
//                .stream()
//                .map(WatchLater::getMovie)
//                .collect(Collectors.toList());
//    }
    
 // Get all movies in watch later list for a specific user
    public List<Movie> getWatchLaterMoviesByUser(Long userId) {
        return watchLaterRepository.findAll()
                .stream()
                .filter(wl -> wl.getUser().getId().equals(userId)) // only this user
                .map(WatchLater::getMovie)
                .collect(Collectors.toList());
    }


    
 // Remove a movie from a user's watch later list
    public String removeFromWatchLater(Long movieId, Long userId) {
        // Fetch the entry for this user and movie
        WatchLater watchLater = watchLaterRepository
                .findByMovieIdAndUserId(movieId, userId)
                .orElseThrow(() -> new RuntimeException("Movie not found in your Watch Later list"));

        // Delete it
        watchLaterRepository.delete(watchLater);
        return "Movie removed from Watch Later successfully";
    }
}
>>>>>>> 17e39ace98303ad11c221db7e8ab2bc0ca7685d6
