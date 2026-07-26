import React from "react";

// Extracted list-item component. The `key` stays on the element in the parent's
// map() call, NOT as a named prop inside this component.
function CourseItem({ course }) {
  return (
    <li className="card">
      <h4>{course.title}</h4>
      <p>{course.duration} weeks</p>
      <span className={`tag status-${course.status}`}>{course.status}</span>
    </li>
  );
}

// Technique 4: switch statement + Technique 5: Immediately Invoked Function
// Expression (IIFE) for inline conditional rendering
function CourseDetails({ courses, status }) {
  function renderByStatus() {
    switch (status) {
      case "loading":
        return <p className="empty">Loading courses…</p>;
      case "error":
        return <p className="empty error">Something went wrong loading courses.</p>;
      case "ready":
        return courses.length > 0 ? (
          <ul className="card-list">
            {courses.map((course) => (
              <CourseItem key={course.id} course={course} />
            ))}
          </ul>
        ) : (
          <p className="empty">No courses to show.</p>
        );
      default:
        return null;
    }
  }

  return (
    <section className="panel">
      <h2>🎓 Course Details</h2>
      <p className="hint">
        Conditional rendering techniques: switch statement + IIFE, with an
        extracted &lt;CourseItem key=... /&gt; list component
      </p>

      {renderByStatus()}

      {/* Technique 5: IIFE used directly inside JSX */}
      {(() => {
        const readyCount = courses.filter((c) => c.status !== "archived").length;
        return readyCount > 0 ? (
          <p className="summary">{readyCount} active course(s) available.</p>
        ) : null;
      })()}
    </section>
  );
}

export default CourseDetails;
