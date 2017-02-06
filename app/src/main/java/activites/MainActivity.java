package activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rcmapps.retrofit2withmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import interfaces.MainView;
import models.Post;
import presenters.MainPresenter;
import services.RestClientManager;
import services.RetrofitManager;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener{

    @BindView(R.id.editText)
    private EditText postNumberEdtxt;
    @BindView(R.id.button)
    private Button getPostBtn;
    @BindView(R.id.textView1)
    private TextView tv1;
    @BindView(R.id.textView2)
    private TextView tv2;
    @BindView(R.id.textView3)
    private TextView tv3;
    @BindView(R.id.textView4)
    private TextView tv4;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getPostBtn.setOnClickListener(this);

        presenter = new MainPresenter(this,new RestClientManager(new RetrofitManager()));
    }

    @Override
    public void showPost(Post post) {

    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if(view.equals(getPostBtn)){
            presenter.getPost(postNumberEdtxt.getText().toString());
        }
    }
}
