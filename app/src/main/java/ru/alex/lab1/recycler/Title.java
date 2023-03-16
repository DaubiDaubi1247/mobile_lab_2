package ru.alex.lab1.recycler;

public class Title implements ElementType{
    private String text;

    public Title(String text) {
        this.text = text;
    }

    public Title() {
    }

    public String getText() {
        return text;
    }
}
