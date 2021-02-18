<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="cccccc">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="white">
	<form action="/myshop/manager/postaddProduct" method="post" enctype="multipart/form-data">
	产品类型：<select name="pt">
			<c:forEach items="${pts }" var="pt">
				<option value="${pt.id }">${pt.name }</option>
			</c:forEach>
			</select><br>
			名称：&nbsp&nbsp&nbsp<input type="text" name="name" /><br>
			描述：&nbsp&nbsp&nbsp<input type="text" name="description" /><br>
			原价：&nbsp&nbsp&nbsp<input type="text" name="price" /><br>
			优惠价：<input type="text" name="discountprice" /><br>
			颜色（注意：要求输入英文；若有多种颜色，以逗号隔开输入）：<input type="text" name="color" /><br>
			尺寸 （注意：若有多种尺寸，以逗号隔开输入）：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="size" /><br>
			封面图片：<input type="file" name="listimg" /><br>
			详情图片：<input type="file" name="img1" /><br>
			<input type="submit" value="新增">
	</form>
</body>
</html>