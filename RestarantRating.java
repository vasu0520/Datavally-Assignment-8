import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RestaurantRating {
    private String restaurantName;
    private double rating;

    public RestaurantRating(String restaurantName, double rating) {
        this.restaurantName = restaurantName;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }
}

class RestaurantRatingAnalyzer {
    private List<RestaurantRating> restaurantRatings;

    public RestaurantRatingAnalyzer() {
        this.restaurantRatings = new ArrayList<>();
    }

    public void addRestaurantRating(RestaurantRating rating) {
        restaurantRatings.add(rating);
    }

    public void analyzeRestaurantRatings() {
        Map<String, Integer> ratingRangeCounts = new HashMap<>();
        ratingRangeCounts.put("1-5", 0);
        ratingRangeCounts.put("6-10", 0);

        Map<String, Double> ratingRangeTotal = new HashMap<>();
        ratingRangeTotal.put("1-5", 0.0);
        ratingRangeTotal.put("6-10", 0.0);

        for (RestaurantRating rating : restaurantRatings) {
            double currentRating = rating.getRating();
            String rangeKey = (currentRating >= 1 && currentRating <= 5) ? "1-5" : "6-10";
            ratingRangeCounts.put(rangeKey, ratingRangeCounts.get(rangeKey) + 1);
            ratingRangeTotal.put(rangeKey, ratingRangeTotal.get(rangeKey) + currentRating);
        }

        System.out.println("Restaurant Rating Analysis:");
        for (Map.Entry<String, Integer> entry : ratingRangeCounts.entrySet()) {
            String range = entry.getKey();
            int count = entry.getValue();
            double totalRating = ratingRangeTotal.get(range);
            double averageRating = (count == 0) ? 0 : totalRating / count;
            System.out.println("Restaurants rated in range " + range + ": " + count + ", Average rating: " + averageRating);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        RestaurantRatingAnalyzer analyzer = new RestaurantRatingAnalyzer();

        // Example restaurant ratings
        analyzer.addRestaurantRating(new RestaurantRating("Restaurant1", 4.5));
        analyzer.addRestaurantRating(new RestaurantRating("Restaurant2", 7.8));
        analyzer.addRestaurantRating(new RestaurantRating("Restaurant3", 3.2));
        analyzer.addRestaurantRating(new RestaurantRating("Restaurant4", 9.5));
        analyzer.addRestaurantRating(new RestaurantRating("Restaurant5", 6.4));

        analyzer.analyzeRestaurantRatings();
    }
}
