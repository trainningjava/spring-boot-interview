package com.interviewcity.interview.service;

import com.interviewcity.interview.exception.CityNotFoundException;
import com.interviewcity.interview.exception.ClientNotFoundException;
import com.interviewcity.interview.model.City;
import com.interviewcity.interview.model.Client;
import com.interviewcity.interview.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    public Client save(Client city) {
        return repository.save(city);
    }

    public Client findBy(Long id) {
        Optional<Client> optionalClient = repository.findById(id);
        if (optionalClient == null || !optionalClient.isPresent()) {
            throw new ClientNotFoundException(id);
        }
        return optionalClient.get();
    }

    public List<Client> findByName(String nome) {
        return this.repository.findByName(nome);
    }

    public void update(Long id, Client client) {
        Optional<Client> optionalClient = repository.findById(id);
        if (optionalClient != null && optionalClient.isPresent()) {
            Client savedClient = optionalClient.get();
            savedClient.setName(client.getName());
            savedClient.setAge(client.getAge());
            savedClient.setSex(client.getSex());
            savedClient.setBirth(client.getBirth());
            this.repository.save(savedClient);
        } else {
            throw new ClientNotFoundException(id);
        }
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

}
