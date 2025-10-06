package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Modal.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	List<Movie> findByGenres(String genres);
    List<Movie> findByDirector(String director);

}
