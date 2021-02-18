<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>注册</title>
<link href="static/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="static/css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<script src="static/js/jquery.min.js"></script>
<script type="text/javascript">
        $(document).ready(function() {
            $(".dropdown img.flag").addClass("flagvisibility");

            $(".dropdown dt a").click(function() {
                $(".dropdown dd ul").toggle();
            });
                        
            $(".dropdown dd ul li a").click(function() {
                var text = $(this).html();
                $(".dropdown dt a span").html(text);
                $(".dropdown dd ul").hide();
                $("#result").html("Selected value is: " + getSelectedValue("sample"));
            });
                        
            function getSelectedValue(id) {
                return $("#" + id).find("dt a span.value").html();
            }

            $(document).bind('click', function(e) {
                var $clicked = $(e.target);
                if (! $clicked.parents().hasClass("dropdown"))
                    $(".dropdown dd ul").hide();
            });


            $("#flagSwitcher").click(function() {
                $(".dropdown img.flag").toggleClass("flagvisibility");
            });
        });
     </script>
<script type="text/javascript">  
function send() {
	$.post("/myshop/loginuser/emailonlyone",{"email":$("#email").val()},function(result){
		if(result=="false") {  
               document.getElementById("ture").innerHTML = "用户名已被注册或者格式不正确！";  
           } else {  
               document.getElementById("ture").innerHTML = "用户名可以使用";  
           }
	  });
}    
function ispassword() {
	$.post("/myshop/loginuser/isthepassword",{"password":$("#password").val(),"configpassword":$("#configpassword").val()},function(result){
		if(result=="false") {  
			document.getElementById("turepassword").innerHTML = "与原密码不一致！或为空";
           } else {  
        	   document.getElementById("turepassword").innerHTML = "与原密码一致可用";   
           }
	  });
}   
function send2() {
	$.post("/myshop/loginuser/yanzhenname",{"username":$("#username").val()},function(resultg){
		if(resultg=="false") {  
			document.getElementById("nullusername").innerHTML = "用户名不能为空";
           } else {  
        	   document.getElementById("nullusername").innerHTML = "填写正确";
           }
	  });
}    
function yanzhengmima() {
	$.post("/myshop/loginuser/yanzhengmima",{"password":$("#password").val()},function(resulth){
		if(resulth=="false") {  
			document.getElementById("forsetpassword").innerHTML = "格式错误，长度在6-18之间";
           } else {  
        	   document.getElementById("forsetpassword").innerHTML = "填写正确";
           }
	  });
}    

function check(){
	    var name = document.getElementById("username").value;
	    var gender=$("input[name='gender']:checked").val();
	    var forsetpassword=document.getElementById("forsetpassword").innerHTML;
	    var tureyouxiang=document.getElementById("ture").innerHTML;
	    
	     var turepassword=document.getElementById("turepassword").innerHTML;
	    var password=$("#password").val();
	    var querenpassword=$("#configpassword").val();
	     if(name ==  null || name == ''){
	         alert("用户名不能为空");
	          return false;
	     }
	     if(gender ==  null || gender == 'undefined'){
			   alert("性别不能为空");
			   return false;
		   }
	      if(forsetpassword !="填写正确"){
	    	  alert(forsetpassword);
			   alert("密码验证错误，请重新输入密码");
			   return false;
		   }
	    
	     if(tureyouxiang !="用户名可以使用"){
	    	  alert(tureyouxiang);
			   alert("邮箱验证错误");
			   return false;
		   }
	     
        if(turepassword !="与原密码一致可用"){
        	   alert(turepassword);
			   alert("确认密码验证错误");
			   return false;
		   } 
 
	     if(password ==  null || password == ''){
	         alert("密码不能为空");
	          return false;
	     }
	     if(querenpassword ==  null || querenpassword == ''){
	         alert("请输入确定密码");
	          return false;
	     }
	    return true;
	  }
	  
	  
