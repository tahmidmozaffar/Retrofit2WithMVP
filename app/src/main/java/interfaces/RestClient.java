package interfaces;

import models.Post;
import services.Callbacks.RequestCallback;

/**
 * Created by receme on 2/6/17.
 */
public interface RestClient {
    void getPostAsync(String postId, RequestCallback<Post> postRequestCallback);
}
