package com.example.sprint4;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("v1/us/daily.json")
    Call<List<ResponseModel> > getUser();
}
