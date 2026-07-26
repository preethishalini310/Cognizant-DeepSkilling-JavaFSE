# bloggerapp — React Hands-on Lab

Solution for the "ReactJS-HOL: Conditional Rendering, Lists & Keys, map()" lab.

## What this covers

The app has 3 components, each demonstrating a different way of doing
**conditional rendering** in React, plus **list rendering with `map()` and
`key`**:

| Component | File | Conditional rendering technique |
|---|---|---|
| `BookDetails` | `src/components/BookDetails.js` | `if / else` (element variable) |
| `BlogDetails` | `src/components/BlogDetails.js` | Ternary operator (`? :`) and logical `&&` |
| `CourseDetails` | `src/components/CourseDetails.js` | `switch` statement + IIFE, plus an **extracted** list-item component (`CourseItem`) that receives its `key` from the parent's `map()` call |

`App.js` renders all three components and has buttons to toggle empty /
loading / error states so you can see every branch of the conditional logic
in the browser.

## Run it locally

```bash
npm install
npm start
```

Then open http://localhost:3000

## Upload this folder to GitHub

1. Create a new empty repository on GitHub (don't add a README there).
2. From inside this `bloggerapp` folder, run:

```bash
git init
git add .
git commit -m "React HOL: conditional rendering, lists and keys"
git branch -M main
git remote add origin https://github.com/<your-username>/<your-repo>.git
git push -u origin main
```

That's it — the whole folder (minus `node_modules`, which is excluded via
`.gitignore`) will be pushed to GitHub.
