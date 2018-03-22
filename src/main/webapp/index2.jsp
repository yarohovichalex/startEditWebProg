<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>first page</title>
</head>
<body>
	<header>
    	<h1>Welcome to our library</h1>
    	<h3>login to get the necessary access rights</h3>
    	<div class="subscribe">
	    	<form action="SimpleServlet" method="post">
	    		<input type = "hidden" name="action"  value = "action">
	    	    <input type="text" name="login" placeholder="enter your login" required>
	    	    <input type="password" name="password" placeholder="enter password" required>
	     	    <input type="submit" value="check in">
	   		 </form>
       
    </div>
        <p>*You can not use without registering.</p>
        	<article class="qqq">
	<h2>Сайт молодежного служения церкви Добрая Весть</h2>
	<span><p class="event">Каждое воскресенье вечером в 17.00, в нашей Церкви собирается молодежь, 
	мы читаем Библию, молимся, рассуждаем о Боге, и просто общаемся за чашкой вкусного чая.
Если тебе это интересно, то ты также можешь придти, и провести это время вместе с нами!
Мы ждем каждого!
Приходи!
Будем рады видеть тебя!</p>
<p class="event">Имя Иисуса Христа несет в себе глубочайший смысл, являясь своеобразным кратким символом христианской веры.
 Иисус – греческая форма еврейского слова «Иешуа», что значит помощь Бога, или Спаситель. 
 Христос – греческое слово, означающее «Помазанник», на еврейском звучащее как Машиах – Мессия.</p>
</span>
	</article>

</header>
    
<section>
    <article>
       
    </article>
</section>
</body>
</html>