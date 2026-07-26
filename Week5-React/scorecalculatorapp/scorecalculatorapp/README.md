# scorecalculatorapp

A React application for a **Student Management Portal** that calculates and displays a student's average score, built as part of the "ReactJS Hands-On Lab" exercise on function components.

## Objective

Create a function component named **CalculateScore** that accepts `Name`, `School`, `total`, and `goal` as props, calculates the average score of a student, and displays the student's details along with the computed score.

## Prerequisites

- Node.js
- NPM
- Visual Studio Code

## Project Structure

```
scorecalculatorapp/
├── public/
│   └── index.html
├── src/
│   ├── Components/
│   │   └── CalculateScore.js
│   ├── Stylesheets/
│   │   └── mystyle.css
│   ├── App.js
│   └── index.js
├── package.json
└── .gitignore
```

## How it works

`CalculateScore` is a function component that:

1. Receives `Name`, `School`, `total`, and `goal` as props.
2. Computes the score as `total / goal`, formatted to 2 decimal places with a `%` suffix.
3. Renders the student's name, school, total marks, and calculated score, styled via `mystyle.css`.

With the sample data in `App.js` (`total={284}`, `goal={3}`), the app displays:

```
Student Details:
Name: Steeve
School: DNV Public School
Total: 284 Marks
Score: 94.67%
```

## Setup

1. Create the React project:
   ```
   npx create-react-app scorecalculatorapp
   ```
2. Inside `src`, create a folder named `Components` and add `CalculateScore.js`.
3. Create a folder named `Stylesheets` and add `mystyle.css` with styles for the component.
4. Edit `App.js` to import and render `CalculateScore` with the desired props.
5. Run the app:
   ```
   npm start
   ```
6. Open a browser at `http://localhost:3000` to see the student's details and calculated score.

## Scripts

- `npm start` — runs the app in development mode
- `npm run build` — builds the app for production