</script>
</head>
<body>
	<div class="header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="header-left">
						<div class="logo">
							<a href="index.html"><img src="static/images/logo.png" alt="" /></a>
						</div>
						<div class="menu">
							<a class="toggleMenu" href="#"><img
								src="static/images/nav.png" alt="" /></a>
							<ul class="nav" id="nav">
								<li><a href="shop.html">商店</a></li>
								<li><a href="experiance.html">经验交流</a></li>
								<li><a href="contact.html">联系我们</a></li>
								<div class="clear"></div>
							</ul>
							<script type="text/javascript" src="static/js/responsive-nav.js"></script>
						</div>
						<div class="clear"></div>
					</div>
					<div class="header_right">
						<!-- start search-->
						<div class="search-box">
							<div id="sb-search" class="sb-search">
								<form>
									<input class="sb-search-input"
										placeholder="Enter your search term..." type="search"
										name="search" id="search"> <input
										class="sb-search-submit" type="submit" value=""> <span
										class="sb-icon-search"> </span>
								</form>
							</div>
						</div>
						<!----search-scripts---->
						<script src="static/js/classie.js"></script>
						<script src="static/js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
						<ul class="icon1 sub-icon1 profile_img">
							<li><a class="active-icon c1" href="#"> </a>
								<ul class="sub-icon1 list">
									<div class="product_control_buttons">
										<a href="#"><img src="static/images/edit.png" alt="" /></a> <a
											href="#"><img src="static/images/close_edit.png" alt="" /></a>
									</div>
									<div class="clear"></div>
									<li class="list_img"><img src="images/1.jpg" alt="" /></li>
									<li class="list_desc"><h4>
											<a href="#">商品</a>
										</h4>
										<span class="actual">1 x $12.00</span></li>
									<div class="login_buttons">
										<div class="check_button">
											<a href="checkout.html">去购物车结算</a>
										</div>
										<div class="login_button">
											<a href="login.html">登录</a>
										</div>
										<div class="clear"></div>
									</div>
									<div class="clear"></div>
								</ul></li>
						</ul>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="main">
		<div class="shop_top">
			<div class="container">
				<form action="/myshop/loginuser/zhuce" method="post" onsubmit="return check()">
					<div class="register-top-grid">
						<h3>填写注册信息</h3>
						<div>
							<span>用户名<label>*</label></span> <input type="text"
								name="nickName" id="username" onblur="send2()"><span
								style="color: red" id="nullusername"></span>
						</div>
						<div>
							<span>邮箱<label>*</label></span> <input type="text" name="email"
								id="email" onblur="send()"><span style="color: red"
								id="ture"></span>
						</div>
						<div>
							<span>性别<label>*</label></span> <input type="radio" 
								name="gender" value="男" />男 <input type="radio" 
								name="gender" value="女" />女<br />
						</div>
						<div>
							<span>个性签名<label></label></span> <input type="text"
								name="introduce">
						</div>
						<div class="clear"></div>
						<a class="news-letter" href="#"> <label class="checkbox"><input
								type="checkbox" name="checkbox" checked=""><i> </i></label>
						</a>
						<div class="clear"></div>
					</div>
					<div class="clear"></div>
					<div class="register-bottom-grid">
						<h3>登录信息</h3>
						<div>
							<span>密码<label>*</label></span> <input type="password"
								name="password" id="password" onblur="yanzhengmima()"><span
								style="color: red" id="forsetpassword"></span>
						</div>
						<div>
							<span>确认密码<label>*</label></span> <input type="password"
								id="configpassword" onblur="ispassword()"><span
								style="color: red" id="turepassword"></span>
						</div>
						<div class="clear"></div>
					</div>
					<div class="clear"></div>
					<input type="submit" value="提交">
				</form>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<ul class="footer_box">
						<h4>商品</h4>
						<li><a href="#">男士</a></li>
						<li><a href="#">女士</a></li>
						<li><a href="#">青年</a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<ul class="footer_box">
						<h4>关于</h4>
						<li><a href="#">就业和实习</a></li>
						<li><a href="#">团队</a></li>
						<li><a href="#">请求/下载目录 </a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<ul class="footer_box">
						<h4>客户支持</h4>
						<li><a href="#">联系我们</a></li>
						<li><a href="#">订单跟踪</a></li>
						<li><a href="#">保修</a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<ul class="footer_box">
						<h4>通讯</h4>
						<div class="footer_search">
							<form>
								<input type="text" value="输入您的电子邮件" onfocus="this.value = '';"
									onblur="if (this.value == '') {this.value = 'Enter your email';}">
								<input type="submit" value="Go">
							</form>
						</div>
						<ul class="social">
							<li class="facebook"><a href="#"><span> </span></a></li>
							<li class="twitter"><a href="#"><span> </span></a></li>
							<li class="instagram"><a href="#"><span> </span></a></li>
							<li class="pinterest"><a href="#"><span> </span></a></li>
							<li class="youtube"><a href="#"><span> </span></a></li>
						</ul>

					</ul>
				</div>
			</div>
			<div class="row footer_bottom">
				<div class="copy">
					<p>
						版权 &copy; 2014.公司保留所有权利.<a target="_blank"
							href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
					</p>
				</div>
				<dl id="sample" class="dropdown">
					<dt>
						<a href="#"><span>更改地区</span></a>
					</dt>
					<dd>
						<ul>
							<li><a href="#">澳大利亚<img class="flag"
									src="static/images/as.png" alt="" /><span class="value">AS</span></a></li>
							<li><a href="#">斯里兰卡<img class="flag"
									src="static/images/srl.png" alt="" /><span class="value">SL</span></a></li>
							<li><a href="#">新西兰<img class="flag"
									src="static/images/nz.png" alt="" /><span class="value">NZ</span></a></li>
							<li><a href="#">巴基斯坦<img class="flag"
									src="static/images/pk.png" alt="" /><span class="value">Pk</span></a></li>
							<li><a href="#">联合国<img class="flag"
									src="static/images/uk.png" alt="" /><span class="value">UK</span></a></li>
							<li><a href="#">美国<img class="flag"
									src="static/images/us.png" alt="" /><span class="value">US</span></a></li>
						</ul>
					</dd>
				</dl>
			</div>
		</div>
	</div>
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>