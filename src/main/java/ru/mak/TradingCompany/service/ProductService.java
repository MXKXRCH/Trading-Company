package ru.mak.tradingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.tradingCompany.dto.ProductDto;
import ru.mak.tradingCompany.entity.Product;
import ru.mak.tradingCompany.entity.Type;
import ru.mak.tradingCompany.repo.ProductRepo;
import ru.mak.tradingCompany.repo.TypeRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
	@Autowired
    ProductRepo productRepo;
    @Autowired
    TypeRepo typeRepo;

    public ProductDto getById(Long id) {
        try {
            return productRepo.getReferenceById(id).toProductDto();
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public ProductDto save(ProductDto productDto, Long typeId) {
        try {
            Type type = typeRepo.getReferenceById(typeId);
            return productRepo.save(new Product(productDto, type)).toProductDto();
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    public List<ProductDto> getAll() {
        return productRepo.findAll().stream().map(Product::toProductDto).collect(Collectors.toList());
    }
}
