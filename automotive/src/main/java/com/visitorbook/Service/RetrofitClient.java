package com.visitorbook.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {
    Retrofit retrofit;
    public static String BASE_URL = "https://visitorbook-ebon.vercel.app/api/";
    private static RetrofitClient mClient;

    private RetrofitClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public static synchronized RetrofitClient getmClient() {
        if (mClient == null) {
            mClient = new RetrofitClient();
        }
        return mClient;

    }
    public ApiService getApi(){
        return  retrofit.create(ApiService.class);
    }

}

