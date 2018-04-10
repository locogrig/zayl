<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/themes/black/easyui.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/themes/IconExtension.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/easyui-lang-zh_CN.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.easyui.validater.js"></script>
        <script charset="utf-8" src="${pageContext.request.contextPath}/static/editor//kindeditor-common.js"></script>
        <script charset="utf-8" src="${pageContext.request.contextPath}/static/editor/kindeditor.js"></script>
        <script charset="utf-8" src="${pageContext.request.contextPath}/static/editor/zh-CN.js"></script>
        <script charset="utf-8" src="${pageContext.request.contextPath}/static/js/echars/echarts.min.js"></script>
        <script>
            var $menus,$tt;//$开头的变量代表是一个jquery变量

            $(function(){
                $menus = $("#menus");
                $tt = $("#tt");
                //页面加载完成立即查询数据库中的菜单  渲染到页面上
                //1.获取后台的菜单数据
                $.get("${pageContext.request.contextPath}/back/main/menu.json",function(result){
                    //遍历所有一级菜单
                    $.each(result,function(idx,menu){
                        var content = "<div style='text-align: center;'>";
                        //遍历所有二级菜单
                        $.each(menu.children,function(idx,child){
                            var con = child.name+"#"+child.iconCls+"#"+child.href;
                            content += "<div onclick=\"addTabs('"+con+"')\" style='width: 90%;margin:5px 0px 5px 0px; border:1px #95B8E7 solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\" >"+child.name+"</div><br/>";
                        });
                        content +="</div>";
                        //追加accordion面板
                        $menus.accordion('add',{
                            title:menu.name,
                            iconCls:menu.iconCls,
                            content:content,
                        });
                    });

                },"JSON");
            });

            //处理点击菜单追加选项卡
            function addTabs(content){
                var con = content.split("#");
                //标题
                var title = con[0];
                //图标
                var iconCls = con[1];
                //点击二级菜单的模块查询所有页面
                var href = con[2];
                if(!$tt.tabs('exists',title)){
                    $tt.tabs('add',{
                        title:title,
                        iconCls:iconCls,
                        closable:true,
                        href:href,
                        tools:[{
                            iconCls:'icon-reload',
                            handler:function(){
                                //获取当前选中面板
                                var tab = $tt.tabs('getSelected');
                                console.log(tab);
                                tab.panel('refresh');//调用panel刷新方法
                            }
                        }]
                    });
                }else{//存在选中当前选项卡
                    $tt.tabs('select',title);
                }


            };
        </script>
    </head>
<body class="easyui-layout">
<%--头--%>
<div data-options="region:'north',split:false,href:'${pageContext.request.contextPath}/back/main/head.jsp'" style="height:80px;">

</div>
<%--左栏--%>
<div data-options="region:'west',collapsible:false,title:'系统菜单',split:false,width:220" >
    <%--用来产生accordion控件的div--%>
    <div id="menus" class="easyui-accordion" data-options="fit:true"></div>
</div>
<%--中心--%>
<div data-options="region:'center',">

    <%--选项卡容器--%>
    <div id="tt" class="easyui-tabs" data-options="fit:true"></div>

</div>
<%--尾--%>
<div data-options="region:'south',split:false,href:'${pageContext.request.contextPath}/back/main/bottom.jsp'" style="height:60px;"></div>
</body>
</html>
