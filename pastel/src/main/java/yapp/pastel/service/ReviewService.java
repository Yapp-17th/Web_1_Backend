package yapp.pastel.service;

import org.springframework.beans.factory.annotation.Autowired;

import yapp.pastel.repository.ReviewRepository;

public class ReviewService {
  @Autowired
  private ReviewRepository reviewRepository;
}
