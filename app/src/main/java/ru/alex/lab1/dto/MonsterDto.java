package ru.alex.lab1.dto;

import ru.alex.lab1.pojo.MonsterCardPreview;
import ru.alex.lab1.pojo.RecyclerCardPreview;

public class MonsterDto extends BaseCardPreviewDto{

    public MonsterDto(Long id, String name, String imgName, String source) {
        super(id, name, imgName, source);
    }

    @Override
    public RecyclerCardPreview toPojo() {
        return new MonsterCardPreview(id, name, source, imgName);
    }

    public static MonsterBuilder builder() {
        return new MonsterBuilder();
    }

    public static class MonsterBuilder {
        private Long id;

        private String name;

        private String imgName;

        private String imgDirection;

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

        public MonsterDto build() {
            return new MonsterDto (this.id, name, imgName, imgDirection);
        }

    }
}
