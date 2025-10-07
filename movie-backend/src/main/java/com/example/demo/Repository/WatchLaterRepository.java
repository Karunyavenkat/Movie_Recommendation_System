<<<<<<< HEAD
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
=======
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
>>>>>>> 17e39ace98303ad11c221db7e8ab2bc0ca7685d6
