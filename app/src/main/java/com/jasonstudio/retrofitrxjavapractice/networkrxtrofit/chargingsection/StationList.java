package com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.chargingsection;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "stationList", strict = false)
public class StationList {
    @ElementList(entry = "station")
    private List<Station> stationList;

    public List<Station> getStationList() {
        return stationList;
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
    }
}
