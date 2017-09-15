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
	String json;
	
	recommendDAO rDAO = new recommendDAO();

	ArrayList<tourVO> tour = new ArrayList<tourVO>();
	tour = rDAO.recommendService(gender, age, nation, job, with, purpose, month);
	json = Converter.convertToJson(tour);
%>

<%=json %>
