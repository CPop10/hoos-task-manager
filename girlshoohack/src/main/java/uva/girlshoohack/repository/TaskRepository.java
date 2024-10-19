package uva.girlshoohack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uva.girlshoohack.Entity.Task;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for Task entity.
 * Extends JpaRepository to provide CRUD operations.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
    List<Task> findByTitle(String title);
    List<Task> findByTitleContaining(String keyword);
    List<Task> findByReminderTime(LocalDateTime reminderTime);
    List<Task> findByUserIdAndReminderTimeBetween(Long userId, LocalDateTime startTime, LocalDateTime endTime);
    long countByUserId(Long userId);


}