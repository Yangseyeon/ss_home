<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Member memeber = (Member) session.getAttribute("member");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="">
<meta name="author" content="">

<title>Topic Listing Bootstrap 5 Template</title>

<!-- CSS FILES -->
<link rel="preconnect" href="https://fonts.googleapis.com">

<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500;600;700&family=Open+Sans&display=swap"
	rel="stylesheet">

<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="css/bootstrap-icons.css" rel="stylesheet">

<link href="css/templatemo-topic-listing.css" rel="stylesheet">
<link rel="stylesheet" href="./css/login.css">
<!--

TemplateMo 590 topic listing

https://templatemo.com/tm-590-topic-listing

-->
</head>

<body id="top">

	<section>

		<nav class="navbar navbar-expand-lg bg-gray"
			style="background-color: #89D9CA;">
			<div class="container">
				<a class="navbar-brand" href="index.html"> <i class="bi-back"></i>
					<span>HOME!</span>
				</a>

				<div class="d-lg-none ms-auto me-4">
					<a href="#top" class="navbar-icon bi-person smoothscroll"></a>
				</div>

				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ms-lg-5 me-lg-auto">
						<li class="nav-item"><a class="nav-link click-scroll"
							href="./index.html">Home</a></li>

						<li class="nav-item"><a class="nav-link click-scroll"
							href="#">Announcement</a></li>

						<li class="nav-item"><a class="nav-link click-scroll"
							href="aptfilter.html">Apt</a></li>

						<li class="nav-item"><a class="nav-link click-scroll"
							href="#">Interest</a></li>
					</ul>

					<div class="d-none d-lg-block">
						<a href="./login.html" class="navbar-icon bi-person smoothscroll"></a>
					</div>
				</div>
			</div>
		</nav>

		<section
			class="hero-section2 d-flex justify-content-center align-items-center vh-50"
			id="section_1">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-10 col-lg-6 col-xl-5 ">
						<div class="card bg-dark text-white" style="border-radius: 1rem;">
							<div class="card-body p-5 ">

								<div class="mb-md-5 mt-md-4">

									<h2 class="text-center fw-bold text-white mb-2 text-uppercase">회원
										정보</h2>
									<p class="text-white-50 mb-5"></p>

									<form method="POST" action="${root}/member?action=modify">
										<div class="text-left form-outline form-white mb-4">
											<span class="text-start">이메일: </span> 
											<span class="text-start">${member.userId}</span>
											<input hidden type="email" name="email" class="text-start" value="${member.userId}"/>
										</div>

										<div class="text-left form-outline form-white mb-4">
											<span class="text-start">비밀번호: </span> 
											<input type="password" name="password" class="text-start" value="${member.userPassword}" required/>
										</div>

										<div class="text-left form-outline form-white mb-4">
											<span class="text-start">이름: </span> 
											<input type="text" name="name" class="text-start" value="${member.userName}" required/>
										</div>

										<div class="text-left form-outline form-white mb-4">
											<span class="text-start">주소</span> 
											<input type="text" name="address" class="text-start" value="${member.address}"/>
										</div>

										<div class="text-left form-outline form-white mb-4">
											<span class="text-start">전화번호</span> 
											<input type="text" name="phoneNumber" class="text-start" value="${member.phoneNumber}"/>
										</div>

										<div class="d-flex flex-column align-items-center">
											<button class="btn btn-outline-light btn-lg px-5 mb-3" type="submit">확인</button>
										</div>
									</form>

								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		</main>

		<footer class="site-footer section-padding">
			<div class="container">
				<div class="row">

					<div class="col-lg-3 col-12 mb-4 pb-2">
						<a class="navbar-brand mb-2" href="index.html"> <i
							class="bi-back"></i> <span>Topic</span>
						</a>
					</div>

					<div class="col-lg-3 col-md-4 col-6">
						<h6 class="site-footer-title mb-3">Resources</h6>

						<ul class="site-footer-links">
							<li class="site-footer-link-item"><a href="#"
								class="site-footer-link">Home</a></li>

							<li class="site-footer-link-item"><a href="#"
								class="site-footer-link">How it works</a></li>

							<li class="site-footer-link-item"><a href="#"
								class="site-footer-link">FAQs</a></li>

							<li class="site-footer-link-item"><a href="#"
								class="site-footer-link">Contact</a></li>
						</ul>
					</div>

					<div class="col-lg-3 col-md-4 col-6 mb-4 mb-lg-0">
						<h6 class="site-footer-title mb-3">Information</h6>

						<p class="text-white d-flex mb-1">
							<a href="tel: 305-240-9671" class="site-footer-link">
								305-240-9671 </a>
						</p>

						<p class="text-white d-flex">
							<a href="mailto:info@company.com" class="site-footer-link">
								info@company.com </a>
						</p>
					</div>

					<div class="col-lg-3 col-md-4 col-12 mt-4 mt-lg-0 ms-auto">
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button"
								data-bs-toggle="dropdown" aria-expanded="false">
								English</button>

							<ul class="dropdown-menu">
								<li><button class="dropdown-item" type="button">Thai</button></li>

								<li><button class="dropdown-item" type="button">Myanmar</button></li>

								<li><button class="dropdown-item" type="button">Arabic</button></li>
							</ul>
						</div>

						<p class="copyright-text mt-lg-5 mt-4">
							Copyright © 2048 Topic Listing Center. All rights reserved. <br>
							<br>Design: <a rel="nofollow" href="https://templatemo.com"
								target="_blank">TemplateMo</a> Distribution <a
								href="https://themewagon.com">ThemeWagon</a>
						</p>

					</div>

				</div>
			</div>
		</footer>


		<!-- JAVASCRIPT FILES -->
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.bundle.min.js"></script>
		<script src="js/jquery.sticky.js"></script>
		<script src="js/click-scroll.js"></script>
		<script src="js/custom.js"></script>
		<script src="js/login.js"></script>
</body>
</html>
