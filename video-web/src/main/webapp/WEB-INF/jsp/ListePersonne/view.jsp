<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<div class="portlet-section-header">Liste des personnes</div>

<div class="portlet-font">
	<table>
		<tr class="portlet-table-header">
			<td>Nom</td>
			<td>Prénom</td>
		</tr>
		<%
		boolean unSurDeux = false;
		for() { 
		%>
		<tr
			class="<%unSurDeux?%>portlet-table-body<%:%>portlet-table-alternate"
			onmouseover="class:portlet-table-selected">
			<td></td>
		</tr>
		<%} %>
	</table>
</div>
