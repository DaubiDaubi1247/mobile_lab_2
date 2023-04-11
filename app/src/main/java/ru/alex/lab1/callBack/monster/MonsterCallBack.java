package ru.alex.lab1.callBack.monster;

import org.json.JSONException;

import java.io.IOException;

import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.dto.MonsterWithDescriptionDto;

public interface MonsterCallBack {
    <T> void onSuccess(T response);

    void onFail(IOException error);
}
