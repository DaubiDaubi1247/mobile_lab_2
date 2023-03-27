package ru.alex.lab1.pojo;

public class MonsterCardPreview extends RecyclerCardPreview{
    public MonsterCardPreview(Long id, String name, String source, String imgName) {
        super(id, name, source, imgName);
        setOnClickListener(null);
    }
}
