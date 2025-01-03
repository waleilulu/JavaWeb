package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.Beverage;

@WebServlet("/servlet/beverage")
public class BeverageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//導到分派器 forward 到指定 jsp - index.jsp按進來之後，導向到飲料店購單表格
		req.getRequestDispatcher("/WEB-INF/view/beverage_form.jsp").forward(req, resp);
		
		//如果要讓servlet直接呈現view(.jsp)的結果可以用以下方式，就不要用上面的分派器。(二選一，但請使用上方的分派器)
		
		/*
		resp.getWriter().print("<!DOCTYPE html>");
		resp.getWriter().print("<html>");
		resp.getWriter().print("<head>");
		resp.getWriter().print("<meta charset=\"UTF-8\">");
		resp.getWriter().print("<title>飲料訂購單</title>");
		resp.getWriter().print("</head>");
		resp.getWriter().print("<body>");
		resp.getWriter().print("<form method=\"post\" action=\"/JavaWeb/servlet/beverage\">");
		resp.getWriter().print("<fieldset>");
		resp.getWriter().print("<legend>飲料訂購單</legend>");
		resp.getWriter().print("姓名: <input type=\"text\" name=\"userName\" required /><p />");
		resp.getWriter().print("電郵: <input type=\"email\" name=\"email\" required /><p />");
		resp.getWriter().print("</fieldset>");
		resp.getWriter().print("</form>");
		resp.getWriter().print("</body>");
		resp.getWriter().print("</html>");
		*/
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 編碼 !!!重要!!!
		req.setCharacterEncoding("UTF-8"); //如果是全英文的話就不需要編碼，但如果會有中文就要寫上UTF-8
		
		//2. 接收表單填寫完後的資料
		String userName = req.getParameter("userName"); //Parameter裡面帶的資料為input裡面name的資料
		String email = req.getParameter("email");
		String orderDate = req.getParameter("orderDate");
		String amount = req.getParameter("amount"); // 數量
		String beverageName = req.getParameter("beverageName");
		String ice = req.getParameter("ice");
		String sugar = req.getParameter("sugar");
		String[] additionalArray = req.getParameterValues("additional"); //複選要用陣列，後面帶上getParameterValues
		String memo = req.getParameter("memo");
		
		//3. 計算飲料價格(預設飲料一杯 30 元)
		int totalPrice = 30 * Integer.parseInt(amount);
		
		//4. 建立 entity 用來存放要傳遞給 jsp 的資料 (創一個物件，把所有參數放進去)
		Beverage beverage = new Beverage(userName, email, orderDate, amount, beverageName, ice, sugar, additionalArray, memo, totalPrice);
		
		//5. 將 beverage 放到 request 屬性中, 目的是要傳遞給 jsp 使用
		req.setAttribute("beverage", beverage);
		
		//6. 導到分派器 forward 到指定 jsp - beverage_checkout.jsp按進來之後，導向到飲料店購單表格
		req.getRequestDispatcher("/WEB-INF/view/beverage_checkout.jsp").forward(req, resp);
	}
}