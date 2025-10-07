import React, { useState } from "react";
import axios from "axios";
import { useNavigate, Link } from "react-router-dom";
import "../styles/Auth.css";

const Login = ({ setUser }) => {
  const [email, setEmail] = useState(""); // email input
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    setError("");

    try {
      const res = await axios.post("http://localhost:8080/api/auth/login", {
        email,       // ✅ send email to backend
        password,
      });

      // Save user info in localStorage
      localStorage.setItem("userId", res.data.id);
      localStorage.setItem("username", res.data.username);
      setUser(res.data.username);

      navigate("/profile");
    } catch (err) {
      console.error(err);
      if (err.response && err.response.status === 401) {
        setError(err.response.data || "Invalid email or password");
      } else {
        setError("Login failed. Please try again.");
      }
    }
  };

  return (
    <div className="auth-page">
      <h2>Login</h2>
      <form onSubmit={handleLogin}>
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <button type="submit">Login</button>
      </form>

      {error && <p className="error">{error}</p>}

      <p className="auth-switch">
        Don&apos;t have an account? <Link to="/signup">Sign up here</Link>
      </p>
    </div>
  );
};

export default Login;

