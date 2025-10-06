package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modal.User;
import com.example.demo.Modal.WatchLater;

@Repository
public interface WatchLaterRepository extends JpaRepository<WatchLater, Long> {

	List<WatchLater> findByMovieId(Long movieId);

	Optional<WatchLater> findByMovieIdAndUserId(Long movieId, Long userId);

	List<WatchLater> findByUserId(Long userId);

}
