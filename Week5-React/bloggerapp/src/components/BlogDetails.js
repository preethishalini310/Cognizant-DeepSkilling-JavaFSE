import React from "react";

// Technique 2: Ternary operator + Technique 3: Logical && operator
function BlogDetails({ blogs }) {
  const hasBlogs = blogs && blogs.length > 0;

  return (
    <section className="panel">
      <h2>📝 Blog Details</h2>
      <p className="hint">
        Conditional rendering techniques: ternary operator ( ? : ) and logical
        AND ( &amp;&amp; )
      </p>

      {/* Ternary operator */}
      {hasBlogs ? (
        <ul className="card-list">
          {blogs.map((blog) => (
            <li className="card" key={blog.id}>
              <h4>{blog.title}</h4>
              <p>{blog.summary}</p>
              {/* Logical && operator: only render the badge when featured is true */}
              {blog.featured && <span className="tag featured">Featured</span>}
            </li>
          ))}
        </ul>
      ) : (
        <p className="empty">No blog posts published yet.</p>
      )}
    </section>
  );
}

export default BlogDetails;
