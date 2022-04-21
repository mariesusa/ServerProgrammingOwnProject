package ServerProgramming.PhysicalRecordings.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RecordingRepository extends CrudRepository<Recording, Long> {
	
	List<Recording> findByArtist(String artist);
	List<Recording> findByTitle(String title);

}
