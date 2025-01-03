<%@page import="java.util.Arrays"%>
<%@page import="model.entity.Beverage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% Beverage beverage = (Beverage)request.getAttribute("beverage");%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>飲料結帳單</title>
	</head>
	
	<body>
		<div>
			<fieldset>
				<legend>飲料訂購單</legend>
				姓名: <%=beverage.getUserName() %> <p />
				電郵: <%=beverage.getEmail() %><p />
				日期: <%=beverage.getOrderDate() %><p />
				數量: <%=beverage.getAmount() %><p />
				品名: <%=beverage.getBeverageName() %><p />
				冰塊: <%=beverage.getIce() %><p />
				甜度: <%=beverage.getSugar() %><p />
				配料: <%=Arrays.toString(beverage.getAdditionalArray()) %><p />
				備註:	 <%=beverage.getMemo() %><p />
				----------------------<br>
				金額: <%=beverage.getTotalPrice() %> <p />
				<hr>
				
				EL語法呈現方式，之後會再說明<p /> 
				<!-- EL語法 -->
				姓名: ${ beverage.userName } <p /> 
				電郵: ${ beverage.email } <p />
				日期: ${ beverage.orderDate }<p />
				數量: ${ beverage.amount }<p />
				品名: ${ beverage.beverageName }<p />
				冰塊: ${ beverage.ice }<p />
				甜度: ${ beverage.sugar }<p />
				配料: ${ beverage.additionalArray }<p /> <!--  這個老師之後會在教如何使用標籤方式轉換 -->
				備註:	 ${ beverage.memo }<p />
				----------------------<br>
				金額: ${ beverage.totalPrice }<p />
				
			</fieldset>
			<a href="/JavaWeb/servlet/beverage" title="按我一下可以訂購飲料">回飲料訂購單</a>
		</div>
	</body>
</html>