<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>My WebPage</title>
	</head>
	<body>
		現在時刻: <%=new Date()%>
		<hr/>
		<form method="post" action="/JavaWeb/servlet/bmi">
		<!--<form method="get" action="/JavaWeb/servlet/bmi">-->
			<fieldset>
				<legend>BMI 計算</legend>
				身高:　<input type="number" name="h" placeholder="請輸入身高" required><p/>
				體重:　<input type="number" name="w" placeholder="請輸入體重" required><p/>
				<button type="reset">重置</button>
				<button type="submit">送出</button>
			</fieldset>
		</form>
		<hr/>
		<a href="/JavaWeb/servlet/beverage" title="按我一下可以訂購飲料">飲料訂購單</a>
	</body>
</html>