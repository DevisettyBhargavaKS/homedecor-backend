package com.CodeWithBhargav.dto;

import com.CodeWithBhargav.model.Address;
import com.CodeWithBhargav.request.AddressRequest;
import com.CodeWithBhargav.response.AddressResponse;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AddressDto {
    public AddressResponse mapToAddressResponse(List<Address> addressList) {
        return null;

    }

    public Address mapToAddress(AddressRequest addressRequest) {
        return null;

    }
}
