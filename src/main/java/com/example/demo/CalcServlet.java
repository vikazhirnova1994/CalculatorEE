package com.example.demo;

import java.io.*;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * @author Victoria Zhirnova
 * @project CalculatorEE
 */

public class CalcServlet extends HttpServlet {

    @Inject
    private Calculator calculator;
    @Inject
    private User user;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        user.setName("Vika");
        request.setAttribute("user", user);
        getServletContext()
                .getRequestDispatcher("/calculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String left = request.getParameter("left");
        String right = request.getParameter("right");
        String operator = request.getParameter("operator");
        StringBuilder messages = new StringBuilder("");

        String value = "";

        if (left.isEmpty() || right.isEmpty() || !left.matches("\\d+") || !right.matches("\\d+")) {
            messages.append("Please enter digit");
        } else {
            value = getNewValue(left, right, operator, value);
        }

        request.setAttribute("messages", messages);
        request.setAttribute("user", user);
        request.setAttribute("value", value); // It'll be available as ${sum}.
        request.setAttribute("left", left); // It'll be available as ${sum}.
        request.setAttribute("right", right); // It'll be available as ${sum}.
        request.getRequestDispatcher("/calculator.jsp").forward(request, response);
    }

    private String getNewValue(String left, String right, String operator, String value) {
        switch (operator) {
            case ("add"): //*IF PLUS*//*
                value = String.valueOf(calculator.sum(left, right));
                break;
            case ("substr"): //*IF MINUS*//*
                value = String.valueOf(calculator.subtract(left, right));
                break;
            case ("mul"): //*IF MULTIPLICATION*//*
                value = String.valueOf(calculator.multiply(left, right));
                break;
            case ("div"): //*IF DIVISION*//*
                value = String.valueOf(calculator.divide(left, right));
                break;
            case ("pow"): //*IF POW*//*
                value = String.valueOf(calculator.pow(left, right));
                break;
        }
        return value;
    }

    public void destroy() {
    }
}