<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${loc}" />
<fmt:message key="find.men" var="f" />
<fmt:message key="surname" var="s" />
<fmt:message key="name" var="n" />
<fmt:message key="patronymic" var="p" />
<fmt:message key="add.patient" var="ap" />
				<div class="indent">
					  <form action="work/find.do" name="myform" method="get">
						${f} <br><br>
						 ${s}<br>
						   <input type="text" name="surname" size="30"> <br>
						 ${n} <br>
						   <input type="text" name="name" size="30"> <br>
						 ${p} <br>
						   <input type="text" name="patronomyc" size="30"> <br>
						<br>			
												
   						   <input name="Submit" type=submit value="  ok  "  >


						    <br><br>

						<a href="/hospital/work/patients.jsp"> ${ap}  </a> <br><br><br>


						</form>

				</div>

<%@ include file="footer.jsp" %>
