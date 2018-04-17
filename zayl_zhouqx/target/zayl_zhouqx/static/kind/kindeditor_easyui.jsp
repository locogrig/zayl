<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="/easyui-work/kindeditor/themes/default/default.css" />
    <link rel="stylesheet" href="/easyui-work/kindeditor/plugins/code/prettify.css" />
    <link rel="stylesheet" type="text/css" href="/easyui-work/themes/metro-green/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui-work/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/easyui-work/themes/IconExtension.css">
    <script type="text/javascript" src="/easyui-work/js/jquery.min.js"></script>
    <script type="text/javascript" src="/easyui-work/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/easyui-work/js/jquery.easyui.validater.js"></script>
    <script type="text/javascript" src="/easyui-work/js/easyui-lang-zh_CN.js"></script>
    <script charset="utf-8" src="/easyui-work/kindeditor/kindeditor-all-min.js"></script>
    <script charset="utf-8" src="/easyui-work/kindeditor/zh-CN.js"></script>
    <script charset="utf-8" src="/easyui-work/kindeditor/plugins/code/prettify.js"></script>

    <script>



        $(function(){

            /*$("#btn").click(function(){*/
              $("#pa").panel(function(){

                $("#dd").dialog({
                    width:600,
                    height:400,
                    title:'对话框',
                    href:'/easyui-work/kind/save.jsp',

                });

            });

        })
    </script>

</head>
<body>

   <div  class="easyui-panel"  id="pa"></div>

   <%-- <input  type="button" value="打开对话框" id="btn"/>--%>


    <div id="dd" ></div>


</body>
</html>
