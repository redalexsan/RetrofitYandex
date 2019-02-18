package es.example.ale.retrofityandex.data.remote;

import android.content.Context;
import android.os.Bundle;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static ApiService instance;
    private Api api;

    public static ApiService newInstance() {
        if(instance == null)
            instance = new ApiService();
        return instance;
    }

    private ApiService(){
        buildApService();
    }

    private void buildApService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://translate.yandex.net/api/v1.5/tr.json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public Api getApi(){
        return api;
    }
}
