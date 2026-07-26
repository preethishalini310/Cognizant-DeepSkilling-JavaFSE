# ticketbookingapp

Answer/solution for the **"React Conditional Rendering" hands-on lab**. A
flight booking app where guests can only browse flights, and logged-in
users can also book them.

## Concepts demonstrated

1. **Conditional rendering** – `App.js` renders `<GuestPage />` or
   `<UserPage />` depending on `isLoggedIn` state, and `LoginControl`
   swaps between `<LoginButton />` / `<LogoutButton />`.
2. **Element variables** – `LoginControl.js` assigns the button element to
   a `button` variable before returning it, instead of nesting ternaries
   in JSX.
3. **Preventing a component from rendering** – `WarningBanner.js` returns
   `null` when `showWarning` is `false`, so nothing is rendered to the DOM.

## Behavior

- **Guest page** (default): shows the list of available flights, no
  booking action, and a prompt to log in.
- Click **Login** → the **User page** is displayed: same flight list, plus
  a **Book** button per row that confirms a booking.
- Click **Logout** → back to the Guest page.
- **Hide/Show Warning** button on both pages toggles the `WarningBanner`
  on/off, demonstrating the component returning `null`.

## Project structure

```
ticketbookingapp/
├── public/
│   └── index.html
├── src/
│   ├── components/
│   │   ├── flightData.js
│   │   ├── WarningBanner.js
│   │   ├── LoginControl.js
│   │   ├── GuestPage.js
│   │   └── UserPage.js
│   ├── App.js
│   ├── index.js
│   └── index.css
├── package.json
└── .gitignore
```

## Run locally

```bash
npm install
npm start
```

Then open http://localhost:3000.

## Push to GitHub

```bash
cd ticketbookingapp
git init
git add .
git commit -m "React conditional rendering hands-on lab solution"
git branch -M main
git remote add origin https://github.com/<your-username>/<your-repo>.git
git push -u origin main
```
