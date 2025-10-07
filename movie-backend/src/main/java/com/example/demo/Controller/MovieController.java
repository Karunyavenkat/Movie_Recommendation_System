<<<<<<< HEAD
package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modal.Movie;
import com.example.demo.Modal.User;
import com.example.demo.Service.MovieService;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/api/movies")
//@CrossOrigin(origins = "http://localhost:5173")
public class MovieController {
	private final MovieService movieService;
	private final UserService userService;

	public MovieController(MovieService movieService, UserService userService) {
        this.movieService = movieService;
        this.userService = userService;
    }

    @GetMapping
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable Long id) {
        return movieService.getById(id);
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @RequestBody Movie movie) {
        movie.setId(id);
        return movieService.save(movie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	movieService.delete(id);
    }
    
//
//    @GetMapping("/recommend/director/{director}")
//    public List<Movie> recommendByDirector(@PathVariable String director) {
//        return service.recommendByDirector(director);
//    }
//    @GetMapping("/recommend/user/{userId}")
//    public List<Movie> getRecommendedMovies(@PathVariable Long userId) {
//        return service.getRecommendedMoviesForUser(userId);
//    }
//
//    @GetMapping("/recommend/genre/{genre}")
//    public List<Movie> recommendByGenre(@PathVariable String genre) {
//        return service.recommendByGenre(genre);
//    }
    @GetMapping("/recommend/{userId}")
    public List<Movie> recommendMovies(@PathVariable Long userId) {
        User user = userService.getUserById(userId).orElseThrow();
        return movieService.recommendMovies(user);
    }

}
=======
package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modal.Movie;
import com.example.demo.Modal.User;
import com.example.demo.Service.MovieService;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/api/movies")
//@CrossOrigin(origins = "http://localhost:5173")
public class MovieController {
	private final MovieService movieService;
	private final UserService userService;

	public MovieController(MovieService movieService, UserService userService) {
        this.movieService = movieService;
        this.userService = userService;
    }

    @GetMapping
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable Long id) {
        return movieService.getById(id);
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @RequestBody Movie movie) {
        movie.setId(id);
        return movieService.save(movie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	movieService.delete(id);
    }
    
//
//    @GetMapping("/recommend/director/{director}")
//    public List<Movie> recommendByDirector(@PathVariable String director) {
//        return service.recommendByDirector(director);
//    }
//    @GetMapping("/recommend/user/{userId}")
//    public List<Movie> getRecommendedMovies(@PathVariable Long userId) {
//        return service.getRecommendedMoviesForUser(userId);
//    }
//
//    @GetMapping("/recommend/genre/{genre}")
//    public List<Movie> recommendByGenre(@PathVariable String genre) {
//        return service.recommendByGenre(genre);
//    }
    @GetMapping("/recommend/{userId}")
    public List<Movie> recommendMovies(@PathVariable Long userId) {
        User user = userService.getUserById(userId).orElseThrow();
        return movieService.recommendMovies(user);
    }

}
>>>>>>> 17e39ace98303ad11c221db7e8ab2bc0ca7685d6
