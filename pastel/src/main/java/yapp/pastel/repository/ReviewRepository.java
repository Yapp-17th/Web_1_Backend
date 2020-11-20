package yapp.pastel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import yapp.pastel.domain.user.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
  
}
