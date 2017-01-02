package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.model.MealsStorage;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;


/**
 * User: gkislin
 * Date: 19.08.2014
 */
public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to users");

//        request.getRequestDispatcher("/users.jsp").forward(request, response);
        List<MealWithExceed>mealWithExceedList=MealsUtil.getFilteredWithExceededByCycle(MealsStorage.getMeals(),
                LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        request.setAttribute("mealsList", mealWithExceedList);
        request.getRequestDispatcher("meals.jsp").forward(request,response);
//        response.sendRedirect("meals.jsp");
    }
}
