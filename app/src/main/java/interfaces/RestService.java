package interfaces;

import java.util.List;

import models.Comment;
import models.Post;

/**
 * Created by receme on 2/6/17.
 */

// Implement this in your restclient library manager class
// In this project, 'Retrofit2' is used
public interface RestService {
    void getPostAsync(String postId,RequestListener<Post> listener);
    void getCommentsAsync(String postId,RequestListener<List<Comment>> listener);
}
