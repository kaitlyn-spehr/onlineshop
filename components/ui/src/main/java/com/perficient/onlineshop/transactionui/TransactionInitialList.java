package com.perficient.onlineshop.transactionui;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TransactionInitialList {

    public List<TransactionUI> asList() {
        return Arrays.asList(new TransactionUI(11L, 13L, "1/1/2019"),
                new TransactionUI(101L, 63L, "5/3/2019"),
                new TransactionUI(99L, 133L, "1/14/2019"),
                new TransactionUI(11L, 14L, "6/10/2019")
        );
    }
}
