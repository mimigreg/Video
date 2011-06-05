<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />
<portlet:actionURL var="myActionURL" />

<div class="portlet-section-header">Liste des personnes</div>

<div class="portlet-font">
	<table>
		<tr class="portlet-table-header">
			<td>Nom</td>
			<td>Prénom</td>
		</tr>
		<c:forEach items="${listePersonnes}" var="personne">
		<%
		boolean unSurDeux = false;
			String styleLigne = unSurDeux?"portlet-table-body":"portlet-table-alternate";
			unSurDeux=!unSurDeux;
		%>
		<tr class="<%=styleLigne%>" onmouseover="class:portlet-table-selected">
			<td>${personne.nom} ${personne.prenom}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="portlet-font">
		<form:form  action="<%=myActionURL%>" method="POST" modelAttribute="recherchePersonneFormBean">
			Rechercher par nom : <input type="hidden" name="action" value="search" />
			<span class="portlet-form-field-label">Recherche avancée : Oui</span>
				<form:radiobutton class="portlet-form-input-field" path="rechercheAvancee" value="true" />
			<span class="portlet-form-field-label">Non</span>
				<form:radiobutton class="portlet-form-input-field" path="rechercheAvancee" value="false" />
			<br/>
			<span class="portlet-form-field-label">Nom :</span>
				<form:input class="portlet-form-input-field" path="nom" />
			<br/>
			<span class="portlet-form-field-label">prenom :</span>
				<form:input class="portlet-form-input-field" path="prenom" />
			<br/>	
			<span class="portlet-form-field-label">Sexe : Homme</span>
				<form:radiobutton class="portlet-form-input-field" path="homme" value="true" />
			<span class="portlet-form-field-label">Femme</span>
				<form:radiobutton class="portlet-form-input-field" path="homme" value="false" />
			<br/>
			<span class="portlet-form-field-label">Visibilité : Privé</span>
				<form:radiobutton class="portlet-form-input-field" path="prive" value="true" />
			<span class="portlet-form-field-label">Publique</span>
				<form:radiobutton class="portlet-form-input-field" path="prive" value="false" />
			<br/>
			<input class="portlet-form-button" type="Submit" />
		</form:form>
	</div>
	
</div>
