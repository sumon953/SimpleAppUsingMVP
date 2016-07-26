package com.simple.counter.mvp;

/**
 * Created by lolipop on 7/27/16.
 */
public interface CounterPresenter {

    void onAddNumber();
    void onRemoveNumber();
    void onRefreshButton();
    void OnResume();
}
