package com.example.demo.infraestructure.rest.controllers;

import com.example.demo.application.services.ITodoListService;
import com.example.demo.domain.models.ToDoList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/to-do-list")
@Slf4j
public class ToDoListController {
    private final ITodoListService service;

    public ToDoListController(ITodoListService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ToDoList> create(@RequestBody ToDoList toDoList){
        return new ResponseEntity<>(service.create(toDoList), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ToDoList> update(@RequestBody ToDoList toDoList){
        return new ResponseEntity<>(service.update(toDoList), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<ToDoList>> list(){
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoList> get(@PathVariable String id){
        return new ResponseEntity<>(service.get(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
