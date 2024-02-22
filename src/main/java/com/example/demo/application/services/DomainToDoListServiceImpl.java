package com.example.demo.application.services;

import com.example.demo.domain.models.ToDoList;
import com.example.demo.domain.ports.IToDoListRepository;

import java.util.Optional;

public class DomainToDoListServiceImpl implements ITodoListService{
    private final IToDoListRepository repository;

    public DomainToDoListServiceImpl(IToDoListRepository repository) {
        this.repository = repository;
    }

    @Override
    public ToDoList create(ToDoList topic) {
        return repository.create(topic);
    }

    @Override
    public ToDoList update(ToDoList topic) {
        return repository.update(topic);
    }

    @Override
    public Iterable<ToDoList> list() {
        return repository.list();
    }

    @Override
    public Optional<ToDoList> get(String id) {
        return repository.get(id);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }
}
