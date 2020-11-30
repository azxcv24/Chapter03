package com.jvision.admin.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //롬복 적용
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;
    private final String address;

}
