package ru.alex.lab1.utils.converter;

import ru.alex.lab1.dto.MonsterWithDescriptionDto;

public interface MonsterConverter {
    MonsterWithDescriptionDto toMonsterWithDesc(String responseInStr);
}
