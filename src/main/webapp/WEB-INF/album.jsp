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
	<div class="container"><h3>ALBUMS BY ${ArtistName}</h3>
	<ul>
			<li>#&nbsp;&nbsp;ALBUM TITLE</li>
	</ul>
		<ul><c:forEach items="${allAlbums}" var="album">
		<li><c:out value="${album.albumId}"/>&nbsp;<c:out value="${album.title}"/></li>
		</c:forEach>
	</ul>
	<p><a class="artist" href="/music">Back to artists</a></p>
	</div>
</body>
</html>
