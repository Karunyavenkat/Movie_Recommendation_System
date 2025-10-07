<<<<<<< HEAD
package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.Modal.Movie;
import com.example.demo.Modal.User;
import com.example.demo.Repository.MovieRepository;

@Service
public class MovieService {
	private final MovieRepository movieRepo;

    public MovieService(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    public List<Movie> getAll() {
        return movieRepo.findAll();
    }

    public Movie getById(Long id) {
        return movieRepo.findById(id).orElse(null);
    }

    public Movie save(Movie movie) {
        return movieRepo.save(movie);
    }

    public void delete(Long id) {
    	movieRepo.deleteById(id);
    }

 // Recommendation logic
    public List<Movie> recommendMovies(User user) {
        List<Movie> allMovies = movieRepo.findAll();

        final List<Movie> watchlist = (user.getWatchlist() != null) ? user.getWatchlist() : new ArrayList<>();

        return allMovies.stream()
                .filter(m -> watchlist.stream().noneMatch(w -> w.getId().equals(m.getId())))
                .filter(m -> watchlist.stream()
                        .anyMatch(w -> w.getGenres().equals(m.getGenres()) || w.getDirector().equals(m.getDirector()))
                )
                .collect(Collectors.toList());
    }


}
=======
package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.Modal.Movie;
import com.example.demo.Modal.User;
import com.example.demo.Repository.MovieRepository;

@Service
public class MovieService {
	private final MovieRepository movieRepo;

    public MovieService(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    public List<Movie> getAll() {
        return movieRepo.findAll();
    }

    public Movie getById(Long id) {
        return movieRepo.findById(id).orElse(null);
    }

    public Movie save(Movie movie) {
        return movieRepo.save(movie);
    }

    public void delete(Long id) {
    	movieRepo.deleteById(id);
    }

 // Recommendation logic
    public List<Movie> recommendMovies(User user) {
        List<Movie> allMovies = movieRepo.findAll();

        final List<Movie> watchlist = (user.getWatchlist() != null) ? user.getWatchlist() : new ArrayList<>();

        return allMovies.stream()
                .filter(m -> watchlist.stream().noneMatch(w -> w.getId().equals(m.getId())))
                .filter(m -> watchlist.stream()
                        .anyMatch(w -> w.getGenres().equals(m.getGenres()) || w.getDirector().equals(m.getDirector()))
                )
                .collect(Collectors.toList());
    }


}
>>>>>>> 17e39ace98303ad11c221db7e8ab2bc0ca7685d6
