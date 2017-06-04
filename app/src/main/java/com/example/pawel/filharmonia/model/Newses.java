package com.example.pawel.filharmonia.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Newses extends BaseAnswer{
    @SerializedName("data")
    @Expose
    private List<News> loadData = new ArrayList<News>();

    public List<News> getLoadData() {
        return loadData;
    }
}
