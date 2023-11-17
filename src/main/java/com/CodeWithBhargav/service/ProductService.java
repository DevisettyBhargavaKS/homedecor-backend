package com.CodeWithBhargav.service;

import com.CodeWithBhargav.dto.ProductDto;
import com.CodeWithBhargav.exception.common.ResourceNotFoundException;
import com.CodeWithBhargav.model.Category;
import com.CodeWithBhargav.model.Product;
import com.CodeWithBhargav.repository.CategoryRepository;
import com.CodeWithBhargav.repository.ProductRepository;
import com.CodeWithBhargav.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductService {

    @Autowired
    private ProductDto productDto;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public List<Product> createProduct(ProductRequest productRequest) {
        Product product = ProductDto.mapToProduct(productRequest);
        Category category = categoryRepository.findById(productRequest.getCategory_id())
                .orElseThrow(() -> new ResourceNotFoundException("Category_id",
                        "Category_id", productRequest.getCategory_id()));
        assert product != null;
        product.setCategory(category);
        productRepository.save(product);
        return findAll();
    }

    @Transactional
    public List<Product> updateProduct(ProductRequest productRequest) {
        Product product = productDto.mapToProduct(productRequest);
        Category category = categoryRepository.findById(productRequest.getCategory_id())
                .orElseThrow(() -> new ResourceNotFoundException("Category_id",
                        "Category_id", productRequest.getCategory_id()));
        assert product != null;
        product.setCategory(category);
        productRepository.save(product);
        return findAll();
    }
@Transactional
    public List<Product> deleteById(Integer id) {
        productRepository.deleteById(Long.valueOf(id));
        return findAll();
    }
}
