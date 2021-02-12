<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>お客様用トップページ</title>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>初心者向けホームページテンプレート tp_beginner6</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="DVDレンタルサイト">
<meta name="keywords" content="キーワード１,キーワード２,キーワード３,キーワード４,キーワード５">
<link rel="stylesheet" href="css/style.css">

<!-- css -->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css"></link>
<!-- javascript -->
<script src="<c:url value="/resources/js/fixmenu_pagetop.js" />" type="text/javascript"></script>


<script src="js/fixmenu_pagetop.js"></script>
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
// $(function(){
$('a[href^="#"]').click(function() {
var speed = 800;
var href= $(this).attr("href");
var target = $(href == "#" || href == "" ? 'html' : href);
var position = target.offset().top;
$('body,html').animate({scrollTop:position}, speed, 'swing');
return false;
});

</script>
</head>

<body>



<header>
<h1 id="logo"><a href="company"><img src="<c:url value="/resources/images/logo.png" />" alt="Music Life Agency"></a></h1>
<nav id="menubar">
<ul>
<li><a href="allGoodsList">Search</a></li>
<li><a href="memberList">Account</a></li>
<li><a href="#service">Service</a></li>
<li><a href="#contact">Contact</a></li>
</ul>
</nav>
</header>

<div id="container">

<div id="contents">


<section id="service">

<h2>Service</h2>

<div class="list">
<img src="<c:url value="/resources/images/sample1.jpg" />" alt="">
<h4>よくあるご質問</h4>
<p><li><a href="question">お客様の声</a></li></p>
</div>

<div class="list">
<img src="<c:url value="/resources/images/sample2.jpg" />" alt="">
<h4>レンタルプラン</h4>
<p>
お試しプラン：月額324円 (新規登録月限定)<br />
Bronzeプラン：月額1,080円<br />
Silverプラン：月額2,160円<br />
Goldプラン    ：月額5,400円
</p>
</div>

<div class="list">
<img src="<c:url value="/resources/images/sample4.jpg" />" alt="">
<h4>ネット宅配レンタル</h4>
<p>
<li><a href="rental">CD、DVD、Blu-rayをネットで借りる</a></li><br />
ご自宅までお届け 返却はポストでOK（送料無料）
</p>
</div>

</section>
<!--/#service-->

<section id="contact">

<h2>Contact</h2>
<p class="c">お問い合わせは以下までお願い致します。</p>
<p class="c"><span class="big1">092-713-5561</span><br>
定休日：年中無休<br>
店舗営業時間：24時間</p>
<p class="c"><img src="<c:url value="/resources/images/sample1.jpg" />" alt="" width="300"></p>

</section>
<!--/#contact-->

</div>
<!--/#contents-->

</div>
<!--/#container-->

<footer>
<small>Copyright&copy; <a href="index.html">Music Life Agency</a> All Rights Reserved.</small>
<span class="pr">《<a href="https://template-party.com/" target="_blank">Web Design:Template-Party</a>》</span>
</footer>

<!--ページの上部に戻る「↑」ボタン-->
<p class="nav-fix-pos-pagetop"><a href="#">↑</a></p>

</body>
</html>
