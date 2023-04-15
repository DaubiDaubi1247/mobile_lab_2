package ru.alex.lab1.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import java.util.Optional;

import ru.alex.lab1.dto.MonsterWithDescriptionDto;
import ru.alex.lab1.entity.Monster;
import ru.alex.lab1.entity.MonsterDescription;

@Dao
public interface MonsterDescriptionDao {

    @Query("SELECT * FROM monster_desc " +
            "WHERE monsterId = :id ")
    Optional<MonsterDescription> getMonsterById(Long id);

    @Query("DELETE FROM monster_desc " +
            "WHERE monsterId = :monsterId")
    void nukeTableByMonsterId(long monsterId);

    @Insert
    void insert(MonsterDescription monsterDescription);
}
