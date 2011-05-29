package fr.michot.video.ihm.portlet.personne;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("EDIT")
public class PersonneEditHandler {

	@RequestMapping // default (action=list)
	public String showEditListePersonne() {
		return "/edit";
	}


}
