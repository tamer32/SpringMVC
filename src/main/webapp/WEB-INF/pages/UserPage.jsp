<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<tf:layout>
	<body>
		<h1>Hello</h1>
		<form:form action="deleteUser" model ="user" method="delete" id="deleteForm"></form:form>
		<table>
			<c:forEach  items = "${users}" var = "user">
				<tr>
					<td>${user.id}</td>
					<td> ${user.username}</td>
					<td> ${user.age}</td>
					<td> ${user.address.address}</td>
					<td> ${user.address.zipCode}</td>
					<td><button type = "submit" value="${user}" form ="deleteForm">delete</button></td> 	
				</tr>
			</c:forEach>	
		</table>
	<!-- 	<script>
			function fetchData() {
				let table = document.getElementById("users");
				$
						.ajax({
							type : "get",
							url : window.location.origin
									+ "/HibernateCrud/viewUsers",
							contentType : "application/json",
							dataType : "json",
							success : function(response) {
								for ( var i in response) {
									let row = table.insertRow(i);
									row.insertCell(0).innerHTML = response[i].id;
									row.insertCell(1).innerHTML = response[i].username;
									row.insertCell(2).innerHTML = response[i].age;
									row.insertCell(3).innerHTML = response[i].address.address;
									row.insertCell(4).innerHTML = response[i].address.zipCode;
									row.insertCell(5).innerHTML = "<button type = button id='deleteButton' onclick = deleteUser() value =" + response[i].id + " > Delete User </button>";
								}
							},
							error : function(response) {
								alert("Something went wrong");
							}
						});
			}
			function deleteUser(){
				let object = {"id" : $("#deleteButton").val()};
				$.ajax({
					type :"delete",
					url : window.location.origin
					+ "/HibernateCrud/deleteUser",
					data:object,
					contentType : "application/json",
					dataType : "json",
					success : function(response) {
						alert("Ok it happened");
					},
					error: function (response){
						alert("Something went wrong");
					}
				});
			}
		</script> -->
	</body>
</tf:layout>
