package interfaces;

/**
 * Created by receme on 2/7/17.
 */

public interface RequestListener<T> {
    void onResponseSuccess(T response);
    void onResponseFailure(Throwable t);
}
