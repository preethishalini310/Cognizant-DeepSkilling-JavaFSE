# cricketapp

A React application demonstrating **ES6 features** — `map()`, arrow functions, destructuring, and the spread operator — built as part of the "ReactJS Hands-On Lab" exercise.

## Objectives

- List the features of ES6 (`let`, `const`, classes, arrow functions, destructuring, `map()`)
- Use `map()` to render lists
- Apply arrow functions to filter data
- Implement array destructuring to pull out specific elements

## What it does

The app has two "screens", toggled by a `flag` variable in `src/App.js`:

**When `flag = true`** — `ListofPlayers`
- Renders all 11 players (name + score) using `Array.prototype.map()`.
- Renders a second list, `ScoreBelow70`, filtering out players whose score is over 70 using an arrow function.

**When `flag = false`** — `IndianPlayers`
- `OddPlayers` destructures the 1st, 3rd, and 5th elements of the `IndianTeam` array (skipping the others with empty destructuring slots).
- `EvenPlayers` destructures the 2nd, 4th, and 6th elements the same way.
- `T20Players` and `RanjiTrophyPlayers` are merged into one `IndianPlayers` array using the ES6 spread operator (`[...T20Players, ...RanjiTrophyPlayers]`), then rendered with `ListofIndianPlayers`.

## Project Structure

```
cricketapp/
├── public/
│   └── index.html
├── src/
│   ├── data/
│   │   ├── players.js         # 11 players with name & score
│   │   └── IndianTeam.js      # 6-player array for destructuring
│   ├── Components/
│   │   ├── ListofPlayers.js       # map() over players
│   │   ├── ScoreBelow70.js        # arrow-function filter (score <= 70)
│   │   ├── OddPlayers.js          # destructuring: 1st/3rd/5th
│   │   ├── EvenPlayers.js         # destructuring: 2nd/4th/6th
│   │   ├── IndianPlayersData.js   # spread-merge of two arrays
│   │   └── ListofIndianPlayers.js # renders the merged array
│   ├── App.js          # if/else on `flag` switches between the two views
│   └── index.js
├── package.json
└── .gitignore
```

## Try both views

Open `src/App.js` and change:

```js
var flag = true;   // -> ListofPlayers / ScoreBelow70 view
var flag = false;  // -> Odd/Even Players + merged Indian Players view
```

## Setup

```
npx create-react-app cricketapp
# copy the files from src/ into your project's src/ folder
npm start
```

Open `http://localhost:3000` to view the result.

## Scripts

- `npm start` — runs the app in development mode
- `npm run build` — builds the app for production
