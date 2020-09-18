
<%@page import="java.util.ArrayList" %>
<%@page import="bean.Keigiban_bean" %>
<%@page import="dao.Keigiban_dao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板</title>
</head>
<body>

<a href="/keigiban/admin"type="button">管理者画面</a>
<br>【投稿】<br>

<form  action="/keigiban/Main"method="post">
投稿者名<br>
<input type="text" name="name"><br>
内容(400字まで)<br>
<textarea name="content" rows="10" cols="80" maxlength = "400"></textarea><br>


メールアドレス<br>
<input type="email" name="mail"><br>


<input type="submit" value="送信">

</form>

<p>----------------------------------------------------------------------------------------</p>

	<h1>投稿一覧</h1>
<table border="1">
		<tr>
			<th>番号</th>
			<th>投稿者</th>
			<th>内容</th>
			<th>投稿時間</th>

		</tr>
		<%
	ArrayList<Keigiban_bean> list = (ArrayList<Keigiban_bean>)request.getAttribute("list");
	for(int i = 0 ; i < list.size() ; i++){
		Keigiban_bean toukou = list.get(i);
	%>
		<tr>
			<td width="50" height="8"><%=toukou.getId() %></td>
			<td width="250" height="8"><%=toukou.getName() %></td>
			<td width="2150" height="8"><%=toukou.getContent() %></td>
			<td width="50" height="8"><%=toukou.getTime() %></td>

		</tr>
		<%
	}

	%>

	</table>

</body>
</html>