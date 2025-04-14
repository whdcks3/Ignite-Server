package ignite.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ignite.api.models.requests.ReviewRequest;
import ignite.api.service.ReviewService;

@RestController
@RequestMapping("/api/review")
public class ReviewRestController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<?> createReview(@RequestBody ReviewRequest req) {
        reviewService.createReview(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
