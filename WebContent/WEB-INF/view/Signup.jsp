<%@page import="com.vo.CityVo"%>
<%@page import="com.vo.TypeVo"%>
<%@page import="java.util.List"%>
<%@page import="com.vo.UserVo"%>
<%@page import="com.mysql.fabric.Response"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
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
<%UserVo userdata=(UserVo)session.getAttribute("user");
	List cityls=(List)session.getAttribute("citylist");
%>

<!DOCTYPE HTML>
<html>

<!-- Mirrored from p.w3layouts.com/demos/28-03-2016/shoppy/web/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 29 Oct 2018 15:59:10 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
<title>Sign Up</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
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
</head>
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
<div class="login-page">
<!---728x90--->

    <div class="login-main">  
    	 <div class="login-head">
				<h1>Sign Up</h1>
			</div>			
			<div class="login-block">
			<span style='color:red'>${loginError}</span>
			
				<form action="signup.htm" method="post">
					<input type="text" name="tiffinemail" placeholder="Enter Email" required="">
					<input type="text" name="tiffinaddress" placeholder="Enter Address" required="">
					<input type="text" name="tiffinnumber" placeholder="Enter Mobile number" required="">
					<input type="text" name="tiffinname" placeholder="Enter name" required="">
					
					<input type="text" name="tiffinpincode" placeholder="Enter pincode" required="">
					
					<select name="tiffincity"><%for(int i=0;i<cityls.size();i++){ 
						CityVo ct=(CityVo)cityls.get(i); %>
					<option value="<%=ct.getCity_id() %>"><%=ct.getCity_name() %></option>
					<%} %></select><br><br>
					
					<input type="hidden" name="uservo_user_id" value="<%=userdata.getUser_id() %>" required="">
					
					<div class="forgot-top-grids">
						<div class="forgot-grid">
				<!-- 			<ul>
								<li>
									<input type="checkbox" id="brand1" value="">
									<label for="brand1"><span></span>Remember me</label>
								</li>
							</ul> -->
						</div>
						<div class="forgot">
							<!-- <a href="#">Forgot password?</a> -->
						</div>
						<div class="clearfix"> </div>
					</div>
					<input type="submit" name="Sign In" value="Sign Up">	
					<!-- <h3>Not a member?<a href="signup.html"> Sign up now</a></h3>				
					<h2>or login with</h2>
					<div class="login-icons">
						<ul>
							<li><a href="#" class="facebook"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#" class="twitter"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#" class="google"><i class="fa fa-google-plus"></i></a></li>						
						</ul>
					</div> -->
				</form>
				<!-- <h5><a href="index.html">Go Back to Home</a></h5> -->
			</div>
      </div>
</div>

		<script src="./js/jquery.nicescroll.js"></script>
		<script src="./js/scripts.js"></script>
		<!--//scrolling js-->
<script src="./js/bootstrap.js"> </script>
<!-- mother grid end here-->
</body>

</html>


                      
						
