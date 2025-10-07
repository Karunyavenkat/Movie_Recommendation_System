import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import '../styles/Navbar.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons';

export default function Navbar() {
  const [search, setSearch] = useState("");
  const [dropdownOpen, setDropdownOpen] = useState(false);
  const navigate = useNavigate();
  const username = localStorage.getItem("username");

  const handleSearch = (e) => {
    e.preventDefault();
    if (search.trim() !== "") {
      navigate(`/movies?search=${search}`);
      setSearch("");
    }
  };

  const handleLogout = () => {
    localStorage.removeItem("username");
    navigate("/login");
  };

  return (
    <nav className="navbar">
      <div className="nav-logo">
        Movie<span>Next</span>
      </div>

      <ul className="nav-links">
        <li><Link to="/">Home</Link></li>
        <li><Link to="/movies">Movies</Link></li>
        <li><Link to="/profile">Profile</Link></li>
        <li><Link to="/about">About</Link></li>
      </ul>

      <div className="nav-actions">
        <form className="search-form" onSubmit={handleSearch}>
          <input
            type="text"
            placeholder="Search movies..."
            value={search}
            onChange={(e) => setSearch(e.target.value)}
          />
          <button type="submit" className="search-btn">
            <FontAwesomeIcon icon={faMagnifyingGlass} />
          </button>
        </form>

        {username ? (
          <div className="profile-dropdown">
            <div 
              className="profile-icon" 
              onClick={() => setDropdownOpen(!dropdownOpen)}
            >
              {username.charAt(0).toUpperCase()}
            </div>
            {dropdownOpen && (
              <div className="dropdown-menu">
                <p className="dropdown-username">{username}</p>
                <button onClick={handleLogout}>Logout</button>
              </div>
            )}
          </div>
        ) : (
          <Link to="/login">
            <button className="btn-login">Login</button>
          </Link>
        )}
      </div>
    </nav>
  );
}
