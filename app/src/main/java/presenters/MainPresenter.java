package presenters;

import interfaces.MainView;
import interfaces.RequestListener;
import interfaces.RestService;
import models.Post;
import interfaces.RestClient;
import models.SSS;
import services.Callbacks.RequestCallback;

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
    public void onResponseSuccess(Post response) {

    }

    @Override
    public void onResponseFailure(Throwable t) {

    }
}
