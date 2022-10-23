package com.example.springoauth2.controller;

import com.example.springoauth2.dtos.ProductDTO;
import com.example.springoauth2.entity.Product;
import com.example.springoauth2.payload.ApiResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ProductController.BASE_PATH)
public interface ProductController {

    String BASE_PATH = "api/product";
    String NEW_PRODUCT_PATH = "/new";
    String GET_PRODUCT_PATH = "/{id}";
    String GET_PRODUCT_LIST_PATH = "/list";
    String EDIT_PRODUCT_PATH = "/edit";
    String DELETE_PRODUCT_PATH = "/{id}";

    @PostMapping(NEW_PRODUCT_PATH)
    ApiResult<Boolean> add(@RequestBody ProductDTO productDTO);

    @GetMapping(GET_PRODUCT_PATH)
    ApiResult<Product> get(@PathVariable Integer id);

    @GetMapping(GET_PRODUCT_LIST_PATH)
    ApiResult<List<Product>> getList();

    @PutMapping(EDIT_PRODUCT_PATH)
    ApiResult<Boolean> edit(@RequestBody ProductDTO productDTO);

    @DeleteMapping(DELETE_PRODUCT_PATH)
    ApiResult<Boolean> delete(@PathVariable Integer id);
}
