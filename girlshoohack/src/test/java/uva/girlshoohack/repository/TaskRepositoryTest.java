package uva.girlshoohack.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import uva.girlshoohack.Entity.Task;
import uva.girlshoohack.Entity.User;
import uva.girlshoohack.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setEmail("test@example.com");
        user = userRepository.save(user);
    }

    @Test
    public void testSaveAndFindTask() {
        Task task = new Task();
        task.setTitle("Sample Task");
        task.setDescription("This is a sample task.");
        task.setReminderTime(LocalDateTime.now());
        task.setUser(user);

        taskRepository.save(task);

        List<Task> foundTasks = taskRepository.findByTitle("Sample Task");
        Assertions.assertEquals(1, foundTasks.size());
        Assertions.assertEquals("Sample Task", foundTasks.get(0).getTitle());
    }
}