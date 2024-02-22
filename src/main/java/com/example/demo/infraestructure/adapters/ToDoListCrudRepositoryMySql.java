package com.example.demo.infraestructure.adapters;

import com.example.demo.domain.models.ToDoList;
import com.example.demo.domain.ports.IToDoListRepository;
import com.example.demo.infraestructure.entities.ToDoListEntity;
import com.example.demo.infraestructure.rest.mappers.IToDoListMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Slf4j
public class ToDoListCrudRepositoryMySql implements IToDoListRepository {
    private final IToDoListCrudRepositoryMySql repository;

    @Autowired
    private IToDoListMapper toDoListMapper;

    public ToDoListCrudRepositoryMySql(IToDoListCrudRepositoryMySql repository) {
        this.repository = repository;
    }

    @Override
    public ToDoList create(ToDoList topic) {
        ToDoListEntity topicEntity = this.toDoListMapper.toToDoEntity(topic);
        return this.toDoListMapper.toToDoList(this.repository.save(topicEntity));
    }

    @Override
    public ToDoList update(ToDoList topic) {
        ToDoListEntity topicEntity = this.toDoListMapper.toToDoEntity(topic);
        return this.toDoListMapper.toToDoList(this.repository.save(topicEntity));
    }

    @Override
    public Iterable<ToDoList> list() {
        return this.toDoListMapper.toToDoLists(this.repository.findAll());
    }

    @Override
    public Optional<ToDoList> get(String id) {
        Optional<ToDoListEntity> topic = this.repository.findById(id);

        return Optional.of(this.toDoListMapper.toToDoList(topic));
    }

    @Override
    public void delete(String id) {
        Optional<ToDoListEntity> topicEntity = this.repository.findById(id);
        this.repository.deleteById(topicEntity.get().getId());
    }
}
