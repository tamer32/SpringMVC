<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tf"%>
<tf:layout>
	<h2>Register</h2>
	<form action="createUser" method="POST" id="registrationForm">
		Username <input type="text" id="username"><br /> Age <input
			type="text" id="age"><br /> Address <input type="text"
			id="address"><br /> ZipCode <input type="text" id="zipCode"><br />
	</form>
	<input type="button" onclick="sendData()">
	<script>
		function sendData() {
			console.log($("#username").val());
			let object = {"username" : $("#username").val(),
					'age':$("#age").val(),
					'address': $("#address").val(),
					'zipCode': $("#zipCode").val()};
			$.ajax({
				type : "post",
				url : window.location.href + "createUser",
				contentType: "application/json",
				dataType: "json",
				data : JSON.stringify(object),
				success : function(response) {
					window.location.replace(window.location.href + "UserPage");
				},
				error: function(response){
					alert("Something went wrong");
				}
			});
		}
	</script>
</tf:layout>