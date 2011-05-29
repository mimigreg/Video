package fr.michot.video.ihm.portlet.listePersonne;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Config")
public class ListePersonneConfigHandler {

	@RequestMapping	// default (action=list)
	public String showConfigListePersonne() {
		return "/edit";
	}

}
