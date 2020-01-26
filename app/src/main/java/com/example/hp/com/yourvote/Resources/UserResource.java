package com.example.hp.com.yourvote.Resources;

import com.example.hp.com.yourvote.Models.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserResource {

    @POST("/rest/users/auth/{uid}/{pwd}")
    Call<Users> authenticate(@Path("uid")int uid, @Path("pwd") String pwd);

    @POST("/rest/users/load")
    Call<Users> register(@Body Users user);

}
