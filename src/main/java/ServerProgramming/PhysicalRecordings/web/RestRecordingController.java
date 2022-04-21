package ServerProgramming.PhysicalRecordings.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ServerProgramming.PhysicalRecordings.domain.Recording;
import ServerProgramming.PhysicalRecordings.domain.RecordingRepository;

@RestController
public class RestRecordingController {
	
	@Autowired
	private RecordingRepository rrepository;
	
	@RequestMapping(value="/recordings", method = RequestMethod.GET)
	public List<Recording> recordinglistRest() {
		return (List<Recording>) rrepository.findAll();
	}
	
	@RequestMapping(value="/recordings/{id}", method = RequestMethod.GET)
	public Optional<Recording> findRecordingRest(@PathVariable("id") Long id) {
		return rrepository.findById(id);
	}

}
