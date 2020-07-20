package com.nodamu.dogapi.service;

import com.nodamu.dogapi.entity.Dog;

import java.util.List;

public interface DogService {
    List<String> retrieveDogBreed();

    List<Dog> retrieveDogs();

    String retrieveDogBreedById(Long id);

    List<String> retrieveDogNames();
}
