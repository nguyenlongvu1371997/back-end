package com.example.backend.service;

import com.example.backend.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> getProductList(Pageable pageable, String name, String typeId);

    void createProduct(Product product);

    void deleteProduct(Integer id);

    void editProduct(Product product);

    Product getProductById(Integer id);

}
