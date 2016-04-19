<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${loc}" />
<fmt:message key="found" var="f" />
<%@ include file="header.jsp" %>

				<div class="indent">
				        ${f} <br>
						<c:forEach var="person" items="${SNP}" >
						<p style="color:red"><a href="/hospital/work/kart.jsp?id=${person.id}">${person}</a></p>  <br>
						</c:forEach> <br><br><br><br><br><br><br><br><br>
				</div>

<%@ include file="footer.jsp" %>

