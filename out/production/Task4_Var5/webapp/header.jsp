<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${loc}" />
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
				<div class="indent"><a href="#"><img alt="" src="/hospital/images/logo.gif" /></a></div>
			</div>
			<div class="col_2">
				<div class="indent"><c:out value="${user.login}" />
		                    		<p ><a href="/hospital/work/logout.do">${l}</a> </p>
		                    		<a href="work/en.do">en</a> <a href="work/ru.do">rus</a>
                </div>
			</div>

		</div>
		<div class="row_2">
			<div class="col_1"><img alt="" src="/hospital/images/header_img1.jpg" /></div>
			<div class="col_2">