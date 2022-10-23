package com.example.springoauth2.service;

import com.example.springoauth2.dtos.ProductDTO;
import com.example.springoauth2.entity.Product;
import com.example.springoauth2.exception.RestException;
import com.example.springoauth2.payload.ApiResult;
import com.example.springoauth2.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public ApiResult<Boolean> add(ProductDTO productDTO) {

        if (productRepository.existsByName(productDTO.getName()))
            throw RestException.throwEx("Product already exist", HttpStatus.CONFLICT);

        Product product = Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .build();

        productRepository.save(product);

        return ApiResult.successResponse();
    }

    @Override
    public ApiResult<Product> get(Integer id) {

        Product product = productRepository
                            .findById(id)
                            .orElseThrow(
                                () -> RestException
                                        .throwEx("Product not found",
                                                    HttpStatus.NOT_FOUND));

        return ApiResult.successResponse(product);
    }

    @Override
    public ApiResult<List<Product>> getList() {

        List<Product> products = productRepository
                .findAll();

        return ApiResult.successResponse(products);
    }

    @Override
    public ApiResult<Boolean> edit(ProductDTO productDTO) {

        productRepository
                .findById(productDTO.getId())
                .orElseThrow(
                        () -> RestException
                                .throwEx("Product not found",
                                        HttpStatus.NOT_FOUND));

        productRepository
                .findByName(productDTO.getName())
                .orElseThrow(
                        () -> RestException
                                .throwEx("Product already exist",
                                        HttpStatus.CONFLICT));

        Product product = Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .build();

        productRepository.save(product);

        return ApiResult.successResponse();
    }

    @Override
    public ApiResult<Boolean> delete(Integer id) {

        productRepository
                .findById(id)
                .orElseThrow(
                        () -> RestException
                                .throwEx("Product not found",
                                        HttpStatus.NOT_FOUND));

        productRepository.deleteById(id);

        return ApiResult.successResponse();
    }
}
