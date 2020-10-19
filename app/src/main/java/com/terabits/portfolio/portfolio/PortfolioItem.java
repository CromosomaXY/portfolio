package com.terabits.portfolio.portfolio;

import java.io.Serializable;

public class PortfolioItem implements Serializable {

    public PortfolioItem(int image) {
        this.image = image;
    }

    private int image;
    private String title, description;

    public PortfolioItem(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public PortfolioItem(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public PortfolioItem() {
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
