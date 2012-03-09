package fr.michot.video.ihm.portlet.listePersonne;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import fr.michot.video.business.services.impl.PersonneServiceImpl;
import fr.michot.video.db.Personne;

@Controller
@RequestMapping("VIEW")
@SessionAttributes({ "listePersonnes", "recherchePersonneFormBean" })
public class ListePersonneViewHandler {

	@Inject
	PersonneServiceImpl service;

	@RenderMapping
	public String showListePersonne() {
		return "/view";
	}

	@ModelAttribute("listePersonnes")
	private List<Personne> getListePersonnes() {
		return new ArrayList<Personne>();
	}

	@ModelAttribute("recherchePersonneFormBean")
	private RecherchePersonneFormBean getRecherchePersonneFormBean() {
		return new RecherchePersonneFormBean();
	}

	@ActionMapping("search")
	public void populatePersonne(
			@ModelAttribute("recherchePersonneFormBean") @Valid RecherchePersonneFormBean recherchePersonneFormBean,
			BindingResult result, SessionStatus status, Model model,
			ActionResponse response) {
		// status.setComplete();
		List<Personne> listePersonnes;
		if (recherchePersonneFormBean.isRechercheAvancee()) {
			listePersonnes = service.recherche(
					recherchePersonneFormBean.getNom(),
					recherchePersonneFormBean.getPrenom(),
					recherchePersonneFormBean.getHomme(),
					recherchePersonneFormBean.getPrive());
		} else {
			// TODO coder une recherche champs libre
			listePersonnes = service.recherche(
					recherchePersonneFormBean.getNom(),
					recherchePersonneFormBean.getPrenom(),
					recherchePersonneFormBean.getHomme(),
					recherchePersonneFormBean.getPrive());
		}
		model.addAttribute("listePersonnes", listePersonnes);
		response.setRenderParameter("action", "list");
	}

	@ActionMapping("delete")
	public void removePersonne(@RequestParam("idPersonne") int idPersonne,
	// @ModelAttribute("listePersonnes") ArrayList<Personne> listePersonnes, //
	// Don't work
			PortletSession session, ActionResponse response) {
		service.efface(idPersonne);
		deletePersonneFromModel(idPersonne, session);
		response.setRenderParameter("action", "list");
	}

	@ActionMapping("select")
	public void selectPersonne(@RequestParam("idPersonne") int idPersonne,
			ActionResponse response) {
		response.setEvent("idPersonne", idPersonne);
		response.setRenderParameter("action", "list");
	}

	@SuppressWarnings("unchecked") // Quick fix, i need to know what's wrong
	private void deletePersonneFromModel(int idPersonne, PortletSession session) {
		// It's amazing to look for it there... such far, i must mistake but
		// cannot see where... nothing work... (modelattribute, map at argument,
		// ...)... ??? where is my wrong ???
		List<Personne> listePersonnes = (List<Personne>) ((Map<String, Object>) session
				.getAttribute("org.springframework.web.portlet.mvc.annotation.AnnotationMethodHandlerAdapter.IMPLICIT_MODEL"))
				.get("listePersonnes");
		for (Personne personne : listePersonnes) {
			if (personne.getId() == idPersonne) {
				listePersonnes.remove(personne);
				break;
			}
		}
	}
}
