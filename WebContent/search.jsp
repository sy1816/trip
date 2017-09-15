<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="recommend.*"%>
<%
	String json;
	String data = request.getParameter("id");
	
	searchDAO sDAO = new searchDAO();
	
	if(data == null){
		ArrayList<searchVO> search = null;
		search = sDAO.searchList();
		json = Converter.convertToJson(search);
	} else{
		searchVO search = null;
		search = sDAO.tourSpotInfo(data);
		System.out.println(search.getImage_url1());
		json = Converter.convertToJson(search);
	}

%>

<%=json %>
