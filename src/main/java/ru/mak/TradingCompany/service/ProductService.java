package ru.mak.tradingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.tradingCompany.dto.ProductDto;
import ru.mak.tradingCompany.entity.Product;
import ru.mak.tradingCompany.entity.Type;
import ru.mak.tradingCompany.repo.ProductRepo;
import ru.mak.tradingCompany.repo.TypeRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
	@Autowired
    ProductRepo productRepo;
    @Autowired
    TypeRepo typeRepo;

    public ProductDto getById(Long id) {
        Product product = productRepo.findById(id).orElse(null);
        return (product == null) ? null : product.toProductDto();
    }

    public ProductDto save(ProductDto productDto, Long typeId) {
        Type type = typeRepo.findById(typeId).orElse(null);
        return (type == null) ? null : productRepo.save(new Product(productDto, type)).toProductDto();
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    public List<ProductDto> getAll() {
        return productRepo.findAll().stream().map(Product::toProductDto).collect(Collectors.toList());
    }
}
