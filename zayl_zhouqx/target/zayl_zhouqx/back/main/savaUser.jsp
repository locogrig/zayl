<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<div style="text-align: center">
    <form id="adduser" method="post" action="/user/sava">
        <div style="margin-top: 40px">
            昵&nbsp;&nbsp;称:<input class="easyui-textbox" name="nickname"data-options="required:true"><br/>
        </div>

        <div style="margin-top:20px">
        姓&nbsp;&nbsp;名:<input class="easyui-textbox" name="uname"data-options="required:true"><br/>
    </div>

        <div style="margin-top:20px">
            签&nbsp;&nbsp;名:<input class="easyui-textbox" name="sign"data-options="required:true"><br/>
        </div>

        <div style="margin-top:20px">
            密&nbsp;&nbsp;码:<input class="easyui-textbox" name="password"data-options="required:true"><br/>
        </div>

    </form>
</div>
