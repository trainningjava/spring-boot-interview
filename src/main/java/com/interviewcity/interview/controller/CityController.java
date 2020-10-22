package com.interviewcity.interview.controller;

import com.interviewcity.interview.model.City;
import com.interviewcity.interview.service.CityServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/cidade")
@Api(value="API REST Cidade")
public class CityController {
    /***
     * Permite cadastrar. listar e apagar cidades
     * @Version 1.0
     */

    @Autowired
    private CityServiceImpl service;

    @ApiOperation(value="Salva uma cidade")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @ResponseBody
    @PostMapping
    public ResponseEntity<?> save(@RequestBody City city) throws URISyntaxException {
        City saved = service.save(city);
        return created(new URI(Long.toString(saved.getId()))).build();
    }

    @ApiOperation(value="Lista todas as cidades")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @ResponseBody
    @GetMapping
    public ResponseEntity<List<City>> listAll(){
        return ResponseEntity.ok(this.service.listAll());
    }

    @ApiOperation(value="Busca pelo código da cidade")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<City> findByCityID(@PathVariable("id") long id){
        return ResponseEntity.ok(this.service.findBy(id));
    }

    @ApiOperation(value="Busca o estado pela cidade")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @ResponseBody
    @GetMapping("/{cidade}/cidade")
    public ResponseEntity<List<City>> findByCity(@PathVariable("cidade") String cidade){
        return ResponseEntity.ok(this.service.findByCity(cidade));
    }

    @ApiOperation(value="Busca o cidade pelo estado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @ResponseBody
    @GetMapping("/{estado}/estado")
    public ResponseEntity<List<City>> findByState(@PathVariable("estado") String estado){
        return ResponseEntity.ok(this.service.findByState(estado));
    }

    @ApiOperation(value="Atualiza um municipio")
    @ResponseBody
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody City city) {
        service.update(id, city);
        return ok().build();
    }

    @ApiOperation(value="Exclui uma cidade")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @ResponseBody
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        service.remove(id);
        return ok().build();
    }

}
