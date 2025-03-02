package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.ImetierRestaurant;
import metier.MetierImpl;
import metier.Restaurant;

@WebServlet(name = "cs", urlPatterns = { "/controleur" })
public class ControleurServlet extends HttpServlet {
    private ImetierRestaurant metier;

    @Override
    public void init() throws ServletException {
        metier = new MetierImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mc = request.getParameter("motCle"); 
        RestaurantModele mod = new RestaurantModele(); 
        mod.setMotCle(mc); 
        List<Restaurant> restaurants = metier.getRestaurantsParMotCle(mc); 
        mod.setRestaurants(restaurants); 
        request.setAttribute("modele", mod); 
        request.getRequestDispatcher("RestaurantsView.jsp").forward(request, response); 
    }
}
