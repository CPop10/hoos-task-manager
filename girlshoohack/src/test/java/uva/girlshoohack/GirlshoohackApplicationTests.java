package uva.girlshoohack;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class GirlshoohackApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCreateAndGetUser() throws Exception {
		// Create a new user
		mockMvc.perform(post("/api/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"email\": \"test@example.com\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.email").value("test@example.com"));

		// Retrieve the user by email
		mockMvc.perform(get("/api/users/email/test@example.com"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.email").value("test@example.com"));
	}

	@Test
	public void testCreateAndGetTask() throws Exception {
		// Create a new user first
		mockMvc.perform(post("/api/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"email\": \"taskuser@example.com\"}"))
				.andExpect(status().isOk());

		// Create a new task for the user
		mockMvc.perform(post("/api/tasks/1")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"title\": \"Sample Task\", \"description\": \"This is a sample task.\", \"reminderTime\": \"2024-10-20T10:00:00\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title").value("Sample Task"));

		// Retrieve the task by ID
		mockMvc.perform(get("/api/tasks/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title").value("Sample Task"));
	}
}