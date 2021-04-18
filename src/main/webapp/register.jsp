<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
 form{
 text-align: center;
 margin-left: 600px;
 background-image: url("https://t4.ftcdn.net/jpg/02/71/12/01/360_F_271120192_ZDT2FCxH94akiIsOHwVULWnbNzi8Oagn.jpg");
 height: 300px;
 margin-top: -25px;
 background-size: contain;
 width: 500px;
 
 }
 body{
  text-align: center;
  background-image: url("https://cms-assets.tutsplus.com/uploads/users/2467/posts/32553/image/exit_animation_sketch.gif");
  background-size: cover;
 
 }
 input {
	background: transparent;
	border: 1px solid #94f7f9;
	box-shadow: 0 0 10px #24adb8;
	color: yellow;
}
label {
	color: #fd97fc;
}
 
</style>
<title>Ragister</title>
</head>
<body>
<form action="register" method="post">
 <h2 style="color: #94f7f9;">Register Please</h2>
 <br><br><br>
 <label for="un">Username</label>
 <input type="text" name="userName" ><br><br>
 <label for="pw">Password</label>
 <input type="password" name="password" ><br><br><br>
 <input type="submit"  value="Register">
</form>
</body>
</html>