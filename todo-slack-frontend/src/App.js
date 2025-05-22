import React, { useEffect, useState } from 'react';
import { getTodos, addTodo, deleteTodo, sendSummary } from './services/api';
import AddTodo from './components/AddTodo';
import TodoList from './components/TodoList';
import SummaryButton from './components/SummaryButton';
import './App.css';

function App() {
  const [todos, setTodos] = useState([]);

  useEffect(() => {
    loadTodos();
  }, []);

  const loadTodos = async () => {
    const res = await getTodos();
    setTodos(res.data);
  };

  const handleAdd = async (todo) => {
    await addTodo(todo);
    loadTodos();
  };

  const handleDelete = async (id) => {
    await deleteTodo(id);
    loadTodos();
  };

  const handleSummarize = async () => {
    const res = await sendSummary();
    alert(res.data.message || 'Something went wrong');
  };

  return (
    <div style={{ padding: 20 }}>
      <h2>Todo List</h2>
      <AddTodo onAdd={handleAdd} />
      <TodoList todos={todos} onDelete={handleDelete} />
      <SummaryButton onSummarize={handleSummarize} />
    </div>
  );
}

export default App;
