package fr.michot.video.ihm.portlet.personne;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.michot.video.business.services.impl.PersonneServiceImpl;
import fr.michot.video.db.Personne;

@Controller
@RequestMapping("EDIT")
public class PersonneEditHandler {

	@Inject
	PersonneServiceImpl service;

	private Personne personne = null;

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@ModelAttribute("personne")
	public Personne getPersonne() {
		return this.personne;
	}

	@RequestMapping
	public String showPersonne(Model model) {
		if (personne == null) {
			return "/viewEmpty";
		} else {
			model.addAttribute("personne", personne);
			return "/view";
		}
	}


}
