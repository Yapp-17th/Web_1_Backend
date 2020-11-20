package yapp.pastel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import yapp.pastel.domain.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
  Optional<Tag> findByContent(String content);
}
