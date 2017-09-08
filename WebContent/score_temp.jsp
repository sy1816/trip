<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="recommend.*"%>
<%
	String gender = request.getParameter("gender");
	String age = request.getParameter("age");
	String nation = request.getParameter("nation");
	String job = request.getParameter("job");
	String with = request.getParameter("with");
	String purpose = request.getParameter("purpose");
	String month = request.getParameter("month");
	
	recommendDAO rDAO = new recommendDAO();

	ArrayList<tourVO> tour = new ArrayList<tourVO>();
	tour = rDAO.recommendService(gender, age, nation, job, with, purpose, month);
	
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>TGF - Tour Guide For</title>
</head>
<body>
<%=tour %>
<%=gender %>
</body>
</html>