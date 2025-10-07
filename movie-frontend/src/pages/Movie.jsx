import React, { useEffect, useState } from "react";
import axios from "axios";
import MovieCard from "../components/MovieCard";
import "../styles/Movies.css";
import { useLocation } from "react-router-dom";

const Movies = () => {
  const [movies, setMovies] = useState([]);
  const [filteredMovies, setFilteredMovies] = useState([]);
  const location = useLocation();

  // Fetch all movies
  useEffect(() => {
    axios
      .get("http://localhost:8080/api/movies")
      .then((res) => {
        setMovies(res.data);
        setFilteredMovies(res.data);
      })
      .catch((err) => console.error(err));
  }, []);

  // Filter movies based on search query
  useEffect(() => {
    const query = new URLSearchParams(location.search).get("search");
    if (query) {
      const filtered = movies.filter(movie =>
        movie.title.toLowerCase().includes(query.toLowerCase())
      );
      setFilteredMovies(filtered);
    } else {
      setFilteredMovies(movies);
    }
  }, [location.search, movies]);

  return (
    <div className="movies-page">
      <h1>All Movies</h1>
      <div className="movies-container">
        {filteredMovies.map((movie) => (
          <MovieCard key={movie.id} movie={movie} />
        ))}
      </div>
    </div>
  );
};

export default Movies;
