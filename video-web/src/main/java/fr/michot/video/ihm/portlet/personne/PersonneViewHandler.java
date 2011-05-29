package fr.michot.video.ihm.portlet.personne;

import java.io.IOException;

import javax.inject.Inject;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import fr.michot.video.business.services.impl.PersonneServiceImpl;
import fr.michot.video.db.Personne;

@Controller
@RequestMapping("VIEW")
public class PersonneViewHandler {

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
	// default (action=detail)
	public String showListePersonne(Model model) {// ,
													// @RequestParam("personneId")
													// String personneId) {

		// if (personneId != null) {
		// personne = service.rechercheParId(Integer.parseInt(personneId));
		// }
		if (personne != null) {
			model.addAttribute("personne", personne);
			return "/view";
		} else {
			return "/viewEmpty";
		}
	}

	@RequestMapping(params = "action=search")
	public void processActionSearch(@RequestParam("personneId") int personneId, ActionResponse aResponse) {
		this.personne = service.rechercheParId(personneId);
		aResponse.setRenderParameter("action", "detail");
	}

	@RequestMapping(params = "action=save")
	public void processActionSave(@ModelAttribute("personne") Personne personne, BindingResult result, SessionStatus status, ActionResponse response) {
		// new PersonneValidator().validate(personne, result);
		if (!result.hasErrors()) {
			status.setComplete();
			response.setRenderParameter("action", "detail");
		}
	}

	@RequestMapping(params = "event=personneId")
	public void processEventPersonneId(@RequestParam("personneId") int personneId, EventResponse eResponse) throws PortletException, IOException {
		personne = service.rechercheParId(personneId);
		//model.addAttribute("personne", personne);
	}

}
