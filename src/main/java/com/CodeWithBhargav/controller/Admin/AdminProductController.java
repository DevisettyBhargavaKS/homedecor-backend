package com.CodeWithBhargav.controller.Admin;

import com.CodeWithBhargav.model.Product;
import com.CodeWithBhargav.model.Role;
import com.CodeWithBhargav.request.ProductRequest;
import com.CodeWithBhargav.response.common.APIResponse;
import com.CodeWithBhargav.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/admin/product")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RolesAllowed(Role.ADMIN)
public class AdminProductController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllProducts() {
        List<Product> productList = productService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(productList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse> createProduct(@RequestBody
                                                  ProductRequest productRequest) {
        List<Product> productList = productService.createProduct(productRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(productList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateProduct(@RequestBody
                                                     ProductRequest productRequest) {
        List<Product> productList = productService.updateProduct(productRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(productList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteProduct(@PathVariable Integer id) {
        List<Product> productList = productService.deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(productList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
