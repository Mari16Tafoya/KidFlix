package com.example.kidflix.network;

import com.example.kidflix.model.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiVideo {
    //describir las operaciones solicitadas a la api
    @GET("movies/list.php")
    Call<List<Video>> getVideos();
}
