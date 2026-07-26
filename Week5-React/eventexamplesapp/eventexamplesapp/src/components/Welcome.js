import React, { useState } from "react";

// Functional component - demonstrates passing an argument to an event handler
function Welcome() {
  const [message, setMessage] = useState("");

  // handleWelcome receives "welcome" as an argument via an arrow function
  // wrapper: onClick={() => handleWelcome("welcome")}
  const handleWelcome = (text) => {
    setMessage(`Say ${text}! Welcome to React events.`);
  };

  return (
    <div className="section">
      <h2>2. Say Welcome (passing an argument)</h2>
      <button onClick={() => handleWelcome("welcome")}>Say Welcome</button>
      {message && <p className="output">{message}</p>}
    </div>
  );
}

export default Welcome;
