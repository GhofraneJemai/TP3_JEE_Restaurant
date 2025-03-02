package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements ImetierRestaurant {

    @Override
    public List<Restaurant> getRestaurantsParMotCle(String motCle) {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM restaurants WHERE NOM_RESTAURANT LIKE ?");
            ps.setString(1, "%" + motCle + "%"); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Restaurant r = new Restaurant();
                r.setIdRestaurant(rs.getLong("ID_RESTAURANT"));
                r.setNomRestaurant(rs.getString("NOM_RESTAURANT"));
                r.setTypeCuisine(rs.getString("TYPE_CUISINE"));
                r.setAdresse(rs.getString("ADRESSE"));
                restaurants.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }


    @Override
    public void addRestaurant(Restaurant r) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO restaurants (NOM_RESTAURANT, TYPE_CUISINE, ADRESSE) VALUES (?, ?, ?)");
            ps.setString(1, r.getNomRestaurant());
            ps.setString(2, r.getTypeCuisine());
            ps.setString(3, r.getAdresse());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
