package com.od.dutyparmaciesapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PharmacyModel implements Serializable {
    @SerializedName("EczaneAdi")
    @Expose
    private String name;
    @SerializedName("Adresi")
    @Expose
    private String address;
    @SerializedName("Semt")
    @Expose
    private String district;
    @SerializedName("YolTarifi")
    @Expose
    private String direction;
    @SerializedName("Telefon")
    @Expose
    private String phone1;
    @SerializedName("Telefon2")
    @Expose
    private String phone2;
    @SerializedName("Sehir")
    @Expose
    private String city;
    @SerializedName("ilce")
    @Expose
    private String state;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("distanceMt")
    @Expose
    private Integer distanceMt;
    @SerializedName("distanceKm")
    @Expose
    private Double distanceKm;
    @SerializedName("distanceMil")
    @Expose
    private Double distanceMil;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getDistanceMt() {
        return distanceMt;
    }

    public void setDistanceMt(Integer distanceMt) {
        this.distanceMt = distanceMt;
    }

    public Double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(Double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public Double getDistanceMil() {
        return distanceMil;
    }

    public void setDistanceMil(Double distanceMil) {
        this.distanceMil = distanceMil;
    }
}
