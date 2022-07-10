package com.example.jixiaofan.rentinghousetest;

/**
 * Created by jixiaofan on 2022/7/4.
 */

public class House {

    private String name;

    private int imageId;

    public House(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
