package yapp.pastel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import yapp.pastel.domain.Kind;

public interface KindRepository extends JpaRepository<Kind, Long> {
  
}
