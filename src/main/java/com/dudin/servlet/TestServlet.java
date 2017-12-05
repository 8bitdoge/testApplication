package com.dudin.servlet;

import com.dudin.Dao.JDBCDAO;
import com.dudin.Gson.GsonTest;
import com.dudin.model.Answer;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 8bitdoge on 14.11.2017.
 */
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

//        GsonTest gsonTest = new GsonTest();
//        String ttt = request.getReader().readLine();
//        System.out.println(ttt);
//        String numberOfTest = request.getParameter("numberOfTest");
//
//        String json = new Gson().toJson(gsonTest.getGsonTest(numberOfTest));
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(json);
           }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        GsonTest gsonTest = new GsonTest();
        String numberOfTest = request.getParameter("numberOfTest");

        String json = new Gson().toJson(gsonTest.getGsonTest(numberOfTest));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
