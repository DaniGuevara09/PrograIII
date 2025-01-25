package com.example.ev4.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "SvItem", value = "/SvItem")
public class SvItem extends HttpServlet {

    private Gson gson;
    private SvItem svItem;

    @Override
    public void init() throws ServletException {
        super.init();
        gson = new Gson();
        svItem = new SvItem();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("dragonball.json");

        // Verificar si el archivo no fue encontrado
        if (inputStream == null) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Archivo dragonball.json no encontrado.");
            return;
        }

        // Leer el contenido del archivo JSON
        String json = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonArray itemsArray = jsonObject.getAsJsonArray("items");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(itemsArray.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}