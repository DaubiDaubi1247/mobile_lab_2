package ru.alex.lab1.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.alex.lab1.entity.MonsterClass;

@Dao
public interface MonsterClassDao {
    @Query("SELECT * FROM monster_class ")
    List<MonsterClass> getAll();

    @Insert
    void insertAll(List<MonsterClass> monsterClassList);
}
