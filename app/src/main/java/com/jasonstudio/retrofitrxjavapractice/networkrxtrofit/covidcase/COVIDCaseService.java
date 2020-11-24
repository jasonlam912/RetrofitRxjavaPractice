package com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.covidcase;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

//{"resource":"http://www.chp.gov.hk/files/misc/enhanced_sur_covid_19_eng.csv","section":1,"format":"json","filters":[[1,"in",["234","123","124"]]]}
//%22234%22%2C%22123%22%2C%22124%22
public interface COVIDCaseService {
    @GET("filter?q=%7B\"resource\"%3A\"http%3A%2F%2Fwww.chp.gov.hk%2Ffiles%2Fmisc%2Fenhanced_sur_covid_19_eng.csv\"%2C\"section\"%3A1%2C\"format\"%3A\"json\"%2C\"filters\"%3A%5B%5B1%2C\"in\"%2C%5B\"234\"%2C\"123\"%2C\"124\"%5D%5D%5D%7D")
    Observable<List<COVIDCase>> getCOVIDCases();
    @GET("filter?")
    Observable<List<COVIDCase>> getCOVIDCases(@Query(value = "q", encoded = true) String subURL);
}
