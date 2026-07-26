import React, { useState } from "react";

// Demonstrates React's SyntheticEvent - the cross-browser wrapper React
// provides around the browser's native event on every event handler.
function SyntheticEventDemo() {
  const [clicked, setClicked] = useState(false);

  // "event" here is a React SyntheticEvent, not the raw DOM event.
  const handlePress = (event) => {
    // event.type -> "click", event.target -> the button element, etc.
    console.log("SyntheticEvent type:", event.type);
    setClicked(true);
  };

  return (
    <div className="section">
      <h2>3. Synthetic Event (OnPress)</h2>
      <button onClick={handlePress}>Press Me</button>
      {clicked && <p className="output">I was clicked</p>}
    </div>
  );
}

export default SyntheticEventDemo;
