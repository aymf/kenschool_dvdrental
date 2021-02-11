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
<style type="text/css">
.error {
	color: #FF0000;
}
</style>
</head>
<body>
	<h1>会員削除</h1>
	<hr />
	<p><a href="menu">メニューへ戻る</a></p>
	<hr />
	<p>下記アカウントを削除します。</p>
	<form:form>
		<table>
		<tr>
			<td>会員ID</td>
			<td>
				<c:out value="${deleteMembersData.member_id}" />
				<input type="hidden" value="${deleteMembersData.member_id}" name="member_id" />
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>名前</td>
			<td><c:out value="${deleteMembersData.member_name}" /></td>
		</tr>
		<tr>
			<td>携帯番号</td>
			<td><c:out value="${deleteMembersData.member_phone}" /></td>
		</tr>
		<tr>
			<td>メールアドレス</td>
			<td><c:out value="${deleteMembersData.member_email}" /></td>
		</tr>
		<tr>
			<td>パスワード</td>
			<td><c:out value="${deleteMembersData.member_password}" /></td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="削除" />
			</td>
		</tr>
		</table>
	</form:form>
	<p class="error">${errorMessage}</p>
</body>
</html>