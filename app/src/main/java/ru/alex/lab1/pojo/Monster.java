package ru.alex.lab1.pojo;

import ru.alex.lab1.recycler.ElementType;

public class Monster implements ElementType {
    private String name;
    private int imgResource;

    public Monster(String name, int imgResource) {
        this.name = name;
        this.imgResource = imgResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}
