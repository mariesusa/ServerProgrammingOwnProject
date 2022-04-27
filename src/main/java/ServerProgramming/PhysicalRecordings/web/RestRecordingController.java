package ServerProgramming.PhysicalRecordings.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ServerProgramming.PhysicalRecordings.domain.Recording;
import ServerProgramming.PhysicalRecordings.domain.RecordingRepository;

@RestController
public class RestRecordingController {
	
	@Autowired
	private RecordingRepository rrepository;
	
	@GetMapping("recordings")
	Iterable<Recording> getAll() {
		return rrepository.findAll();
	}
	
	@PostMapping("recordings")
	Recording newRecording(@RequestBody Recording newRecording) {
		return rrepository.save(newRecording);
	}
	
	@PutMapping("/recordings/{id}")
	Recording replaceRecording(@RequestBody Recording newRecording, @PathVariable Long id) {
		newRecording.setId(id);
		return rrepository.save(newRecording);	 
	}
	
	@DeleteMapping("/recordings/{id}")
	void deleteRecording(@PathVariable Long id) {
		rrepository.deleteById(id);
	}

}
