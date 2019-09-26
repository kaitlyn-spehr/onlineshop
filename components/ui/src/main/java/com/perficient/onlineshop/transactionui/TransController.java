package com.perficient.onlineshop.transactionui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class TransController {
    private TransactionClient transactionClient;

    public TransController(TransactionClient transactionClient) {
        this.transactionClient = transactionClient;
    }
    @GetMapping("/transactions")
    public String allTransactions(Map<String,Object> model) {
        model.put("transactions", transactionClient.getAll());
        return "transactions";
    }
}

