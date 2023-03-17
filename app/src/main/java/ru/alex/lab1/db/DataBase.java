package ru.alex.lab1.db;

import java.util.HashMap;
import java.util.Map;

import ru.alex.lab1.R;
import ru.alex.lab1.dto.MonsterDto;

public class DataBase {
    private final Map<Integer, MonsterDto> monsterDb;
    private static DataBase instance;
    private DataBase(){
        monsterDb = new HashMap<>();
        setInitialData();
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

    private void setInitialData() {
        MonsterDto monsterDto = new MonsterDto(R.drawable.vampire, "Вампиры",
                "Вампир может не есть и три года, но если уж он вышел на охоту… \nОн не остановится, пока не упьется кровью! ",
                "Гвинт",
                "Вампиры - cобирательное название группы существ, попавших на Континент во " +
                        "время глобального катаклизма под названием Сопряжение Сфер. " +
                        "Существует несколько видов вампиров, различных по повадкам и привычкам, а также по способностям и слабостям");
        monsterDb.put(1, monsterDto);

        monsterDto = new MonsterDto(R.drawable.ghost, "Духи и призраки",
                "Призраки появляются, когда смерть не избавляет умершего от страданий. Тот, кто привлечет к себе внимание морока, немедля перестанет мечтать о смерти! ",
                "Гвинт: Маг-Отступник", "Призрак (ориг. Upiór) — чудовище, упоминаемое в литературной саге и фигурирующее в играх Ведьмак, Ведьмак 2: Убийцы Королей, Ведьмак 3: Дикая Охота и Ведьмак: Охотник на чудовищ, неупокоенная душа, вернувшаяся из-за завесы смерти");
        monsterDb.put(2, monsterDto);
    }
}
