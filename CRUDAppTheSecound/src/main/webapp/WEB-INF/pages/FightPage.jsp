<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tf:layout>
	<h1>Prepare to fight!</h1>
	<h2>
		<table frame="below">
			<tr>
				<td>${monster.name}</td>
			</tr>
		</table>
	</h2>
	<h3>
		<table frame="below">
			<form:form action="rollTheDice" modelAttribute="monster" method="GET">
				<tr>
					<c:forEach items="${monster.stats}" var="monsterStats"
						varStatus="status">
						<td>${monsterStats.key}</td>
						<td>${monsterStats.value}</td>
					</c:forEach>
				</tr>
				<td><input type="submit" value="Roll the dice!"></td>
			</form:form>
		</table>	
</tf:layout>