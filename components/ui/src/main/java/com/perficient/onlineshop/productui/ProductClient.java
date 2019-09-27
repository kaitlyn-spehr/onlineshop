package com.perficient.onlineshop.productui;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.List;

public class ProductClient {
    private static ParameterizedTypeReference<List<ProductUI>> productListType = new ParameterizedTypeReference<List<ProductUI>>() {};
    private String productsURL;
    private RestOperations restOperations;
    private static final int CACHE_SIZE = 5;
    private final List<ProductUI> lastRead = new ArrayList<>(CACHE_SIZE);


    public ProductClient(String productsURL, RestOperations restOperations) {
        this.productsURL = productsURL;
        this.restOperations = restOperations;
    }

    public void create(ProductUI productUI) {
        restOperations.postForEntity(productsURL, productUI, ProductUI.class);
    }

    @HystrixCommand(fallbackMethod="getAllFallback")
    public List<ProductUI> getAll() {
        List<ProductUI> read = restOperations.exchange(productsURL, HttpMethod.GET, null, productListType).getBody();
        lastRead.clear();
        int copyCount = (read.size() < CACHE_SIZE) ? read.size() : CACHE_SIZE;
        for (int i =0; i < copyCount; i++) {
            lastRead.add(read.get(i));
        }
        return read;
    }

    public List<ProductUI> getAllFallback() {
        return lastRead;
    }

    public void delete(Long id) {
        String deleteURL = new StringBuilder(productsURL).append("/").append(id).toString();
        restOperations.delete(deleteURL);
    }

    public ProductUI view(Long id) {
        String viewURL = new StringBuilder(productsURL).append("/").append(id).toString();
        return restOperations.getForObject(viewURL, ProductUI.class);
    }

}


