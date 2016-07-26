package com.listview.mvp;

/**
 * Created by lolipop on 7/27/16.
 */
public interface ItemPresenter {

    void OnDestroy();
    void OnClick(int position);
    void onResume();
}
