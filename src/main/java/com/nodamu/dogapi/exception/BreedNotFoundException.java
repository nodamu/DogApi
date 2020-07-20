package com.nodamu.dogapi.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreedNotFoundException extends RuntimeException implements GraphQLError {

    Map<String, Object> extensions = new HashMap<>();

    public BreedNotFoundException(String message, String invalidBreed) {
        super(message);
        extensions.put("Invalid Breed", invalidBreed);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }
}
