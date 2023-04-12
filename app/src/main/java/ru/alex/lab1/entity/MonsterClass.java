package ru.alex.lab1.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "monster_class")
public class MonsterClass extends MonsterBase {

    public MonsterClass(@NonNull Long id, String name, String imgName, String imgDirection) {
        super(id, name, imgName, imgDirection);
    }

    public static MonsterClassBuilder builder() {
        return new MonsterClassBuilder();
    }

    public static class MonsterClassBuilder {
        private Long id;

        private String name;

        private String imgName;

        private String imgDirection;

        public MonsterClassBuilder() {
        }

        public MonsterClassBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MonsterClassBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MonsterClassBuilder imgName(String imgName) {
            this.imgName = imgName;
            return this;
        }

        public MonsterClassBuilder imgDirection(String imgDirection) {
            this.imgDirection = imgDirection;
            return this;
        }

        public MonsterClass build() {
            return new MonsterClass(this.id, name, imgName, imgDirection);
        }
    }
}
