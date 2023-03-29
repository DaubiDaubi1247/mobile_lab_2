package ru.alex.lab1.urls.monster;

import ru.alex.lab1.urls.BaseUrl;

public interface MonsterUrls extends BaseUrl {

    String MONSTER = BASE_URL + "monster/";
    String GET_ALL_MONSTER_CLASS = MONSTER + "class/all";
    String GET_ALL_MONSTERS = MONSTER + "all/";
}
