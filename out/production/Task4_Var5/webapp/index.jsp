<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${loc}" />
<fmt:message key="welcome" var="hello" />
<fmt:message key="login" var="l" />
<fmt:message key="pass" var="p" />

<html>
  <head>
  <meta charset="utf-8">
  <title>Little Hospital</title>
<link href="/hospital/style.css" rel="stylesheet" type="text/css" />

<link href="/hospital/layout.css" rel="stylesheet" type="text/css" /> </head>
 <body>

<div id="main">
<div id="header">

		<div class="row_1">
			<div class="col_1">
				<div class="indent"><a href="#"><img alt="" src="/hospital/images/logo.gif" /></a></div>
			</div>
			<div class="col_2">
				<div class="indent">${hello}<br>  <a href="work/en.do">en</a> <a href="work/ru.do">rus</a></div>
            </div>
		</div>

		<div class="row_2">
			<div class="col_1"><img alt="" src="/hospital/images/header_img1.jpg" /></div>
			<div class="col_2">
				<div class="indent">
					<br>
					<form action="work/login.do" name="myform" method="post"> <br><br>
					    ${l} <br> <input type="text" name="login"> <br><br>
					    ${p} <br> <input type="password" name="pass"> <br>
					<br>
					    <input type="submit" value=" ok "><br>
					    <br>
					   <H2> <p style="color:red">
                        ${param.errormessage}
                        </p> </H2>
                        <br> <br>
					</form>
				</div>
			</div>
			<div class="col_3">
				<img alt="" src="/hospital/images/header_img2.jpg" /><br />
				<img alt="" src="/hospital/images/header_img3.jpg" /><br />
				<img alt="" src="/hospital/images/header_img4.jpg" /><br />
		    </div>
			<div class="clear"></div>
		</div>
	</div>
</div>
</body>
</html>

