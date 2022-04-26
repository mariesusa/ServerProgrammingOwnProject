package ServerProgramming.PhysicalRecordings.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SearchRepository extends JpaRepository<Recording, Long> {

	@Query("SELECT r FROM Recording r WHERE CONCAT(r.artist, ' ', r.title, ' ', r.year, ' ', r.label, ' ', r.comment, ' ', r.price, ' ') LIKE %?1%")
	
	public List<Recording> search(String keyword);
}
