<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>商店</title>
<link href="${ctx }/static/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="${ctx }/static/css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="${ctx }/static/js/jquery.min.js"></script>
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
     <style type="text/css">
     *{
     margin:0;
     padding:0;
     }
     html,body{
      height: 100%;
	 width:100%;
     }
     #white{
     background-color:white;
     height: 100%;
	 width:$(window).width();
	
     }
    #a {
	height: 100%;
	width:100%;
	float:left;
	overflow: auto;
	margin: 0 auto;
	 display: block;
  margin-left: auto;
  margin-right: auto;
  
   border:1px solid white;
}

#divfrom {
   float:left;
}
</style>

<script type="text/javascript"> 
function checkAll(obj) {
	
    $('[name="like"]').
                prop("checked", 'true');//全选
 
}

function nocheckAll(obj) {
       
            $('[name="like"]').
                    removeAttr("checked", 'true');//取消全选
    }

function writeCheckValue() {
    var str = "";
    $('[name="like"]:checked').each(function () {
        str += $(this).val()+",";
    });
    //alert(str);
    var ture=document.getElementById("ture").value=str;
    //alert(ture);
    return str;
   
   
   
}

</script>
</head>
<body bgcolor="white">
	<div class="header">
		
			<div class="row">
			  <div class="col-md-12">
				 <div class="header-left">
					 <div class="logo">
						<a href="index.html"><img src="${ctx }/static/images/logo.png" alt=""/></a>
					 </div>
					 <div class="menu">
						 
						    <ul class="nav" id="nav">
						    	<li><a href="/myshop/cart/showcart">未结算的商品</a></li>
								<li><a href="/myshop/cart/showyijiesuancart">已经结算的商品</a></li>
								<li><a href="/myshop/product/productlist">回到商店</a></li>
								<li><a href="/myshop/userzhuye.jsp">回到主页</a></li>
								<li><a href="#">我的积分</a></li>
									
								<div class="clear"></div>
							</ul>
							<script type="text/javascript" src="${ctx }/static/js/responsive-nav.js"></script>
				    </div>	
				     <div class="header_right">
	    		 <!-- start search-->
				  <div class="search-box">
							<div id="sb-search" class="sb-search">
								<form>
									<input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
									<input class="sb-search-submit" type="submit" value="">
									<span class="sb-icon-search"> </span>
								</form>
							</div>
						</div>
						<!----search-scripts---->
						<script src="${ctx }/static/js/classie.js"></script>
						<script src="${ctx }/static/js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
				   
		        <div class="clear"></div>
	       </div>
	      </div>
		 </div>
	    </div>
	  </div>
	  
     <div class="main">
      <div class="shop_top">
		<div class="container">
		
			<div class="row shop_box-top">	
			 <div id=divfrom>
			 
			 <input type="submit" name="checkAll" value="&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp全选&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" onclick="checkAll(this)" ><br>
			 <input type="submit" name="checkAll" value="&nbsp&nbsp&nbsp&nbsp&nbsp取消所选&nbsp&nbsp" onclick="nocheckAll(this)" ><br>
			 <form action="/myshop/cart/jiesuansuoyuan" method="post" onclick="writeCheckValue()">
			 <input type="hidden" name="ture" id="ture">
			  <input type="submit" name="checkAll" value="结算所选产品"  >	
			  </form>
			    				
	    		<c:forEach items="${showcartobject }" var="show">
	    		<div id=white>	
	    	<input type="checkbox" name="like" value="${show.oid} " >
			<form action="/myshop/cart/cast" method="post">
				
                  <div id=a style="width:100%">
      
								 <input type="hidden" name="oid" value=${show.oid}>
							</div>
							<div>
								 <input type="hidden" name="id" value=${show.id}>${show.productname }
							</div>
							<div>
								 <input type="hidden" name="state" value=${show.state}>
							</div>
							
							<div>
								<span>产品名称：<label></label></span> <input type="text"
									name="productname" placeholder=${show.productname } readonly>
							</div>
							<div>
							 <input type="hidden" name="price" value=${show.price }
>
							</div>
							<div>
								 <input type="hidden" name="count" value=${show.count}>
							</div>
							<div>
							<span>单价：&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp<label></label></span> <input type="text" name="xianshicount" placeholder=${show.price }  readonly>
							
						</div>
						<div>
							<span>产品数量：<label></label></span> <input type="text" name="xianshicount" placeholder=${show.count}  readonly>
							
						</div>
						<div>
								<span>颜色： &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<label></label></span> <input type="text"
									name="productcolor" placeholder=${show.color } readonly>
									
							</div>
						<div>
								<span>尺寸大小：<label></label></span> <input type="text"
									name="productsize" placeholder=${show.size } readonly>
									
							</div>	
                         <div class="center-block">
						<input type="submit" value="结算" />
						<li><a href="/myshop/cart/delectproincart?incartproId=${show.oid}">从购物车中删除此商品</a></li> <br></div>
						
			</form>
	
		</c:forEach>    
	 </div>
	 </div> 
	 </div>
	  
			
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>

</body>


</html>