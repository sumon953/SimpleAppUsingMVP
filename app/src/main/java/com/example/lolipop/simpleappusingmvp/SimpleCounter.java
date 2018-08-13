package com.example.lolipop.simpleappusingmvp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.simple.counter.mvp.CounterPresentImpliment;
import com.simple.counter.mvp.CounterPresenter;
import com.simple.counter.mvp.CounterView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SimpleCounter extends AppCompatActivity implements CounterView{



    @BindView(R.id.plus)
    Button plus;
    @BindView(R.id.message)
    TextView messageDisplay;

    @BindView(R.id.minus)
    Button minus;

    @BindView(R.id.refresh)
    Button refresh;
    public CounterPresenter counterPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_counter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
        counterPresenter = new CounterPresentImpliment(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        counterPresenter.OnResume();
    }

    @Override
    public void setPositiveButton() {
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPresenter.onAddNumber();
            }
        });
    }

    @Override
    public void setRefreshButton() {
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPresenter.onRefreshButton();
            }
        });
    }

    @Override
    public void setNegetiveButton() {
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterPresenter.onRemoveNumber();
            }
        });
    }

    @Override
    public void showMessage(String message) {
        messageDisplay.setText(message);
    }
}
