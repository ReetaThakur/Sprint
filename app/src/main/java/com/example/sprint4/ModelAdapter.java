package com.example.sprint4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelViewHolder> {
    private List<ResponseModel> responseList;
    private ClickListner clickListner;
    public ModelAdapter(List<ResponseModel> responseList,ClickListner clickListner){
        this.responseList=responseList;
        this.clickListner=clickListner;
    }

    @Override
    public ModelViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ModelViewHolder(view,clickListner);
    }

    @Override
    public void onBindViewHolder( ModelViewHolder holder, int position) {
        ResponseModel responseModel=responseList.get(position);
        holder.setData(responseModel);

    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }
}
