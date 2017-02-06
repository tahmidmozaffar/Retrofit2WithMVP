package interfaces;

import models.Post;
import services.Retrofit.RequestCallback;

/**
 * Created by receme on 2/6/17.
 */

// Implement this in your restclient library manager class
// In this project, 'Retrofit2' is used
public interface RestService {
    void getPostAsync(String postId, RequestCallback<Post> postRequestCallback);
}
