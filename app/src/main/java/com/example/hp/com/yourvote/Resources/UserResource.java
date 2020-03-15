package com.example.hp.com.yourvote.Resources;

import com.example.hp.com.yourvote.Models.OneTimeAuth;
import com.example.hp.com.yourvote.Models.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserResource {

     @POST("/rest/users/auth/{uid}/{pwd}")
    Call<Users> authenticate(@Path("uid")String uid, @Path("pwd") String pwd);



    @POST("/rest/users/load")
    Call<Users> register(@Body Users user);

    @POST("/rest/users/otp")
    Call<Users> getOTP(@Body Users user);

    @POST("/rest/users/validate/{otp}")
    Call<OneTimeAuth> getOTP(@Path("otp") String otp);


}
