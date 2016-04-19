<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${loc}" />
<fmt:message key="choose" var="ch" />
<%@ include file="header.jsp" %>
<div class="indent">
<p> ${ch}:<br>
</p><br>
  <form action="work/addappointment.do" name="myform" method="post">
        <select name="apptype">
               <c:forEach  var="app" items="${types}">
           <option>${app.displayName}</option>
                 </c:forEach>
        </select>                                     <br><br>
       <input type="text" name="description" > <br><br>
       <input type="hidden" name="id_kart"  value="${id_kart}"> <br><br>
       <input type="hidden" name="id_pers"  value="${id_person}"> <br><br>
       <input name="Submit" type=submit value="  ok  ">
        <input type="button" onclick="history.go(-1);" value="  cancel  ">
  </form>
</div>
<%@ include file="footer.jsp" %>


