import axios from "axios";

const API_URL = "http://localhost:8080/api"; // Spring Boot backend

const API = axios.create({
  baseURL: "http://localhost:8080/api", // Spring Boot backend
});

export const getMovies = () => API.get("/movies");
export const getMovieById = (id) => API.get(`/movies/${id}`);