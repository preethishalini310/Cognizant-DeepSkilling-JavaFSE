import React, { useState } from "react";
import BookDetails from "./components/BookDetails";
import BlogDetails from "./components/BlogDetails";
import CourseDetails from "./components/CourseDetails";

const books = [
  { id: 1, title: "Clean Code", author: "Robert C. Martin", genre: "Software" },
  { id: 2, title: "Atomic Habits", author: "James Clear", genre: "Self-help" },
  { id: 3, title: "Sapiens", author: "Yuval Noah Harari", genre: "History" },
];

const blogs = [
  { id: 1, title: "Getting Started with React", summary: "Hooks, JSX and components in 5 minutes.", featured: true },
  { id: 2, title: "Why Keys Matter", summary: "How React uses keys to track list items.", featured: false },
];

const courses = [
  { id: 1, title: "React Fundamentals", duration: 4, status: "active" },
  { id: 2, title: "Advanced JavaScript", duration: 6, status: "active" },
  { id: 3, title: "Old TypeScript Basics", duration: 3, status: "archived" },
];

function App() {
  // Toggle these to see the empty/loading/error states from each component
  const [showBooks, setShowBooks] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);
  const [courseStatus, setCourseStatus] = useState("ready");

  return (
    <div className="app">
      <header>
        <h1>Blogger App</h1>
        <p>React Hands-on Lab — Conditional Rendering, Lists &amp; Keys, map()</p>
      </header>

      <div className="controls">
        <button onClick={() => setShowBooks((v) => !v)}>Toggle Books</button>
        <button onClick={() => setShowBlogs((v) => !v)}>Toggle Blogs</button>
        <button onClick={() => setCourseStatus("loading")}>Courses: Loading</button>
        <button onClick={() => setCourseStatus("error")}>Courses: Error</button>
        <button onClick={() => setCourseStatus("ready")}>Courses: Ready</button>
      </div>

      <main>
        <BookDetails books={showBooks ? books : []} />
        <BlogDetails blogs={showBlogs ? blogs : []} />
        <CourseDetails courses={courses} status={courseStatus} />
      </main>
    </div>
  );
}

export default App;
