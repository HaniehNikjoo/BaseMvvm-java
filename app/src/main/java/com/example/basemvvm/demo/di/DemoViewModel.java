package com.example.basemvvm.view.demo;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.basemvvm.base.BaseViewModel;
import com.example.basemvvm.network.RestManager;
import com.example.basemvvm.network.RxRetrofitErrorConsumer;
import com.example.basemvvm.utils.SchedulersFacade;
import com.example.basemvvm.utils.SingleLiveData;
import com.example.basemvvm.utils.prefs.PreferencesManager;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;
import timber.log.Timber;

public class DemoViewModel extends BaseViewModel {

    private final MutableLiveData<Response<Demo>> response=new MutableLiveData<>();
    private final MutableLiveData<Boolean> error=new MutableLiveData<>();

    public DemoViewModel(@NonNull RestManager restManager, @NonNull PreferencesManager prefManager, @NonNull CompositeDisposable compositeDisposable, @NonNull SchedulersFacade schedulersFacade, @NonNull SingleLiveData<Integer> toastLiveData) {
        super(restManager, prefManager, compositeDisposable, schedulersFacade,toastLiveData);
    }

    @SuppressWarnings("SameParameterValue")
    void getState() {

        Disposable disposable = mRestManager.getState("714a3bd5d8d4a2e2d1024789c333ae2b","Android" , "1.0.20" ,"NSswhjL6pWDt1OlwQB_BLA||")
                .subscribeOn(mSchedulersFacade.io())
                .observeOn(mSchedulersFacade.ui())
                .subscribe(r -> {
                    Timber.d("success response mvvm view model  : " + r.toString());
                    response.setValue(r);
                }, new RxRetrofitErrorConsumer() {

                    @Override
                    public void handleError(Throwable throwable, int id) {
                        Timber.e("error response mvvm view model  : " + throwable.getMessage());
                        error.setValue(true);
                    }
                });

        mCompositeDisposable.add(disposable);
    }


    public MutableLiveData<Response<Demo>> getResponse() {
        return response;
    }

    public MutableLiveData<Boolean> getError() {
        return error;
    }
}
