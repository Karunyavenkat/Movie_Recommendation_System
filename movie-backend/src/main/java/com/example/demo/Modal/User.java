<<<<<<< HEAD
package com.example.demo.Modal;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, unique = true)
    private String username;
    private String email;
    private String password;
    
 // Watchlist: movies user has already watched or added
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_watchlist",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> watchlist;
    
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Movie> getWatchlist() {
	    return watchlist;
	}
	public void setWatchlist(List<Movie> watchlist) {
	    this.watchlist = watchlist;
	}
}
=======
package com.example.demo.Modal;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, unique = true)
    private String username;
    private String email;
    private String password;
    
 // Watchlist: movies user has already watched or added
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_watchlist",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> watchlist;
    
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Movie> getWatchlist() {
	    return watchlist;
	}
	public void setWatchlist(List<Movie> watchlist) {
	    this.watchlist = watchlist;
	}
}
>>>>>>> 17e39ace98303ad11c221db7e8ab2bc0ca7685d6
