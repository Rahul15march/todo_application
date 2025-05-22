package com.project.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.todo.model.Todo;



public interface TodoRepository extends JpaRepository<Todo, Long> {

}
