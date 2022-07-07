package ru.mak.tradingCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mak.tradingCompany.dto.ClientDto;
import ru.mak.tradingCompany.service.ClientService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ClientDto client = clientService.getById(id);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDto> saveClient(@RequestBody @Valid ClientDto client) {
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        clientService.save(client);
        return new ResponseEntity<>(client, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ClientDto> updateClient(@RequestBody @Valid ClientDto client) {
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        clientService.save(client);
        return new ResponseEntity<>(client, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDto> deleteClient(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ClientDto client = clientService.getById(id);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientDto>> getAllClients(
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        List<ClientDto> clients = clientService.getAll(pageable);
        if (clients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}
