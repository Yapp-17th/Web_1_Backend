package yapp.pastel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import yapp.pastel.domain.Cake;

public interface CakeRepository extends JpaRepository<Cake, Long> {
  public List<Cake> findTop12ByOrderByCreatedAtDesc();
}
