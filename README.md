# Retrofit2WithMVP
This is an implementation of Retrofit2 with Model View Presenter architecture.

In this project 'https://jsonplaceholder.typicode.com' API is used to test GET request.

To use it in your api change `RetrofitApiService` according to your api calls and implement `RestClient` and `RestService` interface.

Please see `RetrofitManager` class to see where actual retrofit Call is made.

Also, add callback class and pass reference of `RequestListener` interface.
Please see `RequestCallback` class for reference.

**_As you see,this implementation is only for async call._**


**TO DO:**
Add support for sync call

