package com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.covidbuilding;

import com.google.gson.annotations.SerializedName;

public class COVIDBuilding {
    @SerializedName("District")
    private String district;
    @SerializedName("Building name")
    private String buildingName;
    @SerializedName("Last date of residence of the cass(s)")
    private String lastDate;
    @SerializedName("Related probable/confirmed cases")
    private  String relatedCases;

    public COVIDBuilding(String district, String buildingName, String lastDate, String relatedCases) {
        this.district = district;
        this.buildingName = buildingName;
        this.lastDate = lastDate;
        this.relatedCases = relatedCases;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getRelatedCases() {
        return relatedCases;
    }

    public void setRelatedCases(String relatedCases) {
        this.relatedCases = relatedCases;
    }
}
