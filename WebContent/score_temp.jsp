<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="recommend.*"%>
<%
	int gender = Integer.valueOf(request.getParameter("gender"));
	int age = Integer.valueOf(request.getParameter("age"));
	int nation = Integer.valueOf(request.getParameter("nation"));
	int job = Integer.valueOf(request.getParameter("job"));
	int with = Integer.valueOf(request.getParameter("with"));
	int purpose = Integer.valueOf(request.getParameter("purpose"));
	int month = Integer.valueOf(request.getParameter("month"));
	
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

</body>
</html>