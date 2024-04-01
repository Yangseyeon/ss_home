<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dto.HouseInfoDto, java.util.List, dto.HouseDealDto"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
String root = request.getContextPath();
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

        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500;600;700&family=Open+Sans&display=swap" rel="stylesheet">
                        
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/bootstrap-icons.css" rel="stylesheet">

        <link href="css/templatemo-topic-listing.css" rel="stylesheet">      
        <link href="css/main.css" rel="stylesheet">
<!--

TemplateMo 590 topic listing

https://templatemo.com/tm-590-topic-listing

-->
    </head>
    
    <body id="top">

        <main>

            <jsp:include page="main-nav.jsp" />
            

            <section class="hero-section d-flex justify-content-center align-items-center" id="section_1">
                <div class="container p-0">
                    <div class="row d-flex">
                        

                        <div class="col-lg-9 p-1 mx-auto"  style="border-radius: 0px;">
                            
                            <div class="container" >
                                <div class="row col-md-12 justify-content-center mb-2">
                                    <form class="row col-md-10 justify-content-center mb-2" action="<%= root %>/house?action=viewApt" method="POST">
                                        <div class="form-group col-lg-2 col-md-12 m-0 p-1" >
                                            <select class="form-select m-0 bg-light" id="sido" name = "sido" style="border: 0;">
                                              <option value="">시도선택</option>
                                            </select>
                                          </div>
                                          <div class="form-group col-lg-2 col-md-12 m-0 p-1">
                                            <select class="form-select bg-light" id="gugun" name="gugun" style="border: 0;">
                                              <option value="">구군선택</option>
                                            </select>
                                          </div>
                                          <div class="form-group col-lg-2 col-md-12 m-0 p-1">
                                            <select class="form-select bg-light" id="dong" name="dong" style="border: 0;">
                                              <option value="">동선택</option>
                                            </select>
                                          </div>
                                          <div class="form-group col-lg-2 col-md-12 m-0 p-1">
                                            <select class="form-select bg-light" id="year" name="year" style="border: 0;">
                                
                                            </select>
                                          </div>
                                          <div class="form-group col-lg-2 col-md-12  m-0 p-1">
                                            
                                            <select class="form-select bg-light" id="month" name="month" style="border: 0;">
                                              <option value="">매매월선택</option>
                                            </select>
                                          </div>
                                          <div class="form-group col-lg-2 col-md-12 d-flex justify-content-center align-items-center m-0 p-1">
                                            <button type="submit" id="list-btn2" class="form-control col-12 w-100">Search</button>
                                        </div>
                                       </form>
                                  </div>
                            </div>
                        </div>

                    </div>
                </div>
            </section>


            <section class="featured-section">
                <div class="container">
                    <div class="row s001">

                        <div class="col-12 mb-4 mb-lg-0">
                            <div class="custom-block bg-white shadow-lg">
                                    <div class="d-flex">
                                        <div id="map" class="mt-3 custom-block-image img-fluid" style="width: 100%; height: 400px;"></div>

                                    </div>

                            </div>
                        </div>
                        
                        
                        <c:if test="${not empty aptDealList}">
                        <div id="apt-list-block" class="col-12 mt-3 p-3">
                            <div class="custom-block custom-block-overlay bg-light p-3 shadow-lg">
                                <table class="table table-hover text-center m-3">
                                    <tr>
                                      <th>아파트이름</th>
                                      <th>거래 년도</th>
                                      <th>거래 월</th>
                                      <th>공급면적</th>
                                      <th>층</th>
                                      <th>거래 금액</th>
                                    </tr>
                                    <tbody id="deallist">
	                                    <c:forEach items="${ aptDealList}" var="deal">
											<tr>
												<td>${deal.apartmentName}</td>
												<td>${deal.dealYear}</td>
												<td>${deal.dealMonth}</td>
												<td>${deal.area}</td>
												<td>${deal.floor}</td>
												<td>${deal.dealAmount}</td>
											</tr>
										</c:forEach>
                                    </tbody>
                                  </table>
                            </div>
                        </div>
                        </c:if>
                        
                        
                        
						
						<c:if test="${not empty aptInfoList}">
                        <div id="apt-list-block" class="col-12 mt-3 p-3">
                            <div class="custom-block custom-block-overlay bg-light p-3 shadow-lg">
                                <table class="table table-hover text-center m-3">
                                    <tr>
                                      <th>아파트이름</th>
                                      <th>도로명</th>
                                      <th>법정동</th>
                                      <th>지번</th>
                                      <th>건축년도</th>
                                      <th>상세보기</th>
                                    </tr>
                                    <tbody id="aptlist">
	                                    <c:forEach items="${ aptInfoList}" var="info">
											<tr>
												<td>${info.aptName}</td>
												<td>${info.roadName}</td>
												<td>${info.dong}</td>
												<td>${info.jibun}</td>
												<td>${info.buildYear}</td>
												<td><a  href = '<%= root %>/house?action=viewDetailAptDeal&aptName=${info.aptName}&year=${year}&month=${month}&dong=${dong}&lng=${info.lng}&lat=${info.lat}'>상세보기</a></td>
												<td style="display:none">${info.lng}</td>
												<td style="display:none">${info.lat}</td>
											</tr>
										</c:forEach>
                                    </tbody>
                                  </table>
                            </div>
                        </div>
                        </c:if>

                    </div>
                </div>
            </section>


            
            
