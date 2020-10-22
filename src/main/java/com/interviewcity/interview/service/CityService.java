package com.interviewcity.interview.service;

import com.interviewcity.interview.exception.CityNotFoundException;
import com.interviewcity.interview.model.City;
import com.interviewcity.interview.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CityService {

    City save(City city);

    City findBy(Long id);

    List<City> listAll();

    void remove(Long id);

    List<City> findByCity(String cidade);

    List<City> findByState(String estado);

    void update(Long id, City city);
}
