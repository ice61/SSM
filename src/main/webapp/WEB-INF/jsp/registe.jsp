<%--
  Created by IntelliJ IDEA.
  User: WIN 10
  Date: 2019/1/16
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" charset="utf8" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>员工注册</title>
</head>
<body>
    <form>
        <table>
            <tr>
                <td>工号：</td>
                <td>
                    <div><input type="number" oninput="if(value.length>10)value=value.slice(0,10)"
                                id="clerk_id"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td>
                    <div><input type="text" id="clerk_name" name="name" required="required"/></div>
                </td>
            </tr>
            <tr>
                <td>性别：</td>
                <td>男<input type="radio" name="sex" id="clerk_sex" value="male" required="required"/>
                    女<input type="radio" name="sex" id="clerk_sex" value="female" required="required"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <div>
                        <input type="password" id="clerk_password1" name="password1"
                               maxlength=12 required="required"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td>再次输入密码：</td>
                <td>
                    <div><input type="password" id="clerk_password2" maxlength=12 required="required"/></div>
                </td>
            </tr>
            <tr>
                <td>密保问题（最喜欢的水果）：</td>
                <td>
                    <div>
                        <input type="text" id="clerk_question" name="question" maxlength=5/">
                    </div>
                </td>
            </tr>
        </table>
        <button id="registe">注册</button>
    </form>
<script>
    $("#registe").click(function() {
        var id = $("#clerk_id").val();
        var name = $("#clerk_name").val();
        var password = $("#clerk_password1").val();
        //var sex = $("#clerk_sex").val();
        var question = $("#clerk_question").val();
        var clerk = {
            "id":id,
            "name":name,
            "password":password,
            //"sex":sex,
            "question":question
        };
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/reg/registe.do",
            contentType:"application/json;charset=utf-8",
            data:JSON.stringify(clerk),
            success:function (data) {
                console.log(clerk);
                if(data == "error")
                    window.alert("请勿重复注册");
                else if(data == "fail")
                    window.alert("注册失败，请稍后再试");
            }
        });
    });
</script>
</body>
</html>
