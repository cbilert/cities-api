package com.api.cities.controller;

import com.api.cities.model.City;
import com.api.cities.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CityController {

    @Autowired
    private final CityRepository repository;

  /* 1st
  @GetMapping
  public List<City> cities() {
      return repository.findAll();
  }*/

    // 2nd - Pageable
    @GetMapping("/")
    public Page<City> cities(final Pageable page) {
        return repository.findAll(page);
    }
}
