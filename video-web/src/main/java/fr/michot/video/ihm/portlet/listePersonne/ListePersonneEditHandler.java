package fr.michot.video.ihm.portlet.listePersonne;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("EDIT")
public class ListePersonneEditHandler {

	@RequestMapping // default (action=list)
	public String showEditListePersonne() {
		return "/edit";
	}


}
