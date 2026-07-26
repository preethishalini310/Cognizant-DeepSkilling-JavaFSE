# officespacerentalapp

A React application demonstrating **JSX** — elements, attributes, expressions, and inline styling — built as part of the "ReactJS Hands-On Lab" exercise.

## Objectives

- Define JSX and `React.createElement()`
- Create React nodes with JSX
- Render JSX to the DOM
- Use JavaScript expressions inside JSX
- Use inline / conditional CSS in JSX

## What it does

- **JSX element** — `const element = 'Office Space';` rendered inside `<h1>{element} , at Affordable Range</h1>`.
- **JSX attribute** — an `<img>` element with `src`, `width`, `height`, and `alt` attributes pointing at a simple office-building graphic.
- **Object + expressions** — each office space is an object (`{ Name, Rent, Address }`); the values are injected into JSX with `{ }` expressions.
- **List rendering** — `officeList.js` holds an array of office objects; `App.js` loops over it with `.map()` to render a card per office.
- **Conditional styling** — for each office, the Rent text is colored **red** when `Rent <= 60000` and **green** when it's above 60000, via a `textRed` / `textGreen` CSS class.

## Project Structure

```
officespacerentalapp/
├── public/
│   └── index.html
├── src/
│   ├── officeList.js     # array of office objects (Name, Rent, Address)
│   ├── officeSpace.svg   # simple building graphic used as the JSX image attribute
│   ├── App.js            # JSX elements/attributes/expressions + rent color logic
│   ├── App.css           # .textRed / .textGreen styling
│   └── index.js
├── package.json
└── .gitignore
```

## Setup

```
npx create-react-app officespacerentalapp
# copy the files from src/ into your project's src/ folder
npm start
```

Open `http://localhost:3000` — you'll see the heading, the office building graphic, and a card per office with the rent colored red or green depending on its value.

## Scripts

- `npm start` — runs the app in development mode
- `npm run build` — builds the app for production
