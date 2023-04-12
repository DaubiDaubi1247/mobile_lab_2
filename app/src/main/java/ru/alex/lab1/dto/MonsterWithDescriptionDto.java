package ru.alex.lab1.dto;

import ru.alex.lab1.entity.Monster;
import ru.alex.lab1.entity.MonsterDescription;

public class MonsterWithDescriptionDto {

    private Long id;

    public Long getId() {
        return id;
    }

    public MonsterWithDescriptionDto( String quote, String quoteAuthor, String description) {
        this.quote = quote;
        this.quoteAuthor = quoteAuthor;
        this.description = description;
    }

    private String name;
    private String source;
    private String imgName;

    public String getSource() {
        return source;
    }

    public String getImgName() {
        return imgName;
    }

    private String quote;
    private String quoteAuthor;
    private String description;

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public String getName() {
        return name;
    }

    public String getQuote() {
        return quote;
    }

    public String getDescription() {
        return description;
    }

    public static MonsterDescriptionBuilder builder() {
        return new MonsterDescriptionBuilder();
    }

    public void setSource(Monster monster) {
        this.name = monster.getName();
        this.imgName = monster.getImgName();
        this.source = monster.getImgDirection();
    }

    public static class MonsterDescriptionBuilder {

        private String quote;

        private String quoteAuthor;

        private String description;

        private Long monsterId;

        public MonsterDescriptionBuilder() {
        }


        public MonsterDescriptionBuilder quote(String name) {
            this.quote = name;
            return this;
        }

        public MonsterDescriptionBuilder quoteAuthor(String quoteAuthor) {
            this.quoteAuthor = quoteAuthor;
            return this;
        }

        public MonsterDescriptionBuilder description(String description) {
            this.description = description;
            return this;
        }


        public MonsterWithDescriptionDto build() {
            return new MonsterWithDescriptionDto( quote, quoteAuthor, description);
        }

    }
}
