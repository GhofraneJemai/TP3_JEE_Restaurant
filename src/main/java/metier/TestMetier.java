package metier;

import java.util.List;

public class TestMetier {
	public static void main(String[] args) {
		MetierImpl metier = new MetierImpl();
		List<Restaurant> restaurants = metier.getRestaurantsParMotCle("Le Gourmet"); 
		for (Restaurant r : restaurants) {
			System.out.println(r);
		}
	}
}