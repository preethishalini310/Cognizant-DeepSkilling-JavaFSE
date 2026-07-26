# blogapp

A React application demonstrating the **component life cycle** — built as part of the "ReactJS Hands-On Lab" exercise.

## Objectives

- Explain the need and benefits of the component life cycle
- Identify various life cycle hook methods
- List the sequence of steps in rendering a component

## What it does

- Implements the `componentDidMount()` hook to fetch data right after the component mounts.
- Implements the `componentDidCatch()` life cycle hook to catch and alert on rendering errors.
- Fetches a list of posts from `https://jsonplaceholder.typicode.com/posts` and renders each post's title and body.

## Prerequisites

- Node.js
- NPM
- Visual Studio Code

## Project Structure

```
blogapp/
├── public/
│   └── index.html
├── src/
│   ├── Post.js       # plain class modeling a single post (id, title, body)
│   ├── Posts.js       # class component: constructor, loadPosts(), componentDidMount(), componentDidCatch(), render()
│   ├── App.js         # renders the Posts component
│   └── index.js
├── package.json
└── .gitignore
```

## How it works

1. **`Post`** (`src/Post.js`) — a plain JS class with a constructor that sets `id`, `title`, and `body`.
2. **`Posts`** (`src/Posts.js`) — a class component:
   - `constructor(props)` initializes `state.posts` as an empty array.
   - `loadPosts()` calls the Fetch API against the JSONPlaceholder posts endpoint and maps the response into `Post` instances, then updates state.
   - `componentDidMount()` calls `loadPosts()` once the component has mounted.
   - `render()` maps over `state.posts`, showing each post's title as a heading and its body as a paragraph.
   - `componentDidCatch(error, info)` catches any error thrown while rendering/fetching and shows it as an alert.
3. **`App`** (`src/App.js`) — renders the `Posts` component.

## Setup

1. Create the project:
   ```
   npx create-react-app blogapp
   ```
2. Copy the files from `src/` into your project's `src/` folder.
3. Run the app:
   ```
   npm start
   ```
4. Open `http://localhost:3000` — the list of posts fetched from JSONPlaceholder will render.

## Scripts

- `npm start` — runs the app in development mode
- `npm run build` — builds the app for production
