import React from "react";

// Two small components, one shown at a time depending on auth state -
// a classic conditional rendering pattern.
function LoginButton({ onClick }) {
  return <button onClick={onClick}>Login</button>;
}

function LogoutButton({ onClick }) {
  return (
    <button className="logout-btn" onClick={onClick}>
      Logout
    </button>
  );
}

// Element variable: we build up the button to render in a variable, then
// return that single variable in the JSX below.
function LoginControl({ isLoggedIn, onLogin, onLogout }) {
  let button;
  if (isLoggedIn) {
    button = <LogoutButton onClick={onLogout} />;
  } else {
    button = <LoginButton onClick={onLogin} />;
  }

  return <div className="auth-bar">{button}</div>;
}

export default LoginControl;
