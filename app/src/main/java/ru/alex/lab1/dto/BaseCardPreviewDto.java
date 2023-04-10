package ru.alex.lab1.dto;

import ru.alex.lab1.pojo.RecyclerCardPreview;

public abstract class BaseCardPreviewDto {

    public Long id;

    public String name;

    public String imgName;

    public String source;

    public abstract RecyclerCardPreview toPojo();
}
