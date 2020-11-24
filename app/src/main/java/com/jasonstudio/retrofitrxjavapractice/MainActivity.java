package com.jasonstudio.retrofitrxjavapractice;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.chargingsection.StationList;
import com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.chargingsection.StationListRetrofitInstance;
import com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.covidbuilding.COVIDBuilding;
import com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.covidbuilding.COVIDBuildingClientInstance;
import com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.covidbuilding.COVIDBuildingService;
import com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.covidcase.COVIDCase;
import com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.covidcase.COVIDCaseRetrofitInstance;
import com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.covidcase.COVIDCaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    CompositeDisposable cd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        COVIDBuildingService service = COVIDBuildingClientInstance.getClient().create(COVIDBuildingService.class);
        Call<List<COVIDBuilding>> call = service.getCOVIDBuildingC();
        call.enqueue(new Callback<List<COVIDBuilding>>() {
            @Override
            public void onResponse(Call<List<COVIDBuilding>> call, Response<List<COVIDBuilding>> response) {
                Log.d("result", response.body().get(0).getBuildingName());
            }

            @Override
            public void onFailure(Call<List<COVIDBuilding>> call, Throwable t) {

            }
        });
        cd = new CompositeDisposable();
        Observable<List<COVIDBuilding>> observable1 = service.getCOVIDBuildingO();
        Disposable d =  observable1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s-> Log.d("result",s.get(0).getBuildingName()));
        //d.dispose();
        cd.add(d);
        String subURL = "%7B\"resource\"%3A\"http%3A%2F%2Fwww.chp.gov.hk%2Ffiles%2Fmisc%2Fenhanced_sur_covid_19_eng.csv\"%2C\"section\"%3A1%2C\"format\"%3A\"json\"%2C\"filters\"%3A%5B%5B1%2C\"in\"%2C%5B\"234\"%2C\"123\"%2C\"124\"%5D%5D%5D%7D";
        Observable<List<COVIDCase>> observable2 = COVIDCaseRetrofitInstance.getService().getCOVIDCases(subURL);
        Disposable d2 = observable2.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s->System.out.println(s.get(1).getCaseNumber()));
        cd.add(d2);

        Disposable d3= Observable.zip(observable1, observable2, new BiFunction<List<COVIDBuilding>, List<COVIDCase>, Map<String,Object>>() {
            @Override
            public Map apply(List<COVIDBuilding> covidBuildings, List<COVIDCase> covidCases) throws Exception {
                Map<String, Object> map = new HashMap<>();
                map.put("COVIDBuildingList", covidBuildings);
                map.put("COVIDCaseList",covidCases);
                return map;
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(stringObjectMap -> {
                    List<COVIDBuilding> buildings = (List<COVIDBuilding>) stringObjectMap.get("COVIDBuildingList");
                    List<COVIDCase> cases = (List<COVIDCase>) stringObjectMap.get("COVIDCaseList");
                    Log.d("d3",buildings.get(0).getBuildingName());
                    Log.d("d3",cases.get(0).getCaseNumber());
                });
        cd.add(d3);

        Observable<StationList> observable4 = StationListRetrofitInstance.getInstance().getService().getStationList();
        Disposable d4 = observable4.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(stationList -> {
                    String loc = stationList.getStationList().get(0).getLocation();
                    Log.d("d4", loc);
                });
        cd.add(d4);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cd.dispose();
    }
}
