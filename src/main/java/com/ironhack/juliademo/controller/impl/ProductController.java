package com.ironhack.juliademo.controller.impl;

import com.ironhack.juliademo.controller.dto.ProductDTO;
import com.ironhack.juliademo.controller.dto.ProductNameDTO;
import com.ironhack.juliademo.controller.interfaces.IProductController;
import com.ironhack.juliademo.model.Product;
import com.ironhack.juliademo.repository.ProductRepository;
import com.ironhack.juliademo.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController implements IProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IProductService productService;


    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/products/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findByCategory(@PathVariable("category") String category) {
        return productService.findByCategory(category);
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody @Valid ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @PatchMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateName(@PathVariable long id, @RequestBody @Valid ProductNameDTO productNameDTO) {
        productService.updateName(id, productNameDTO.getName());
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable long id) {
        productService.deleteProduct(id);
    }
}
