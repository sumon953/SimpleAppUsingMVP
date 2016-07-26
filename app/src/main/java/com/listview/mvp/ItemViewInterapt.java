package com.listview.mvp;

import java.util.List;

/**
 * Created by lolipop on 7/27/16.
 */
public interface ItemViewInterapt {

    interface OnFinishedItemLisener{
        void setItemIntoList(List<String> items);
    }

    void OnFinished(OnFinishedItemLisener lisener);
}
