package com.CodeWithBhargav.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private Long id;
    private Long category_id;
    private String title;
    private String description;
    private Double price;
    private byte[] photo;
}
