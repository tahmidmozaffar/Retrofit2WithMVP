package services;

import interfaces.RestClient;
import interfaces.RestService;
import models.Post;
import services.Retrofit.RequestCallback;

/**
 * Created by receme on 2/6/17.
 */

public class RestClientManager implements RestClient {

    private RestService service;

    public RestClientManager(RestService service) {
        this.service = service;
    }

    @Override
    public void getPostAsync(String postId, RequestCallback<Post> postRequestCallback) {
        service.getPostAsync(postId,postRequestCallback);
    }
}
