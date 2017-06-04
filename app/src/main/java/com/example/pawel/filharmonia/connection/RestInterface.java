package com.example.pawel.filharmonia.connection;

import com.example.pawel.filharmonia.model.Newses;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestInterface {
    @GET("/news")
    Call<Newses> loadData();
}
