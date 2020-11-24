package com.jasonstudio.retrofitrxjavapractice.networkrxtrofit.covidcase;

import com.google.gson.annotations.SerializedName;

public class COVIDCase {
    @SerializedName("Case no.")
    private String caseNumber;
    @SerializedName("Report date")
    private String reportDate;
    @SerializedName("Date of onset")
    private String onsetDate;
    @SerializedName("Gender")
    private String gender;
    @SerializedName("Age")
    private Integer age;
    @SerializedName("Name of hospital admitted")
    private String hospitalName;
    @SerializedName("Hospitalised/Discharged/Deceased")
    private String hospitalStatus;
    @SerializedName("HK/Non-HK resident")
    private String hkOrNot;
    /*
    @SerializedName("Case classification*")
    private String caseClassification;
    @SerializedName("Confirmed/probable")
    private String confirmedOrNot;*/

    public COVIDCase(String caseNumber, String reportDate, String onsetDate, String gender, Integer age, String hospitalName, String hospitalStatus, String hkOrNot, String caseClassification, String confirmedOrNot) {
        this.caseNumber = caseNumber;
        this.reportDate = reportDate;
        this.onsetDate = onsetDate;
        this.gender = gender;
        this.age = age;
        this.hospitalName = hospitalName;
        this.hospitalStatus = hospitalStatus;
        this.hkOrNot = hkOrNot;
        //this.caseClassification = caseClassification;
        //this.confirmedOrNot = confirmedOrNot;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getOnsetDate() {
        return onsetDate;
    }

    public void setOnsetDate(String onsetDate) {
        this.onsetDate = onsetDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalStatus() {
        return hospitalStatus;
    }

    public void setHospitalStatus(String hospitalStatus) {
        this.hospitalStatus = hospitalStatus;
    }

    public String getHkOrNot() {
        return hkOrNot;
    }

    public void setHkOrNot(String hkOrNot) {
        this.hkOrNot = hkOrNot;
    }

    /*public String getCaseClassification() {
        return caseClassification;
    }

    public void setCaseClassification(String caseClassification) {
        this.caseClassification = caseClassification;
    }

    public String getConfirmedOrNot() {
        return confirmedOrNot;
    }

    public void setConfirmedOrNot(String confirmedOrNot) {
        this.confirmedOrNot = confirmedOrNot;
    }*/
}
