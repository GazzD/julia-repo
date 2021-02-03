package com.ironhack.juliademo.service.impl;

import com.ironhack.juliademo.controller.dto.ProductDTO;
import com.ironhack.juliademo.enums.Category;
import com.ironhack.juliademo.enums.Department;
import com.ironhack.juliademo.model.Product;
import com.ironhack.juliademo.repository.ProductRepository;
import com.ironhack.juliademo.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findByCategory(String category) {
        try {
            return productRepository.findByCategory(Category.valueOf(category.toUpperCase()));
        }catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Una categoría válida POR FAVOR >:(");
        }

    }

    public Product save(ProductDTO productDTO) {

        Product product = new Product();
        try {
            product.setCategory(Category.valueOf(productDTO.getCategory().toUpperCase()));
            product.setDepartment(Department.valueOf(productDTO.getDepartment().toUpperCase()));

        }catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Una categoría y departamento tienen que ser válidos POR FAVOR >:(");
        }
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());

        return productRepository.save(product);
    }

    public void updateName(long id, String name) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            product.get().setName(name);
            productRepository.save(product.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El producto con el ID " + id + " no se encontró :C");
        }
    }

    public void deleteProduct(long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            productRepository.delete(product.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El producto no fue encontrado uwu");
        }
    }
}
