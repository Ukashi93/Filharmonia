package com.example.pawel.filharmonia.model;

import com.example.pawel.filharmonia.database.MyDatabase;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class)
public class News extends BaseModel{
    @PrimaryKey
    @Column
    @SerializedName("id")
    int id;

    @Column
    @SerializedName("title")
    String title;

    @Column
    @SerializedName("content")
    String content;

    @Column
    @SerializedName("image_link")
    String image_link;

    @Column
    @SerializedName("full_content")
    String full_content;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getFull_content() {
        return full_content;
    }

    public void setFull_content(String full_content) {
        this.full_content = full_content;
    }

}
