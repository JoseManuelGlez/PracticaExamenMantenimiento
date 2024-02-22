package com.example.demo.infraestructure.adapters;

import com.example.demo.infraestructure.entities.ToDoListEntity;
import org.springframework.data.repository.CrudRepository;

public interface IToDoListCrudRepositoryMySql extends CrudRepository<ToDoListEntity, String> {
}
