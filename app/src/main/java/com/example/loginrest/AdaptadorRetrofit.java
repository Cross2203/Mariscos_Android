package com.example.loginrest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdaptadorRetrofit {
    Retrofit retrofit;

    public AdaptadorRetrofit(){
    }

    public Retrofit getAdaptador() {
        String URL = "http://127.0.0.1:8000/";
        //String URL = "http://localhost/apiretrofit/";
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
