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
import ru.mak.tradingCompany.dto.EmployeeDto;
import ru.mak.tradingCompany.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EmployeeDto employee = employeeService.getById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody @Valid EmployeeDto employee) {
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        employeeService.save(employee);
        return new ResponseEntity<>(employee, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody @Valid EmployeeDto employee) {
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        employeeService.save(employee);
        return new ResponseEntity<>(employee, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EmployeeDto employee = employeeService.getById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        List<EmployeeDto> employees = employeeService.getAll(pageable);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
