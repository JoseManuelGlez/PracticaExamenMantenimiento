package com.example.demo.infraestructure.rest.mappers;

import com.example.demo.domain.models.ToDoList;
import com.example.demo.infraestructure.entities.ToDoListEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface IToDoListMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "tittle", target = "tittle"),
            @Mapping(source = "status", target = "status"),
    }
    )
    ToDoList toToDoList(ToDoListEntity toDoList);
    Iterable<ToDoList> toToDoLists(Iterable<ToDoListEntity> toDoListEntities);

    @InheritInverseConfiguration
    ToDoListEntity toToDoEntity (ToDoList toDoList);

    ToDoList toToDoList(Optional<ToDoListEntity> toDoList);
}
