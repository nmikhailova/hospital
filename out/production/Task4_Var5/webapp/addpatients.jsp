<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${loc}" />
<fmt:message key="surname" var="s" />
<fmt:message key="name" var="n" />
<fmt:message key="patronymic" var="p" />
<fmt:message key="adress" var="a" />
<fmt:message key="dob" var="d" />
<fmt:message key="phone" var="ph" />
<fmt:message key="diagnos" var="ds" />

<%@ include file="header.jsp" %>
				<div class="indent">
					  <form action="work/addpatient.do" name="myform" method="get">
						 ${s}<br>
						   <input type="text" name="surname" size="30"> <br>
						 ${n} <br>
						   <input type="text" name="name" size="30"> <br>
						 ${p} <br>
						   <input type="text" name="patronomyc" size="30"> <br>
						 ${a} <br>
                           <input type="text" name="adress" size="30"> <br>
                         ${d} <br>
                         <input type="text" name="date" size="30"> <br>
                         ${ph} <br>
                         <input type="text" name="phone" size="30"> <br>
                          <c:if test="${user.r =='DOCTOR'}">
                          ${ds}
                         <input type="text" name="diagnosa" size="30"> <br>
                            </c:if>
                         <br>
   						 <input name="Submit" type=submit value="  ok  "  >

                         <input type="button" onclick="history.go(-1);" value="  cancel  ">
                        <br>

					  </form>

				</div>

<%@ include file="footer.jsp" %>
