<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<portlet:defineObjects />

<div class="portlet-section-header">Liste des personnes</div>

<div class="portlet-font">
	<table>
		<tr class="portlet-table-header">
			<td>Nom</td>
			<td>Prénom</td>
			<td>X</td>
		</tr>
		<%boolean unSurDeux = true; %>
		<c:if test="${listePersonnes!=null}">
			<c:forEach items="${listePersonnes}" var="personne">
				<%
					String styleLigne = unSurDeux?"portlet-table-body":"portlet-table-alternate";
					unSurDeux=!unSurDeux;
				%>
				<tr class="<%=styleLigne%>" onmouseover="this.className='portlet-table-selected'" onmouseout="this.className='<%=styleLigne%>'" onclick="document.location.href='<portlet:actionURL name='select'><portlet:param name='idPersonne' value='${personne.id}'/></portlet:actionURL>'">
					<td>${personne.nom}</td><td>${personne.prenom}</td><td><a href="<portlet:actionURL name='delete'><portlet:param name='idPersonne' value='${personne.id}'/></portlet:actionURL>">X</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="portlet-font">
		<portlet:actionURL var="searchURL" name="search"/>
		<form:form  action="${searchURL}" method="POST" modelAttribute="recherchePersonneFormBean">
			Rechercher : 
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
