package unit01;

import java.io.IOException; //doGet메소드의 throws 절에서 IOException을 사용했기에 임포트한다. 
import java.io.PrintWriter; //클라이언트 결과를 출력하기 위한 out 객체를 PrintWriter클래스로 선언했기 때문에 PrintWriter를 임포트한다.

//doGet 과 doPost 메소드를 사용하기 위한 임포트문들
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; //HttpServlet 클래스를 사용하기 위해 임포트한다.
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddtionServelet01
 */
//※ 서블릿은 자바 코드 안에 HTML 코드가 들어가는 구조임!!

//서블릿은 Server + Applet의 합성어 ! : 서버에서 실행되는 Applet : 웹브라우저 에서 html 태그를 통해서 동작하는 동적 프로그램.
//자바를 이용해서 웹에서 실행되는 프로그램을 작성하는 기술을 말한다. 
//자바의 문법적인 형태를 그대로 닮은 서블릿!

@WebServlet("/AddtionServelet01") //WebServlet을 사용하기 위해 임포트한다. 
//서블릿을 요청할 때 직접 클래스를 요청하는 것이 아니고, @WebServlet() 안에 기술된 URL에 요청한다. 
//HttpServlet웹어플리케이션으로 동작하도록하는 기본 동작 즉 요청에 대한 응답이 가능하도록 하는 내용이 기술 되어있기때문에 상속 받아야한다.
public class AddtionServelet01 extends HttpServlet { 
	//필드
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	//생성자
    public AddtionServelet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // 메소드
    // 서블릿이 요청을 받으면 이벤트 처리 방식으로 자동으로 호출되는 메소드이다. 
    // HttpServlet에 정의된 메소드(doGet, doPost)인데, 이를 오버라이딩해서 개발자의 요청이 있을 경우 어떤 처리를 해야하는지 명시해 주어야한다. 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //입출력시 예외 처리
		
		int num1 = 20; 
		int num2 = 10; 
		int add = num1 + num2; 
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Addition</title></head>");
		out.println("<body>");
		out.println(num1+" + "+num2+" = "+add);
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//웹프로그래밍에서 가장 중요한건 클라이언트가 서버에 어떻게 요청하는 지이다. 
	//서블릿의 동작 방식 이해하기!
	// 클라이언트가 서버에 요청하는 법은 두가지 방식이 있다. ( get 방식 / post 방식 )
	
	//01. get 방식 >> 주소 창을 타고 넘어가기 때문에 서버로 보내는 데이터를 사용자가 그대로 볼 수 있다. 그래서 보안에 취약함 . 255이하의 적은 양의 데이터를 전송한다. 
	//02. post 방식 >> html header를 타고 넘어가기 때문에 보안에 강하다. 255자 이상의 대용량의 데이터를 전송한다. 
	
	//클라이언트는 보통 <form> 태그를 이용해서 서버에 무엇인가를 전달하거나 요청을 하게 된다. 
	/*
		<form action="CallServlet"> 요청할 서블릿작성
			<input type="submit" value="전송"> 클릭하면 서블릿이 요청된다. 
		</form>
	 */
	
	//<form> 태그가 서블릿으로 요청할 때는 get과 post 두 가지 전송 방식 중 한가지로 전송된다. 
	//mothod 속성 값으로 get을 적으면 doGet() 메소드가, post를 적으면 doPost() 메소드가 호출된다. 
	
	//폼태그에 서블릿 이름을 써 놓으면 서버에서는 WAS(톰캣엔진)가 확장자가 운영체제와 같은 시스템 프로그래밍이므로 .class인 파일을 톰캣이 가지고 있다가 요청이 들어오면 해당 서블릿 클래스들을 찾아서 실행
	/*
	 --------------> get방식 <-----------------------
	<form method="get" action="CallServlet"> 요청할 서블릿작성
		<input type="submit" value="전송"> 클릭하면 서블릿이 요청된다. 
	</form>
	
	 --------------> post방식 <------------------------
	<form method="post" action="CallServlet"> 요청할 서블릿작성
		<input type="submit" value="전송"> 클릭하면 서블릿이 요청된다. 
	</form>
	 
	 */
	
	//!--method 속성을 생략한 채 전송 방식을 결정하지 않으면 기본값인 get방식으로 요청한다. 
	
	//일반적인 폼(로그인처리같은)에서는 보통 보안에 취약한 get방식보다는 post방식을 많이 쓴다. 
	//<a>태그를 통해서 하이퍼링크를 통해서 서버가 요청되는 경우에는 get방식으로 요청된다. 
	//doGet 메소드는 예외를 외부로 처리하도록 만들어놓음 ServletException과 IOException 
	//doGet 메소드는 두개의 매개 변수를 갖는다. HttpServletRequest 와 HttpServletResponse
	//HttpServletRequest는 클라이언트의 요청을 처리 (request)
	//HttpServletResponse는 요청 처리 결과를 클라이언트에게 되돌리기(응답하기 response)
	//서버가 요청에 대한 처리 결과를 마치고, 클라이언트들에게 결과를 돌려주기 위해서는 HttpServletResponse로부터 PrintWriter 형의 출력 스트림 객체를 얻어와서 응답함.
	
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //입출력시 예외 처리
		
		PrintWriter out = response.getWriter();
		out.println("<HTML코드 작성>"); //클라이언트 창에 응답처리 출력해줌
	
	}*/
	
	
}	
