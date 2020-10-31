package yapp.pastel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import yapp.pastel.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
}
