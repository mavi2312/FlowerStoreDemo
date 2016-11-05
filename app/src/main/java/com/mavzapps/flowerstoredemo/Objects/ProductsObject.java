package com.mavzapps.flowerstoredemo.Objects;

/**
 * Created by MariaVirginia on 1/11/2016.
 */

public class ProductsObject {

    private String name;
    private String imageName;
    private String description;

    public ProductsObject(String name, String imageName, String description){
        this.name = name;
        this.imageName = imageName;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
