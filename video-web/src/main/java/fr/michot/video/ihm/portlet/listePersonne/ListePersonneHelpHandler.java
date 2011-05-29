package fr.michot.video.ihm.portlet.listePersonne;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("HELP")
public class ListePersonneHelpHandler {

	@RequestMapping	// default (action=list)
	public String showHelpListePersonne() {
		return "/help";
	}

}
