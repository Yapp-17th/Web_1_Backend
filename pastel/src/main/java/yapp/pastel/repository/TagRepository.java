package yapp.pastel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import yapp.pastel.domain.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
  
}
