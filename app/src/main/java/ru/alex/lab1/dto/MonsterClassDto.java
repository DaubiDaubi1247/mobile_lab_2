package ru.alex.lab1.dto;

import ru.alex.lab1.pojo.MonsterClassCardPreview;
import ru.alex.lab1.pojo.RecyclerCardPreview;

public class MonsterClassDto {

    private Long id;

    private String name;

    private String imgName;

    private String source;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public MonsterClassCardPreview toPojo() {
        return new MonsterClassCardPreview(id, name, source, imgName);
    }
}
