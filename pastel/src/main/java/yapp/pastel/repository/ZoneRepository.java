package yapp.pastel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yapp.pastel.domain.Zone;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
  public Optional<Zone> findByName(String name);
}
