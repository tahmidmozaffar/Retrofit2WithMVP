package services;

import java.util.List;

import interfaces.RequestListener;
import interfaces.RestClient;
import interfaces.RestService;
import models.Comment;
import models.Post;

/**
 * Created by receme on 2/6/17.
 */

public class RestClientManager implements RestClient {

    private RestService service;

    public RestClientManager(RestService service) {
        this.service = service;
    }

    @Override
    public void getPostAsync(String postId, RequestListener<Post> listener) {
        service.getPostAsync(postId,listener);
    }

    @Override
    public void getCommentsAsync(String postId, RequestListener<List<Comment>> listener) {
        service.getCommentsAsync(postId,listener);
    }
}
