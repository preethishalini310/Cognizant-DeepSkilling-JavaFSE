import React, { useState } from "react";

// Fixed conversion rate used for the lab (approx. INR -> EUR)
const RUPEES_TO_EURO_RATE = 0.011;

function CurrencyConvertor() {
  const [rupees, setRupees] = useState("");
  const [euro, setEuro] = useState(null);

  const handleChange = (event) => {
    setRupees(event.target.value);
  };

  // handleSubmit is invoked on the Convert button's click event and
  // performs the conversion of Rupees to Euro.
  const handleSubmit = (event) => {
    event.preventDefault();
    const amount = parseFloat(rupees);
    if (!isNaN(amount)) {
      setEuro((amount * RUPEES_TO_EURO_RATE).toFixed(2));
    } else {
      setEuro(null);
    }
  };

  return (
    <div className="section">
      <h2>4. Currency Convertor (Rupees to Euro)</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Enter amount in Rupees"
          value={rupees}
          onChange={handleChange}
        />
        <button type="submit">Convert</button>
      </form>
      {euro !== null && (
        <p className="output">
          {rupees} INR = {euro} EUR
        </p>
      )}
    </div>
  );
}

export default CurrencyConvertor;
