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
import services.Retrofit.RetrofitManager;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener{

    @BindView(R.id.editText)
    EditText postNumberEdtxt;
    @BindView(R.id.button)
    Button getPostBtn;
    @BindView(R.id.textView1)
    TextView tv1;
    @BindView(R.id.textView2)
    TextView tv2;
    @BindView(R.id.textView3)
    TextView tv3;
    @BindView(R.id.textView4)
    TextView tv4;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getPostBtn.setOnClickListener(this);

        presenter = new MainPresenter(this,new RestClientManager(new RetrofitManager()));
        //you can use other restclient library here.
        //to do that, replace RetrofitManager class with different implementation
    }

    @Override
    public void showPost(Post post) {
        tv1.setText(post.getId());
        tv2.setText(post.getUserid());
        tv3.setText(post.getTitle());
        tv4.setText(post.getBody());
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
