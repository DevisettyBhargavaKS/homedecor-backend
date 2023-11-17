package com.CodeWithBhargav.service;
import com.CodeWithBhargav.dto.VendorDto;
import com.CodeWithBhargav.model.Vendor;
import com.CodeWithBhargav.repository.VendorRepository;
import com.CodeWithBhargav.request.VendorRequest;
import com.CodeWithBhargav.response.VendorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private VendorDto vendorDto;

    public VendorResponse findAll() {
        List<Vendor> vendors = vendorRepository.findAll();
        return vendorDto.mapToVendorResponse(vendors);
    }

    public VendorResponse create(VendorRequest vendorRequest) {
        Vendor vendor = vendorDto.mapToVendor(vendorRequest);
        vendorRepository.save(vendor);
        return findAll();
    }

    public VendorResponse update(VendorRequest vendorRequest) {
        Vendor vendor  = vendorDto.mapToVendor(vendorRequest);
        vendorRepository.save(vendor);
        return findAll();
    }

    public VendorResponse deleteById(Integer id) {
        vendorRepository.deleteById(Long.valueOf(id));
        return findAll();
    }
}
