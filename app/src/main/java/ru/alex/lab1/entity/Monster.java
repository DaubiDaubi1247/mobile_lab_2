package ru.alex.lab1.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "monster",
        foreignKeys = {@ForeignKey(entity = MonsterClass.class,
                parentColumns = "id",
                childColumns = "classId",
                onDelete = ForeignKey.CASCADE)
        })
public class Monster extends MonsterBase {

    public Monster(@NonNull Long id, String name, String imgName, String imgDirection, Long classId) {
        super(id, name, imgName, imgDirection);
        this.classId = classId;
    }

    private Long classId;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public static MonsterBuilder builder() {
        return new MonsterBuilder();
    }

    public static class MonsterBuilder {
        private Long id;

        private String name;

        private String imgName;

        private String imgDirection;
        private Long classId;

        public MonsterBuilder() {
        }

        public MonsterBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MonsterBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MonsterBuilder imgName(String imgName) {
            this.imgName = imgName;
            return this;
        }

        public MonsterBuilder imgDirection(String imgDirection) {
            this.imgDirection = imgDirection;
            return this;
        }

        public MonsterBuilder classId(Long classId) {
            this.classId = classId;
            return this;
        }

        public Monster build() {
            return new Monster(this.id, name, imgName, imgDirection, classId);
        }
    }
}
