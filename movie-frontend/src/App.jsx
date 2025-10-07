import React, { useEffect, useState } from "react";
import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import Navbar from "./components/Navbar";
import Home from "./pages/Home";
import MovieDetail from "./pages/MovieDetail";
import Footer from "./components/Footer";
import Profile from "./pages/Profile";
import Movies from "./pages/Movie";
import Login from "./pages/Login";
import Signup from "./pages/Signup";


function App() {
  // const [user, setUser] = useState(null);
  const [user, setUser] = useState(localStorage.getItem("username"));

  useEffect(() => {
  if (user) {
    localStorage.setItem("username", user);
  } else {
    localStorage.removeItem("username");
  }
}, [user]);

 return (
    <BrowserRouter>
      <Navbar /> {/* Always renders */}
      
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/movies" element={<Movies />} />
        <Route path="/movies/:id" element={<MovieDetail />} />
        <Route path="/login" element={<Login setUser={setUser} />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/profile" element={<Profile />} />
        {/* <Route path="/profile" element={user ? <Profile user={user} /> : <Navigate to="/login" />} /> */}
        <Route
  path="/profile"
  element={user ? <Profile user={user} /> : <Navigate to="/login" />}
/>

      </Routes>

      <Footer /> {/* Always renders */}
    </BrowserRouter>
  );
}

export default App;
