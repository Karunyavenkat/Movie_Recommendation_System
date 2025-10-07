import React from "react";
import { useNavigate } from "react-router-dom";
import "../styles/MovieCard.css";

const MovieCard = ({ movie }) => {
  const navigate = useNavigate();

  return (
    <div
      className="movie-card"
      onClick={() => navigate(`/movies/${movie.id}`)}
    >
      <img src={movie.posterUrl} alt={movie.title} className="movie-poster" />
    </div>
  );
};

export default MovieCard;
