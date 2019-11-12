<%@ tag import="java.util.Date, java.text.DateFormat"%>
<%@ tag import= "java.util.Random" %>
<%@ attribute name="layout"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
</head>
<body>
	<%!
  Random rand = new Random();
  int randomNumber = rand.nextInt(300); 
  %>
  
  <%= "Random number with JSTL tag file " + randomNumber %>
  <jsp:doBody/>
</body>
</html>