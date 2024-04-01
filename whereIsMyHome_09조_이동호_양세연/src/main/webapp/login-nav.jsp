<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();
%>

<nav class="navbar navbar-expand-lg bg-gray" style="background-color: #89D9CA;">
    <div class="container">
        <a class="navbar-brand" href="<%= root %>/house?action=main">
            <i class="bi-back"></i>
            <span>HOME!</span>
        </a>

        <div class="d-lg-none ms-auto me-4">
            <a href="<%= root %>/house?action=main" class="navbar-icon bi-person smoothscroll"></a>
        </div>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-lg-5 me-lg-auto">
                <li class="nav-item">
                    <a class="nav-link click-scroll" href="<%= root %>/house?action=main">Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link click-scroll" href="<%= root %>/house?action=announce">Announcement</a>
                </li>

                <li class="nav-item">
                	<a class="nav-link click-scroll" href="<%= root %>/house?action=aptList">Apt</a>
                    <!-- <a class="nav-link click-scroll" href="aptfilter.html">Apt</a> -->
                </li>

                <li class="nav-item">
                    <a class="nav-link click-scroll" href="<%= root %>/house?action=interest">Interest</a>
                </li>
<!-- 
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarLightDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">Pages</a>

                                <ul class="dropdown-menu dropdown-menu-light" aria-labelledby="navbarLightDropdownMenuLink">
                                    <li><a class="dropdown-item" href="topics-listing.html">Topics Listing</a></li>

                                    <li><a class="dropdown-item" href="contact.html">Contact Form</a></li>
                                </ul>
                            </li> -->
            </ul>

            <div class="d-none d-lg-block">
                <a href="./login.html" class="navbar-icon bi-person smoothscroll"></a>
            </div>
        </div>
    </div>
</nav>
