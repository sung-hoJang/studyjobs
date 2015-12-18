<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="robots" content="index, follow">
        <title>STUDYJOBS</title>
        <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Open+Sans:regular,700,600&amp;latin" type="text/css" />
        <!-- Essential styles -->
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="assets/plugins/font-awesome/css/font-awesome.css" type="text/css"> 

        <!-- Dlapak styles -->
        <link id="theme_style" type="text/css" href="assets/css/style1.css" rel="stylesheet" media="screen">


        <!-- Favicon -->
        <link href="assets/img/favicon.png" rel="icon" type="image/png">

        <!-- Assets -->
        <link rel="stylesheet" href="assets/plugins/owl-carousel/owl.carousel.css">
        <link rel="stylesheet" href="assets/plugins/owl-carousel/owl.theme.css"> 

        <!-- JS Library -->
        <script src="assets/js/jquery.js"></script>
		
    </head>
    <body>
        <div class="wrapper">
           <!-- header가 드갈 부분 -->
           <tiles:insertAttribute name="header" />
           <!-- header가 드갈 부분 -->
           
           
            <section class="main no-padding">
                <!-- accountheader.jsp 시작부 -->
               <tiles:insertAttribute name="accountheader" />
                <!-- accountheader.jsp 끝 부-->
                
                
                
                <div class="container">
                    <div class="row">
                    
                    
                        <div class="col-md-3 col-sm-3">
                        	<tiles:insertAttribute name="left" />
                        </div>
                        
                        
                        <div class="col-md-9 col-sm-9">
                           <tiles:insertAttribute name="main" />
                        </div>  
                    </div>
                </div>
            </section>
           <div id="footer">
				<tiles:insertAttribute name="footer" />
			</div>
        </div>
        <!-- Essentials -->
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/plugins/owl-carousel/owl.carousel.js"></script>
        <script src="assets/plugins/counter/jquery.countTo.js"></script>
        <script src="assets/plugins/filestyle/bootstrap-filestyle.min.js"></script>
    </body>