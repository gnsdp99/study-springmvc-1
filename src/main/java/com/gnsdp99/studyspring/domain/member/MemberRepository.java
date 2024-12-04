package com.gnsdp99.studyspring.domain.member;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    @Getter
    private static final MemberRepository instance = new MemberRepository();

    private MemberRepository() {}

    public Long save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member.getId();
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
