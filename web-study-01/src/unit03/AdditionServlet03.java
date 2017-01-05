package unit03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 로직과 표현을 분리하여 프로그래밍 하는 것을 MVC 패턴이라고 한다. 
// 서블릿이 비즈니스 로직을 구현하는 Model 역할을 하고 , 
// JSP가 결과를 출력하는 View 역할을 한다. 

@WebServlet("/AdditionServlet03")
public class AdditionServlet03 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//num1 과 num2 두 수의 합을 구하는 자바코드를 기술
		int num1 = 20; 
		int num2 = 10; 
		int add = num1+num2; 
		
		//request 객체의 속성값으로 저장한 후 
		request.setAttribute("num1", num1);
		request.setAttribute("num2", num2);
		request.setAttribute("add", add);
		
		//서버상에서 페이지가 이동되는 포워드 방식으로 addition03.jsp페이지로 이동
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("addition03.jsp");
		dispatcher.forward(request, response);
	}

}
