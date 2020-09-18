
<%@page import="java.util.ArrayList" %>
<%@page import="bean.Keigiban_bean" %>
<%@page import="dao.Keigiban_dao" %>
<%@page import="dao.Admin_dao" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者画面</title>
</head>
<body>
<a href="/keigiban/Main">戻る</a><br>
<form action="/keigiban/adminsub" method="get">
		<h1>削除する投稿の情報を入力してください</h1><br>
		番号：<input type="text" name="id"><br>
		投稿者名：<input type="text" name="name"><br>
			<input type="submit" value="削除">
	</form>
<br>
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