package com.iftm.restapp.services;

import com.iftm.restapp.entidades.Post;
import com.iftm.restapp.entidades.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndPoint {

    @GET("users")
    Call<List<User>> obterUsuarios();

    @POST("posts")
    Call<Post> criarPost(@Body Post post);

}
