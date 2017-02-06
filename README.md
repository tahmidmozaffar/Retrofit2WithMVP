# Retrofit2WithMVP
This is an implementation of Retrofit2 with Model View Presenter architecture.

In this project 'https://jsonplaceholder.typicode.com' API is used to test GET request.

Here `Retrofit2` is used. But any other restclient library can be used also.

To do that just implement `RestService` interface in your Restclient library manager class and add specific implementation for the library you used.

Please see `RetrofitManager` class for reference.

Also, add callback class and pass reference of `RequestListener` interface.
Please see `RequestCallback` class for reference.

_As you see,this implementation is only for async call._


**TO DO:**
Add support for sync call

