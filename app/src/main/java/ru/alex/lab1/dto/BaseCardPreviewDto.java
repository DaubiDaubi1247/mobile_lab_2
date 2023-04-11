package ru.alex.lab1.dto;

import ru.alex.lab1.pojo.RecyclerCardPreview;

public abstract class BaseCardPreviewDto {

    public BaseCardPreviewDto(Long id, String name, String imgName, String source) {
        this.id = id;
        this.name = name;
        this.imgName = imgName;
        this.source = source;
    }

    protected Long id;

    protected String name;

    protected String imgName;

    protected String source;

    public abstract RecyclerCardPreview toPojo();
}
