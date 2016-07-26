package com.listview.mvp;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lolipop on 7/27/16.
 */
public class ItemInteraptImpliment implements ItemViewInterapt {
    @Override
    public void OnFinished(final OnFinishedItemLisener lisener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lisener.setItemIntoList(createItem());
            }
        }, 2000);
    }

    public List<String> createItem(){
        return Arrays.asList("item 1", "item 2", "item 3", "item 4", "item 5", "item 6", "item 7", "item 8", "item 9", "item 10");
    }
}
