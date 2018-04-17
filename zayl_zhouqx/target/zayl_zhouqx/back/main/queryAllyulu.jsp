<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<script>
    var $yl,$yll;
    $(function(){
        $yl = $("#yl");//这是datagrid选择器
        $yll = $("#yll");


        //初始化datagrid控件
        $yl.datagrid({
            fit:true,
            striped:true,
            fitColumns:true,
            rownumbers:true,
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
                        return "<a class='del' data-options=\"plain:true,iconCls:'icon-remove'\" onclick=\"delYlu('"+row.id+"')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<a class='del' data-options=\"plain:true,iconCls:'icon-edit'\" onclick=\"editYLL('"+row.id+"')\">修改</a>"
                    }
                },
            ]],
            onLoadSuccess:function(){
                $(".del").linkbutton();
            },



        });

    });




    //修改用户的对话框
    function  editYLL(id){

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


    //删除
    function delYlu(id){
        console.log(id);
        //友情提醒
        $.messager.confirm('提示','确定要删除吗?',function(r){

            if(r){
                //发送ajax请求删除
                $.post('${pageContext.request.contextPath}/article/delete',{"id":id},function(){
                    $.messager.show({
                        title:'提示',
                        msg:'删除语录成功...',
                    });

                    $("#yl").datagrid('reload');//始终保持在当前页展示
                });
            }

        });
    }
</script>


<%--创建datagrid--%>
<table id="yl"></table>





<%--保存日志对话框--%>
<div id="yll"></div>

