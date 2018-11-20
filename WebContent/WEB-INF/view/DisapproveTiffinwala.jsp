<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html> -->
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html> -->
<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>

<!-- Mirrored from p.w3layouts.com/demos/28-03-2016/shoppy/web/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 29 Oct 2018 15:57:22 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
<title>Shoppy an Admin Panel Category Flat Bootstrap Responsive Website Template | Home :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link href="./css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<!-- Custom Theme files -->
<link href="./css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!--js-->
<script src="./js/jquery-2.1.1.min.js"></script> 
<!--icons-css-->
<link href="./css/font-awesome.css" rel="stylesheet"> 
<!--Google Fonts-->
<link href='http://fonts.googleapis.com/css?family=Carrois+Gothic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Work+Sans:400,500,600' rel='stylesheet' type='text/css'>
<!--static chart-->
<script src="./js/Chart.min.js"></script>
<!--//charts-->
<!-- geo chart -->
    <script src="../../../../../cdn.jsdelivr.net/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
    <script>window.modernizr || document.write('<script src="lib/modernizr/modernizr-custom.html"><\/script>')</script>
    <!--<script src="lib/html5shiv/html5shiv.js"></script>-->
     <!-- Chartinator  -->
    <script src="./js/chartinator.js" ></script>
    <script type="text/javascript">
        jQuery(function ($) {

            var chart3 = $('#geoChart').chartinator({
                tableSel: '.geoChart',

                columns: [{role: 'tooltip', type: 'string'}],
         
                colIndexes: [2],
             
                rows: [
                    ['China - 2015'],
                    ['Colombia - 2015'],
                    ['France - 2015'],
                    ['Italy - 2015'],
                    ['Japan - 2015'],
                    ['Kazakhstan - 2015'],
                    ['Mexico - 2015'],
                    ['Poland - 2015'],
                    ['Russia - 2015'],
                    ['Spain - 2015'],
                    ['Tanzania - 2015'],
                    ['Turkey - 2015']],
              
                ignoreCol: [2],
              
                chartType: 'GeoChart',
              
                chartAspectRatio: 1.5,
             
                chartZoom: 1.75,
             
                chartOffset: [-12,0],
             
                chartOptions: {
                  
                    width: null,
                 
                    backgroundColor: '#fff',
                 
                    datalessRegionColor: '#F5F5F5',
               
                    region: 'world',
                  
                    resolution: 'countries',
                 
                    legend: 'none',

                    colorAxis: {
                       
                        colors: ['#679CCA', '#337AB7']
                    },
                    tooltip: {
                     
                        trigger: 'focus',

                        isHtml: true
                    }
                }

               
            });                       
        });
    </script>
<!--geo chart-->

<!--skycons-icons-->
<script src="js/skycons.js"></script>
<!--//skycons-icons-->
</head>
<%@include file="adminheader.jsp" %>
<body>
<script src='../../../../../ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script><script src="../../../../../m.servedby-buysellads.com/monetization.js" type="text/javascript"></script>
<script>
(function(){
	if(typeof _bsa !== 'undefined' && _bsa) {
  		// format, zoneKey, segment:value, options
  		_bsa.init('flexbar', 'CKYI627U', 'placement:w3layoutscom');
  	}
})();
</script>
<script>
(function(){
if(typeof _bsa !== 'undefined' && _bsa) {
	// format, zoneKey, segment:value, options
	_bsa.init('fancybar', 'CKYDL2JN', 'placement:demo');
}
})();
</script>
<script>
(function(){
	if(typeof _bsa !== 'undefined' && _bsa) {
  		// format, zoneKey, segment:value, options
  		_bsa.init('stickybox', 'CKYI653J', 'placement:w3layoutscom');
  	}
})();
</script><script>
	(function(v,d,o,ai){ai=d.createElement("script");ai.defer=true;ai.async=true;ai.src=v.location.protocol+o;d.head.appendChild(ai);})(window, document, "../../../../../vdo.ai/core/w3layouts/vdo.ai.js");
	</script><!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-125810435-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-125810435-1');
</script>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','../../../../../www.google-analytics.com/analytics.js','ga');
ga('create', 'UA-30027142-1', 'w3layouts.com');
  ga('send', 'pageview');
</script>
<body>	
<div class="page-container">	
   <div class="left-content">
	   <div class="mother-grid-inner">
            <!--header start here-->
	
<!--heder end here-->
<!-- script-for sticky-nav -->
		<script>
		$(document).ready(function() {
			 var navoffeset=$(".header-main").offset().top;
			 $(window).scroll(function(){
				var scrollpos=$(window).scrollTop(); 
				if(scrollpos >=navoffeset){
					$(".header-main").addClass("fixed");
				}else{
					$(".header-main").removeClass("fixed");
				}
			 });
			 
		});
		</script>
		<!-- /script-for sticky-nav -->
