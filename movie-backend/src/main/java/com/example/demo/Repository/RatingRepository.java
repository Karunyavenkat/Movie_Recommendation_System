<<<<<<< HEAD
package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Modal.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long>{
	List<Rating> findByUserId(Long userId);
    List<Rating> findByMovieId(Long movieId);
}
=======
package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Modal.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long>{
	List<Rating> findByUserId(Long userId);
    List<Rating> findByMovieId(Long movieId);
}
>>>>>>> 17e39ace98303ad11c221db7e8ab2bc0ca7685d6
