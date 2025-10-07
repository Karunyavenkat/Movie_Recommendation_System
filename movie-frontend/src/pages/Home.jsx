import React, { useEffect, useState } from "react";
import Slider from "react-slick";
import axios from "axios";
import MovieCard from "../components/MovieCard";

const Home = () => {
  const [recommendedMovies, setRecommendedMovies] = useState([]);

  const userId = localStorage.getItem("userId"); // ✅ logged-in user

  // 🔹 Static featured movies (slider)
  const featuredMovies = [
    { id: 1, title: "Movie 1", posterUrl: "https://image.tmdb.org/t/p/original/dYImzEquIZglfzDnJlHYdlUIeSo.jpg" },
    { id: 2, title: "Movie 2", posterUrl: "https://images.ottplay.com/images/arvind-swami-and-karthi-in-meiyazhagan-1729602037.jpg?impolicy=ottplay-20210210&width=1200&height=675" },
    { id: 3, title: "Movie 3", posterUrl: "https://wallpapercave.com/wp/wp8218910.jpg" },
    { id: 4, title: "Movie 4", posterUrl: "https://th.bing.com/th/id/R.cce1c5957b8550f733f2154c72dd5cac?rik=HfvdPlX%2fE5tFnw&riu=http%3a%2f%2fonlookersmedia.in%2fwp-content%2fuploads%2f2020%2f12%2fthalapathy-vijay-master-new-posters-2.jpg&ehk=%2fLznPhM1IrMvrCLW7mTK33KYunZ1gSmXf2ahS5MNmX4%3d&risl=&pid=ImgRaw&r=0" }
  ];

  // 🔹 Fetch recommended movies for the logged-in user
  useEffect(() => {
    if (!userId) return; // not logged in

    axios
      .get(`http://localhost:8080/api/recommendations/${userId}`)
      .then((res) => setRecommendedMovies(res.data))
      .catch((err) => console.error("Error fetching recommendations:", err));
  }, [userId]);

  // 🔹 Slider config
  const sliderSettings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3000,
  };

  return (
    <div className="home-page" style={{ padding: "20px" }}>
      <h1 style={{ textAlign: "center" }}>Welcome to Movie Hub</h1>

      {/* 🔹 Featured movies slider */}
      <Slider {...sliderSettings}>
  {featuredMovies.map((movie) => (
    <div key={movie.id}>
      <img
        src={movie.posterUrl}
        alt={movie.title}
        style={{ width: "100%", height: "400px", objectFit: "cover", borderRadius: "10px" }}
      />
      {/* Removed the title */}
    </div>
  ))}
</Slider>

      {/* 🔹 Recommended Movies Section */}
      <div style={{ marginTop: "40px" }}>
        <h2>🎬 Recommended for You</h2>
        <div style={{ display: "flex", flexWrap: "wrap", gap: "20px" }}>
          {recommendedMovies.length > 0 ? (
            recommendedMovies.map((movie) => (
              <MovieCard key={movie.id} movie={movie} />
            ))
          ) : (
            <p>No recommendations available.</p>
          )}
        </div>
      </div>
    </div>
  );
};

export default Home;
