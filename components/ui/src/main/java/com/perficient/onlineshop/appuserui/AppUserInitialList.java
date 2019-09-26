package com.perficient.onlineshop.appuserui;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AppUserInitialList {

    public List<AppUserUI> asList() {
        return Arrays.asList(new AppUserUI("Kaitlyn","ks@gmail.com","1234", "Columbus"),
                new AppUserUI("Bob","bb@gmail.com","pass", "Detroit"),
                new AppUserUI("Steve","steve@gmail.com","password", "New York"),
                new AppUserUI("Karen","karen@gmail.com","1234", "Dayton")
        );
    }
}
