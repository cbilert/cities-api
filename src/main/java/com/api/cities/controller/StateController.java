package com.api.cities.controller;

import com.api.cities.model.State;
import com.api.cities.repository.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staties")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StateController {

    @Autowired
    private final StateRepository repository;

    @GetMapping("/")
    public List<State> staties() {
        return repository.findAll();
    }
}
