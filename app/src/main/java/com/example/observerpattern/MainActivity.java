package com.example.observerpattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView postRecyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<post_viewModel> posts = new ArrayList<>();

    JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postRecyclerView = findViewById(R.id.postrec);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        postPhotos();

    }
    public void postPhotos() {

        for (int i = 0; i < 50 ; i++) {

            Call<List<photos>> call = jsonPlaceHolderApi.getPhotos(i);

            call.enqueue(new Callback<List<photos>>() {
                @Override
                public void onResponse(Call<List<photos>> call, Response<List<photos>> response) {
                    if(!response.isSuccessful()){

                        makeToast("Something Failed, Error : " + response.code());
                    }

                    List<photos> list = response.body();
                    String photoTitle;
                    String photoUrl;

                    for (photos photos0 : list ){

                        photoTitle = photos0.getTitle();
                        photoUrl = photos0.getUrl();


                        posts.add(new post_viewModel( R.drawable.ic_launcher_background, photoTitle , photoUrl));
                        setRecyclerView();

                        notifSubscribers();
                    }
                }

                @Override
                public void onFailure(Call<List<photos>> call, Throwable t) {
                    System.out.println("Faced with an Error : " + t.getMessage());
                }
            });
        }

    }

    private void makeToast(String message) {

        Toast.makeText(this, message , Toast.LENGTH_SHORT);
    }

    public  void setRecyclerView(){

        postRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new postAdapter(posts);
        postRecyclerView.setAdapter(adapter);
        postRecyclerView.setLayoutManager(layoutManager);
    }

    public void notifSubscribers(){

        String [] subs = {"Arman" , "Alireza"};

        Channel channel = new Channel("ATF Tasks" , subs );
        channel.update("We have added some posts. Don't miss them !");
    }
}