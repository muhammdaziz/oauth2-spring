package com.example.springoauth2.service;

import com.example.springoauth2.dtos.ProductDTO;
import com.example.springoauth2.entity.Product;
import com.example.springoauth2.payload.ApiResult;

import java.util.List;

public interface ProductService {

    ApiResult<Boolean> add(ProductDTO productDTO);

    ApiResult<Product> get(Integer id);

    ApiResult<List<Product>> getList();

    ApiResult<Boolean> edit(ProductDTO productDTO);

    ApiResult<Boolean> delete(Integer id);
}
