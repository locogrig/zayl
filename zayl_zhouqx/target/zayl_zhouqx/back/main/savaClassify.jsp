<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<div style="text-align: center">
    <form id="addd" method="post" action="/classify/sava">
        <div style="margin-top: 40px">
            类&nbsp;别&nbsp;名&nbsp;称:<input class="easyui-textbox" name="cname"data-options="required:true"><br/>
        </div>

        <div style="margin-top:20px">
        父&nbsp;&nbsp;类&nbsp;&nbsp;&nbsp;ID:<input class="easyui-textbox" name="parentid" prompt="若为父类则该项为空"><br/>
    </div>

    </form>
</div>
