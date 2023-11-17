package com.CodeWithBhargav.controller;

import com.CodeWithBhargav.model.Role;
import com.CodeWithBhargav.request.VendorRequest;
import com.CodeWithBhargav.response.VendorResponse;
import com.CodeWithBhargav.response.common.APIResponse;
import com.CodeWithBhargav.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin/vendor")
//@PreAuthorize("hasRole('ROLE_VENDOR')")
@RolesAllowed(Role.VENDOR)
public class VendorController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private VendorService vendorService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllVendors() {
        VendorResponse vendorResponse = vendorService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(vendorResponse.getVendors());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse> createVendor(@Valid @RequestBody
                                                      VendorRequest vendorRequest) {
        VendorResponse vendorResponse  = vendorService.create(vendorRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(vendorResponse.getVendors());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateVendor(@Valid @RequestBody
                                                      VendorRequest vendorRequest) {
        VendorResponse vendorResponse= vendorService.update(vendorRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(vendorResponse.getVendors());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteCategory(@Valid @PathVariable Integer id) {
        VendorResponse vendorResponse = vendorService.deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(vendorResponse.getVendors());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
