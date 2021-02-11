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
	<h1>全件検索</h1>
	<hr />
	<div>
		<form:form modelAttribute="rentalGoodsModel">
		  <form:radiobutton path="selectRadio" label="カテゴリ一覧" value="categories" checked="true" />&nbsp;
			<form:radiobutton path="selectRadio" label="作品一覧" value="goods" />&nbsp;
			<input type="submit" value="検索" />
			<form:errors path="*" element="div" cssClass="error" />
		</form:form>
	</div>
	<hr />
	<p><a href="menu">メニューへ戻る</a></p>
	<hr />
	<div>
		<c:out value="${title}" />
		<c:if test="${categoriesAllGoodsList != null}" >
		<hr />
		<table border="1">
		<tr><th>商品カテゴリ名</th><th>商品名</th></tr>
		<c:forEach var="categories" items="${categoriesAllGoodsList}">
			<c:forEach var="goods" items="${categories.goods}">
				<tr>
					<td><c:out value="${categories.goods_category_name}" /></td>
					<td><c:out value="${goods.goods_name}" /></td>
					
				</tr>
			</c:forEach>
		</c:forEach>
		</table>
		</c:if>
		<c:if test="${goodsAllGoodsList != null}" >
		<hr />
		<table border="1">
		<tr><th>商品ID</th><th>商品名</th><th>商品名(全角カナ)</th></tr>
		<c:forEach var="goods" items="${goodsAllGoodsList}">
			<tr>
				<td><c:out value="${goods.goods_id}" /></td>
				<td><c:out value="${goods.goods_name}" /></td>
				<td><c:out value="${goods.goods_kana}" /></td>
			</tr>
		</c:forEach>
		</table>
		</c:if>
	</div>
</body>
</html>