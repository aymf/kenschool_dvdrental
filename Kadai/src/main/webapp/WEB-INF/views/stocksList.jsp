<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

<div>
	<form:form modelAttribute="stocksModel">
		<form:radiobutton path="selectRadio" label="在庫一覧" value="stock" />&nbsp;
		<input type="submit" value="検索" />
	</form:form>
</div>

<div>
		<c:out value="${title}" />
		<c:if test="${stocksList != null}" >
		<hr />
		<table border="1">
		<tr><th>商品名</th><th>在庫数</th></tr>
		<c:forEach var="goods" items="${goodsList}">
			<c:forEach var="stocks" items="${stocks.goods}">
				<tr>
					<td><c:out value="${goods.goods_name}" /></td>
					<td><c:out value="${stocks.stock_quantity}" /></td>
				</tr>
			</c:forEach>
		</c:forEach>
		</table>
		</c:if>
</div>
	
	<hr />
	<p><a href="customerMenu">MENUへ戻る</a></p>

</body>
</html>