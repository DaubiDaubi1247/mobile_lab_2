package ru.alex.lab1.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class MonsterBase {

    @PrimaryKey
    @NonNull
    private Long id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "img_name")
    private String imgName;

    @ColumnInfo(name = "img_direction")
    private String imgDirection;

    public MonsterBase(@NonNull Long id, String name, String imgName, String imgDirection) {
        this.id = id;
        this.name = name;
        this.imgName = imgName;
        this.imgDirection = imgDirection;
    }


    @NonNull
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgName() {
        return imgName;
    }

    public String getImgDirection() {
        return imgDirection;
    }

//    public static MonsterClassBuilder builder() {
//        return new MonsterClassBuilder();
//    }
//
//    public static class MonsterClassBuilder {
//        private Long id;
//
//        private String name;
//
//        private String imgName;
//
//        private String imgDirection;
//
//        public MonsterClassBuilder() {
//        }
//
//        public MonsterClassBuilder id(Long id) {
//            this.id = id;
//            return this;
//        }
//
//        public MonsterClassBuilder name(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public MonsterClassBuilder imgName(String imgName) {
//            this.imgName = imgName;
//            return this;
//        }
//
//        public MonsterClassBuilder imgDirection(String imgDirection) {
//            this.imgDirection = imgDirection;
//            return this;
//        }
//
//        public MonsterBase build() {
//            return new MonsterBase(this.id, name, imgName, imgDirection);
//        }
//    }

}

