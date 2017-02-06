package services.Retrofit;

import java.util.concurrent.TimeUnit;

import interfaces.RequestListener;
import interfaces.RestService;
import models.Post;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.ServiceConstants;

/**
 * Created by receme on 2/6/17.
 */

public class RetrofitManager implements RestService {

    private final RetrofitApiService service;

    public RetrofitManager() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        OkHttpClient.Builder okHttp = new OkHttpClient.Builder();
        okHttp.connectTimeout(60, TimeUnit.SECONDS);
        okHttp.addInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp.build())
                .build();

        service = retrofit.create(RetrofitApiService.class);
    }

    @Override
    public void getPostAsync(String postId, RequestListener<Post> listener) {
        Call<Post> call = service.getPost(postId);
        call.enqueue(new RequestCallback<>(listener));
    }
}
