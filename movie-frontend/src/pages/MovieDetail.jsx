import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import "../styles/MovieDetail.css";

const MovieDetails = () => {
  const { id } = useParams(); // movieId
  const [movie, setMovie] = useState(null);
  const [rating, setRating] = useState(0);
  const [message, setMessage] = useState("");
  const [showTrailer, setShowTrailer] = useState(false);

  // Fetch movie details from backend
  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/movies/${id}`)
      .then((res) => setMovie(res.data))
      .catch((err) => console.error("Error fetching movie:", err));
  }, [id]);

  useEffect(() => {
  if (movie) {
      setRating(movie.rating || Math.floor(Math.random() * 5) + 1);
    }
  }, [movie]);

  // Add movie to Watch Later
  const handleWatchLater = () => {
    const storedUserId = localStorage.getItem("userId");
    if (!storedUserId || storedUserId === "undefined") {
      alert("Please login first!");
      return;
    }

    axios
      .post(`http://localhost:8080/api/watchlater/${storedUserId}/${id}`)
      .then((res) => setMessage(res.data))
      .catch((err) => {
        console.error(err);
        setMessage("Failed to add to Watch Later");
      });
  };

  if (!movie) return <p>Loading...</p>;

  // const rating = movie.rating || Math.floor(Math.random() * 5) + 1;
  

  // Extract YouTube video ID from URL
  const getYouTubeId = (url) => {
    if (!url) return null;
    const regex =
      /(?:https?:\/\/)?(?:www\.)?(?:youtube\.com\/watch\?v=|youtu\.be\/)([^\s&]+)/;
    const match = url.match(regex);
    return match ? match[1] : null;
  };

  const youtubeId = getYouTubeId(movie.trailer_url || movie.trailerUrl);

  return (
    <div className="movie-details-page">
      {/* Poster */}
      <div className="movie-poster-container">
        <img
          src={movie.posterUrl || movie.poster_url}
          alt={movie.title}
          className="movie-details-poster"
        />
      </div>

      {/* Movie Info */}
      <div className="movie-details-info">
        <h1>{movie.title}</h1>
        <p>
          <strong>Genres:</strong> {movie.genres}
        </p>
        <p>
          <strong>Year:</strong> {movie.year}
        </p>
        <p>
          <strong>Director:</strong> {movie.director}
        </p>
        <p>
          <strong>Description:</strong> {movie.description}
        </p>
        {/* <p>
          <strong>Rating:</strong> {"⭐".repeat(rating)} ({rating}/5)
        </p> */}
        <p><strong>Rating:</strong> {"⭐".repeat(rating)} ({rating}/5)</p>


        <div className="movie-buttons">
          <button className="watch-later-btn" onClick={handleWatchLater}>
            ➕ Watch Later
          </button>
          {message && <span className="watch-later-msg">{message}</span>}
          {youtubeId && (
            <button
              className="trailer-btn"
              onClick={() => setShowTrailer(true)}
            >
              ▶ Watch Trailer
            </button>
          )}
        </div>
      </div>

      {/* Trailer Modal */}
      {showTrailer && youtubeId && (
        <div
          className="trailer-modal"
          onClick={() => setShowTrailer(false)}
        >
          <iframe
            width="800"
            height="450"
            src={`https://www.youtube.com/embed/${youtubeId}?autoplay=1`}
            title={movie.title + " Trailer"}
            frameBorder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowFullScreen
            onClick={(e) => e.stopPropagation()} // prevent modal close when clicking inside
          ></iframe>
        </div>
      )}
    </div>
  );
};

export default MovieDetails;
