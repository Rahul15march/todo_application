import axios from 'axios';

const BASE_URL = 'http://localhost:8081/api/todo';
const SUMMARY_URL = 'http://localhost:8081/api/summarize';

export const getTodos = () => axios.get(BASE_URL);
export const addTodo = (todo) => axios.post(BASE_URL, todo);
export const deleteTodo = (id) => axios.delete(`${BASE_URL}/${id}`);
export const sendSummary = () => axios.post(SUMMARY_URL);