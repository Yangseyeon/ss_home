<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.member.model.MemberDto"%>
<%
MemberDto userInfo = (MemberDto) session.getAttribute("userinfo");

if(userInfo != null) {
%>
	<div class="row justify-content-center">
	  <div class="col-lg-8 col-md-10 col-sm-12 m-3 text-end">
		<strong><%= userInfo.getUserName() %></strong> (<%= userInfo.getUserId() %>)님 안녕하세요.
		<a href="<%= root %>/user?action=logout">로그아웃</a><br />
	  </div>
	</div>
<%
} else {
%>
	<script>
	alert("로그인이 필요한 페이지입니다.");
	location.href = "<%= root %>/user?action=mvlogin";
	</script>
<%	
}
%>