<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
.error {
	color: #ff0000;
}
td {
	width: 300px;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>あいまい作品検索</h1>
	<hr />
	<div>
		<form:form modelAttribute="rentalGoodsModel">
			<form:input path="vagueField" size="50" />&nbsp;
			<input type="submit" value="検索" />
			<form:errors path="*" element="div" cssClass="error" />
		</form:form>
	</div>
	<hr />
	<div>
		<a href="menu">MENUへ</a>
	</div>
	<hr />
	<div>
		<c:out value="${title}" />
		<c:if test="${vagueGoodsList.size() > 0}" >
		<hr />
		<table border="1">
			<tr><th>商品ID</th><th>商品名</th><th>商品名(全角カナ)</th><th>商品カテゴリID</th></tr>
			<c:forEach var="goods" items="${vagueGoodsList}">
			<tr>
				<td><c:out value="${goods.goods_id}" /></td>
				<td><c:out value="${goods.goods_name}" /></td>
				<td><c:out value="${goods.goods_kana}" /></td>
				<td><c:out value="${goods.goods_category_id}" /></td>
			</tr>
			</c:forEach>
			</table>
		</c:if>
		<c:if test="${vagueGoodsList.size() == 0}" >
		<hr />
		<p>
			no data...
		</p>
		</c:if>
	</div>
</body>
</html>