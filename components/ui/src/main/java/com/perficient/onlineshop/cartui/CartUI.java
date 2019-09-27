package com.perficient.onlineshop.cartui;

import com.perficient.onlineshop.productui.ProductUI;

import java.util.HashMap;
import java.util.Map;

public class CartUI {
    private Map<ProductUI, Integer> items;
    private double total;

    public CartUI(){
        items = new HashMap<>();
        total = 0;
    }

    public CartUI(Map<ProductUI, Integer> items) {
        this.items = items;
        double total = 0;
        for(Map.Entry<ProductUI, Integer> item: items.entrySet()){
            total += item.getKey().getPdcost()*item.getValue();
        }
        this.total = total;
    }

    public Map<ProductUI,Integer> getItems() {
        return items;
    }

    public void addItem(ProductUI productUI, Integer quantity) {
        items.put(productUI, quantity);
        total += productUI.getPdcost()*quantity;
    }

    public void deleteItem(ProductUI productUI){
        total -= productUI.getPdcost()*items.get(productUI);
        items.remove(productUI);
    }

    public double getTotal() {
        return total;
    }

    public void clear(){
        items = new HashMap<>();
        total = 0;
    }
}
