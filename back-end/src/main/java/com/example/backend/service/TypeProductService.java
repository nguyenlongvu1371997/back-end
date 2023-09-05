package com.example.backend.service;

import com.example.backend.model.TypeProduct;
import com.example.backend.repository.ITypeProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TypeProductService implements ITypeProductService {
    @Autowired
    private ITypeProductRepository iTypeProductRepository;

    @Override
    public List<TypeProduct> getTypeProductList() {
        return iTypeProductRepository.getTypeProductList();
    }
}
