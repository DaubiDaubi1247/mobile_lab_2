package ru.alex.lab1.utils.converter.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ru.alex.lab1.dto.MonsterClassDto;
import ru.alex.lab1.dto.MonsterDto;
import ru.alex.lab1.dto.MonsterWithDescriptionDto;
import ru.alex.lab1.pojo.RecyclerCardPreview;
import ru.alex.lab1.utils.converter.MonsterConverter;

public class GsonMonsterConverterImpl implements MonsterConverter {

    static Gson gson = new Gson();

    @Override
    public MonsterWithDescriptionDto toMonsterWithDesc(String responseInStr) {

        return gson.fromJson(responseInStr, MonsterWithDescriptionDto.class);
    }

    @Override
    public List<RecyclerCardPreview> toMonsterDtoList(String responseInStr) {

        Type listOfMyClassObject = new TypeToken<ArrayList<MonsterDto>>() {}.getType();
        List<MonsterDto> monsterDtoList = gson.fromJson(responseInStr, listOfMyClassObject);

        return monsterDtoList.stream()
                .map(MonsterDto::toPojo)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecyclerCardPreview> toMonsterClassDtoList(String responseInStr) {
        Type listOfMyClassObject = new TypeToken<ArrayList<MonsterClassDto>>() {}.getType();
        List<MonsterClassDto> monsterDtoList = gson.fromJson(responseInStr, listOfMyClassObject);

        return monsterDtoList.stream()
                .map(MonsterClassDto::toPojo)
                .collect(Collectors.toList());
    }
}
