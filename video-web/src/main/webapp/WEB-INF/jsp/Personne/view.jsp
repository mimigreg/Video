<%@ page import="fr.michot.video.db.*;"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<portlet:defineObjects />

<%Personne personne = (Personne)renderRequest.getAttribute("personne") ;%>

<div class="portlet-section-header"><%=personne.getPrenom()%>
	<%=personne.getNom()%></div>

<br />

<div class="portlet-font">
	<%=personne.isHomme()?"Homme":"Femme" %>
</div>

<div class="portlet-font">
	<img src="<%=personne.getPhotoUrl() %>" alt="Photo" id="personnePhoto" />
</div>

<div class="portlet-font">
	<jsp:getProperty property='annotations' name='personne' />
</div>
