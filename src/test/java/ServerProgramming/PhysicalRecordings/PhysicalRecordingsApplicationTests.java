package ServerProgramming.PhysicalRecordings;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ServerProgramming.PhysicalRecordings.web.RecordingController;

@SpringBootTest
class PhysicalRecordingsApplicationTests {

	@Autowired
	private RecordingController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
