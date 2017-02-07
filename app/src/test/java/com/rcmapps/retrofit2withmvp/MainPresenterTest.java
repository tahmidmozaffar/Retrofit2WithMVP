package com.rcmapps.retrofit2withmvp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import interfaces.MainView;
import interfaces.RequestListener;
import interfaces.RestClient;
import presenters.MainPresenter;
import services.Retrofit.RequestCallback;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

/**
 * Created by receme on 2/7/17.
 */

public class MainPresenterTest {

    @Mock
    RestClient restClient;
    @Mock
    MainView view;

    private MainPresenter presenter;

    @Before
    public void init() {
        view = mock(MainView.class);
        restClient = mock(RestClient.class);
        presenter = new MainPresenter(view, restClient);
    }

    @Test
    public void getPost_withValidPostId_willCallApi() {

        presenter.getPost("1");

        Mockito.verify(view).showProgressDialog(Mockito.anyString());
        Mockito.verify(restClient).getPostAsync(Mockito.anyString(),  Mockito.any(RequestListener.class));

    }

    @Test
    public void getPost_withNullPostId_willNotCallApi() {

        presenter.getPost(null);

        Mockito.verify(view,times(0)).showProgressDialog(Mockito.anyString());
        Mockito.verify(restClient,times(0)).getPostAsync(Mockito.anyString(),  Mockito.any(RequestListener.class));

    }

    @Test
    public void getPost_withEmptyPostId_willNotCallApi() {

        presenter.getPost("");

        Mockito.verify(view,times(0)).showProgressDialog(Mockito.anyString());
        Mockito.verify(restClient,times(0)).getPostAsync(Mockito.anyString(),  Mockito.any(RequestListener.class));

    }

    @Test
    public void getCommment_withValidPostId_willCallApi(){
        presenter.getCommment("1");

        Mockito.verify(view,times(1)).showProgressDialog(Mockito.anyString());
        Mockito.verify(restClient, times(1)).getCommentsAsync(Mockito.anyString(),Mockito.any(RequestListener.class));
    }
}
