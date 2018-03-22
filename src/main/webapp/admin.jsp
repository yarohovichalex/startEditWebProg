<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style1.css" />
<title>Second Page</title>
</head>
<body>
	<p>Admin page</p>

	<header>
		<h1>First library</h1>
		<h3>search book</h3>
		<div class="subscribe">
			<div id="editedit" class="editBook">
				<form action="SimpleServlet" name="editBook" method="post">
			   		<input type = "hidden" name="action" value = "edit" maxlength="24">
					<input type="text" name="editedit" placeholder="edit name book" maxlength="24" required></br>
					<input type="text" name="editAuthor" value="<c:out value="${author_value1}"/>" required></br>
					<input type="text" name="editYear" placeholder="edit year" pattern="[0-9]{4}" required></br>
					<input type="submit" value="edit me now">
				</form>
			</div>
			<form action="SimpleServlet" method="post">
				<input type="hidden" name="action" value="output"> 
				<input type="submit" value="output ">
			</form>
			<form action="SimpleServlet" method="post">
				<input type="hidden" name="action" value="search"> 
				<input type="search" name="search" placeholder="search for name book" required> 
				<input type="submit" value="search ">
			</form>

			<form action="SimpleServlet" method="post">
				<input type="hidden" name="action" value="add"> <input
					type="text" name="addName" placeholder="add name book" required>
				<input type="text" name="addAuthor" placeholder="add name author"
					required> <input type="date" name="publishDate" required>

				<input type="submit" value="add">
			</form>
		</div>
		<p>*You can not use without registering.</p>

		<div class="book">
			<p>список книг</p>
			<form action="SimpleServlet" method="post">

				<c:out value="${user_name}"></c:out>
				<c:forEach var="val" items="${listbook}">

					<div class="bookStyle">
						<p>${val.getId()}</p>				    		 
						<p>${val}</p>
						<form action="SimpleServlet" method="post">
							<input type="hidden" name="action" value="delete"> 
							<input type="hidden" name="book_id" value="${val.getId()}"> 
							<input type="submit" value="delete">
						</form>
						<form action="SimpleServlet" method="post">
							<input type="hidden" name="action" value="ToEdit"> 
							<input type="hidden" name="BookNameIntoEditPage" value="${val.tittle}"> 
							<input type="hidden" name="AuthorNameIntoEditPage" value="${val.authorName}">
							<input type="hidden" name="PrintDateIntoEditPage">							
							<input type="hidden" name="BookIdIntoEditPage" value="${val.getId()}">
							<input type="submit" onclick="edit" value="ToEdit">
													
						</form>
						<form action="SimpleServlet" method="post">
							<input type="hidden" name="action" value="onForm"> 							
							<input type = "button" onclick="editForm()" value="редактировать">
							<input type = "button" onclick="closeForm()" value="закрыть">
						</form>
						<div id="editedit" class="editBook">
							<form action="SimpleServlet" name="editBook" method="post">
						   		<input type = "hidden" name="action" value = "edit" maxlength="24">
								<input type="text" name="editedit" placeholder="edit name book" maxlength="24" required></br>
								<input type="text" name="editAuthor" value="<c:out value="${author_value1}"/>" required></br>
								<input type="text" name="editYear" placeholder="edit year" pattern="[0-9]{4}" required></br>
								<input type="submit" value="edit me now">
							</form>
						</div>
							
												
					</div>

				</c:forEach>
				<div id="render"></div>
			</form>
			<p></p>
			<p></p>			
			<div class="coment">
				<form action="upload" method="post" enctype="multipart/form-data">
					<input type="file" name="file"></br>
					<textarea cols="50" row="5" wrap="soft" ></textarea>
					<button type="submit">Sub</button>
				</form>
			</div>
		</div>

	</header>
	<script type="text/javascript">
	function editForm(){	
		var form=document.getElementById("editedit");
		form.style.display="inline-block"
		}
	function closeForm(){
		var form=document.getElementById("editedit");
		form.style.display="none";
	}
</script> 




</body>
</html>