<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.gnsdp99.studyspring.domain.member.Member" %>
<%@ page import="com.gnsdp99.studyspring.domain.member.MemberRepository" %>
<%
    //request, response 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>가입 성공</div>
    <ul>
        <li>id=<%=member.getId()%></li>
        <li>username=<%=member.getUsername()%></li>
        <li>age=<%=member.getAge()%></li>
    </ul>
    <a href="${pageContext.request.contextPath}/index.html">메인</a>
</body>
</html>