<footer class="site-footer section-padding">
            <div class="container">
                <div class="row">

                    <div class="col-lg-3 col-12 mb-4 pb-2">
                        <a class="navbar-brand mb-2" href="index.html">
                            <i class="bi-back"></i>
                            <span>Home!</span>
                        </a>
                    </div>

                    <div class="col-lg-3 col-md-4 col-6">
                        <h6 class="site-footer-title mb-3">Resources</h6>

                        <ul class="site-footer-links">
                            <li class="site-footer-link-item">
                                <a href="#" class="site-footer-link">Home</a>
                            </li>

                            <li class="site-footer-link-item">
                                <a href="#" class="site-footer-link">How it works</a>
                            </li>

                            <li class="site-footer-link-item">
                                <a href="#" class="site-footer-link">FAQs</a>
                            </li>

                            <li class="site-footer-link-item">
                                <a href="#" class="site-footer-link">Contact</a>
                            </li>
                        </ul>
                    </div>

                    <div class="col-lg-3 col-md-4 col-6 mb-4 mb-lg-0">
                        <h6 class="site-footer-title mb-3">Information</h6>

                        <p class="text-white d-flex mb-1">
                            <a href="tel: 305-240-9671" class="site-footer-link">
                                305-240-9671
                            </a>
                        </p>

                        <p class="text-white d-flex">
                            <a href="mailto:info@company.com" class="site-footer-link">
                                info@company.com
                            </a>
                        </p>
                    </div>

                    <div class="col-lg-3 col-md-4 col-12 mt-4 mt-lg-0 ms-auto">
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                            English</button>

                            <ul class="dropdown-menu">
                                <li><button class="dropdown-item" type="button">Thai</button></li>

                                <li><button class="dropdown-item" type="button">Myanmar</button></li>

                                <li><button class="dropdown-item" type="button">Arabic</button></li>
                            </ul>
                        </div>

                        <p class="copyright-text mt-lg-5 mt-4">Copyright © 2048 Topic Listing Center. All rights reserved.
                        <br><br>Design: <a rel="nofollow" href="https://templatemo.com" target="_blank">TemplateMo</a> Distribution <a href="https://themewagon.com">ThemeWagon</a></p>
                        
                    </div>

                </div>
            </div>
        </footer>


        <!-- JAVASCRIPT FILES -->
        <script src="js/key.js"></script>

        <script
            type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5e28e613a6f651bac00ca7d7b68578eb&libraries=services,clusterer,drawing"
        ></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/jquery.sticky.js"></script>
        <script src="js/custom.js"></script>

        <script src="js/detail.js"></script>

        <script>
            var mapContainer = document.getElementById("map"), // 지도를 표시할 div
            mapOption = {
            center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
            level: 3, // 지도의 확대 레벨
            };

            // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
            var map = new kakao.maps.Map(mapContainer, mapOption);
        </script>
        <c:if test="${not empty aptDealList}">
        <script>
	        var coords = new kakao.maps.LatLng(${lat}, ${lng});
	
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        marker = new kakao.maps.Marker({
	          map: map,
	          position: coords,
	        });
	
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        infowindow = new kakao.maps.InfoWindow({
	          content: `<div style="width:150px;text-align:center;padding:6px 0;">
	                      <p><b>${aptName}</b></p> 
	                    </div>`,
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);

        </script>
        </c:if>

    </body>
</html>
    