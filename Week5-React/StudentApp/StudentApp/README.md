# StudentApp

A React application for a **Student Management Portal**, built as part of the "ReactJS Hands-On Lab" exercise on components.

## Objective

Create a React app named **StudentApp** with three class components:

- **Home** → displays "Welcome to the Home Page of Student Management Portal"
- **About** → displays "Welcome to the About Page of Student Management Portal"
- **Contact** → displays "Welcome to the Contact Page of Student Management Portal"

All three components are rendered together from `App.js`.

## Prerequisites

- Node.js
- NPM
- Visual Studio Code

## Project Structure

```
StudentApp/
├── public/
│   └── index.html
├── src/
│   ├── Components/
│   │   ├── Home.js
│   │   ├── About.js
│   │   └── Contact.js
│   ├── App.js
│   ├── App.css
│   └── index.js
├── package.json
└── .gitignore
```

## Setup

1. Create the React project:
   ```
   npx create-react-app StudentApp
   ```
2. Inside `src`, create a folder named `Components`.
3. Add `Home.js`, `About.js`, and `Contact.js` inside `src/Components`, each as a class component with a `render()` method returning its welcome message.
4. Edit `App.js` to import and render `Home`, `About`, and `Contact`.
5. Run the app:
   ```
   npm start
   ```
6. Open a browser at `http://localhost:3000` to see all three messages rendered on the page.

## Scripts

- `npm start` — runs the app in development mode
- `npm run build` — builds the app for production
