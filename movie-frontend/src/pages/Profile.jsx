import React, { useEffect, useState } from "react";
import axios from "axios";
import MovieCard from "../components/MovieCard";
import "../styles/Profile.css";

const Profile = ({ user }) => {
  const username = user || localStorage.getItem("username");
  const userId = localStorage.getItem("userId"); // ✅ get logged-in user
  const avatarUrl = `https://ui-avatars.com/api/?name=${username}&background=random&rounded=true`;

  const [watchLaterMovies, setWatchLaterMovies] = useState([]);

  const fetchWatchLater = () => {
    if (!userId) return; // safety check

    axios.get(`http://localhost:8080/api/watchlater/user/${userId}`)
      .then(res => setWatchLaterMovies(res.data))
      .catch(err => console.error(err));
  };

  useEffect(() => {
    fetchWatchLater();
  }, [userId]);

  const handleRemove = (movieId) => {
  if (!userId) return;

  axios.delete(`http://localhost:8080/api/watchlater/${movieId}/${userId}`)
    .then(() => fetchWatchLater())
    .catch(err => console.error(err));
};


  return (
    <div className="profile-page">
      <div className="profile-header">
        <img src={avatarUrl} alt={username} className="profile-avatar" />
        <h2>{username}</h2>
      </div>

      <h1>My Watch Later List</h1>
      {watchLaterMovies.length === 0 ? (
        <p>No movies added to Watch Later yet.</p>
      ) : (
        <div className="movies-container-horizontal">
          {watchLaterMovies.map(movie => (
            <div key={movie.id} className="movie-card-wrapper">
              <MovieCard movie={movie} />
              <button
                className="remove-btn"
                onClick={() => handleRemove(movie.id)}
              >
                Remove
              </button>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default Profile;
