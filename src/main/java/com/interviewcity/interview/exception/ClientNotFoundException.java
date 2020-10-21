package com.interviewcity.interview.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Long id) {
        super(String.format("Não foi encotrado nenhum cliente com este id: %d", id));
    }
}
