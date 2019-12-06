package com.example.basemvvm.demo.di;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.basemvvm.R;
import com.example.basemvvm.base.BaseDaggerCompatActivity;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
import retrofit2.Response;


public class ActivityDemo extends BaseDaggerCompatActivity {

    private ProgressDialog progressDialog;
    private CustomAdapterDemo adapter;
    private Unbinder unbinder;

    @BindView(R.id.rv)
    RecyclerView recyclerView;

//    @BindView(R.id.text_view)
//    TextView emailTextView;

    @Inject
    Provider<DemoViewModel> viewModelProvider;

    private DemoViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        viewModel=viewModelProvider.get();
        unbinder= ButterKnife.bind(this);

        initProgressDialog();
        viewModel.getState();
        viewModel.getResponse().observe(this,this::response);
        viewModel.getError().observe(this,this::error);

    }

    final Observer<Demo> nameObserver = new Observer<Demo>() {
        @Override
        public void onChanged(@Nullable Demo demoResponse) {
            // Update the UI, in this case, a TextView.

        }

    };

    private void error(boolean throwable) {
        if (throwable) {
            hideProgressDialog();
            showToast(R.string.error_public);
        }
    }

    private void response(Response<Demo> response) {
        hideProgressDialog();
        if (response != null) {
            generateDataList(response);
        } else
            showToast(R.string.error_public);
    }

    public void initProgressDialog() {
        progressDialog=new ProgressDialog(ActivityDemo.this);
        progressDialog.setMessage("loading...");
        progressDialog.show();
    }

    public void hideProgressDialog() {
        progressDialog.dismiss();
    }

    public void generateDataList(Response<Demo> response) {
        adapter=new CustomAdapterDemo(ActivityDemo.this , response.body().provincelist, (position, string) ->
                showToast(position+" "+string));
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(ActivityDemo.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

//    @OnClick(R.id.button_confirm)
//    public void onClickButton(){
//        EmailValidator.isValidEmail(emailTextView.getText().toString());
//    }
}
