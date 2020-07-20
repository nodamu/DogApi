package com.example.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.entity.Dog;
import com.example.demo.repository.DogRepository;
import com.example.demo.exception.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id){
        Optional<Dog> dog = dogRepository.findById(id);
        if(dog.isPresent()){
            return dog.get();
        }else{
            throw new DogNotFoundException("Dog not found",id);
        }

    }
}
