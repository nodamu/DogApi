package com.example.demo.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogNotFoundGraphqlException extends RuntimeException implements GraphQLError
{

    Map<String, Object> extensions = new HashMap<>();

    public DogNotFoundGraphqlException(String message, Long invalidDogId) {
        super(message);
        extensions.put("Invalid dog id",invalidDogId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }
}
