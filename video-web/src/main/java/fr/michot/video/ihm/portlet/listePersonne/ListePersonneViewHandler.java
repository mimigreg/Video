package fr.michot.video.ihm.portlet.listePersonne;

import java.util.List;

import javax.inject.Inject;
import javax.portlet.ActionResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import fr.michot.video.business.services.impl.PersonneServiceImpl;
import fr.michot.video.db.Personne;

@Controller
@RequestMapping("VIEW")
@SessionAttributes("personne")
public class ListePersonneViewHandler {

	@Inject
	PersonneServiceImpl service;

	private List<Personne> listePersonnes = null;

	public void setListePersonnes(List<Personne> listePersonnes) {
		this.listePersonnes = listePersonnes;
	}

	@ModelAttribute("listePersonnes")
	public List<Personne> getListePersonnes() {
		return this.listePersonnes;
	}

	@RequestMapping	// default (action=list)
	public String showListePersonne(Model model) {// @RequestParam("filmId")
													// String filmId,
													// @RequestParam("recherche")
													// String recherche) {

		// if (filmId != null) {
		// listePersonnes = service.rechercheParFilm(Integer.parseInt(filmId));
		// } else {
		// if (recherche != null) {
		// listePersonnes = service.recherche(recherche, null, null, null);
		// }
		// }

		if (listePersonnes != null && !listePersonnes.isEmpty()) {
			model.addAttribute("listePersonne", listePersonnes);
			return "/view";
		} else {
			return "/viewEmpty";
		}
	}

	@RequestMapping(params = "action=add")	// render phase
	public String showPersonneForm(Model model) {
		// Used for the initial form as well as for redisplaying with errors.
		if (!model.containsAttribute("personne")) {
			model.addAttribute("personne", new Personne());
		}
		return "/personneAdd";
	}

	@RequestMapping(params = "action=add")	// action phase
	public void populatePersonne(@ModelAttribute("personne") Personne personne, BindingResult result, SessionStatus status, ActionResponse response) {
		// new PersonneValidator().validate(personne, result);
		if (!result.hasErrors()) {
			this.listePersonnes.add(personne);
			status.setComplete();
			response.setRenderParameter("action", "list");
		}
	}

	@RequestMapping(params = "action=delete")
	public void removePersonne(@RequestParam("idPersonne") int idPersonne, ActionResponse response) {
		this.listePersonnes.remove(idPersonne);
		response.setRenderParameter("action", "list");
	}

}
