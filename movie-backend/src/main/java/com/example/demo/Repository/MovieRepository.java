<<<<<<< HEAD
package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Modal.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	List<Movie> findByGenres(String genres);
    List<Movie> findByDirector(String director);

}
=======
package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Modal.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	List<Movie> findByGenres(String genres);
    List<Movie> findByDirector(String director);

}
>>>>>>> 17e39ace98303ad11c221db7e8ab2bc0ca7685d6
