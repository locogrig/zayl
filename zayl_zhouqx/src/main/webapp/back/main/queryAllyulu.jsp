<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<script>
    var $yl,$logdia;
    $(function(){
        $yl = $("#yl");//这是datagrid选择器
        $logdia = $("#logdia");


        //初始化datagrid控件
        $yl.datagrid({
            fit:true,
            url:'${pageContext.request.contextPath}/article/queryAll',
            remoteSort:false,
            pagination:true,
            columns:[[
                {title:'编号',field:'id',width:60,align:'center',sortable:false},
                {title:'作者id',field:'userid',width:60,align:'center',sortable:false},
                {title:'发布时间',field:'date',width:120,align:'center',sortable:false},
                {title:'状态',field:'status',width:120,align:'center',sortable:false},
                {title:'内容',field:'content',width:460,align:'center',sortable:false},
                {title:'阅读量',field:'readCount',width:60,align:'center',sortable:false},
                {title:'喜爱人数',field:'clickcount',width:60,align:'center',sortable:false},
                {title:'操作',field:'options',width:180,align:'center',
                    formatter:function(value,row,index){
                        return "<a class='del' data-options=\"plain:true,iconCls:'icon-edit'\" onclick=\"editUser('"+row.id+"')\">修改</a>"
                    }
                },
            ]],
            onLoadSuccess:function(){
                $(".del").linkbutton();
            },
            toolbar:'#tb',


        });

    });




    //修改用户的对话框
    function  editUser(id){

        console.log(id);
        //友情提示
        $.messager.confirm('提示','要通过审核吗？',function(r){
            if(r){

                $.post('/zayl/article/update',{"id":id},function(result){
                    $.messager.alert({
                        title:'提示',
                        msg:result.msg,
                    });
                    //刷新datagrid
                    //$("#dg").datagrid('load');//始终保持在第一页展示
                    $("#yl").datagrid('reload')//始终保持在当前页展示
                });
            }
        });
    }

</script>


<%--创建datagrid--%>
<table id="yl"></table>


<%--工具栏--%>
<div id="tb">

</div>


<%--保存日志对话框--%>
<div id="logdia"></div>

<%--用户修改的对话框--%>
<div id="updateUserDialog"></div>