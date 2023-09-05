package com.example.backend.controller;

import com.example.backend.service.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/typeProduct")
public class TypeProductController {
    @Autowired
    private ITypeProductService typeProductService;

    @GetMapping
    public ResponseEntity<?> getTypeProductList(){
        return new ResponseEntity<>(typeProductService.getTypeProductList(), HttpStatus.OK);
    }
}
