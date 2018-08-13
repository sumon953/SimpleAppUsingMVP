package com.example.lolipop.simpleappusingmvp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.listview.mvp.ItemPresenter;
import com.listview.mvp.ItemPresenterImpliment;
import com.listview.mvp.MainItemView;

import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity implements MainItemView , AdapterView.OnItemClickListener
{


    @BindView(R.id.list_list)
    ListView listView;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    public ItemPresenter itemPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);


        listView.setOnItemClickListener(this);
        itemPresenter = new ItemPresenterImpliment(this);
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
        itemPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        itemPresenter.OnDestroy();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItem(List<String> items) {
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        itemPresenter.OnClick(position);
    }
}
