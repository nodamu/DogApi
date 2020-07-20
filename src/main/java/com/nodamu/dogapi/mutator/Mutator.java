package com.nodamu.dogapi.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.nodamu.dogapi.entity.Dog;
import com.nodamu.dogapi.exception.BreedNotFoundException;
import com.nodamu.dogapi.exception.DogNotFoundGraphqlException;
import com.nodamu.dogapi.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutator implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutator(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog updateDogName(Long id, String newName) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundGraphqlException("Dog not found", id);
        }
    }

    public Boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> dogs = dogRepository.findAll();
        for (Dog d : dogs) {
            if (d.getBreed().equals(breed)) {
                dogRepository.delete(d);
                deleted = true;
            }
        }
        // Throw exception if breed doesn't exist
        if (!deleted) {
            throw new BreedNotFoundException("Breed not found", breed);
        }

        return deleted;
    }
}


