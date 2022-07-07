package ru.mak.tradingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.mak.tradingCompany.dto.TypeDto;
import ru.mak.tradingCompany.entity.Type;
import ru.mak.tradingCompany.repo.TypeRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeService {
	@Autowired
    TypeRepo typeRepo;

    public TypeDto getById(Long id) {
        Type type = typeRepo.findById(id).orElse(null);
        return (type == null) ? null : type.toTypeDto();
    }

    public void save(TypeDto type) {
        typeRepo.save(new Type(type));
    }

    public void delete(Long id) {
        typeRepo.deleteById(id);
    }

    public List<TypeDto> getAll(Pageable pageable) {
        return typeRepo.findAll(pageable).stream().map(Type::toTypeDto).collect(Collectors.toList());
    }
}
