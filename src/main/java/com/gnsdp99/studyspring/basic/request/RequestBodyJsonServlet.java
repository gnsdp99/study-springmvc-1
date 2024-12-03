package com.gnsdp99.studyspring.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnsdp99.studyspring.basic.dto.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * JSON 형식의 데이터 전송
 * */
@WebServlet(
        name = "requestBodyJsonServlet",
        urlPatterns = "/request-body-json"
)
public class RequestBodyJsonServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        response.getWriter().write(helloData.toString());
    }
}
