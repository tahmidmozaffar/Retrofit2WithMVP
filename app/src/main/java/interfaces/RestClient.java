package interfaces;

import models.Post;

/**
 * Created by receme on 2/6/17.
 */
public interface RestClient {
    void getPostAsync(String postId,RequestListener<Post> listener);
}
