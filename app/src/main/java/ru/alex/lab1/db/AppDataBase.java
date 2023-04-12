package ru.alex.lab1.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.alex.lab1.dao.MonsterClassDao;
import ru.alex.lab1.dao.MonsterDao;
import ru.alex.lab1.dao.MonsterDescriptionDao;
import ru.alex.lab1.entity.Monster;
import ru.alex.lab1.entity.MonsterClass;
import ru.alex.lab1.entity.MonsterDescription;

@Database(entities = {MonsterClass.class, Monster.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract MonsterClassDao getMonsterClassDao();
    public abstract MonsterDao getMonsterDao();
    public abstract MonsterDescriptionDao getMonsterDescDao();
}
