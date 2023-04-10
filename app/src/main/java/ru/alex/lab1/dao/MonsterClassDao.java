package ru.alex.lab1.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.entity.MonsterClass;
import ru.alex.lab1.pojo.RecyclerCardPreview;

@Dao
public interface MonsterClassDao {
    @Query("SELECT * FROM monster_class ")
    List<MonsterClass> getAll();

    @Query("DELETE FROM monster_class")
    void nukeTable();

    @Insert
    void insertAll(List<MonsterClass> monsterClassList);

    @Update(entity = MonsterClass.class)
    void updateAll(List<MonsterClass> monsterClassDtoList);
}
