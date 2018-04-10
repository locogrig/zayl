<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<div style="text-align: center">
    <form id="addCarousel" method="post" enctype="multipart/form-data" >

        <div style="margin-top: 80px; margin-left: 80px;">
            上传图片:<input type="file" name="aa"><br/>
        </div>
        <div style="margin-top:20px">
            标&nbsp;&nbsp;题:<input class="easyui-textbox" name="title"data-options="required:true"><br/>
        </div>

        <div style="margin-top:20px">
            内&nbsp;&nbsp;容:<input class="easyui-textbox" name="descs"data-options="required:true"><br/>
        </div>

        <%--<div style="margin-top: 20px;">
            选择状态:<select id="cc" class="easyui-combobox" name="status" style="width:175px;">
            <option value="已激活">激活</option>
            <option value="未激活">未激活</option>
        </select>--%>







    </form>
</div>
