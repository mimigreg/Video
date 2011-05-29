package fr.michot.video.ihm.portlet.personne;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("HELP")
public class PersonneHelpHandler {

	@RequestMapping	// default (action=list)
	public String showHelpListePersonne() {
		return "/help";
	}

}
