package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet/bmi")
public class BMIServlet extends HttpServlet{
	
	//b. 再生成一個doGet寫上errorMessage訊息
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setAttribute("errorMessage", "本網頁不支援 GET 請求");
		req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
	}

	@Override
	/*
		!!!注意!!! 前端HTML(index.jsp)的method=post對應後端(BMIServlet.java)的doPost；Post用法: 輸入的資料(參數)，被夾帶著，不會顯示在網址上
		!!!注意!!! 前端HTML(index.jsp)的method=get對應後端(BMIServlet.java)的doGet；Get用法: 輸入的資料(參數)，參數會被顯示在網址上
	*/
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException // a. 這裡改doPost，index.jsp，<form method="post"也要改
	//protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{	
		//1. 接收請求參數(Parameter)
			String height = req.getParameter("h");
			String weight = req.getParameter("w");
		
		//2. 判斷是否有收到參數 ?
			if(height == null || weight == null) 
			{
				System.out.println("請輸入身高或體重的資料"); // 會印在 Tomcat Console 中
				req.setAttribute("errorMessage", "請輸入身高或體重的資料");
				req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
				return;
			}
			
		//3. 將 height 與 weight 轉 double
			double h = Double.parseDouble(height);
			double w = Double.parseDouble(weight);
		
		//4. 計算 bmi
			//BMI值計算公式: BMI = 體重(公斤) / 身高2(公尺2)，身高要/100轉換成公尺
			double bmi = w/Math.pow(h/100, 2);
			
		//5. 印出 bmi 
			System.out.println("bmi: " + bmi);
		/*1.~5. 步驟做完後可以執行http://localhost:8080/JavaWeb/servlet/bmi?h=170&w=60，bmi資料會出現在下方console*/
		
		//6. 將要傳送給 jsp 的資料放到 req 的屬性中 
			req.setAttribute("height", h);
			req.setAttribute("weight", w);
			req.setAttribute("bmi", bmi);
		
		//7. forward 到 display_bmi.jsp
			//req.getRequestDispatcher("/display_bmi.jsp").forward(req, resp);
			
			//把display_bmi.jsp放進WEB-INF底下的view資料夾後
			req.getRequestDispatcher("/WEB-INF/view/display_bmi.jsp").forward(req, resp);

			
	}

}
