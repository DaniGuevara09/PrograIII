package co.edu.co.servlets;

import co.edu.co.logic.HandlingCar;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletExample", value = "/ServletExample")
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

        try (
            PrintWriter out = response.getWriter();
            ){
            List<Car> cars = handlingCar.getAll();
            out.println(gson.toJson(cars));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}