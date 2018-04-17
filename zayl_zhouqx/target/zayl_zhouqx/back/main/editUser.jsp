<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<%--<script>
    $(function(){
        $("#updateUserForm").form('load','/easyuiDay4/user/queryOne?id=${param.id}');

    });
</script>--%>

<div style="text-align: center">
    <form id="updateUserForm" method="post" >
        <div style="margin-top: 10px">
            昵&nbsp;&nbsp;称:<input class="easyui-textbox" name="nickname" readonly><br/>
        </div>
        <div style="margin-top: 20px">
            姓&nbsp;&nbsp;名:<input class="easyui-textbox" name="uname" readonly><br/>
        </div>
        <div style="margin-top: 20px">
            状&nbsp;&nbsp;态:<input class="easyui-textbox" name="status"><br/>
        </div>


        <div style="margin-top:20px">
            签&nbsp;&nbsp;名:<input class="easyui-textbox" name="sign" readonly><br/>
        </div>

        <div style="margin-top:20px">
            密&nbsp;&nbsp;码:<input class="easyui-textbox" name="password"><br/>
        </div>

        <div style="margin-top:20px">
           <input class="easyui-textbox" name="id"  type="hidden"><br/>
        </div>

    </form>
</div>
