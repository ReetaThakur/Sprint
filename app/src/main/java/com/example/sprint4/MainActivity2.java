package com.example.sprint4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity implements ClickListner {
    private RecyclerView recyclerView;
    private List<ResponseModel> modelList;
    private Button click;
    private EditText userid;
    ModelAdapter adapter;
    private CardView cardView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView=findViewById(R.id.recyclerView);
        click=findViewById(R.id.btnblueclick);
        userid=findViewById(R.id.userid);
        cardView=findViewById(R.id.cardView);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService apiService=Network.getInstance().create(ApiService.class);
                apiService.getUser().enqueue(new Callback<List<ResponseModel>>() {
                    @Override
                    public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                        if(response.body()!=null){
                            modelList=response.body();
                            setRecyclerView();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

                    }
                });
            }
        });
    }

    private void setRecyclerView() {
        adapter=new ModelAdapter(modelList,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity2.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClickListner(ResponseModel model, int position) {
        

    }
}