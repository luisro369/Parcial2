package com.luisro00005513.gamenews.Classes;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by luisro on 6/1/18.
 */

public class News {

    String game;
    String title;
    String description;
    String body;
    ImageView coverImage;

    //----------------constructor para teaser de noticia---------------
    public News(String title, String description) {
        this.title = title;
        this.description = description;
    }

    //-----------------constructor para full noticia------------
    public News(String game, String title, String description, String body, ImageView coverImage) {
        this.game = game;
        this.title = title;
        this.description = description;
        this.body = body;
        this.coverImage = coverImage;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ImageView getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(ImageView coverImage) {
        this.coverImage = coverImage;
    }
}
