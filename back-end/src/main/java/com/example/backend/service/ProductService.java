package com.example.backend.service;

import com.example.backend.model.Product;
import com.example.backend.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> getProductList(Pageable pageable, String name, String typeId) {
        return productRepository.getProductByNameAndType(pageable, name, typeId);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.createProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public void editProduct(Product product) {
        productRepository.editProduct(product);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findProductById(id);
    }
}
