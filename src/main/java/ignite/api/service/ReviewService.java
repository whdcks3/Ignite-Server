package ignite.api.service;

import org.springframework.stereotype.Service;

import ignite.api.models.Review;
import ignite.api.models.requests.ReviewRequest;
import ignite.api.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public void createReview(ReviewRequest req) {
        Review review = new Review();
        reviewRepository.save(review);
    }
}
