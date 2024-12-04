package com.gnsdp99.studyspring.web.frontcontroller.v3.controller;

import com.gnsdp99.studyspring.domain.member.Member;
import com.gnsdp99.studyspring.domain.member.MemberRepository;
import com.gnsdp99.studyspring.web.frontcontroller.ModelView;
import com.gnsdp99.studyspring.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", member);
        return modelView;
    }
}
