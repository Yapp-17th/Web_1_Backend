package yapp.pastel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import yapp.pastel.domain.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
  public Optional<Tag> findByContent(String content);
  public List<Tag> findTop3ByOrderByCountDesc();

  @Query(nativeQuery = true, value="SELECT t FROM tag t ORDER BY rand() LIMIT 10")
  public List<Tag> findByRandomOrder();
}
