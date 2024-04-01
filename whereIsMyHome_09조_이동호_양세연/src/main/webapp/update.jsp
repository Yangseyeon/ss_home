<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String root = request.getContextPath(); %>
<%
Member memeber = (Member) session.getAttribute("member");
%>
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
					<div class="col-12 col-md-10 col-lg-6 col-xl-5 ">
						<div class="card bg-dark text-white" style="border-radius: 1rem;">
							<div class="card-body p-5 ">

								<div class="mb-md-5 mt-md-4">

									<h2 class="text-center fw-bold text-white mb-2 text-uppercase">회원
										정보</h2>
									<p class="text-white-50 mb-5"></p>

									<form method="POST" action="<%= root %>/member?action=modify">
										<div class="text-left form-outline form-white mb-4">
											<span class="text-start">이메일: </span> <span
												class="text-start">${member.userId}</span> <input hidden
												type="email" name="email" class="text-start"
												value="${member.userId}" />
										</div>

										<div class="text-left form-outline form-white mb-4">
											<span class="text-start">비밀번호: </span> <input type="password"
												name="password" class="text-start"
												value="${member.userPassword}" required />
										</div>

										<div class="text-left form-outline form-white mb-4">
											<span class="text-start">이름: </span> <input type="text"
												name="name" class="text-start" value="${member.userName}"
												required />
										</div>

										<div class="text-left form-outline form-white mb-4">
											<span class="text-start">주소: </span> <input type="text"
												name="address" class="text-start" value="${member.address}" />
										</div>

										<div class="text-left form-outline form-white mb-4">
											<span class="text-start">전화번호: </span> <input type="text"
												name="phoneNumber" class="text-start"
												value="${member.phoneNumber}" />
										</div>

										<div class="d-flex flex-column align-items-center">
											<button class="btn btn-outline-light btn-lg px-5 mb-3"
												type="submit">확인</button>
										</div>

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
