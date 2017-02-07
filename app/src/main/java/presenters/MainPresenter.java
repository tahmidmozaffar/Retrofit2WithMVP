package presenters;

import java.util.List;

import interfaces.MainView;
import interfaces.RequestListener;
import interfaces.RestClient;
import models.Comment;
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

        if (post != null) {
            view.showPost(post);
        } else {
            view.showAlert("Post cannot be loaded");
        }
    }

    @Override
    public void onResponseFailure(Throwable t) {

        view.hideProgressDialog();

        if (t != null) {
            view.showAlert(t.getMessage());
        }
    }

    public void getCommment(String postId) {

        if (postId == null || postId.isEmpty()) {
            view.showAlert("Please enter a post id");
            return;
        }

        view.showProgressDialog("Please wait...");
        service.getCommentsAsync(postId, new RequestListener<List<Comment>>() {
            @Override
            public void onResponseSuccess(List<Comment> response) {
                view.hideProgressDialog();
                processComments(response);
            }

            @Override
            public void onResponseFailure(Throwable t) {
                view.hideProgressDialog();
                onResponseFailure(t);
            }
        });


    }

    public void processComments(List<Comment> comments) {
        if (comments == null) {
            view.showAlert("Post cannot be loaded");
            return;
        }

        if (comments.size() == 0) {
            view.showAlert("No comments has been posted for this post.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            sb.append(comment.getPostId());
            sb.append(System.getProperty("line.separator"));
            sb.append(comment.getId());
            sb.append(System.getProperty("line.separator"));
            sb.append(comment.getName());
            sb.append(System.getProperty("line.separator"));
            sb.append(comment.getEmail());
            sb.append(System.getProperty("line.separator"));
            sb.append(comment.getBody());
            sb.append(System.getProperty("line.separator"));
            sb.append(System.getProperty("line.separator"));
            sb.append(System.getProperty("line.separator"));
        }
        view.showComments(sb.toString());
    }

}
