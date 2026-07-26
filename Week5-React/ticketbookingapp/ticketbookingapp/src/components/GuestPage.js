import React, { useState } from "react";
import flights from "./flightData";
import WarningBanner from "./WarningBanner";

// Guest users can only browse flight details - no booking action available.
function GuestPage() {
  const [showWarning, setShowWarning] = useState(true);

  return (
    <div className="page">
      <h2>Available Flights (Guest View)</h2>
      <WarningBanner showWarning={showWarning} />
      <button onClick={() => setShowWarning((prev) => !prev)}>
        {showWarning ? "Hide" : "Show"} Warning
      </button>

      <table>
        <thead>
          <tr>
            <th>From</th>
            <th>To</th>
            <th>Airline</th>
            <th>Time</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {flights.map((flight) => (
            <tr key={flight.id}>
              <td>{flight.from}</td>
              <td>{flight.to}</td>
              <td>{flight.airline}</td>
              <td>{flight.time}</td>
              <td>{flight.price}</td>
            </tr>
          ))}
        </tbody>
      </table>

      <p className="status">Please login to book a ticket.</p>
    </div>
  );
}

export default GuestPage;
