<%--
  Created by IntelliJ IDEA.
  User: qiuji
  Date: 2020/3/17
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: sans-serif;
            /*背景图的地址*/
            /*background: ;*/
            background-size: cover;
        }

        .box {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 400px;
            padding:40px;
            background: rgba(0, 0, 0, .8);
            box-sizing: border-box;
            box-shadow: 0 15px 25px rgba(0, 0, 0, .5);
            border-radius: 10px;
        }

        .box h2 {
            margin: 0 0 30px;
            padding: 0;
            color: #fff;
            text-align: center;
        }

        .box .inputBox {
            position: relative;
        }

        .box .inputBox input {
            width: 100%;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            letter-spacing: 1px;
            margin-bottom: 30px;
            border: none;
            border-bottom: 1px solid #ffffff;
            outline: none;
            background: transparent;
        }
        .box .inputBox input[name="checkcode"] {
            width: 50%;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            letter-spacing: 1px;
            margin-bottom: 30px;
            border: none;
            border-bottom: 1px solid #ffffff;
            outline: none;
            background: transparent;
        }

        .box .inputBox label {
            position: absolute;
            top: 0;
            left: 0;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            letter-spacing: 1px;
            pointer-events: none;
            transition: .5s;

        }

        .box .inputBox input:focus ~ label, .box .inputBox input:valid ~ label {
            top: -20px;
            left: 0;
            color: #03a9f4;
            font-size: 12px;
        }

        .box input[type="submit"] {
            background: transparent;
            border: none;
            outline: none;
            color: #fff;
            background: #03a9f4;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
        }
        .box img{
            padding-left: 40px;
        }

    </style>
    <script>
        var err='<%=request.getParameter("error")%>';
        if(err=='y'){
            alert("验证码输入错误!!!!!");
        }else if(err=='y2'){
            alert("密码或用户名输入错误!!!!!!!!")
        }
        window.onload=function () {
            var img=document.getElementById("checkCode");
            img.onclick=function () {
                var date = new Date().getTime();
                img.src="/day17web/checkCodeServlet?date="+date;
            }
        }
    </script>
</head>
<body>
<div class="box">
    <h2>Login</h2>
    <form action="/day17web/loginServlet" method="post">
        <div class="inputBox">
            <input type="text" name="username" required="">
            <label>用户名</label>
        </div>
        <div class="inputBox">
            <input type="password" name="password" required="">
            <label>密码</label>
        </div>
        <div class="inputBox" >
            <input type="text" name="checkcode" required="">
            <label>验证码</label>
            <img id="checkCode" src="/day17web/checkCodeServlet">
        </div>
        <input type="submit" name="" value="Submit">
    </form>
</div>
</body>
</html>
