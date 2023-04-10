package ru.alex.lab1.dto;

import ru.alex.lab1.entity.MonsterClass;
import ru.alex.lab1.pojo.MonsterClassCardPreview;

public class MonsterClassDto extends BaseCardPreviewDto {

    public MonsterClassDto(Long id, String name, String imgName, String source) {
        super(id, name, imgName, source);
    }

    @Override
    public MonsterClassCardPreview toPojo() {
        return new MonsterClassCardPreview(id, name, source, imgName);
    }

    public static MonsterClassDto.MonsterClassBuilder builder() {
        return new MonsterClassDto.MonsterClassBuilder();
    }



    public static class MonsterClassBuilder {
        private Long id;

        private String name;

        private String imgName;

        private String imgDirection;

        public MonsterClassBuilder() {
        }

        public MonsterClassDto.MonsterClassBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MonsterClassDto.MonsterClassBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MonsterClassDto.MonsterClassBuilder imgName(String imgName) {
            this.imgName = imgName;
            return this;
        }

        public MonsterClassDto.MonsterClassBuilder imgDirection(String imgDirection) {
            this.imgDirection = imgDirection;
            return this;
        }

        public MonsterClassDto build() {
            return new MonsterClassDto (this.id, name, imgName, imgDirection);
        }

    }
}
