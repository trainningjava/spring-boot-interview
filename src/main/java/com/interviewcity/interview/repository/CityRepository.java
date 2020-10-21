package com.interviewcity.interview.repository;

import com.interviewcity.interview.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("from City c where c.name = :cidade")
    List<City> findByCity(@Param("cidade") String cidade);

    @Query("from City c where c.state = :estado")
    List<City> findByState(@Param("estado") String estado);

}
