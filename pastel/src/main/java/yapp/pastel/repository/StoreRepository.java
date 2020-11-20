package yapp.pastel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import yapp.pastel.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
  
}
