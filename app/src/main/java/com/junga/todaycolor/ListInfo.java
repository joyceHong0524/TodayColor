package com.junga.todaycolor;

public class ListInfo {

    //related to list
    String image;
    String title;

    //related to result
    int color;
    String description;
    String resultImage;

    public ListInfo(String image, String title,int color,String description,String resultImage) {
        this.image = image; //Image for list
        this.title = title; //Title for the list

        //Keep in the mind that all the result is already determined.

        this.color = color; // color of today(going to be presented on Result Activity.)
        this.description = description; // description of result (going to be presented on Result Activity)
        this.resultImage = resultImage;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public int getColor(){
        return color;
    }

    public String getDescription(){
        return description;
    }
}
