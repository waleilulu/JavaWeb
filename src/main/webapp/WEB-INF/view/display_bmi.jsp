<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>顯示 BMI 結果頁面</title>
	</head>
	<body>
		<fieldset>
			<legend>計算結果</legend>
				身高: <%=request.getAttribute("height")%></p>
				體重: <%=request.getAttribute("weight")%></p>
				BMI值計算公式: BMI = 體重(公斤) / 身高的平方(公分換算成公尺後的平方)</p>
				BMI: <%=request.getAttribute("bmi")%></p>
				
				<a href="/JavaWeb/index.jsp">回首頁</a>
		</fieldset>
	</body>
</html>