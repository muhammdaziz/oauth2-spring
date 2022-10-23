package com.example.springoauth2.controller;

import com.example.springoauth2.dtos.ProductDTO;
import com.example.springoauth2.entity.Product;
import com.example.springoauth2.payload.ApiResult;
import com.example.springoauth2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController{

    private final ProductService productService;

    @Override
    public ApiResult<Boolean> add(ProductDTO productDTO) {
        return productService.add(productDTO);
    }

    @Override
    public ApiResult<Product> get(Integer id) {
        return productService.get(id);
    }

    @Override
    public ApiResult<List<Product>> getList() {
        return productService.getList();
    }

    @Override
    public ApiResult<Boolean> edit(ProductDTO productDTO) {
        return productService.edit(productDTO);
    }

    @Override
    public ApiResult<Boolean> delete(Integer id) {
        return productService.delete(id);
    }
}
