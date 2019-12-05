package com.example.rohit.pythonide;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface IMyService {

    static final String IP = "http://192.168.0.103:3000/";
    @FormUrlEncoded
    @POST("index")
    Call<MessageResult> sendProgram(
            @Field("program") String program,
            @Field("input") String input
    );
}

