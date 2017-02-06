package presenters;

import interfaces.MainView;
import interfaces.RequestListener;
import interfaces.RestClient;
import models.Post;

/**
 * Created by receme on 2/6/17.
 */

public class MainPresenter implements RequestListener<Post> {

    private MainView view;
    private RestClient service;

    public MainPresenter(MainView view, RestClient service) {
        this.view = view;
        this.service = service;
    }

    public void getPost(String postId) {
        if (postId == null || postId.isEmpty()) {
            view.showAlert("Please enter a post id");
            return;
        }

        view.showProgressDialog("Please wait...");
        service.getPostAsync(postId, this);
    }

    @Override
    public void onResponseSuccess(Post post) {

        view.hideProgressDialog();

        if(post!=null){
            view.showPost(post);
        }
        else{
            view.showAlert("Post cannot be loaded");
        }
    }

    @Override
    public void onResponseFailure(Throwable t) {

        view.hideProgressDialog();

        if(t!=null){
            view.showAlert(t.getMessage());
        }
    }
}
