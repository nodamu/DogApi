package com.nodamu.dogapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.nodamu.dogapi.entity.Dog;
import com.nodamu.dogapi.exception.DogNotFoundGraphqlException;
import com.nodamu.dogapi.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> dog = dogRepository.findById(id);
        if (dog.isPresent()) {
            return dog.get();
        } else {
            throw new DogNotFoundGraphqlException("Dog not found", id);
        }

    }
}
