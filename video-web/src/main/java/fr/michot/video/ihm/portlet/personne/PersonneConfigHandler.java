package fr.michot.video.ihm.portlet.personne;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Config")
public class PersonneConfigHandler {

	@RequestMapping	// default (action=list)
	public String showConfigListePersonne() {
		return "/edit";
	}

}
