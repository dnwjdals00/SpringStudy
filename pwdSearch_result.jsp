<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="my.css">
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>신규 비밀번호 등록</h1>
  <p>본인확인이 완료되었습니다. 신규 비밀번호를 등록 후 사용해주세요.</p>
  <input type="text"  name="textfield" style="text-align:center; width:500px; height:50px; letter-spacing: 1px" 
   placeholder="비밀번호 입력(띄어쓰기 없이 영문, 숫자 포함 10~20자 이내) "><br>
     <input type="text"  name="textfield" style="text-align:center; width:500px; height:50px; letter-spacing: 1px" 
   placeholder="비밀번호 재입력 ">
   <div class="join-btn-box btn-box">
             <!-- 바로 로그인창으로 넘어감 -->
            <button type="button" onclick="location.href='login.jsp' ">취소</button>
            <!--완료시 이벤트로 변경완료되었다고 뜨고 로그인창으로 넘어감  -->
            <button type="button" onclick="location.href='login.jsp' ">변경완료</button>
            
</body>
</html>