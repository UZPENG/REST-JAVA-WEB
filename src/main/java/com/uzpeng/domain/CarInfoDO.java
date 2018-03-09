package com.uzpeng.domain;

import java.io.Serializable;

/**
 * @author serverliu on 2018/2/26.
 */
public class CarInfoDO implements Serializable {
    private String id;
    private String name;
    private String mileage;
    private String year;
    private String loc;
    private float origin_price;
    private float discount_price;
    private String img_url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public double getOrigin_price() {
        return origin_price;
    }

    public void setOrigin_price(float origin_price) {
        this.origin_price = origin_price;
    }

    public double getDiscountPrice() {
        return discount_price;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discount_price = discountPrice;
    }

    public String getImgUrl() {
        return img_url;
    }

    public void setImgUrl(String imgUrl) {
        this.img_url = imgUrl;
    }
}
