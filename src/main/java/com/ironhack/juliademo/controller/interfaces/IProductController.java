package com.ironhack.juliademo.controller.interfaces;

import com.ironhack.juliademo.controller.dto.ProductDTO;
import com.ironhack.juliademo.controller.dto.ProductNameDTO;
import com.ironhack.juliademo.model.Product;

import java.util.List;

public interface IProductController {
    public List<Product> findAll();
    public List<Product> findByCategory(String category);
    public Product create(ProductDTO productDTO);
    public void updateName(long id, ProductNameDTO productNameDTO);
    public void delete(long id);
}
