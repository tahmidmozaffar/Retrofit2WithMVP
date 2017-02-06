package services;

import java.util.concurrent.TimeUnit;

import interfaces.RetrofitApiService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by receme on 2/6/17.
 */

public class RetrofitManager{

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
}
