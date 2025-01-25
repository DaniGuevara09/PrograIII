package uptc.edu.co.evaluation4.servlets;

import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import uptc.edu.co.evaluation4.logic.Dish;
import uptc.edu.co.evaluation4.persistence.DishDAO;

@WebServlet(name = "DishServlet", value = "/dish-servlet")
public class SvDish extends HttpServlet {
    private DishDAO dishDAO;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        dishDAO = new DishDAO();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");
        try (PrintWriter out = response.getWriter()) {
            switch (option) {
                case "1": {
                    out.println(gson.toJson(dishDAO.getAll()));
                    break;
                }

                case "2": {
                    String idDish = request.getParameter("idDish");
                    Dish dish = dishDAO.findById(idDish);
                    out.println(gson.toJson(dish));
                    break;
                }
                default:
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    out.println("Invalid option");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idDish = request.getParameter("idDish");
        String name = request.getParameter("name");
        int calories = Integer.parseInt(request.getParameter("calories"));
        boolean isVegetarian = Boolean.parseBoolean(request.getParameter("isVegetarian"));
        int value = Integer.parseInt(request.getParameter("value"));
        String comments = request.getParameter("comments");

        try (PrintWriter out = response.getWriter()) {
            Dish dish = new Dish(idDish, name, calories, isVegetarian, value, comments);
            Dish savedDish = dishDAO.save(dish);
            out.println(gson.toJson(savedDish));
        }
    }
}
