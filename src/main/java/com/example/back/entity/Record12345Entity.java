package com.example.back.entity;

import java.sql.Date;

public class Record12345Entity {
    private String id;
    private String events;
    private String category;
    private String name;
    private String phone;
    private Date occur_time;
    private Date solve_time;
    private String address;
    private Double longitude;
    private Double latitude;
    private String geom;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getOccur_time() {
        return occur_time;
    }

    public void setOccur_time(Date occur_time) {
        this.occur_time = occur_time;
    }

    public Date getSolve_time() {
        return solve_time;
    }

    public void setSolve_time(Date solve_time) {
        this.solve_time = solve_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getGeom() {
        return geom;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }

    @Override
    public String toString() {
        return "Record12345Entity{" +
                "id='" + id + '\'' +
                ", events='" + events + '\'' +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", occur_time=" + occur_time +
                ", solve_time=" + solve_time +
                ", address='" + address + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", geom='" + geom + '\'' +
                '}';
    }
}
