package com.perficient.onlineshop.productui;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.List;

public class ProductClient {
    private static ParameterizedTypeReference<List<ProductUI>> productListType = new ParameterizedTypeReference<List<ProductUI>>() {};
    private String productsURL;
    private RestOperations restOperations;


    public ProductClient(String productsURL, RestOperations restOperations) {
        this.productsURL = productsURL;
        this.restOperations = restOperations;
    }

    public void create(ProductUI productUI) {
        restOperations.postForEntity(productsURL, productUI, ProductUI.class);
    }

    public List<ProductUI> getAll() {
        return restOperations.exchange(productsURL, HttpMethod.GET, null, productListType).getBody();
    }

    public void delete(Long id) {
        String deleteURL = new StringBuilder(productsURL).append("/").append(id).toString();
        restOperations.delete(deleteURL);
    }

    public ProductUI view(Long id) {
        String viewURL = new StringBuilder(productsURL).append("/").append(id).toString();
        return restOperations.getForObject(viewURL, ProductUI.class);
    }
//
//    public int countAll() {
//        return restOperations.getForEntity(productURL + "/count", Integer.class).getBody();
//    }
//
//    public List<ProductUI> findAll() {
//        String URI = UriComponentsBuilder.fromUriString(productURL).toUriString();
//        return restOperations.exchange(URI, HttpMethod.GET, null, productListType).getBody();
//    }
//
//    public List<ProductUI> findRange(String field, String key) {
//        String URI = UriComponentsBuilder.fromUriString(productURL)
//                .queryParam("field", field)
//                .queryParam("key", key)
//                .toUriString();
//        return restOperations.exchange(URI, HttpMethod.GET, null, productListType).getBody();
//    }
}


