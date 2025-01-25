package com.example.demo1.servlets;

import com.example.demo1.logic.Car;
import com.example.demo1.logic.HandlingCar;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletExample", value = "/servlet-example")
public class ServletExample extends HttpServlet {
    private HandlingCar handlingCar;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        handlingCar = new HandlingCar();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("option");
        try (
                PrintWriter out = response.getWriter();
        ){
            switch (op){
                case "1": out.println(gson.toJson(handlingCar.getAll()));
                break;
                case "2": {
                    String plate = request.getParameter("plate");
                    out.println(gson.toJson(handlingCar.findByPlate(plate)));
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String plate = request.getParameter("plate");
        String mark = request.getParameter("mark");
        String model = request.getParameter("model");
        String color = request.getParameter("color");

        try (
                PrintWriter out = response.getWriter();
                ){
            Car car = new Car(plate, mark, Short.parseShort(model), color);

            if (handlingCar.addCar(car)){
                out.println(gson.toJson(handlingCar.findByPlate(plate)));
            } else {
                out.println(gson.toJson(handlingCar.findByPlate(plate)));
            }
        }
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try (
                PrintWriter out = response.getWriter();
                ){
            out.println();
        }
    }
}
