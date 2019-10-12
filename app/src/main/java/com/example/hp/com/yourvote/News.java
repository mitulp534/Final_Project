package com.example.hp.com.yourvote;

public class News {
    private int id;
    private String title, shortDesc;
    private int image;

    public News(int id, String title, String shortDesc, int image) {
        this.id = id;
        this.title = title;
        this.shortDesc = shortDesc;
        this.image = image;
    }

    public int getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public int getImage() {
        return image;
    }
}

