package com.gnsdp99.studyspring.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("Kim", 25);

        // when
        Long saveId = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(saveId);
        assertThat(findMember.getId()).isEqualTo(saveId);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("member1", 25);
        Member member2 = new Member("member2", 28);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> all = memberRepository.findAll();

        // then
        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(member1, member2);
    }
}