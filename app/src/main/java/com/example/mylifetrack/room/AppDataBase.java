package com.example.mylifetrack.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mylifetrack.models.TaskModel;

@Database(entities = {TaskModel.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
