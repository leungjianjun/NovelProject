<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Chapter</title>
    <meta name="title" content="" />
    <meta name="description" content="中国最大、资源最全、广告最少的免费在线小说、文学阅读网站。拥有各类小说：修真小说、玄幻小说....。然你享受最好的小说阅读体验" />
    <meta name="keywords" content="在线免费小说" />
    <!--<link rel="search" type="application/opensearchdescription+xml" href="http://search.taobao.com/opensearch.xml" title="淘宝购物" />  -->
    <link rel="shortcut icon" href="<c:url value="/resources/ico/favicon.ico"/>" />
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value="/resources/ico/apple-touch-icon-144-precomposed.png"/>" >
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value="/resources/ico/apple-touch-icon-114-precomposed.png"/>" >
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value="/resources/ico/apple-touch-icon-72-precomposed.png"/>" >
    <link rel="apple-touch-icon-precomposed" href="<c:url value="/resources/ico/apple-touch-icon-57-precomposed.png"/>" >

    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2-min.js"/>" ></script>
    <link href="<c:url value="/resources/css/global.css"/>" rel="stylesheet">
</head>
<body style="background-color:#EEFAEE">
<!-- Navbar
    ============================================================ -->
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <div class="nav-collapse collapse">
                    <ul class="nav">
                        <li class="active">
                            <a href="./index.html">Home</a>
                        </li>
                        <li class="">
                            <a href="./getting-started.html">Get started</a>
                        </li>
                        <li class="">
                            <a href="./scaffolding.html">Scaffolding</a>
                        </li>
                        <li class="">
                            <a href="./base-css.html">Base CSS</a>
                        </li>
                        <li class="">
                            <a href="./components.html">Components</a>
                        </li>
                        <li class="">
                            <a href="./javascript.html">Javascript</a>
                        </li>
                        <li class="">
                            <a href="./customize.html">Customize</a>
                        </li>
                    </ul>
                </div><!-- .collapse END -->
            </div>
        </div><!-- .navbar-inner END-->
    </div><!-- .navbar END -->
    <header>
        <div class="container">
            <img src="/resources/temp/1.jpg" />
        </div><!-- .container END-->
        <div class="container">
            <ul>
                <li class="home"><a href=""></a></li>
            </ul>
        </div>
    </header>
    <div class="container">
        <div class="row">
            <div class="span10">
                <div class="page-header">
                    <h2>${chapter.title}</h2>
                    <h5 class="muted">小说：<a>${book.name}</a>&nbsp;|&nbsp;作者:<a>${book.author.nicename}</a>&nbsp;|&nbsp;更新时间:${chapter.updateTime4Display()}</h5>
                </div>
                <div class="book-content">
                    ${chapter.content}
                </div>

            </div>
            <div class="span2"></div>
        </div><!-- .row -->
    </div><!-- .container -->
</body>
</html>