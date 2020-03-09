<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>ARTISTS</title>
	<link rel="stylesheet" href="/styles/list.css">
</head>

<body>
	<div class="container"><h3>ARTISTS</h3>
	<form id="add-new-form" method="post">
    <input id="new-artist-namee" name="Name" required type="text" placeholder=" type artist here..." autofocus /> 
    <input type="submit" id="add-new-artist" value="Add to list" />
</form>
	<ul>
			<li>#&nbsp;&nbsp;NAME&nbsp;(click to see albums)</li>
	</ul>
	<ul><c:forEach items="${allArtists}" var="art">
			<li><a class="artist" href="album?id=${art.artistId}&name=${art.name}"><c:out value="${art.artistId}"/>&nbsp;<c:out value="${art.name}"/></a><a class="delete" href="ChinookDeleteServlet?id=${art.artistId}"> X </a></li>
		</c:forEach>
	</ul>
	</div>
</body>
</html>
