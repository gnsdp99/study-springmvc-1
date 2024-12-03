package com.gnsdp99.studyservlet.basic.dto;

import lombok.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelloData {

    private String username;
    private int age;
}
