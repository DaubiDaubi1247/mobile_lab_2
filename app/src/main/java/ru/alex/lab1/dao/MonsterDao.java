package ru.alex.lab1.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.alex.lab1.entity.Monster;
import ru.alex.lab1.entity.MonsterClass;

@Dao
public interface MonsterDao {
    @Query("SELECT * FROM monster " +
            "WHERE classId = :classId")
    List<Monster> getAllByClassId(Long classId);

    @Query("SELECT * FROM monster " +
            "WHERE id = :monsterId")
    Monster getMonsterById(Long monsterId);

    @Query("DELETE FROM monster " +
            "WHERE classId = :classId")
    void nukeTableByClassId(long classId);

    @Insert
    void insertAll(List<Monster> monsterList);
}
