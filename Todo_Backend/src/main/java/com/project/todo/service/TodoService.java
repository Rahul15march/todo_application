package com.project.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.todo.model.Todo;
import com.project.todo.repositories.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepo;

    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    public Todo addTodo(Todo todo) {
        return todoRepo.save(todo);
    }

    public boolean deleteTodo(Long id) {
        if (todoRepo.existsById(id)) {
            todoRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
