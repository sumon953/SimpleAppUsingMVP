package com.simple.counter.mvp;

/**
 * Created by lolipop on 7/27/16.
 */
public interface CounterView {

    void setPositiveButton();
    void setRefreshButton();
    void setNegetiveButton();
    void showMessage(String message);
}
