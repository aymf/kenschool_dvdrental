<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>顧客管理登録確認画面</title>
</head>
<body>
<div align="center">
	<h1>アカウント登録確認画面</h1>
	<hr />
	<form:form modelAttribute="employeeModel">
	<table width="1000">
	<tr>
		<td>氏名</td>
		<td>${name}</td>
	</tr>
	<tr>
		<td>フリガナ</td>
		<td>${kana}</td>
	</tr>
	<tr>
		<td>性別</td>
		<td>${gender}</td>
	</tr>
	<tr>
		<td>生年月日</td>
		<td>${bYear}年&nbsp;${bMonth}月&nbsp;${bDay}日</td>
	</tr>
	<tr>
		<td>郵便番号</td><td>${zip}</td>
	</tr>
	<tr>
		<td>住所</td><td>${address}</td>
	</tr>
	<tr>
		<td>携帯番号</td><td>${phone}</td>
	</tr>
	<tr>
		<td>メールアドレス</td><td>${mail}</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="登録" />
		</td>
	</tr>
	</table>
	</form:form>
</div>
</body>
</html>