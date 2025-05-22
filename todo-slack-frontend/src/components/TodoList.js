import React from 'react';

const TodoList = ({ todos, onDelete }) => {
  if (todos.length === 0) return <p>No todos yet!</p>;

  return (
    <ul className="todo-list">
      {todos.map(todo => (
        <li key={todo.id} className="todo-item">
          <span>{todo.text}</span>
          <button
            type="button"
            className="delete-btn"
            onClick={() => {
              if (window.confirm('Delete this todo?')) {
                onDelete(todo.id);
              }
            }}
          >
            Delete
          </button>
        </li>
      ))}
    </ul>
  );
};

export default TodoList;
