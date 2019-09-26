package com.perficient.onlineshop.appuserui;

import com.perficient.onlineshop.productui.ProductClient;
import com.perficient.onlineshop.productui.ProductUI;
import com.perficient.onlineshop.transactionui.TransactionClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CartController {
    private CartClient cartClient;
    private ProductClient productClient;

    public CartController(ProductClient productClient) {
        this.productClient = productClient;
        this.cartClient = new CartClient();
    }


    @GetMapping("/cart")
    public String allProducts(Map<String,Object> model) {
        model.put("cart", cartClient.view());
        return "cart";
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        cartClient.deleteProduct(productClient.view(id));
        return "backtoproducts";
    }

    @GetMapping("/cart/add/{id}")
    public String addItem(@PathVariable Long id, @RequestParam int quantity) {
        cartClient.addProduct(productClient.view(id), quantity);
        return "backtoproducts";
    }

    @GetMapping("/cart/checkout")
    public String checkout(Map<String, Object> model) {
        CartUI cart = cartClient.view();
        for(Map.Entry<ProductUI, Integer> item: cart.getItems().entrySet()){
            ProductUI product = productClient.view(item.getKey().getId());
            productClient.delete(item.getKey().getId());
            product.increasePdquantity(item.getValue());
            productClient.create(product);
        }
        cartClient.clear();
        return "checkout";
    }
}
