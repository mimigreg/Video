<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<div class="portlet-section-header">Personne de sélectionné</div>
<div class="portlet-font">
<portlet:actionURL var="myActionURL"/>
<form action="<%= myActionURL %>" method="POST">
         <span class="portlet-form-field-label">Nouvelle personne</span>
         <input type="hidden" name="action" value="add"/>
         <input class="portlet-form-button" type="Submit"/>
</form>
</div>

