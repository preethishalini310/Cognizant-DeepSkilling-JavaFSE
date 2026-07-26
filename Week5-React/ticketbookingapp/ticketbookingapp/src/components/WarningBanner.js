import React from "react";

// Demonstrates "preventing a component from rendering": when showWarning
// is false, the component returns null instead of JSX, so nothing is
// rendered to the DOM at all (not even an empty wrapper element).
function WarningBanner({ showWarning }) {
  if (!showWarning) {
    return null;
  }

  return (
    <div className="warning-banner">
      ⚠ Flight prices and timings shown here are indicative and may change.
    </div>
  );
}

export default WarningBanner;
