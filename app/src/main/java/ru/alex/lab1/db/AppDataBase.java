package ru.alex.lab1.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.alex.lab1.dao.MonsterClassDao;
import ru.alex.lab1.entity.MonsterClass;

@Database(entities = {MonsterClass.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract MonsterClassDao getMonsterClassDao();
}