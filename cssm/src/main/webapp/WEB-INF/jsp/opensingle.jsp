<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="opensinglejfmpeg" method="post">
  <p>RtspUrl: <input type="text" id="rtspUrl" name="rtspUrl" /></p>
  <p>RtspUsername: <input type="text" name="rtspUsername" /></p>
  <p>RtspPassword: <input type="text" name="rtspPassword" /></p>
  <p>JsmpegPassword: <input type="text" name="jsmpegPassword" /></p>
  <input type="submit" value="Submit" />
</form>
</body>
</html>