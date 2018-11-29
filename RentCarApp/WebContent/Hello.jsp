
<%@page import="fr.upem.manage.Review"%>
<%@page import="fr.upem.manage.Vehicle"%>
<%@page import="fr.upem.manage.Main"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- UIkit CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.24/css/uikit.min.css" />

<!-- UIkit JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.24/js/uikit.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.24/js/uikit-icons.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" href="../css/buypage.css" type="text/css" />
<title>Hello</title>
</head>
<body>
	<div class=liste>
		<%-- <%
			for (int i = 0; i < depo.vehicle; i += 1) {
		%>
		<tr>
			<td>${allFestivals.get(i).getFestivalName()}</td>
			<td>${allFestivals.get(i).getLocation()}</td>
			<td>${allFestivals.get(i).getStartDate()}</td>
			<td>${allFestivals.get(i).getEndDate()}</td>
			<td>${allFestivals.get(i).getURL()}</td>
		</tr>
		<%
			}
		%> --%>
		<div class="uk-card uk-card-default uk-card-hover uk-card-body">
			<div class="uk-card-badge-loue uk-card-badge uk-label">Louee</div>
			<h3 class="uk-card-title"><%=new Vehicle(10, "model", "brand", 0, 16500, 300, 23)%></h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
			<button class="uk-button-reviews uk-button uk-button-primary">Reviews</button>
		</div>

		<div class="uk-card uk-card-default uk-card-hover uk-card-body">
			<div class="uk-card-badge-buy uk-card-badge uk-label">Achetee</div>
			<h3 class="uk-card-title"><%=new Date()%></h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
			<button class="uk-button-reviews uk-button uk-button-primary">Reviews</button>
		</div>

		<div class="uk-card uk-card-default uk-card-hover uk-card-body">
			<div class="uk-card-badge-dispo uk-card-badge uk-label">Disponible</div>
			<h3 class="uk-card-title"><%=new Date()%></h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
			<button class="uk-button-reviews uk-button uk-button-primary">Reviews</button>
		</div>

	</div>
	<div class="reviews">
		<article class="uk-comment uk-comment-primary"> <header
			class="uk-comment-header uk-grid-medium uk-flex-middle" uk-grid>
		<div class="uk-width-auto"></div>
		<div class="uk-width-expand">
			<h4 class="uk-comment-title uk-margin-remove">
				<a class="uk-link-reset" href="#">Author</a>
			</h4>
			<ul
				class="uk-comment-meta uk-subnav uk-subnav-divider uk-margin-remove-top">
				<span uk-icon="star"></span>
				<span uk-icon="star"></span>
				<span uk-icon="star"></span>
				<li><a href="#">Reply</a></li>
			</ul>
		</div>
		</header>
		<div class="uk-comment-body">
			<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed
				diam nonumy eirmod tempor invidunt ut labore et dolore magna
				aliquyam erat, sed diam voluptua. At vero eos et accusam et justo
				duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata
				sanctus est Lorem ipsum dolor sit amet.</p>
		</div>
	</div>

	</article>
</body>
</html>