package uva.girlshoohack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uva.girlshoohack.Entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for User entity.
 * Extends JpaRepository to provide CRUD operations.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by email.
     *
     * @param email the email of the user to find.
     * @return an optional containing the found user or empty if no user found.
     */
    Optional<User> findByEmail(String email);
    List<User> findAll();
    boolean existsByEmail(String email);
    List<User> findAllById(Iterable<Long> ids);
}