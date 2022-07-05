package ru.mak.tradingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.tradingCompany.dto.TypeDto;
import ru.mak.tradingCompany.entity.Type;
import ru.mak.tradingCompany.repo.TypeRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeService {
	@Autowired
    TypeRepo typeRepo;

    public TypeDto getById(Long id) {
        try {
            return typeRepo.getReferenceById(id).toTypeDto();
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public void save(Type type) {
        typeRepo.save(type);
    }

    public void delete(Long id) {
        typeRepo.deleteById(id);
    }

    public List<TypeDto> getAll() {
        return typeRepo.findAll().stream().map(Type::toTypeDto).collect(Collectors.toList());
    }
}
