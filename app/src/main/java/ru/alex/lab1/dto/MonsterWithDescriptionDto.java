package ru.alex.lab1.dto;

public class MonsterWithDescriptionDto {
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
}
