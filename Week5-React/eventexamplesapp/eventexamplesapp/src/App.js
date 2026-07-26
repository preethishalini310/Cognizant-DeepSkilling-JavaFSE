import React from "react";
import "./App.css";
import Counter from "./components/Counter";
import Welcome from "./components/Welcome";
import SyntheticEventDemo from "./components/SyntheticEventDemo";
import CurrencyConvertor from "./components/CurrencyConvertor";

function App() {
  return (
    <div className="App">
      <h1>React Events - Hands-on Lab</h1>
      <Counter />
      <Welcome />
      <SyntheticEventDemo />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
