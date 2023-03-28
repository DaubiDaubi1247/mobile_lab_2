package ru.alex.lab1.dto;

import ru.alex.lab1.pojo.RecyclerCardPreview;

public abstract class BaseCardPreviewDto {

    protected Long id;

    protected String name;

    protected String imgName;

    protected String source;

    public abstract RecyclerCardPreview toPojo();
}
