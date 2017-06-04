package com.example.pawel.filharmonia.model;

import com.example.pawel.filharmonia.database.MyDatabase;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class)
public class Gallery extends BaseModel {

    @PrimaryKey
    @Column
    @SerializedName("id")
    int id;

    @Column
    @SerializedName("image_title")
    String title;

    @Column
    @SerializedName("image_link")
    int image_link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageTitle() {
        return title;
    }

    public void setImageTitle(String title) {
        this.title = title;
    }

    public int getImage_link() {
        return image_link;
    }

    public void setImage_link(int image_link) {
        this.image_link = image_link;
    }
}

