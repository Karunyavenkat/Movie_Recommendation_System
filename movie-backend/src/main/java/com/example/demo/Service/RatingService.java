package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Modal.Rating;
import com.example.demo.Repository.RatingRepository;

@Service
public class RatingService {
	private final RatingRepository repo;

    public RatingService(RatingRepository repo) {
        this.repo = repo;
    }

    public List<Rating> getAll() {
        return repo.findAll();
    }

    public Rating getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Rating save(Rating rating) {
        return repo.save(rating);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Rating> getByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public List<Rating> getByMovie(Long movieId) {
        return repo.findByMovieId(movieId);
    }
}
