package services.Retrofit;

import models.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by receme on 2/6/17.
 */

public interface RetrofitApiService {

    @GET("/posts/{postId}")
    Call<Post> getPost(@Path("postId") String postId);

}
