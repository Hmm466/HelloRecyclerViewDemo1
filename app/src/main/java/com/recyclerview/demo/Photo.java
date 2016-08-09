package com.recyclerview.demo;

/**
 * Created by Administrator on 2016/8/8.
 */
public class Photo {
    private int image;

    private String title;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Photo(int image, String title) {
        this.image = image;
        this.title = title;
    }
}
