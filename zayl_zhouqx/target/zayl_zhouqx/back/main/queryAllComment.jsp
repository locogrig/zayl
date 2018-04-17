<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<script>
    var $dp,$pl;
    $(function(){
        $dp = $("#dp");//这是datagrid选择器
        $pl = $("#pl");


        //初始化datagrid控件
        $dp.datagrid({
            fit:true,
            striped:true,
            fitColumns:true,
            rownumbers:true,
            url:'${pageContext.request.contextPath}/comment/queryAll',
            remoteSort:false,
            pagination:true,
            columns:[[
                {title:'编号',field:'id',width:260,align:'center',sortable:false},
                {title:'评论',field:'commentcontent',width:260,align:'center',sortable:false},

                {title:'操作',field:'options',width:160,align:'center',
                    formatter:function(value,row,index){
                        return "<a class='del' data-options=\"plain:true,iconCls:'icon-remove'\" onclick=\"delPlun('"+row.id+"')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" /*+
                            "<a class='del' data-options=\"plain:true,iconCls:'icon-edit'\" onclick=\"editUser('"+row.id+"')\">修改</a>"*/
                    }
                },
            ]],
            onLoadSuccess:function(){
                $(".del").linkbutton();
            },
            /*toolbar:'#comment',*/


        });

    });

    //处理搜索
    function qq(value,name){
        console.log(value)
        console.log(name);
        $("#dp").datagrid({
            url:'${pageContext.request.contextPath}/user/queryBySearch?name='+name+'&value='+value
        })
    }



    //删除用户
    function delPlun(id){
        console.log(id);
        //友情提醒
        $.messager.confirm('提示','确定要删除吗?',function(r){

            if(r){
                //发送ajax请求删除用户
                $.post('${pageContext.request.contextPath}/comment/delete',{"id":id},function(){
                    $.messager.show({
                        title:'提示',
                        msg:'删除成功...',
                    });

                    $("#dp").datagrid('reload');//始终保持在当前页展示
                });
            }

        });
    }





</script>


<%--创建datagrid--%>
<table id="dp"></table>


<%--工具栏--%>
<%--<div id="comment">
    <a href="#" class="easyui-linkbutton" onclick="openpllog();" data-options="iconCls:'icon-add',plain:true">添加</a>
    &lt;%&ndash;搜索框&ndash;%&gt;
    <input id="ss" class="easyui-searchbox"
           data-options="searcher:qq,prompt:'请输入查询条件....',menu:'#mm',width:400"/>
    <div id="mm" data-options="">
        <div data-options="name:'name',">类名</div>
    </div>
</div>--%>


<%--保存日志对话框--%>
<div id="pl"></div>

<%--用户修改的对话框--%>
<div id="updateUserDialog"></div>