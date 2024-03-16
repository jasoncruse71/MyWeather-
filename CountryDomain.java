package com.example.myweathernew;

public class CountryDomain {
    private String picPath;
    private String country;
    private int highTemp;
    private int lowTemp;

    public CountryDomain(String picPath, String country, int highTemp, int lowTemp) {
        this.picPath = picPath;
        this.country = country;
        this.highTemp = highTemp;
        this.lowTemp = lowTemp;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(int highTemp) {
        this.highTemp = highTemp;
    }

    public int getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(int lowTemp) {
        this.lowTemp = lowTemp;
    }
}
