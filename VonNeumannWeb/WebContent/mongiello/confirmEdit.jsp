<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="it.beije.neumann.web.mongiello.Contatto"%>
<%@page import="it.beije.neumann.web.mongiello.RubricaJPA"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="contattoToEdit" class="it.beije.neumann.web.mongiello.Contatto" scope="session"></jsp:useBean>
	IDtoEdit - <jsp:getProperty property="id" name="contattoToEdit"/><br>
	NometoEdit - <jsp:getProperty property="name" name="contattoToEdit"/><br>
	CognometoEdit - <jsp:getProperty property="surname" name="contattoToEdit"/><br>



</body>
</html>