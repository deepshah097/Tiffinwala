<%@page import="com.vo.TypeVo"%>
<%@page import="java.util.List"%>
<%@page import="com.vo.TiffinVo"%>
<%@page import="com.mysql.fabric.Response"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>

<!-- Mirrored from p.w3layouts.com/demos/28-03-2016/shoppy/web/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 29 Oct 2018 15:57:22 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
<title>Tiffinwala</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!--js-->
<script src="js/jquery-2.1.1.min.js"></script> 
<!--icons-css-->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!--Google Fonts-->
<link href='http://fonts.googleapis.com/css?family=Carrois+Gothic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Work+Sans:400,500,600' rel='stylesheet' type='text/css'>
<!--static chart-->
<script src="js/Chart.min.js"></script>
<!--//charts-->
<!-- geo chart -->
    <script src="../../../../../cdn.jsdelivr.net/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
    <script>window.modernizr || document.write('<script src="lib/modernizr/modernizr-custom.html"><\/script>')</script>
    <!--<script src="lib/html5shiv/html5shiv.js"></script>-->
     <!-- Chartinator  -->
    <script src="js/chartinator.js" ></script>
    

<!--skycons-icons-->
<script src="js/skycons.js"></script>
<!--//skycons-icons-->
</head>
<%@include file="adminheader.jsp" %>
<% Integer tid=(Integer)session.getAttribute("tid");
List typels=(List)session.getAttribute("typelist");
%>
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
<!--inner block start here-->
<div class="inner-block">
<!--mainpage chit-chating-->
<button class="btn btn-success"><a href="ViewCurrentMenu.htm?id=<%=tid%>" style="color:white">view Current menu</a></button>
<button class="btn btn-danger"><a href="ViewPastMenu.htm?id=<%=tid%>" style="color:white">view past menu</a></button>
<div class="chit-chat-layer1">
	<div class="col-md-12 chit-chat-layer1-left">
               <div class="work-progres">
                            <div class="chit-chat-heading">
                                  Add New Menu
                            </div>
                            <div class="table-responsive">
                                <form action="savemenu.htm" method="post">
								 <div class="form-group">								 
								    <label>Enter Menu Items</label>
								    <input type="text" name="menuitems" class="form-control" placeholder="Enter Menu Item" required="">								  					 
								 </div>
								 <div class="form-group">								 
								    <label>Enter Menu Description</label>
								   <!--  <input type="text" name="user_name" class="form-control" required="required">		 -->
								   <!-- <input type="text" name="user_email" required="required" class="form-control"> -->
								   <textarea row="5" col="5" name="menudesc" placeholder="Enter Description" class="form-control" required=""></textarea>			 
								 </div>
								 <div class="form-group">								 
								    <label>Enter Price</label>
								    <!-- <input type="text" name="user_name" class="form-control" required="required"> -->
								    <input type="text" name="menuprice" placeholder="Enter Price" class="form-control" required="">
								    <input type="hidden" name="tiffinvo_tiffin_id" value="<%=tid %>" required="">
								    <!-- <input type="password" name="user_password" class="form-control" required="required"> -->					 
								 </div>
								 <div class="form-group">								 
								    <label>Type</label>
								    <!-- <input type="text" name="user_name" class="form-control" required="required"> -->
								    
								    <select name="menutype" class="form-control"><%for(int i=0;i<typels.size();i++){ 
										TypeVo ct=(TypeVo)typels.get(i); %>
									<option value="<%=ct.getType_id() %>"><%=ct.getType_name()%></option>
									<%} %></select>					 
								 </div>
								 
								 <center>
								 	<button type="submit" class="btn btn-primary">Add Menu</button>
								 </center>
								</form>
                  			</div>
             	</div>
      </div>
</div>

	
<div class="clearfix"> </div>

</div>
<!--inner block end here-->
<!---728x90--->

<!--copy rights start here-->
	
<!--COPY rights end here-->
</div>
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
		<script src="js/jquery.nicescroll.js"></script>
		<script src="js/scripts.js"></script>
		<!--//scrolling js-->
<script src="js/bootstrap.js"> </script>
<!-- mother grid end here-->
</body>

<!-- Mirrored from p.w3layouts.com/demos/28-03-2016/shoppy/web/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 29 Oct 2018 15:58:26 GMT -->
</html>                     
<%-- <%@page import="com.vo.TypeVo"%>
<%@page import="java.util.List"%>
<%@page import="com.vo.TiffinVo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="adminheader.jsp" %>
<% Integer tid=(Integer)session.getAttribute("tid");
List typels=(List)session.getAttribute("typelist");
%>
<body>

<center>
<a href="ViewPastMenu.htm?id=<%=tid%>">view past menu</a><br>
<a href="ViewCurrentMenu.htm?id=<%=tid%>">view Current menu</a>

<form action="savemenu.htm" method="post">
<br><br>
				<input type="text" name="menuitems" placeholder="Enter menu item" required=""><br><br>
				<input type="text" name="menuprice" placeholder="Enter Price" required=""><br><br>
				<textarea row="5" col="5" name="menudesc" placeholder="Enter desc" required=""></textarea>
				<br>
				<select name="menutype"><%for(int i=0;i<typels.size();i++){ 
					TypeVo ct=(TypeVo)typels.get(i); %>
				<option value="<%=ct.getType_id() %>"><%=ct.getType_name()%></option>
				<%} %></select><br><br>
				 <br>
				 <input type="hidden" name="tiffinvo_tiffin_id" value="<%=tid %>" required="">
				<input type="submit" name="Sign In" value="Update Menu">	
</form>
</center>
</body>
</html>


 --%>