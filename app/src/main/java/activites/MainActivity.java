package activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rcmapps.retrofit2withmvp.R;

import interfaces.MainView;
import presenters.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView{

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        presenter.init();

    }
}
