<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String root = request.getContextPath(); %>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="">
<meta name="author" content="">

<title>where is my home</title>

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
		<jsp:include page="/common/header.jsp" />

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
										action="<%= root %>/member?action=login">
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
											href="<%= root %>/member?action=login" value="로그인" />
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
										회원이 아니신가요? <a href="<%= root %>/member?action=registForm"
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

		<%@ include file="/common/footer.jsp"%>


		<!-- JAVASCRIPT FILES -->
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.bundle.min.js"></script>
		<script src="js/jquery.sticky.js"></script>
		<script src="js/click-scroll.js"></script>
		<script src="js/custom.js"></script>
		<script src="js/login.js"></script>
</body>
</html>
