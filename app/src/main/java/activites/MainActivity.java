package activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rcmapps.retrofit2withmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import interfaces.MainView;
import models.Post;
import presenters.MainPresenter;
import services.RestClientManager;
import services.Retrofit.RetrofitManager;
import utils.AppUtils;

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
        tv2.setText(post.getUserId());
        tv3.setText(post.getTitle());
        tv4.setText(post.getBody());
    }

    @Override
    public void showAlert(String message) {
        AppUtils.showSimpleAlertWithMessage(this,"",message);
    }

    @Override
    public void showProgressDialog(String message) {
        AppUtils.showProgressDialog(this,message);
    }

    @Override
    public void hideProgressDialog() {
        AppUtils.hideProgressDialog(this);
    }

    @Override
    public void onClick(View view) {
        if(view.equals(getPostBtn)){
            presenter.getPost(postNumberEdtxt.getText().toString());
        }
    }
}
