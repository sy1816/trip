<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="recommend.*"%>
<%
	String json;
	String id = request.getParameter("id");
	
	tourspotStasticDAO tsDAO = new tourspotStasticDAO();
	
	tourspotStasticVO ts = null;
	ts = tsDAO.tourSpotStastic(id);
	json = Converter.convertToJson(ts);
%>

<%=json %>
