package com.perficient.onlineshop.productui;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductInitialList {

    public List<ProductUI> asList() {
        return Arrays.asList(new ProductUI("Electronics", "Iphone", 1000, "New iphone 11", 50),
                new ProductUI("Furniture", "Dresser", 100, "New design", 100),
                new ProductUI("Furniture", "Couch", 700, "Sectional Sofa", 25),
                new ProductUI("Clothing", "Shirt", 25, "Comes in black, white, or grey", 125)
        );
    }
}
