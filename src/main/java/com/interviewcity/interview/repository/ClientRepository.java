package com.interviewcity.interview.repository;

import com.interviewcity.interview.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("from Client c where c.name LIKE  :nome%")
    List<Client> findByName(@Param("nome") String nome);

    @Query("SELECT C FROM Client C WHERE C.city.id = :id")
    List<Client> findClientByCityId(@Param("id") Long id);
}
