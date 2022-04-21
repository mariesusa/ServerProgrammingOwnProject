package ServerProgramming.PhysicalRecordings.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ServerProgramming.PhysicalRecordings.domain.ConditionRepository;
import ServerProgramming.PhysicalRecordings.domain.FormatRepository;
import ServerProgramming.PhysicalRecordings.domain.GenreRepository;
import ServerProgramming.PhysicalRecordings.domain.Recording;
import ServerProgramming.PhysicalRecordings.domain.RecordingRepository;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class RecordingController {
	
	@Autowired
	private RecordingRepository rrepository;
	
	@Autowired
	private FormatRepository frepository;
	
	@Autowired
	private ConditionRepository crepository;
	
	@Autowired
	private GenreRepository grepository;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value= {"/", "/recordinglist"})
	public String recordinglist(Model model) {
		model.addAttribute("recordings", rrepository.findAll());
		return "recordinglist";
	}
	
	@RequestMapping(value = "/add")
	public String addRecording(Model model) {
		model.addAttribute("recording", new Recording());
		model.addAttribute("formats", frepository.findAll());
		model.addAttribute("conditions", crepository.findAll());
		model.addAttribute("genres", grepository.findAll());
		return "addrecording";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Recording recording, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("A validation error occurred.");
			return "/addrecording";
		}
		rrepository.save(recording);
		return "redirect:recordinglist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteRecording(@PathVariable("id") Long id, Model model) {
		rrepository.deleteById(id);
		return "redirect:../recordinglist";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editRecording(@PathVariable("id") Long id, Model model) {
		model.addAttribute("recording", rrepository.findById(id));
		model.addAttribute("formats", frepository.findAll());
		model.addAttribute("conditions", crepository.findAll());
		model.addAttribute("genres", grepository.findAll());
		return "editrecording";
	}

}
