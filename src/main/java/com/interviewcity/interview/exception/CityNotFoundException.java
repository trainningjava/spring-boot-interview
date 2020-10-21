package com.interviewcity.interview.exception;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(Long id) {
        super(String.format("Não foi encotrado nenhum cidade com este id: %d", id));
    }
}
