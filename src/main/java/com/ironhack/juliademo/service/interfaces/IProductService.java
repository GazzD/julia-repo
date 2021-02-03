package com.ironhack.juliademo.service.interfaces;

import com.ironhack.juliademo.controller.dto.ProductDTO;
import com.ironhack.juliademo.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findByCategory(String category);
    public Product save(ProductDTO productDTO);
    public void updateName(long id, String name);
    public void deleteProduct(long id);
}
