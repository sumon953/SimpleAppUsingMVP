package com.simple.counter.mvp;

/**
 * Created by lolipop on 7/27/16.
 */
public interface CounterIntarapt {

    interface OnFinishedCounterLisener{
        void OnshowMessageSuccess();
    }

    void OnFinished(OnFinishedCounterLisener lisener);
}
