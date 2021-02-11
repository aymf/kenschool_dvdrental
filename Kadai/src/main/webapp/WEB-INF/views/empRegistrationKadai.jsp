<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>顧客管理登録画面</title>
<style type="text/css">
.error {
	color: #ff0000;
}
</style>
</head>
<body>
<div align="center">
	<h1>アカウント登録画面</h1>
	<hr />
	<form:form modelAttribute="employeeModel">
	<table width="1000">
	<tr>
		<td>氏名</td>
		<td><form:input path="name" size="50" /></td>
		<td><form:errors path="name" element="div" cssClass="error" /></td>
	</tr>
	<tr>
		<td>フリガナ</td>
		<td><form:input path="kana" size="50" /></td>
		<td><form:errors path="kana" element="div" cssClass="error" /></td>
	</tr>
	<tr>
		<td>性別</td>
		<td>
			<form:radiobutton path="gender" label="男" value="man" checked="true" />
			<form:radiobutton path="gender" label="女" value="woman" />
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>生年月日</td>
		<td>
			<form:select path="bYear" items="${bYear}" itemLabel="label" itemValue="data" />年&nbsp;
			<form:select path="bMonth" items="${bMonth}" itemLabel="label" itemValue="data" />月&nbsp;
			<form:select path="bDay" items="${bDay}" itemLabel="label" itemValue="data" />日
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>郵便番号</td><td><form:input path="zip" size="10" /></td>
		<td><form:errors path="zip" element="div" cssClass="error" /></td>
	</tr>
	<tr>
		<td>住所</td><td><form:input path="address" size="100" /></td>
		<td><form:errors path="address" element="div" cssClass="error" /></td>
	</tr>
	<tr>
		<td>携帯番号</td><td><form:input path="phone" size="15" /></td>
		<td><form:errors path="phone" element="div" cssClass="error" /></td>
	</tr>
	<tr>
		<td>メールアドレス</td><td><form:input path="mail" size="50" /></td>
		<td><form:errors path="mail" element="div" cssClass="error" /></td>
	</tr>
	<tr>
		<td colspan="3">
			<input type="submit" value="確認" />
		</td>
	</tr>
	</table>
	</form:form>
</div>
</body>
</html>