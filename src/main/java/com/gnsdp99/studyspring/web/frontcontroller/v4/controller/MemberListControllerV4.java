package com.gnsdp99.studyspring.web.frontcontroller.v4.controller;

import com.gnsdp99.studyspring.domain.member.Member;
import com.gnsdp99.studyspring.domain.member.MemberRepository;
import com.gnsdp99.studyspring.web.frontcontroller.ModelView;
import com.gnsdp99.studyspring.web.frontcontroller.v3.ControllerV3;
import com.gnsdp99.studyspring.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> membersList = memberRepository.findAll();
        model.put("membersList", membersList);
        return "members";
    }
}
