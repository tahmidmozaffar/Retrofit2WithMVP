package interfaces;

import java.util.List;

import models.Comment;
import models.Post;

/**
 * Created by receme on 2/6/17.
 */
public interface RestClient {
    void getPostAsync(String postId,RequestListener<Post> listener);
    void getCommentsAsync(String postId,RequestListener<List<Comment>> listener);
}
