<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dto.HouseInfoDto, java.util.List"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<%
String root = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>hi</h2>
<div>
                     <table class="table table-hover text-center m-3">
                         <tr>
                           <th>아파트이름</th>
                           <th>도로명</th>
                           <th>법정동</th>
                           <th>지번</th>
                           <th>건축년도</th>
                         </tr>
                         <tbody id="aptlist">
                          <c:forEach items="${ aptInfoList}" var="info">
<tr>
	<td>${info.aptName}</td>
	<td>${info.roadName}</td>
	<td>${info.dong}</td>
	<td>${info.jibun}</td>
	<td>${info.buildYear}</td>
	</tr>
</c:forEach>
                          </tbody>
                        </table>
</div>

</body>
</html>