package ru.alex.lab1.utils.converter.Impl;

import java.util.List;

import ru.alex.lab1.dto.MonsterWithDescriptionDto;
import ru.alex.lab1.entity.MonsterDescription;
import ru.alex.lab1.utils.converter.MonsterConverterDb;

public class MonsterDescriptionConverterDbImpl implements MonsterConverterDb<MonsterWithDescriptionDto, MonsterDescription, MonsterWithDescriptionDto> {
    @Override
    public MonsterDescription toEntity(MonsterWithDescriptionDto monsterClassDto) {
        return MonsterDescription.builder()
                .id(monsterClassDto.getId())
                .quote(monsterClassDto.getQuote())
                .quoteAuthor(monsterClassDto.getQuoteAuthor())
                .description(monsterClassDto.getDescription())
                .build();
    }


    @Override
    public MonsterWithDescriptionDto toDto(MonsterDescription monsterClassDto) {
        return MonsterWithDescriptionDto.builder()
                .quote(monsterClassDto.getQuote())
                .quoteAuthor(monsterClassDto.getQuoteAuthor())
                .description(monsterClassDto.getDescription())
                .build();
    }

}
