package com.mavzapps.flowerstoredemo.Objects;

/**
 * Created by MariaVirginia on 30/10/2016.
 */

public class DealsObject {

    private String name;
    private String imageName;
    private String price;

    public DealsObject(String name,String imageName, String price){
        this.name = name;
        this.imageName = imageName;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
