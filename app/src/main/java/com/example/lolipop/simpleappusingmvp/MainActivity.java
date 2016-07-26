package com.example.lolipop.simpleappusingmvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.login.mvp.LoginPresenterImpliment;
import com.login.mvp.LoginView;
import com.login.mvp.LoginViewPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LoginView{


    @Bind(R.id.password)
    EditText userPassword;
    @Bind(R.id.username)
    EditText userName;
    @Bind(R.id.progress)
    ProgressBar progressBar;
    @Bind(R.id.button)
    Button button;


    public LoginViewPresenter loginViewPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        loginViewPresenter = new LoginPresenterImpliment(this);
        ButterKnife.bind(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewPresenter.OnFinishedSuccess(userName.getText().toString() , userPassword.getText().toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {

        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setUserNameError() {
        userName.setError(getString(R.string.username_error));
    }

    @Override
    public void setUserPasswordError() {
        userPassword.setError(getString(R.string.password_error));
    }

    @Override
    public void OnGoToAnotherAcitivity() {
        startActivity(new Intent(MainActivity.this , SecondActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginViewPresenter.OnDestroy();
        finish();
    }
}
