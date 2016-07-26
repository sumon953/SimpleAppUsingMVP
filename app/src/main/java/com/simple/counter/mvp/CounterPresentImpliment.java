package com.simple.counter.mvp;

/**
 * Created by lolipop on 7/27/16.
 */
public class CounterPresentImpliment implements CounterPresenter , CounterIntarapt.OnFinishedCounterLisener {

    private CounterView counterView;
    private CounterIntarapt counterIntarapt;

    public static int number = 0;

    public CounterPresentImpliment(CounterView counterView){
        this.counterView = counterView;
        counterIntarapt = new CounterIntaraptImpliment();
    }

    @Override
    public void onAddNumber() {
        if (counterView!=null){
            number = number+1;
            counterView.showMessage(""+number);
        }
    }

    @Override
    public void onRemoveNumber() {
        if (counterView!=null){
            if (number>0){
                number = number-1;
                counterView.showMessage(""+number);
            }
        }
    }

    @Override
    public void onRefreshButton() {
        if (counterView!=null){
            if (number>0){
                number=0;
                counterView.showMessage(""+number);
            }
        }
    }

    @Override
    public void OnResume() {
        if (counterView!=null){
            counterView.setNegetiveButton();
            counterView.setPositiveButton();
            counterView.setRefreshButton();
        }
    }

    @Override
    public void OnshowMessageSuccess() {

        if (counterView!=null){
            counterIntarapt.OnFinished(this);
        }
    }
}
