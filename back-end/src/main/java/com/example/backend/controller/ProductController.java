package com.example.backend.controller;

import com.example.backend.dto.ProductDto;
import com.example.backend.model.Product;
import com.example.backend.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping()
    public ResponseEntity<?> getProductList(@RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam("name") String name, @RequestParam("typeId") String typeId) {
        Pageable pageable = PageRequest.of(page, limit);
        return new ResponseEntity<>(productService.getProductList(pageable, name, typeId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult, @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        Product updatedProduct = new Product();
        BeanUtils.copyProperties(productDto, updatedProduct);
        productService.editProduct(updatedProduct);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        Product createProduct = new Product();
        BeanUtils.copyProperties(productDto, createProduct);
        productService.createProduct(createProduct);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
