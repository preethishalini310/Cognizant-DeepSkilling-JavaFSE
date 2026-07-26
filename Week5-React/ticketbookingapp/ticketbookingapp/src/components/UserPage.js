import React, { useState } from "react";
import flights from "./flightData";
import WarningBanner from "./WarningBanner";

// Logged-in users see the same flight list, but can also book a ticket.
function UserPage() {
  const [showWarning, setShowWarning] = useState(true);
  const [bookedId, setBookedId] = useState(null);

  const handleBook = (flight) => {
    setBookedId(flight.id);
  };

  return (
    <div className="page">
      <h2>Available Flights (Logged-in User View)</h2>
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
            <th></th>
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
              <td>
                <button className="book-btn" onClick={() => handleBook(flight)}>
                  Book
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {bookedId && (
        <p className="status">
          Ticket booked for flight #{bookedId}. Have a safe trip!
        </p>
      )}
    </div>
  );
}

export default UserPage;
