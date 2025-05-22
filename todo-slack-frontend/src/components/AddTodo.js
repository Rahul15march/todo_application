import React, { useState } from 'react';

const AddTodo = ({ onAdd }) => {
  const [text, setText] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!text.trim()) return;
    onAdd({ text });
    setText('');
  };

  return (
    <form className="add-todo" onSubmit={handleSubmit}>
      <input
        autoFocus
        value={text}
        onChange={e => setText(e.target.value)}
        placeholder="New todo..."
      />
      <button type="submit" disabled={!text.trim()}>
        Add
      </button>
    </form>
  );
};

export default AddTodo;
