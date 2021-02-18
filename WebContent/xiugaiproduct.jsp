<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="cccccc">
	<form action="/myshop/manager/toxiugaiProduct" method="post" enctype="multipart/form-data">
	产品类型：<select name="pt">

			<c:forEach items="${pts }" var="pt">
				<c:if test="${pt.id!=product.producttypeid }"><option value="${pt.id }">${pt.name }</option></c:if>
				<c:if test="${pt.id==product.producttypeid }"><option value="${pt.id }" selected="selected">${pt.name }</option></c:if>
			</c:forEach>
			</select><br>
			<input type="hidden" name="id" value=${product.id}><br>
			名称：&nbsp&nbsp&nbsp<input type="text" name="name" value="${product.name}"/><br>
			描述：&nbsp&nbsp&nbsp<input type="text" name="description" value="${product.description}" /><br>
			原价：&nbsp&nbsp&nbsp<input type="text" name="price" value="${product.price}"/><br>
			优惠价：<input type="text" name="discountprice" value="${product.discountprice}"/><br>
			颜色（注意：要求输入英文；若有多种颜色，以逗号隔开输入）：<input type="text" name="color" value="${productcolor }"/><br>
			

		   

			
			
			尺寸 （注意：若有多种尺寸，以逗号隔开输入）：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="size" value="${productsize}" /><br>
			封面图片：<input type="file" name="listimg" /><img src="${ctx }/static/${product.listimg }" width="100px" height="100px"/><br>
			详情图片：<input type="file" name="img1"  /><img src="${ctx }/static/${product.img1 }" width="100px" height="100px"/><br>
			<input type="submit" value="修改">
	</form>
</body>
</html>