<!--inner block start here-->
<div class="inner-block">
<!--market updates updates-->
	 <%-- <div class="market-updates">
			<div class="col-md-6 market-update-gd">
				<div class="market-update-block clr-block-1">
					<div class="col-md-8 market-update-left">
						<h3>${useractivelist}</h3>
						<h4>Total Active User</h4>
					</div>
					<div class="col-md-4 market-update-right">
						<i class="fa fa-file-text-o"> </i>
					</div>
				  <div class="clearfix"> </div>
				</div>
			</div>
			<div class="col-md-6 market-update-gd">
				<div class="market-update-block clr-block-2">
				 <div class="col-md-8 market-update-left">
					<h3>${activetiffin }</h3>
					<h4>Total Active Tiffin-wala</h4>
				  </div>
					<div class="col-md-4 market-update-right">
						<i class="fa fa-eye"> </i>
					</div>
				  <div class="clearfix"> </div>
				</div>
			</div>
		   <div class="clearfix"> </div>
		</div> --%>
<!--market updates end here-->
<!---728x90--->

<!--mainpage chit-chating-->
<div class="chit-chat-layer1">
	<div class="col-md-12 chit-chat-layer1-left">
               <div class="work-progres">
                            <div class="chit-chat-heading">
                                  Disapprove Tiffinwala List
                            </div>
                            <div class="table-responsive">
                                <table class="table table-hover">
                                  <thead>
                                    <tr>
        <!--                             <td>Tiffin Id
<td>Tiffin Name
<td>City Id
<td>City name
<td>Address
<td>pincode
<td>mobile number
<td>email
<td>flag
<td>Action -->
                                      <th>Tiffin Id</th>
                                      <th>Tiffin Name</th>
                                      <!-- <th>City Id</th> -->                                   
                                      <th>City Name</th>                                   
                                                                        
                                      <th>Address</th>
                                      <th>Pincode</th>
                                      <th>Mobile Number</th>
                                      <th>Email</th>
                                      <!-- <th>Flag</th> -->
                                      <th colspan="1">Action</th>
                                  </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${tiffinlist}" var="n">
                                <tr>
                                  
									<td>${n.tiffin_id}</td>
									<td>${n.tiffin_name}</td>
									<td>${n.cityvo.city_name}</td>
									<td>${n.tiffin_address}</td>
									<td>${n.tiffin_pincode}</td>
									<td>${n.tiffin_mobile}</td>
									<td>${n.tiffin_email}</td>
									<%-- <td>${n.tiffin_flag}</td> --%>
									<td><button style="background: blue;border-radius: 50px"><a style="color:white" href="approveflag.htm?id=${n.tiffin_id}&user_id=${n.uservo.user_id}">Approve</a></button></td>

                                  
                              </tr>
                              
							</c:forEach>
                              
                          </tbody>
                      </table>
                  </div>
             </div>
      </div>
    
     <div class="clearfix"> </div>
<%--      
<center>
<table border="1">
<tr>
<td>Tiffin Id
<td>Tiffin Name
<td>City Id
<td>City name
<td>Address
<td>pincode
<td>mobile number
<td>email
<td>flag
<td>Action

</tr>
<c:forEach items="${tiffinlist}" var="n">
<tr>
<td>${n.tiffin_id}</td>
<td>${n.tiffin_name}</td>
<td>${n.cityvo.city_id}</td>
<td>${n.cityvo.city_name}</td>
<td>${n.tiffin_address}</td>
<td>${n.tiffin_pincode}</td>
<td>${n.tiffin_mobile}</td>
<td>${n.tiffin_email}</td>
<td>${n.tiffin_flag}</td>
<td><a href="approveflag.htm?id=${n.tiffin_id}&user_id=${n.uservo.user_id}">Approve</a></td>



</tr>
</c:forEach>

</table>
</center>
 --%></div>
<!--main page chit chating end here-->
<!---728x90--->

<!--main page chart start here-->
<!--main page chart layer2-->

<!--climate start here-->
<!--climate end here-->
</div>
<!--inner block end here-->
<!---728x90--->

<!--copy rights start here-->
<div class="copyrights">
	 <p>© All Rights Reserved </p>
</div>	
<!--COPY rights end here-->
</div>
</div>
<!--slider menu-->
   
</div>
<!--slide bar menu end here-->
<script>
var toggle = true;
            
$(".sidebar-icon").click(function() {                
  if (toggle)
  {
    $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
    $("#menu span").css({"position":"absolute"});
  }
  else
  {
    $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
    setTimeout(function() {
      $("#menu span").css({"position":"relative"});
    }, 400);
  }               
                toggle = !toggle;
            });
</script>
<!--scrolling js-->
		<script src="./js/jquery.nicescroll.js"></script>
		<script src="./js/scripts.js"></script>
		<!--//scrolling js-->
<script src="./js/bootstrap.js"> </script>
<!-- mother grid end here-->
</body>

<!-- Mirrored from p.w3layouts.com/demos/28-03-2016/shoppy/web/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 29 Oct 2018 15:58:26 GMT -->
</html>                     