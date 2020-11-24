package com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.chargingsection;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface StationListService {
    @GET("GetChargingSectionXML.aspx?lang=EN")
    public Observable<StationList> getStationList();
}
