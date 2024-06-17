package com.example.loginrest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdaptadorRetrofit {
    Retrofit retrofit;

    public AdaptadorRetrofit(){
    }

    public Retrofit getAdaptador() {
        String URL = "https://heroku-test-9fab.onrender.com/";
        //String URL = "http://localhost/apiretrofit/";
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
