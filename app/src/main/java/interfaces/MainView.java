package interfaces;

import models.Post;

/**
 * Created by receme on 2/6/17.
 */

public interface MainView {
    void showPost(Post post);
    void showComments(String comments);
    void showAlert(String message);
    void showProgressDialog(String message);
    void hideProgressDialog();
}
