package ru.alex.lab1.callBack.monster;

import java.io.IOException;

import ru.alex.lab1.dto.MonsterWithDescriptionDto;

public interface MonsterCallBack {
    void onSuccess(String responseInString);
    void onFail(IOException error);
}
