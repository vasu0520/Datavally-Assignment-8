import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Movie {
    private String title;
    private String rating;
    private double userRating;

    public Movie(String title, String rating, double userRating) {
        this.title = title;
        this.rating = rating;
        this.userRating = userRating;
    }

    public String getRating() {
        return rating;
    }

    public double getUserRating() {
        return userRating;
    }
}

class MovieAnalyzer {
    private List<Movie> movies;

    public MovieAnalyzer() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void analyzeMovies() {
        Map<String, Integer> categoryCounts = new HashMap<>();
        Map<String, Double> categoryTotalRatings = new HashMap<>();

        for (Movie movie : movies) {
            String rating = movie.getRating();
            double userRating = movie.getUserRating();

            categoryCounts.put(rating, categoryCounts.getOrDefault(rating, 0) + 1);
            categoryTotalRatings.put(rating, categoryTotalRatings.getOrDefault(rating, 0.0) + userRating);
        }

        System.out.println("Movie Ratings Analysis:");
        for (String rating : categoryCounts.keySet()) {
            int count = categoryCounts.get(rating);
            double totalRating = categoryTotalRatings.get(rating);
            double averageRating = totalRating / count;

            System.out.println("Rating: " + rating + ", Number of movies: " + count + ", Average rating: " + averageRating);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MovieAnalyzer analyzer = new MovieAnalyzer();

        // Example movie ratings
        analyzer.addMovie(new Movie("Movie1", "PG", 4.5));
        analyzer.addMovie(new Movie("Movie2", "PG-13", 3.8));
        analyzer.addMovie(new Movie("Movie3", "R", 4.2));
        analyzer.addMovie(new Movie("Movie4", "PG", 3.9));
        analyzer.addMovie(new Movie("Movie5", "R", 4.1));

        analyzer.analyzeMovies();
    }
}
