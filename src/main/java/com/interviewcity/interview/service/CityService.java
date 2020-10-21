package com.interviewcity.interview.service;

import com.interviewcity.interview.exception.CityNotFoundException;
import com.interviewcity.interview.model.City;
import com.interviewcity.interview.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public City save(City city) {
        return repository.save(city);
    }

    public City findBy(Long id) {
        Optional<City> optionalCity = repository.findById(id);
        if (optionalCity == null || !optionalCity.isPresent()) {
            throw new CityNotFoundException(id);
        }
        return optionalCity.get();
    }

    public List<City> listAll() {
        return this.repository.findAll();
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public List<City> findByCity(String cidade) {
        return this.repository.findByCity(cidade);
    }

    public List<City> findByState(String estado) {
        return this.repository.findByState(estado);
    }

    public void update(Long id, City city) {
        Optional<City> optionalCity = repository.findById(id);
        if (optionalCity != null && optionalCity.isPresent()) {
            City savedCity = optionalCity.get();
            savedCity.setName(city.getName());
            savedCity.setState(city.getState());
            this.repository.save(savedCity);
        } else {
            throw new CityNotFoundException(id);
        }
    }
}
