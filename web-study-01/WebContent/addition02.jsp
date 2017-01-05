<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- page태그는 해당페이지내에 사용되는 전반적인 환경을 결정 해줌 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 의미와 이해</title>
</head>
<body>
<!-- ※ JSP 는 HTML문서 내부에 자바코드가 들어가는 구조이다! -->

<!-- JSP 는 Java Server Page의 줄임말!! 
	=> 자바로 서버페이지를 작성하기 위한 언어 
	=> HTML 과 JSP태그(스크립트릿)로 구성되어 화면을 작성하는 데 유리한 웹프로그래밍 기술이다. 
	=> 서버페이지는 웹서버에서 실행되는 페이지를 말하며 요청에 필요한 페이지를 위한 로직이나 데이터 베이스와의 연동을 위해 필요한 것들을 포함한다. 
	
-->
<!-- 자바를 사용해서 로직을 구현한다! -->
<%
	int num1 = 20; 
	int num2 = 10; 
	int add = num1 + num2;
%>
<%=num1 %>+<%=num2 %>=<%=add %>


<%  %><!--이 태그는 '스크립트릿'Scriptlet이라고 한다. 자바코드를 기술하기 위해서는 기본적으로 이 안에서 해야함 -->
<%= %><!--이 태그는 '표현식'expression이라고 한다. 변수에 저장된 값이나 함수의 결과값을 출력하기 위해서 사용해야함 -->

<!-- 서블릿과 JSP 를 비교해보면 JSP로 개발하는 편이 훨씬 쉽고 간단해보이나 복잡한 자바코드가 기술되어야할 경우에는 서블릿이 필요하다. -->
<!-- 복잡한 로직이 필요한 예는 AdditionServlet03.java와 .jsp 파일로 봅시다. -->

</body>
</html>