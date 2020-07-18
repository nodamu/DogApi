package com.example.demo.service;

import com.example.demo.entity.Dog;

import java.util.List;

public interface DogService {
    List<String> retrieveDogBreed();
    List<Dog> retrieveDogs();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();
}
