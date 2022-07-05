package ru.mak.tradingCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mak.tradingCompany.dto.TypeDto;
import ru.mak.tradingCompany.entity.Type;
import ru.mak.tradingCompany.service.TypeService;

import java.util.List;

@RestController
@RequestMapping(path = "/types", produces = MediaType.APPLICATION_JSON_VALUE)
public class TypeController {
    @Autowired
    TypeService typeService;

    @GetMapping("/{id}")
    public ResponseEntity<TypeDto> getType(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        TypeDto type = typeService.getById(id);
        if (type == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TypeDto> saveType(@RequestBody Type type) {
        if (type == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        typeService.save(type);
        return new ResponseEntity<>(type.toTypeDto(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TypeDto> updateType(@RequestBody Type type) {
        if (type == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        typeService.save(type);
        return new ResponseEntity<>(type.toTypeDto(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TypeDto> deleteType(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        TypeDto type = typeService.getById(id);
        if (type == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        typeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TypeDto>> getAllTypes() {
        List<TypeDto> types = typeService.getAll();
        if (types.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(types, HttpStatus.OK);
    }
}
