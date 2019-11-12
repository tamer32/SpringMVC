<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<tf:layout>
	<table>
		<tr>
			<td>Graceful Dice: ${gracefulDice}</td>
		</tr>
		<tr>
			<td>Skull Dice: ${skullDice}</td>
		</tr>
	</table>
	</h3>
	<c:choose>
		<c:when test="${battleResult == null}">
		</c:when>
		<c:when test="${battleResult < 0}">
			<p>Congratulations on your victory!</p>
			<form:form action="fightPage" modelAttribute="playerInfo"
				method="GET">
				<input type="submit" value="Fight again!">
				</form:form>
				<form:form action="createUser" modelAttribute="playerInfo"
					method="POST">
					<input type="submit" id = "fleeButton" value="or stop here?">		
			</form:form>
		</c:when>
		<c:when test="${battleResult == 0}">
			<p>You almost defeat the vile beast, but with it's last drop of
				luck managed to escape!</p>
			<form:form action="fightPage" modelAttribute="playerInfo"
				method="GET">
				<input type="submit" value="Fight again!">
					</form:form>
				<form:form action="createUser" modelAttribute="playerInfo"
					method="POST">
					<input type="submit" id = "fleeButton" value="or stop here?">		
			</form:form>
		</c:when>
		<c:when test="${battleResult > 0}">
			<p>
				This time the fate wasn't on your side and you lost to the beast and
				your hero died miserably.Create a new
				character and go avenge your fallen hero!
				<form:form action="deletePage" modelAttribute="playerInfo"
					method="GET">
					<input type="submit" value="Inherit Legacy">
				</form:form>
		</c:when>
	</c:choose>
</tf:layout>