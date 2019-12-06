package com.example.basemvvm.base;


import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;


import com.example.basemvvm.network.RestManager;
import com.example.basemvvm.utils.SchedulersFacade;
import com.example.basemvvm.utils.SingleLiveData;
import com.example.basemvvm.utils.prefs.PreferencesManager;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {

    protected final RestManager mRestManager;
    protected final PreferencesManager mPrefManager;
    protected final CompositeDisposable mCompositeDisposable;
    protected final SchedulersFacade mSchedulersFacade;
    protected final SingleLiveData<Integer> mToastLiveData;


    public BaseViewModel(@NonNull RestManager restManager,
                         @NonNull PreferencesManager prefManager,
                         @NonNull CompositeDisposable compositeDisposable,
                         @NonNull SchedulersFacade schedulersFacade,
                         @NonNull SingleLiveData<Integer> toastLiveData) {
        this.mPrefManager = prefManager;
        this.mRestManager = restManager;
        this.mCompositeDisposable = compositeDisposable;
        this.mSchedulersFacade = schedulersFacade;
        this.mToastLiveData = toastLiveData;
    }

    public SingleLiveData<Integer> getToastLiveData(){
        return mToastLiveData;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        mCompositeDisposable.clear();
        super.onCleared();
    }
}
