<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.info" /></title>
</head>
<body>
	<p><spring:message  code="id"/> : ${member.id }</p>
	<p><spring:message code="email" /> : ${member.email }</p>
	<P><spring:message code="name" /> : ${member.name }</P>
	<P><spring:message code="registeDate"/> : <tf:formatDateTime value="${member.registerDateTime}" pattern="yyyy-MM-dd HH:mm"/></P>
</body>
</html>