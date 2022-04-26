package ServerProgramming.PhysicalRecordings.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Search {
	
	@Autowired
	private SearchRepository srepository;
	
	public List<Recording> listAll(String keyword) {
		if (keyword != null) {
			return srepository.search(keyword);
		}
		return srepository.findAll();
	}

}
