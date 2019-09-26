package com.perficient.onlineshop;


import com.perficient.onlineshop.appuserui.AppUserClient;
import com.perficient.onlineshop.appuserui.AppUserInitialList;
import com.perficient.onlineshop.productui.ProductClient;
import com.perficient.onlineshop.productui.ProductInitialList;
import com.perficient.onlineshop.transactionui.TransactionClient;
import com.perficient.onlineshop.transactionui.TransactionInitialList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class RootController {
    private AppUserClient appUserClient;
    private ProductClient productClient;
    private TransactionClient transactionClient;

    public RootController(AppUserClient appUserClient, ProductClient productClient, TransactionClient transactionClient) {
        this.appUserClient = appUserClient;
        this.productClient = productClient;
        this.transactionClient = transactionClient;
    }
    @GetMapping("/")
    public String rootPath()
    {
        return "home";
    }


//    @GetMapping("/setup")
//    public String setupDatabase(Map<String, Object> model, AppUserInitialList appUserInitialList, ProductInitialList productInitialList, TransactionInitialList transactionInitialList) {
//        appUserInitialList.asList().forEach(appUserClient::create);
//        productInitialList.asList().forEach(productClient::create);
//        transactionInitialList.asList().forEach(transactionClient::create);
//        model.put("appusers", appUserClient.getAll());
//        model.put("products", productClient.getAll());
//        model.put("transactions", transactionClient.getAll());
//        return "setup";
//    }

}
