<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${loc}" />
<fmt:message key="diag" var="d" />
<%@ include file="header.jsp" %>
<div class="indent">

    <p> ${d}:<br> </p><br>
      <form action="work/enddiagnos.do" name="myform" method="post">
           <textarea rows="8" cols="22" name="exitdiagnos">
           </textarea>
           <input type="hidden" name="id_diagn"  value="${id_diagn}"> <br><br>
           <input type="hidden" name="id_person"  value="${id_person}"> <br><br>
           <input name="Submit" type=submit value="  ok  ">
            <input type="button" onclick="history.go(-1);" value="  cancel  ">
            <br><br>

       </form>
</div>
<%@ include file="footer.jsp" %>


