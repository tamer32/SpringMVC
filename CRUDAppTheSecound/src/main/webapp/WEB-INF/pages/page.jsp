<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tf"%>
<%@page import="com.third.iter.services.UserManagmentServiceImpl"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.third.iter.entities.heroes.PlayerInfo"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tf:layout>

	<table frame="below">
		<form:form action="fightPage" modelAttribute="playerInfo" method = "GET">
		<tr>
			<td>${playerInfo.username}</td>
			<td>${playerInfo.playerClass}</td>
			<td><input type="submit" value="Let's Fight!"></td>
		</tr>
		</form:form>
		
	</table>
</tf:layout>