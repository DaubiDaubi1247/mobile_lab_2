package ru.alex.lab1.db;

import java.util.HashMap;
import java.util.Map;

import ru.alex.lab1.dto.MonsterDto;

public class DataBase {
    private final Map<Integer, MonsterDto> monsterDb;
    private static DataBase instance;
    private DataBase(){
        monsterDb = new HashMap<>();
    }
    public static DataBase getInstance() {

        if (instance == null){
            instance = new DataBase();
        }

        return instance;
    }

    public MonsterDto getMonsterById(int id) {
        return monsterDb.get(id);
    }
}
