package com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.covidbuilding;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface COVIDBuildingService {
    @GET("/v2/filter?q=%7B\"resource\"%3A\"http%3A%2F%2Fwww.chp.gov.hk%2Ffiles%2Fmisc%2Fbuilding_list_eng.csv\"%2C\"section\"%3A1%2C\"format\"%3A\"json\"%7D")
    Call<List<COVIDBuilding>> getCOVIDBuildingC();
    @GET("/v2/filter?q=%7B\"resource\"%3A\"http%3A%2F%2Fwww.chp.gov.hk%2Ffiles%2Fmisc%2Fbuilding_list_eng.csv\"%2C\"section\"%3A1%2C\"format\"%3A\"json\"%7D")
    Observable<List<COVIDBuilding>> getCOVIDBuildingO();
}
