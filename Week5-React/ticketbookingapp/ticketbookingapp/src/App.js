import React, { useState } from "react";
import "./index.css";
import LoginControl from "./components/LoginControl";
import GuestPage from "./components/GuestPage";
import UserPage from "./components/UserPage";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  return (
    <div className="App">
      <h1>Flight Ticket Booking</h1>

      <LoginControl
        isLoggedIn={isLoggedIn}
        onLogin={handleLogin}
        onLogout={handleLogout}
      />

      {/*
        Conditional rendering: the Guest page is shown while the user is
        not logged in; once logged in, the User page (with booking
        capability) is shown instead.
      */}
      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;
