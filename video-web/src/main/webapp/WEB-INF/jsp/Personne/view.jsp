<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<portlet:defineObjects />

<portlet:actionURL var="switchURL" name="switchMode"/>
<portlet:actionURL var="saveURL" name="save"/>
<portlet:actionURL var="newURL" name="newPersonne"/>

<form:form action="${switchURL}" method="POST" modelAttribute="personne">
	<form:hidden path="editMode" />
	<form:hidden path="id" />
	<div class="portlet-section-header">
		${personne.prenom} ${personne.nom}
		<div class="portlet-form-field-label">
			Nom :
			<form:input class="portlet-form-input-field" path="nom"
				disabled="${!personne.editMode}" />
		</div>
		<div class="portlet-form-field-label">
			prenom :
			<form:input class="portlet-form-input-field" path="prenom"
				disabled="${!personne.editMode}" />
		</div>
	</div>
	<div class="portlet-font">
		<div class="portlet-form-field-label">
			Homme
			<form:radiobutton class="portlet-form-input-field" path="homme"
				value="true" disabled="${!personne.editMode}" />
			Femme
			<form:radiobutton class="portlet-form-input-field" path="homme"
				value="false" disabled="${!personne.editMode}" />
			<br />
		</div>
		<c:choose>
			<c:when test="${personne.homme}">Homme</c:when>
			<c:when test="${!personne.homme}">Femme</c:when>
		</c:choose>
	</div>
	<div class="portlet-font">
		<div class="portlet-form-field-label">
			Privé
			<form:radiobutton class="portlet-form-input-field" path="prive"
				value="true" disabled="${!personne.editMode}" />
			Publique
			<form:radiobutton class="portlet-form-input-field" path="prive"
				value="false" disabled="${!personne.editMode}" />
			<br />
		</div>
		<c:choose>
			<c:when test="${personne.prive}">Privé</c:when>
			<c:when test="${!personne.prive}">Publique</c:when>
		</c:choose>
	</div>

	<div class="portlet-font">
		<img src="${personne.photoUrl}" alt="Photo" id="personnePhoto" />
		<div class="portlet-form-field-label">
			URL :
			<form:input class="portlet-form-input-field" path="photoUrl"
				disabled="${!personne.editMode}" />
		</div>
	</div>
	<div class="portlet-font">
		<form:textarea path="annotations" cols="50" rows="20"
			disabled="${!personne.editMode}" />
	</div>
	<div class="portlet-font">
	<c:if test="${!personne.editMode&&personne.id>=0}"><input class="portlet-form-button" type="Button" value="Modifier" onclick="form.action='${switchURL}';form.submit();"/></c:if>
	<c:if test="${personne.editMode}"><input class="portlet-form-button" type="Button" value="Enregistrer" onclick="form.action='${saveURL}';form.submit();"/></c:if>
	<c:if test="${!personne.editMode}"><input class="portlet-form-button" type="Button" value="Nouveau" onclick="form.action='${newURL}';form.submit();"/></c:if>
	</div>
</form:form>
