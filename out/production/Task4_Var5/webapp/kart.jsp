<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${loc}" />
<fmt:message key="add.app" var="aa" />
<fmt:message key="ending" var="en" />
<fmt:message key="number" var="n" />
<fmt:message key="type" var="t" />
<fmt:message key="description" var="d" />
<fmt:message key="exec" var="ex" />
<fmt:message key="execut" var="ext" />
<fmt:message key="prescribe" var="pr" />
<fmt:message key="logout" var="l" />
<html>
  <head>
  <meta charset="utf-8">
  <title>hospital</title>
</head>
<link href="/hospital/style.css" rel="stylesheet" type="text/css" />
<link href="/hospital/layout.css" rel="stylesheet" type="text/css" /> </head>
<body>

<div id="main">
    <div id="header">

            <div class="row_1">

                <div class="col_1">
                    <div class="indent"><a href="http://localhost/hospital/work/login.do"><img alt="" src="/hospital/images/logo.gif" /></a>  </div>
                </div>

                <div class="col_2">
                        <div class="indent">
                         <p ><a href="/hospital/work/logout.do">${l}</a> </p>
                         <a href="work/en.do">en</a> <a href="work/ru.do">rus</a> <br>
                            <c:out value="${user.r}" /> <br>
			            </div>
                </div>

            </div>



            <div class="row_2">

                <div class="col_1">
                 <c:out  value="${per}" />
                  Adress: <c:out  value="${per.adress} " />
                  phone: <c:out  value="${per.phone} " />

                  <br><br>

                <c:if test="${user.r =='DOCTOR'}">
 			        <a href="/hospital/work/appointment.jsp?id_kart=${kart.id}&id_person=${per.id}"> ${aa} </a>
 			    </c:if>

                    <br><br>

                <form action="work/updatediagnos.do" method="post">
                    <textarea rows="7" cols="35" name="diagnosa">
                                <c:out  value="${diagn.ishodniy}" />
                    </textarea>    <p>
                    <input name="Submit" type=submit value="  ok  ">
                    <input type="hidden" name="id_pers"  value="${per.id}"> <br><br>
                    <input type="hidden" name="id_diagn"  value="${diagn.id}"> <br><br>
                </form>


                      <table border="2" bgcolor="white">
                         <th> ${n} </th> <th> ${t} </th> <th> ${d} </th> <th> ${ext} </th> <th>  </th>
                                <c:forEach  var="ap" items="${kart.appointments}" >
                                     <tr> <td> ${ap.id} </td>
                                          <td> ${ap.type.displayName} </td>
                                          <td> ${ap.opisanie}</td>
                                          <td> ${ap.status ? '<img alt="" src="/hospital/images/true.jpg" />':'<img alt="" src="/hospital/images/false.jpg" />'} </td>
                                          <td> <a href="/hospital/work/exec.do?id_app=${ap.id}&id_person=${per.id}"> ${ex} </a> </td>
                                     </tr>
                                </c:forEach>
                      </table>

                               <br>
                                 <c:choose>
                                      <c:when test="${kart.vypiska}"> <h2> ${pr}</h2> </c:when>
                                      <c:otherwise> <c:if test="${user.r =='DOCTOR'}">
                                                    <a href="/hospital/work/diagnos.jsp?id_diagn=${diagn.id}&id_person=${per.id}">  ${en} </a>
                                                    </c:if>
                                      </c:otherwise>
                                 </c:choose>
                </div>
                <div class="col_3">
                				<img alt="" src="/hospital/images/header_img2.jpg" /><br /> <br>
                				<img alt="" src="/hospital/images/header_img2-02.jpg" /><br /> <br>
                				<img alt="" src="/hospital/images/header_img4.jpg" /><br /> <br>
                </div>
                 &#9;
                 <div class="col_3">
                   				<img alt="" src="/hospital/images/нов.jpg" /><br /> <br>
                   				<img alt="" src="/hospital/images/нов4.jpg" /><br /> <br>
                 				<img alt="" src="/hospital/images/нов2.jpg" /><br /> <br>
                 </div>

                <div class="clear"></div>
            </div>
    </div>
</div>  
</body>
</html>

   