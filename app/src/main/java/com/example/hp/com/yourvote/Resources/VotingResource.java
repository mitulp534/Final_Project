package com.example.hp.com.yourvote.Resources;

import com.example.hp.com.yourvote.Models.Users;
import com.example.hp.com.yourvote.Models.Vote;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface VotingResource {

    @POST("/rest/vote/load/")
    Call<Vote> castVote(@Body Vote vote);
}
