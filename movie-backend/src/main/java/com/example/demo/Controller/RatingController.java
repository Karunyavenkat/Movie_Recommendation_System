package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modal.Rating;
import com.example.demo.Service.RatingService;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
	private final RatingService service;

    public RatingController(RatingService service) {
        this.service = service;
    }

    @GetMapping
    public List<Rating> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Rating getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Rating create(@RequestBody Rating rating) {
        return service.save(rating);
    }

    @PutMapping("/{id}")
    public Rating update(@PathVariable Long id, @RequestBody Rating rating) {
        rating.setId(id);
        return service.save(rating);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/user/{userId}")
    public List<Rating> getByUser(@PathVariable Long userId) {
        return service.getByUser(userId);
    }

    @GetMapping("/movie/{movieId}")
    public List<Rating> getByMovie(@PathVariable Long movieId) {
        return service.getByMovie(movieId);
    }
}
