package com.diary.today.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EnumMapperValue {
    private final String code;
    private final String name;

    public EnumMapperValue(EnumMapperType mapperType) {
        code = mapperType.getCode();
        name = mapperType.getName();
    }
}
