package com.example.demo.infraestructure.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "to-do-lists")
@NoArgsConstructor
@Data
public class ToDoListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String description;
    private String tittle;
    private String status;
}
