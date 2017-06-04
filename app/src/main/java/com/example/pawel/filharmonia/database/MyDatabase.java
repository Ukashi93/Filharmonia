package com.example.pawel.filharmonia.database;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)
public class MyDatabase {

    static final String NAME = "NewsDatabase";
    static final int VERSION = 1;
}
