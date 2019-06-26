package interview.mistplay.mistplayapp;

import com.fasterxml.jackson.annotation.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Comparator;

public class Game {


    @JsonProperty("genre")
    String genre;

    @JsonProperty("imgURL")
    String imgURL;

    @JsonProperty("subgenre")
    String subgenre;

    @JsonProperty("title")
    String title;
    @JsonProperty("pid")
    String pid;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @JsonProperty("rating")
    String rating;



    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getSubgenre() {
        return subgenre;
    }

    public void setSubgenre(String subgenre) {
        this.subgenre = subgenre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

}
