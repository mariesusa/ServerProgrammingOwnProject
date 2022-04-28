package ServerProgramming.PhysicalRecordings;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ServerProgramming.PhysicalRecordings.domain.ConditionRepository;
import ServerProgramming.PhysicalRecordings.domain.FormatRepository;
import ServerProgramming.PhysicalRecordings.domain.GenreRepository;
import ServerProgramming.PhysicalRecordings.domain.Recording;
import ServerProgramming.PhysicalRecordings.domain.RecordingRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)

public class RecordingRepositoryTest {

	@Autowired
	private RecordingRepository rrepository;
	
	@Autowired
	private FormatRepository frepository;
	
	@Autowired
	private ConditionRepository crepository;
	
	@Autowired
	private GenreRepository grepository;
	
	@Test
	public void findByTitleShouldReturnRecording() {
		List<Recording> recordings = rrepository.findByTitle("Garbage");
		assertThat(recordings.get(0).getArtist()).isEqualTo("Garbage");
	}
	
	@Test
	public void createNewRecording() {
		Recording recording = new Recording ("Lagwagon", "Double Plaidium", 1997, "Fat Wreck Chords", "4th album", 39.47, frepository.findByFormat("Vinyl").get(0), crepository.findByCondition("Mint-").get(0), grepository.findByGenre("Punk").get(0));
		rrepository.save(recording);
		assertThat(recording.getId()).isNotNull();
	}
	
	@Test
	public void deleteNewRecording() {
		List<Recording> recordings = rrepository.findByTitle("Garbage");
		Recording recording = recordings.get(0);
		rrepository.delete(recording);
		List<Recording> newRecordings = rrepository.findByTitle("Garbage");
		assertThat(newRecordings).hasSize(0); 
	}
}
