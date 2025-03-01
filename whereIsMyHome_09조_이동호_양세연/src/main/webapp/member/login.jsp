<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

		<%@ include file="/common/header.jsp" %>
		<section
			class="hero-section2 d-flex justify-content-center align-items-center vh-50"
			id="section_1">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-10 col-lg-6 col-xl-5">
						<div class="card bg-dark text-white" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">

								<div class="mb-md-5 mt-md-4 pb-5">

									<h2 class="fw-bold text-white mb-2 text-uppercase">로그인</h2>
									<%
									String msg = (String) request.getAttribute("msg");
									System.out.print(msg);
									if (msg != null) {
									%>
									<span class="text-danger">${msg}</span>
									<%
									}
									%>
									<form id="loginForm" method="POST"
										action="${root}/member?action=login">
										<div class="text-white-50 mb-5"></div>

										<div class="form-outline form-white mb-4">
											<div class="text-start">이메일</div>
											<input type="email" name="email" id="typeEmailX"
												class="form-control form-control-lg" required /> <label
												class="form-label" for="typeEmailX"> </label>
										</div>

										<div class="form-outline form-white mb-4">
											<div class="text-start">비밀번호</div>
											<input type="password" name="password" id="typePasswordX"
												class="form-control form-control-lg" required /> <label
												class="form-label" for="typePasswordX"></label>
										</div>

										<p class="small mb-5 pb-lg-2">
											<a class="text-white-50" href="#!">비밀번호 찾기</a>
										</p>

										<input class="btn btn-outline-light btn-lg px-5" type="submit"
											href="${root}/member?action=login" value="로그인" />
									</form>

									<div
										class="d-flex justify-content-center text-center mt-4 pt-1">
										<a href="#!" class="text-white"><i
											class="fab fa-facebook-f fa-lg"></i></a> <a href="#!"
											class="text-white"><i
											class="fab fa-twitter fa-lg mx-4 px-2"></i></a> <a href="#!"
											class="text-white"><i class="fab fa-google fa-lg"></i></a>
									</div>

								</div>

								<div>
									<p class="mb-0">
										회원이 아니신가요? <a href="${root}/member?action=registForm"
											class="text-white fw-bold">회원가입</a>
									</p>
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
