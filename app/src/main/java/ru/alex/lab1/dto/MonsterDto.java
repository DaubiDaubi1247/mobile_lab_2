package ru.alex.lab1.dto;

public class MonsterDto {
    private int imgRes;
    private String name;
    private String quote;
    private String quoteAuthor;
    private String description;

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public MonsterDto(int imgRes, String name, String quote, String quoteAuthor, String description) {
        this.imgRes = imgRes;
        this.name = name;
        this.quote = quote;
        this.quoteAuthor = quoteAuthor;
        this.description = description;
    }

    public int getImgRes() {
        return imgRes;
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
