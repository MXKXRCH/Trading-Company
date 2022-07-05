package ru.mak.tradingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.tradingCompany.entity.Product;
import ru.mak.tradingCompany.repo.ProductRepo;
import ru.mak.tradingCompany.repo.TypeRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductService {
	@Autowired
    ProductRepo productRepo;
    @Autowired
    TypeRepo typeRepo;

    public Product getById(Long id) {
        try {
            return productRepo.getReferenceById(id);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public Product save(Product product, Long typeId) {
        try {
            product.setType(typeRepo.getReferenceById(typeId));
        } catch (EntityNotFoundException e) {
            return null;
        }
        return productRepo.save(product);
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    public List<Product> getAll() {
        return productRepo.findAll();
    }
}
