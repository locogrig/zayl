<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {


            $("#fs").click(function () {
                var phonenumber=$("#phonenumber").val();
                $.get("${pageContext.request.contextPath}/frontUser/sendCode",{"phonenumber":phonenumber},
                function (result) {

                });
            });
        });
    </script>
</head>
<body>
<div style="text-align: center">
    <form action="${pageContext.request.contextPath}/user/code" method="post">
        请输入手机号：<input  type="text" name="phonenumber" id="phonenumber"/>
        <input type="button" value="获取验证码" id="fs"/><br>
        请输入验证码：<input type="text" name="code">
        <input type="submit" value="提交">
       <%-- 请输入验证码: <input type="text" name="code">--%>
    </form>


</div>
</body>
</html>
