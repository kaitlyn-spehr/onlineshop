package com.perficient.onlineshop.appuserui;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.List;

public class AppUserClient {
    private static ParameterizedTypeReference<List<AppUserUI>> appUserListType = new ParameterizedTypeReference<List<AppUserUI>>() {};
    private String appUsersURL;
    private RestOperations restOperations;
    private static final int CACHE_SIZE = 5;
    private final List<AppUserUI> lastRead = new ArrayList<>(CACHE_SIZE);


    public AppUserClient(String appUsersURL, RestOperations restOperations) {
        this.appUsersURL = appUsersURL;
        this.restOperations = restOperations;
    }

    public void create(AppUserUI appUserUI) {
        restOperations.postForEntity(appUsersURL, appUserUI, AppUserUI.class);
    }

    public void delete(Long id) {
        String deleteURL = new StringBuilder(appUsersURL).append("/").append(id).toString();
        restOperations.delete(deleteURL);
    }

    @HystrixCommand(fallbackMethod="getAllFallback")
    public List<AppUserUI> getAll() {
        List<AppUserUI>read = restOperations.exchange(appUsersURL, HttpMethod.GET, null, appUserListType).getBody();
        lastRead.clear();
        int copyCount = (read.size() < CACHE_SIZE) ? read.size() : CACHE_SIZE;
        for (int i =0; i < copyCount; i++) {
            lastRead.add(read.get(i));
        }
        return read;
    }


    public List<AppUserUI> getAllFallback() {
        return lastRead;
    }

    public AppUserUI view(Long id) {
        String viewURL = new StringBuilder(appUsersURL).append("/").append(id).toString();
        return restOperations.getForObject(viewURL, AppUserUI.class);
    }
}


