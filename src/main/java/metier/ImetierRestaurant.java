package metier;

import java.util.List;

public interface ImetierRestaurant  {
    public List<Restaurant> getRestaurantsParMotCle(String motCle);

    public void addRestaurant(Restaurant r);
}
