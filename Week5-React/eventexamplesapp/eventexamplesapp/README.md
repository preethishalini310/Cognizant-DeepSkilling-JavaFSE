# eventexamplesapp

Answer/solution for the **"React Events" hands-on lab**. It's a small React app
that demonstrates event handling concepts:

1. **Counter** – Increment / Decrement buttons. The Increment button calls two
   methods on a single click: it increases the counter *and* shows a static
   "Hello" message (built as a class component, showing use of the `this`
   keyword).
2. **Welcome** – a "Say Welcome" button that invokes a handler with an
   argument (`"welcome"`).
3. **Synthetic Event** – a button whose `onClick` handler receives React's
   cross-browser `SyntheticEvent` and displays "I was clicked".
4. **CurrencyConvertor** – converts an entered amount in Indian Rupees to
   Euros when the "Convert" button is clicked (`handleSubmit`).

## Project structure

```
eventexamplesapp/
├── public/
│   └── index.html
├── src/
│   ├── components/
│   │   ├── Counter.js
│   │   ├── Welcome.js
│   │   ├── SyntheticEventDemo.js
│   │   └── CurrencyConvertor.js
│   ├── App.js
│   ├── App.css
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
cd eventexamplesapp
git init
git add .
git commit -m "React events hands-on lab solution"
git branch -M main
git remote add origin https://github.com/<your-username>/<your-repo>.git
git push -u origin main
```
