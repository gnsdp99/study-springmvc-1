package com.gnsdp99.studyspring.web.frontcontroller.v2.controller;

import com.gnsdp99.studyspring.domain.member.Member;
import com.gnsdp99.studyspring.domain.member.MemberRepository;
import com.gnsdp99.studyspring.web.frontcontroller.MyView;
import com.gnsdp99.studyspring.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> membersList = memberRepository.findAll();

        request.setAttribute("membersList", membersList);

        return new MyView("/WEB-INF/views/members.jsp");
    }
}
