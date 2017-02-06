package services;

import java.util.concurrent.TimeUnit;

import interfaces.RestService;
import interfaces.RetrofitApiService;
import models.Post;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import services.Callbacks.RequestCallback;

/**
 * Created by receme on 2/6/17.
 */

public class RetrofitManager implements RestService{

    private final RetrofitApiService service;

    public RetrofitManager(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        OkHttpClient.Builder okHttp = new OkHttpClient.Builder();
        okHttp.connectTimeout(60, TimeUnit.SECONDS);
        okHttp.addInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceConstants.BASE_URL)
                .client(okHttp.build())
                .build();

        service = retrofit.create(RetrofitApiService.class);
    }

    @Override
    public void getPostAsync(String postId, RequestCallback<Post> postRequestCallback) {
        Call<Post> call = service.getPost(postId);
        call.enqueue(postRequestCallback);
    }
}
