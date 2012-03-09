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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.EventMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import fr.michot.video.business.services.impl.PersonneServiceImpl;
import fr.michot.video.db.Personne;

@Controller
@RequestMapping("VIEW")
@SessionAttributes({ "personne" })
public class PersonneViewHandler {

	@Inject
	PersonneServiceImpl service;

	@ModelAttribute("personne")
	public PersonneViewModel getPersonneVM() {
		return new PersonneViewModel();
	}

	@RenderMapping
	public String showPersonne(Model model) {
		return "/view";
	}

	@ActionMapping("switchMode")
	public void switchMode(
			@ModelAttribute("personne") PersonneViewModel personne,
			SessionStatus status, Model model, ActionResponse response) {
		personne.setEditMode(!personne.isEditMode());
		model.addAttribute("personne", personne);
		response.setRenderParameter("action", "list");
	}

	@ActionMapping("newPersonne")
	public void nouvellePersonne(
			SessionStatus status, Model model, ActionResponse response) {
		status.setComplete();
		PersonneViewModel personne = new PersonneViewModel();
		personne.setEditMode(true);
		model.addAttribute("personne", personne);
		response.setRenderParameter("action", "list");
	}

	@ActionMapping("save")
	public void populatePersonne(
			@Valid @ModelAttribute("personne") PersonneViewModel personne,
			BindingResult result, SessionStatus status, Model model,
			ActionResponse response) {
		Personne personneDb;
		if (personne.getId() > 0) {
			personneDb = service.modifie(personne.getId(), personne.getNom(),
					personne.getPrenom(), personne.getHomme(),
					personne.getPrive(), personne.getPhotoUrl(),
					personne.getAnnotations());
		} else {
			personneDb = service.ajoute(personne.getNom(), personne.getPrenom(),
					personne.getHomme(), personne.getPrive(),
					personne.getPhotoUrl(), personne.getAnnotations());
		}
		personne.setId(personneDb.getId());
		personne.setEditMode(false);
		status.setComplete();
		response.setRenderParameter("action", "list");
	}

	@EventMapping("idPersonne")
	public void processEventPersonneId(EventRequest eRequest,
			EventResponse eResponse, Model model) throws PortletException,
			IOException {
		Event event = eRequest.getEvent();
		int personneId = ((Integer) event.getValue()).intValue();
		Personne personne = service.rechercheParId(personneId);
		if (personne != null)
			model.addAttribute(
					"personne",
					new PersonneViewModel(personne.getId(),personne.getNom(), personne
							.getPhotoUrl(), personne.getPrenom(), personne
							.getPrive(), personne.getHomme(), personne
							.getAnnotations(), false));
	}

}
