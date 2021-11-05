package com.api.cities.controller;

import com.api.cities.model.Country;
import com.api.cities.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryRepository repository;

    public CountryController(final CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        Optional<Country> countryOptional = repository.findById(id);
        if (countryOptional.isPresent()) {
            return ResponseEntity.ok().body(countryOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
}
