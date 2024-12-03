package com.gnsdp99.studyspring.web.servlet;

import com.gnsdp99.studyspring.domain.member.Member;
import com.gnsdp99.studyspring.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(
        name = "memberListServlet",
        urlPatterns = "/servlet/members"
)
public class MemberListServlet extends HttpServlet {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> membersList = memberRepository.findAll();

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();
        writer.write("""
                <html>
                <head>
                    <meta charset="UTF-8">
                    <title>Title</title>
                </head>
                <body>
                    <a href="/index.html">메인</a>
                    <table>
                        <thead>
                            <th>id</th>
                            <th>username</th>
                            <th>age</th>
                        </thead>
                        <tbody>
                """);

        for (Member member : membersList) {
            writer.write("""
                        <tr>
                            <td>%d</td>
                            <td>%s</td>
                            <td>%d</td>
                        </tr>
                        """.formatted(member.getId(), member.getUsername(), member.getAge()));
        }

        writer.write("""
                        </tbody>
                    </table>
                </body>
                </html>
                """);
    }
}
