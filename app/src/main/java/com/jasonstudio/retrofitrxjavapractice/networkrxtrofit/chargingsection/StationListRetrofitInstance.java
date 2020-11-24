package com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.chargingsection;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class StationListRetrofitInstance {
    private static StationListRetrofitInstance instance;
    private Retrofit retrofit;
    private StationListService service;
    private static final String base_url = "https://opendata.clp.com.hk/";
    private StationListRetrofitInstance(){
        retrofit = new Retrofit.Builder()
                        .baseUrl(base_url)
                        .addConverterFactory(SimpleXmlConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
        service = retrofit.create(StationListService.class);
    }
    public static StationListRetrofitInstance getInstance(){
        if(instance==null){
            synchronized (StationListRetrofitInstance.class){
                if(instance==null){
                    instance = new StationListRetrofitInstance();
                }
            }
        }
        return instance;
    }
    public StationListService getService(){
        return service;
    }
}
