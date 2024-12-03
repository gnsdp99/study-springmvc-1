package com.gnsdp99.studyspring.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class Member {

    @Setter
    private Long id;
    private String username;
    private int age;

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
