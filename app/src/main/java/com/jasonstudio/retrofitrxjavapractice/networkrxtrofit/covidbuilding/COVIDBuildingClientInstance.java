package com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.covidbuilding;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class COVIDBuildingClientInstance {
    private static Retrofit retrofit;
    private final static String base_url = "https://api.data.gov.hk";
    public static Retrofit getClient(){
        if(retrofit == null){
            synchronized (Retrofit.class){
                retrofit = new Retrofit.Builder()
                        .baseUrl(base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
            }
        }
        return retrofit;
    }
}
