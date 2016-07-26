package com.listview.mvp;

import java.util.List;

/**
 * Created by lolipop on 7/27/16.
 */
public interface MainItemView {

    void showProgressBar();
    void hideProgressBar();
    void setItem(List<String> items);
    void showMessage(String message);
}
