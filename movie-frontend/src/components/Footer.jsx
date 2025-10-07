import React from "react";
import '../styles//Footer.css'

export default function Footer() {
   return (
    <footer className="footer">
      <div className="footer-content">
        <div className="footer-logo">
          Movie<span>Next</span>
        </div>

        <ul className="footer-links">
          <li><a href="/">Home</a></li>
          <li><a href="/movies">Movies</a></li>
          <li><a href="/profile">Profile</a></li>
          <li><a href="/about">About</a></li>
        </ul>

        <div className="footer-socials">
          <a href="https://facebook.com" target="_blank" rel="noreferrer">📘</a>
          <a href="https://twitter.com" target="_blank" rel="noreferrer">🐦</a>
          <a href="https://instagram.com" target="_blank" rel="noreferrer">📸</a>
          <a href="https://youtube.com" target="_blank" rel="noreferrer">▶️</a>
        </div>
      </div>

      <div className="footer-bottom">
        <p>© {new Date().getFullYear()} MovieNext. All Rights Reserved.</p>
      </div>
    </footer>
  );
}
