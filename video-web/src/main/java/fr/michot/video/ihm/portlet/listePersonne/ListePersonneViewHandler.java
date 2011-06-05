package fr.michot.video.ihm.portlet.listePersonne;

import java.util.List;

import javax.inject.Inject;
import javax.portlet.ActionResponse;
import javax.validation.Valid;

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
 
	RecherchePersonneFormBean recherchePersonneFormBean = null;
	
	private List<Personne> listePersonnes = null;

	public void setListePersonnes(List<Personne> listePersonnes) {
		this.listePersonnes = listePersonnes;
	}

	@ModelAttribute("listePersonnes")
	public List<Personne> getListePersonnes() {
		return this.listePersonnes;
	}

	@RequestMapping
	// default (action=list)
	public String showListePersonne(Model model) {
		if(recherchePersonneFormBean==null) {
			recherchePersonneFormBean = new RecherchePersonneFormBean();
		}
		model.addAttribute("recherchePersonneFormBean", recherchePersonneFormBean);
		if (listePersonnes != null && !listePersonnes.isEmpty()) {
			model.addAttribute("listePersonne", listePersonnes);
			return "/view";
		} else {
			return "/viewEmpty";
		}
	}

	@RequestMapping(params = "action=search")
	public void populatePersonne(@ModelAttribute("recherchePersonneFormBean") @Valid RecherchePersonneFormBean recherchePersonneFormBean,BindingResult result, SessionStatus status, ActionResponse response) {
		System.out.println(result.hasErrors());
		System.out.println(recherchePersonneFormBean);
		
		
		if(recherchePersonneFormBean.isRechercheAvancee()) {
			listePersonnes = service.recherche(recherchePersonneFormBean.getNom(), recherchePersonneFormBean.getPrenom(), recherchePersonneFormBean.getHomme(), recherchePersonneFormBean.getPrive());
		} else {
			// TODO coder une recherche champs libre
			listePersonnes = service.recherche(recherchePersonneFormBean.getNom(), recherchePersonneFormBean.getPrenom(), recherchePersonneFormBean.getHomme(), recherchePersonneFormBean.getPrive());
		}
		
		status.setComplete();
		response.setRenderParameter("action", "list");
	}

	@RequestMapping(params = "action=delete")
	public void removePersonne(@RequestParam("idPersonne") int idPersonne, ActionResponse response) {
		service.efface(idPersonne);
		this.listePersonnes.remove(idPersonne);
		response.setRenderParameter("action", "list");
	}
	
	@RequestMapping(params = "action=select")
	public void selectPersonne(@RequestParam("idPersonne") int idPersonne, ActionResponse response) {
		response.setEvent("idPersonne", idPersonne);		
		response.setRenderParameter("action", "list");
	}

}
