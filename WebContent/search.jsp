<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="recommend.*"%>
<%
	String json;
	
	searchDAO sDAO = new searchDAO();

	ArrayList<searchVO> search = new ArrayList<searchVO>();
	search = sDAO.searchList();
	json = Converter.convertToJson(search);

%>

<%=json %>
