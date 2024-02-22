package com.example.demo.infraestructure.configs;

import com.example.demo.application.services.DomainToDoListServiceImpl;
import com.example.demo.application.services.ITodoListService;
import com.example.demo.domain.ports.IToDoListRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanToDoListConfiguration {
    @Bean
    ITodoListService ToDoListBeanService(final IToDoListRepository repository){
        return new DomainToDoListServiceImpl(repository);
    }
}
