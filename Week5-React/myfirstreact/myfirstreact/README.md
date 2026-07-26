# myfirstreact

A minimal React application created as part of the "ReactJS Hands-On Lab" exercise.

## Objective

Create a new React application named **myfirstreact** that displays the heading:

> Welcome to the first session of React

## Prerequisites

- Node.js
- NPM
- Visual Studio Code

## Setup

1. Install Node.js and NPM: https://nodejs.org/en/download/
2. Install create-react-app globally:
   ```
   npm install -g create-react-app
   ```
3. Create the app:
   ```
   npx create-react-app myfirstreact
   ```
4. Move into the project folder:
   ```
   cd myfirstreact
   ```
5. Open the folder in Visual Studio Code.
6. Open `src/App.js` and replace its contents with:
   ```jsx
   import React from 'react';

   function App() {
     return (
       <div className="App">
         <h1>Welcome to the first session of React</h1>
       </div>
     );
   }

   export default App;
   ```
7. Run the app:
   ```
   npm start
   ```
8. Open a browser window at `http://localhost:3000` to see the result.

## Scripts

- `npm start` — runs the app in development mode
- `npm run build` — builds the app for production
