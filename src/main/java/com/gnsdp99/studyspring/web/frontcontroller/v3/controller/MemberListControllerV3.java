package com.gnsdp99.studyspring.web.frontcontroller.v3.controller;

import com.gnsdp99.studyspring.domain.member.Member;
import com.gnsdp99.studyspring.domain.member.MemberRepository;
import com.gnsdp99.studyspring.web.frontcontroller.ModelView;
import com.gnsdp99.studyspring.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> membersList = memberRepository.findAll();

        ModelView modelView = new ModelView("members");
        modelView.getModel().put("membersList", membersList);
        return modelView;
    }
}
