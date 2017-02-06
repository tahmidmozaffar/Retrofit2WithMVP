package interfaces;

/**
 * Created by receme on 2/7/17.
 */

public abstract interface RequestListener<T> {
    void onResponseSuccess(T response);
    void onResponseFailure(Throwable t);
}
