package ru.alex.lab1.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.alex.lab1.entity.Monster;
import ru.alex.lab1.entity.MonsterDescription;

@Dao
public interface MonsterDescriptionDao {

    @Query("SELECT * FROM monster_desc " +
            "WHERE monsterId = :id ")
    List<Monster> getMonsterById(Long id);

    @Query("DELETE FROM monster_desc")
    void nukeTable();

    @Insert
    void insert(MonsterDescription monsterDescription);
}
