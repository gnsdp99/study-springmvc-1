package com.gnsdp99.studyservlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnsdp99.studyservlet.basic.dto.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "responseJsonServlet",
        urlPatterns = "/response-json"
)
public class ResponseJsonServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloData helloData = HelloData.builder()
                .username("Kim")
                .age(25)
                .build();

        String messageBody = objectMapper.writeValueAsString(helloData);
        response.getOutputStream().print(messageBody);
    }
}
