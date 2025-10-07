<<<<<<< HEAD
package com.example.demo.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "watch_later")
public class WatchLater {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to the movie
    @ManyToOne
    @JoinColumn(name = "movie_id", unique = false) // prevents duplicates at DB level
    private Movie movie;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	
}
=======
package com.example.demo.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "watch_later")
public class WatchLater {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to the movie
    @ManyToOne
    @JoinColumn(name = "movie_id", unique = false) // prevents duplicates at DB level
    private Movie movie;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	
}
>>>>>>> 17e39ace98303ad11c221db7e8ab2bc0ca7685d6
