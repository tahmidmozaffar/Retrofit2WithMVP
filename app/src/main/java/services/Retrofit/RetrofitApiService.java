package services.Retrofit;

import java.util.List;

import models.Comment;
import models.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by receme on 2/6/17.
 */

public interface RetrofitApiService {

    @GET("/posts/{postId}")
    Call<Post> getPost(@Path("postId") String postId);

    @GET("posts/{postId}/comments")
    Call<List<Comment>> getComment(@Path("postId") String postId);
}
