package com.jvision.admin.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복테스트하는(){
        String name = "홍길동";
        int amount = 2000;
        String address = "vision";

        HelloResponseDto dto = new HelloResponseDto(name, amount, address);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        assertThat(dto.getAddress()).isEqualTo(address);
    }
}
