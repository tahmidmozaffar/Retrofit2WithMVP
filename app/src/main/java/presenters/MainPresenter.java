package presenters;

import interfaces.MainView;
import interfaces.RequestListener;
import models.Post;
import interfaces.RestClient;
import services.Retrofit.RequestCallback;

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
        if (postId == null) {
            view.showAlert("Please enter a post id");
            return;
        }

        service.getPostAsync(postId, new RequestCallback<>(this));
    }

    @Override
    public void onResponseSuccess(Post post) {
        if(post!=null){
            view.showPost(post);
        }
        else{
            view.showAlert("Post cannot be loaded");
        }
    }

    @Override
    public void onResponseFailure(Throwable t) {
        if(t!=null){
            view.showAlert(t.getMessage());
        }
    }
}
