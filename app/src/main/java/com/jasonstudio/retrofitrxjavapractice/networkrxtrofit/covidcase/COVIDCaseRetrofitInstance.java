package com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.covidcase;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//%22234%22%2C%22123%22%2C%22124%22%5D%5D%5D%7D
public class COVIDCaseRetrofitInstance {
    static private COVIDCaseRetrofitInstance instance;
    private static Retrofit retrofit;
    private static COVIDCaseService service;
    static private final String base_url = "https://api.data.gov.hk/v2/";

    private COVIDCaseRetrofitInstance(){
        retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        service = retrofit.create(COVIDCaseService.class);
    }

    public static Retrofit getRetrofit(){
        if(retrofit == null){
            synchronized (COVIDCaseRetrofitInstance.class){
                if(retrofit ==null){
                    instance = new COVIDCaseRetrofitInstance();
                }
            }
        }
        return retrofit;
    }

    public static COVIDCaseService getService(){
        if(service == null){
            synchronized (COVIDCaseRetrofitInstance.class){
                if(service ==null){
                    instance = new COVIDCaseRetrofitInstance();
                }
            }
        }
        return service;
    }
}
