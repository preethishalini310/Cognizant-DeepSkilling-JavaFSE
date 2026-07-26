import React, { Component } from "react";

// Class component - demonstrates use of the "this" keyword to bind
// event handlers and access component state.
class Counter extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
      greeting: ""
    };

    // Bind "this" so it refers to the component instance inside the handlers
    this.increment = this.increment.bind(this);
    this.decrement = this.decrement.bind(this);
    this.sayHello = this.sayHello.bind(this);
  }

  increment() {
    // Uses "this.setState" to update the counter value
    this.setState((prevState) => ({ count: prevState.count + 1 }));
  }

  decrement() {
    this.setState((prevState) => ({ count: prevState.count - 1 }));
  }

  sayHello() {
    this.setState({ greeting: "Hello! Counter was incremented." });
  }

  // The Increment button invokes two methods on a single click:
  // it increments the counter AND displays a static greeting message.
  handleIncrementClick = () => {
    this.increment();
    this.sayHello();
  };

  render() {
    return (
      <div className="section">
        <h2>1. Counter with Increment / Decrement</h2>
        <p>
          Counter value: <span className="counter-value">{this.state.count}</span>
        </p>
        <button onClick={this.handleIncrementClick}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>
        {this.state.greeting && <p className="output">{this.state.greeting}</p>}
      </div>
    );
  }
}

export default Counter;
