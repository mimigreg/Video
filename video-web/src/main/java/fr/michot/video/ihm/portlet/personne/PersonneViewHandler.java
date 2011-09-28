package fr.michot.video.ihm.portlet.personne;

import java.io.IOException;

import javax.inject.Inject;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.EventMapping;

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
	public String showPersonne(Model model) {
		if (personne == null) {
			return "/viewEmpty";
		} else {
			model.addAttribute("personne", personne);
			return "/view";
		}
	}
	
	@RequestMapping(params = "action=add")
	public String showPersonneForm(Model model) {
		if (!model.containsAttribute("personne")) {
			model.addAttribute("personne", new Personne());
		}
		return "/edit";
	}

	@RequestMapping(params = "action=add")
	public void populatePersonne(@Valid @ModelAttribute("personne") Personne personne, SessionStatus status, ActionResponse response) {
		//this.personne = service.ajoute(personne.getNom(), personne.getPrenom(), personne.isHomme(), personne.isPrive(), personne.getPhotoUrl(), personne.getAnnotations());
		status.setComplete();
		response.setRenderParameter("action", "view");
	}

	@EventMapping("idPersonne")
	public void processEventPersonneId(EventRequest eRequest, EventResponse eResponse) throws PortletException, IOException {
		Event event = eRequest.getEvent();
		int personneId = Integer.parseInt((String) event.getValue());
		personne = service.rechercheParId(personneId);
		eResponse.setRenderParameter("action", "detail");
	}

}
