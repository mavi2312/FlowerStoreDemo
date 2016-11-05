package com.mavzapps.flowerstoredemo.Objects;

/**
 * Created by MariaVirginia on 30/10/2016.
 */

public class CategoriesObject {

    private String name;
    private String imageName;

    public CategoriesObject(String name,String imageName){
        this.name = name;
        this.imageName = imageName;
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

}
