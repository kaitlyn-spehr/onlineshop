package com.perficient.onlineshop.transactionui;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.List;

public class TransactionClient {
    private static ParameterizedTypeReference<List<TransactionUI>> transactionListType = new ParameterizedTypeReference<List<TransactionUI>>() {};
    private String transactionsURL;
    private RestOperations restOperations;
    private static final int CACHE_SIZE = 5;
    private final List<TransactionUI> lastRead = new ArrayList<>(CACHE_SIZE);


    public TransactionClient(String transactionsURL, RestOperations restOperations) {
        this.transactionsURL = transactionsURL;
        this.restOperations = restOperations;
    }

    public void create(TransactionUI transactionUI) {
        restOperations.postForEntity(transactionsURL, transactionUI, TransactionUI.class);
    }

    @HystrixCommand(fallbackMethod="getAllFallback")
    public List<TransactionUI> getAll() {
        List<TransactionUI> read = restOperations.exchange(transactionsURL, HttpMethod.GET, null, transactionListType).getBody();
        lastRead.clear();
        int copyCount = (read.size() < CACHE_SIZE) ? read.size() : CACHE_SIZE;
        for (int i =0; i < copyCount; i++) {
            lastRead.add(read.get(i));
        }
        return read;
    }

    public List<TransactionUI> getAllFallback() {
        return lastRead;
    }

}


