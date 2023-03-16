package ru.alex.lab1.recycler;

public class Title implements ElementType{
    private final String text;

    public Title(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
