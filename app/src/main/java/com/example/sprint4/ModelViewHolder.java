package com.example.sprint4;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ModelViewHolder extends RecyclerView.ViewHolder {
    private TextView date;
    private TextView positive;
    private TextView negative;
    private TextView hospital;
    private TextView vantilator;
    private TextView death;
    private TextView dateChecked;
    private ClickListner clickListner;
    private LinearLayout linearLayout;
    public ModelViewHolder( View itemView,ClickListner clickListner) {
        super(itemView);
        this.clickListner=clickListner;
        initView(itemView);
    }

    private void initView(View itemView) {
        date=itemView.findViewById(R.id.date);
        positive=itemView.findViewById(R.id.positive);
        negative=itemView.findViewById(R.id.negative);
        hospital=itemView.findViewById(R.id.hospitalize);
        vantilator=itemView.findViewById(R.id.vantilator);
        death=itemView.findViewById(R.id.death);
        dateChecked=itemView.findViewById(R.id.datecheked);
        linearLayout=itemView.findViewById(R.id.lineatLayout);
    }
    public void setData(ResponseModel responseModel){
        date.setText(responseModel.getDate());
        positive.setText(responseModel.getPositive());
        negative.setText(responseModel.getNegative());
        hospital.setText(responseModel.getHospitalizedCurrently());
        vantilator.setText(responseModel.getOnVentilatorCurrently());
        death.setText(responseModel.getDeath());
        dateChecked.setText(responseModel.getDateChecked());
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListner.onClickListner(responseModel,getAdapterPosition());
            }
        });
    }
}
