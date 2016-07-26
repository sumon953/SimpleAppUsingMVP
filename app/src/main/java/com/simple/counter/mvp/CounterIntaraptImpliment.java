package com.simple.counter.mvp;

/**
 * Created by lolipop on 7/27/16.
 */
public class CounterIntaraptImpliment implements CounterIntarapt {
    @Override
    public void OnFinished(OnFinishedCounterLisener lisener) {
        lisener.OnshowMessageSuccess();
    }
}
