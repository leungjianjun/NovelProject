<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.2-min.js"/>" ></script>
    <title>Chapter</title>
</head>
<body>
<p class="test" id="test">Yes</p>
<p><c:out value="${chapter.title}" /></p>
<p>${chapter.title}</p>
<p>${chapter.updateTime4Display()}</p>
<p>${chapter.content}</p>
</body>
</html>