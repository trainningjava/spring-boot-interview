package com.interviewcity.interview.service;

import com.interviewcity.interview.exception.ClientNotFoundException;
import com.interviewcity.interview.model.Client;
import com.interviewcity.interview.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client save(Client city);

    Client findBy(Long id);

    List<Client> findByName(String nome);

    void update(Long id, Client client);

    void remove(Long id);

}
