package com.example.basemvvm.view.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basemvvm.R;
import com.example.basemvvm.utils.CallBack;

import java.util.List;

/**
 * Created by HN on 8/24/2018.
 */

public class CustomAdapterDemo extends RecyclerView.Adapter<CustomAdapterDemo.CustomViewHolder> {

    public List<Demo.ProvinceModel> dataList;
    private Context context;
    private CallBack callBack;

    public CustomAdapterDemo(Context context, List<Demo.ProvinceModel>  dataList, CallBack callBack){
        this.dataList=dataList;
        this.context=context;
        this.callBack=callBack;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.row_demo,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.txtCity.setText(dataList.get(position).provincename);
        holder.itemView.setOnClickListener(v -> callBack.onItemClick(position,dataList.get(position).provincename));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        public final View mView;
        private TextView txtCity;

        public CustomViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
            txtCity= (TextView) mView.findViewById(R.id.txtCity);
        }
    }
}
