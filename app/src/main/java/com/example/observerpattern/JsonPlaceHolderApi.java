package com.example.observerpattern;

import retrofit2.Call;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("photos")
    Call<List<photos>> getPhotos (@Query("id") int id);


}
