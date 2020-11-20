package yapp.pastel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import yapp.pastel.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
  Optional<Store> findByZone(String zone);
  Optional<Store> findByEmail(String email);
  Optional<Store> findByName(String name);
}
