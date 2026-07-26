import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    // Initialize the component state with an empty list of Post
    this.state = {
      posts: []
    };
  }

  loadPosts() {
    // Use the Fetch API to get the posts and assign them to the component state
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => response.json())
      .then((data) => {
        const posts = data.map(
          (item) => new Post(item.id, item.title, item.body)
        );
        this.setState({ posts: posts });
      })
      .catch((error) => {
        // Re-throw so componentDidCatch() can handle it
        throw error;
      });
  }

  componentDidMount() {
    // Fetch the posts as soon as the component mounts
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    // Display any error happening in the component as an alert message
    alert('An error occurred: ' + error.toString());
  }

  render() {
    return (
      <div className="posts">
        {this.state.posts.map((post) => (
          <div key={post.id} className="post">
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
