import React from "react";

// Technique 1: if / else statement returning different JSX (element variable pattern)
function BookDetails({ books }) {
  let content;

  if (!books || books.length === 0) {
    content = <p className="empty">No books available right now.</p>;
  } else {
    content = (
      <ul className="card-list">
        {books.map((book) => (
          <li className="card" key={book.id}>
            <h4>{book.title}</h4>
            <p>by {book.author}</p>
            <span className="tag">{book.genre}</span>
          </li>
        ))}
      </ul>
    );
  }

  return (
    <section className="panel">
      <h2>📚 Book Details</h2>
      <p className="hint">Conditional rendering technique: if / else (element variable)</p>
      {content}
    </section>
  );
}

export default BookDetails;
