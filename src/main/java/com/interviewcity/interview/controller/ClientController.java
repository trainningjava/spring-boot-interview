package com.interviewcity.interview.controller;

import com.interviewcity.interview.model.Client;
import com.interviewcity.interview.service.ClientServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/cliente")
@Api(value="API REST Cliente")
public class ClientController {

    @Autowired
    private ClientServiceImpl service;

    @ApiOperation(value="Salva um Cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @ResponseBody
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Client client) throws URISyntaxException {
        System.out.println(client);
        Client saved = service.save(client);
        return created(new URI(Long.toString(saved.getId()))).build();
    }

    @ApiOperation(value="Busca pelo código do cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<Client> findByClientID(@PathVariable("id") long id){
        return ResponseEntity.ok(this.service.findBy(id));
    }

    @ApiOperation(value="Busca pelo nome do cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @ResponseBody
    @GetMapping("/{nome}/cliente")
    public ResponseEntity<List<Client>>  findByClientID(@PathVariable("nome") String nome){
        return ResponseEntity.ok(this.service.findByName(nome));
    }

    @ApiOperation(value="Atualiza um cliente")
    @ResponseBody
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Client client) {
        service.update(id, client);
        return ok().build();
    }

    @ApiOperation(value="Exclui um cliente")
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
