<<<<<<< HEAD
package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modal.Movie;
import com.example.demo.Service.WatchLaterService;

@RestController
@RequestMapping("/api/watchlater")
//@CrossOrigin(origins = "http://localhost:5173")
public class WatchLaterController {
	@Autowired
    private WatchLaterService watchLaterService;

	// Add movie
	@PostMapping("/{userId}/{movieId}")
	public ResponseEntity<String> addToWatchLater(@PathVariable Long userId, @PathVariable Long movieId) {
	    return ResponseEntity.ok(watchLaterService.addToWatchLater(userId, movieId));
	}

//	@GetMapping("/{userId}")
//	public ResponseEntity<List<Movie>> getWatchLater(@PathVariable Long userId) {
//	    return ResponseEntity.ok(watchLaterService.getWatchLaterMovies(userId));
//	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Movie>> getWatchLaterByUser(@PathVariable Long userId) {
	    return ResponseEntity.ok(watchLaterService.getWatchLaterMoviesByUser(userId));
	}

	 @DeleteMapping("/{movieId}/{userId}")
	    public ResponseEntity<String> removeFromWatchLater(@PathVariable Long movieId,
	                                                       @PathVariable Long userId) {
	        String message = watchLaterService.removeFromWatchLater(movieId, userId);
	        return ResponseEntity.ok(message);
	    }

}
=======
package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modal.Movie;
import com.example.demo.Service.WatchLaterService;

@RestController
@RequestMapping("/api/watchlater")
//@CrossOrigin(origins = "http://localhost:5173")
public class WatchLaterController {
	@Autowired
    private WatchLaterService watchLaterService;

	// Add movie
	@PostMapping("/{userId}/{movieId}")
	public ResponseEntity<String> addToWatchLater(@PathVariable Long userId, @PathVariable Long movieId) {
	    return ResponseEntity.ok(watchLaterService.addToWatchLater(userId, movieId));
	}

//	@GetMapping("/{userId}")
//	public ResponseEntity<List<Movie>> getWatchLater(@PathVariable Long userId) {
//	    return ResponseEntity.ok(watchLaterService.getWatchLaterMovies(userId));
//	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Movie>> getWatchLaterByUser(@PathVariable Long userId) {
	    return ResponseEntity.ok(watchLaterService.getWatchLaterMoviesByUser(userId));
	}

	 @DeleteMapping("/{movieId}/{userId}")
	    public ResponseEntity<String> removeFromWatchLater(@PathVariable Long movieId,
	                                                       @PathVariable Long userId) {
	        String message = watchLaterService.removeFromWatchLater(movieId, userId);
	        return ResponseEntity.ok(message);
	    }

}
>>>>>>> 17e39ace98303ad11c221db7e8ab2bc0ca7685d6
