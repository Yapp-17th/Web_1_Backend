package yapp.pastel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yapp.pastel.repository.ReviewRepository;

@Service
public class ReviewService {
  @Autowired
  private ReviewRepository reviewRepository;
}
