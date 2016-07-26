package com.listview.mvp;

import java.util.List;

/**
 * Created by lolipop on 7/27/16.
 */
public class ItemPresenterImpliment implements ItemPresenter , ItemViewInterapt.OnFinishedItemLisener {


    private MainItemView mainItemView;
    public ItemViewInterapt itemViewInterapt;


    public ItemPresenterImpliment(MainItemView mainItemView){
        this.mainItemView = mainItemView;
        itemViewInterapt = new ItemInteraptImpliment();
    }

    @Override
    public void OnDestroy() {
        if (mainItemView!=null){
            mainItemView = null;
            mainItemView.hideProgressBar();
        }
    }

    @Override
    public void OnClick(int position) {

        if (mainItemView!=null){
            mainItemView.showMessage("You Clicked " +position);
        }
    }

    @Override
    public void onResume() {

        if (mainItemView!=null){
            itemViewInterapt.OnFinished(this);
            mainItemView.showProgressBar();
        }
    }

    @Override
    public void setItemIntoList(List<String> items) {
        if (mainItemView!=null){
            mainItemView.setItem(items);
            mainItemView.hideProgressBar();
        }
    }
}
