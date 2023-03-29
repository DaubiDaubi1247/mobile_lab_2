package ru.alex.lab1.callBack.monster;

import java.io.IOException;

import ru.alex.lab1.dto.MonsterWithDescriptionDto;

public interface MonsterByIdCallBack {
    void onSuccess(MonsterWithDescriptionDto monster);
    void onFail(IOException error);
}
