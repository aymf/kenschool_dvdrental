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
	color: #FF0000;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>会員登録</h1>
	<hr />
	<p><a href="customerMenu">メニューへ戻る</a></p>
	<hr />
	<form:form modelAttribute="membersModel">
		<table>
		<tr>
			<td>名前</td>
			<td><form:input path="member_name" size="50" /></td>
			<td><form:errors path="member_name" element="div" cssClass="error" /></td>
		</tr>
		<tr>
			<td>携帯番号</td>
			<td><form:input path="member_phone" size="20" /></td>
			<td><form:errors path="member_phone" element="div" cssClass="error" /></td>
		</tr>
		<tr>
			<td>メールアドレス</td>
			<td><form:input path="member_email" size="50" /></td>
			<td><form:errors path="member_email" element="div" cssClass="error" /></td>
		</tr>
		<tr>
			<td>パスワード</td>
			<td><form:input path="member_password" size="50" /></td>
			<td><form:errors path="member_password" element="div" cssClass="error" /></td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="登録" name="memberList" />
				<input type="submit" value="リセット" name="memberReset" />
			</td>
		</tr>
		</table>
	</form:form>
	<p class="error">${errorMessage}</p>
</body>
</html>