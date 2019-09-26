package com.perficient.onlineshop.appuserui;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.List;

public class AppUserClient {
    private static ParameterizedTypeReference<List<AppUserUI>> appUserListType = new ParameterizedTypeReference<List<AppUserUI>>() {};
    private String appUsersURL;
    private RestOperations restOperations;


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


    public List<AppUserUI> getAll() {
        return restOperations.exchange(appUsersURL, HttpMethod.GET, null, appUserListType).getBody();
    }

    public AppUserUI view(Long id) {
        String viewURL = new StringBuilder(appUsersURL).append("/").append(id).toString();
        return restOperations.getForObject(viewURL, AppUserUI.class);
    }
//
//    public int countAll() {
//        return restOperations.getForEntity(appUserURL + "/count", Integer.class).getBody();
//    }
//
//    public List<AppUserUI> findAll() {
//        String URI = UriComponentsBuilder.fromUriString(appUserURL).toUriString();
//        return restOperations.exchange(URI, HttpMethod.GET, null, appUserListType).getBody();
//    }
//
//    public List<AppUserUI> findRange(String field, String key) {
//        String URI = UriComponentsBuilder.fromUriString(appUserURL)
//                .queryParam("field", field)
//                .queryParam("key", key)
//                .toUriString();
//        return restOperations.exchange(URI, HttpMethod.GET, null, appUserListType).getBody();
//    }
}


