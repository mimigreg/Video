package fr.michot.video.ihm.portlet.listePersonne;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import fr.michot.video.business.services.impl.PersonneServiceImpl;
import fr.michot.video.db.Personne;

public class ListePersonnePortlet extends GenericPortlet {
	@Inject
	PersonneServiceImpl service;

	@Override
	protected void doView(RenderRequest rRequest, RenderResponse rResponse) throws PortletException, IOException {
		List<Personne> listePersonne = null;

		String filmId = (String) rRequest.getAttribute("filmId");
		String recherche = (String) rRequest.getAttribute("recherche");

		if (filmId != null) {
			listePersonne = service.rechercheParFilm(Integer.parseInt(filmId));
		} else {
			if (recherche != null) {
				listePersonne = service.recherche(recherche, null, null, null);
			}
		}

		if (listePersonne != null && !listePersonne.isEmpty()) {
			rRequest.setAttribute("listePersonne", listePersonne);
			rResponse.setContentType("text/html");
			PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/ListePersonne/view.jsp");
			prd.include(rRequest, rResponse);
		} else {
			rResponse.setContentType("text/html");
			PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/ListePersonne/viewEmpty.jsp");
			prd.include(rRequest, rResponse);
		}
	}

	@Override
	protected void doEdit(RenderRequest rRequest, RenderResponse rResponse) throws PortletException, IOException {
		rResponse.setContentType("text/html");
		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/ListePersonne/edit.jsp");
		prd.include(rRequest, rResponse);
	}

	@Override
	protected void doHelp(RenderRequest rRequest, RenderResponse rResponse) throws PortletException, IOException {
		rResponse.setContentType("text/html");
		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/ListePersonne/help.jsp");
		prd.include(rRequest, rResponse);
	}

	@RenderMode(name = "config")
	protected void doConfig(RenderRequest rRequest, RenderResponse rResponse) throws PortletException, IOException {
		rResponse.setContentType("text/html");
		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/ListePersonne/edit.jsp");
		prd.include(rRequest, rResponse);
	}

	@ProcessAction(name = "search")
	public void processActionSearch(ActionRequest aRequest, ActionResponse aResponse) throws PortletException, IOException {
		String personneId = (String) aRequest.getParameter("personneId");
		aResponse.setRenderParameter("personneId", personneId);
	}

	@ProcessAction(name = "save")
	public void processActionSave(ActionRequest aRequest, ActionResponse aResponse) throws PortletException, IOException {
		String personneId = (String) aRequest.getParameter("personneId");
		aResponse.setRenderParameter("personneId", personneId);
	}

	@ProcessEvent(name = "personneId")
	public void processEventPersonneId(EventRequest eRequest, EventResponse eResponse) throws PortletException, IOException {
		String personneId = (String) eRequest.getEvent().getValue();
		eRequest.setAttribute("personneId", personneId);
		eResponse.setRenderParameter("personneId", personneId);
	}

}
