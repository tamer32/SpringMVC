<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="ErrorPage.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<tf:layout>
	<h2>Hello World!</h2>
	<form:form action="createUser" modelAttribute="playerInfo" method = "POST">
		
		Enter your name Hero:<form:input path="username" />
		  
		<form:errors path="username"/>
		<br/>
		Choose your class:
		<form:radiobutton path="playerClass" value="Warrior" /> Warrior
		<form:radiobutton path="playerClass"  value="Bowman"/> Bowman
		<form:radiobutton path="playerClass"  value="Rogue"/> Rogue
		<form:radiobutton path="playerClass"  value="Sorcerer"/> Sorcerer<br>
		<form:errors path="playerClass"/>
		<input type="submit" value="Click and watch the magic...">
	</form:form>
</tf:layout>