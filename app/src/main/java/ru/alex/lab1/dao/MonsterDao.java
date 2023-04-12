package ru.alex.lab1.dao;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.alex.lab1.entity.MonsterClass;

public interface MonsterDao {
    @Query("SELECT * FROM monster_class ")
    List<MonsterClass> getAll();

    @Query("DELETE FROM monster_class")
    void nukeTable();

    @Insert
    void insertAll(List<MonsterClass> monsterClassList);
}
