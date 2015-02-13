package sample.jpa.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sample.jpa.domain.Note;
import sample.jpa.repository.NoteRepository;

@Controller
public class IndexController {
	

	
	
	@Autowired
	private NoteRepository noteRepository;

	
	@RequestMapping("/candel")
	@Transactional(readOnly = true)
	public ModelAndView index1() {
		List<Note> notes = this.noteRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("index1");
		modelAndView.addObject("notes", notes);
		return modelAndView;
	}
	


}
