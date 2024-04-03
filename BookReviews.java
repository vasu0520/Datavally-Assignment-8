import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BookReview {
    private String title;
    private int rating;

    public BookReview(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}

class BookReviewAnalyzer {
    private List<BookReview> bookReviews;

    public BookReviewAnalyzer() {
        this.bookReviews = new ArrayList<>();
    }

    public void addBookReview(BookReview review) {
        bookReviews.add(review);
    }

    public void analyzeBookReviews() {
        Map<String, Integer> ratingRangeCounts = new HashMap<>();
        ratingRangeCounts.put("1-5 stars", 0);
        ratingRangeCounts.put("6-10 stars", 0);

        int positiveReviews = 0;
        int neutralReviews = 0;
        int negativeReviews = 0;

        for (BookReview review : bookReviews) {
            int rating = review.getRating();

            if (rating >= 1 && rating <= 5) {
                ratingRangeCounts.put("1-5 stars", ratingRangeCounts.get("1-5 stars") + 1);
            } else if (rating >= 6 && rating <= 10) {
                ratingRangeCounts.put("6-10 stars", ratingRangeCounts.get("6-10 stars") + 1);
            }

            if (rating >= 7 && rating <= 10) {
                positiveReviews++;
            } else if (rating == 5 || rating == 6) {
                neutralReviews++;
            } else {
                negativeReviews++;
            }
        }

        System.out.println("Book Review Analysis:");
        System.out.println("Books reviewed in the range of 1-5 stars: " + ratingRangeCounts.get("1-5 stars"));
        System.out.println("Books reviewed in the range of 6-10 stars: " + ratingRangeCounts.get("6-10 stars"));
        System.out.println("Positive reviews: " + positiveReviews);
        System.out.println("Neutral reviews: " + neutralReviews);
        System.out.println("Negative reviews: " + negativeReviews);
    }
}

public class Main {
    public static void main(String[] args) {
        BookReviewAnalyzer analyzer = new BookReviewAnalyzer();

        // Example book reviews
        analyzer.addBookReview(new BookReview("Book1", 8));
        analyzer.addBookReview(new BookReview("Book2", 4));
        analyzer.addBookReview(new BookReview("Book3", 7));
        analyzer.addBookReview(new BookReview("Book4", 5));
        analyzer.addBookReview(new BookReview("Book5", 9));
        analyzer.addBookReview(new BookReview("Book6", 2));

        analyzer.analyzeBookReviews();
    }
}
