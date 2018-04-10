<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<script>
    var $dc,$logdia;
    $(function(){
        $dc = $("#dc");//这是datagrid选择器
        $logdia = $("#logdia");


        //初始化datagrid控件
        $dc.datagrid({
            fit:true,
            url:'${pageContext.request.contextPath}/classify/queryAll',
            remoteSort:false,
            pagination:true,
            columns:[[
                {title:'编号',field:'id',width:260,align:'center',sortable:false},
                {title:'类名',field:'cname',width:260,align:'center',sortable:false},
                {title:'父类id',field:'parentid',width:260,align:'center',sortable:false},
                {title:'操作',field:'options',width:160,align:'center',
                    formatter:function(value,row,index){
                        return "<a class='del' data-options=\"plain:true,iconCls:'icon-remove'\" onclick=\"delUser('"+row.id+"')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" /*+
                            "<a class='del' data-options=\"plain:true,iconCls:'icon-edit'\" onclick=\"editUser('"+row.id+"')\">修改</a>"*/
                    }
                },
            ]],
            onLoadSuccess:function(){
                $(".del").linkbutton();
            },
            toolbar:'#tb',


        });

    });

    //处理搜索
    function qq(value,name){
        console.log(value)
        console.log(name);
        $("#dc").datagrid({
            url:'${pageContext.request.contextPath}/user/queryBySearch?name='+name+'&value='+value
        })
    }


    //打开对话框
    function openLogDialog(){
        //渲染对话框
        $logdia.dialog({
            width:400,
            height:300,
            title:'保存类别',
            iconCls:'icon-man',
            href:'${pageContext.request.contextPath}/back/main/savaClassify.jsp',
            buttons:[{
                text:'保存类别',
                iconCls:'icon-save',
                handler: saveUser,
            },{
                text: '关闭',
                iconCls: 'icon-cancel',
                handler: function () {
                    //关闭当前对话框
                    $logdia.dialog('close',true);
                }
            }]
        });
    };

    //保存用户信息
    function saveUser(){
        $("#addd").form('submit',{
            url:'${pageContext.request.contextPath}/classify/sava'+$(this).serialize(),
            onSubmit:function(){
                //验证表单元素
                return $(this).form('validate');
            },
            success:function(data){
                //data  都是json格式字符串   使用数据时将json转为js对象和数组
                $.messager.show({
                    title:'提示',
                    msg:'保存用户成功...',
                });

                //关闭当前对话框
                $logdia.dialog('close',true);
                //刷新datagrid
                //$("#dg").datagrid('load');//始终保持在第一页展示
                $("#dc").datagrid('reload');//始终保持在当前页展示
            }
        });
    }


    //删除用户
    function delUser(id){
        console.log(id);
        //友情提醒
        $.messager.confirm('提示','确定要删除吗?',function(r){

            if(r){
                //发送ajax请求删除用户
                $.post('${pageContext.request.contextPath}/classify/delete',{"id":id},function(){
                    $.messager.show({
                        title:'提示',
                        msg:'删除用户成功...',
                    });

                    $("#dc").datagrid('reload');//始终保持在当前页展示
                });
            }

        });
    }

    //修改用户信息
    function editUser(id){

        $("#updateUserDialog").dialog({

            title:'修改用户信息',
            iconCls:'icon-edit',
            width:500,
            height:300,
            href:'${pageContext.request.contextPath}/back/main/editUser.jsp?id='+id,
            buttons:[{
                text:'修改用户',
                iconCls: 'icon-edit',
                handler:updateUser,

            },
                {
                    text: '关闭',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        //关闭当前对话框
                        $("#updateUserDialog").dialog('close',true);
                        $("#dc").datagrid('reload');
                    }

                }
            ]



        })
        $.post("${pageContext.request.contextPath}/classify/queryOne?id="+id,function(result){
            $("#updateUserForm").form('load',result);
        },"JSON");
    }



    //修改用户信息
    function updateUser() {

        $("#updateUserForm").form('submit',{

            url:'${pageContext.request.contextPath}/user/edit',
            onSubmit:function () {
                return true;

            },
            success:function () {
                //关闭对话框
                $("#updateUserDialog").dialog('close',true);
                //刷新datagrid
                $("#dc").datagrid('reload');
            }
        });
    }

</script>


<%--创建datagrid--%>
<table id="dc"></table>


<%--工具栏--%>
<div id="tb">
    <a href="#" class="easyui-linkbutton" onclick="openLogDialog();" data-options="iconCls:'icon-add',plain:true">添加</a>
    <%--搜索框--%>
    <input id="ss" class="easyui-searchbox"
           data-options="searcher:qq,prompt:'请输入查询条件....',menu:'#mm',width:400"/>
    <div id="mm" data-options="">
        <div data-options="name:'name',">类名</div>
    </div>
</div>


<%--保存日志对话框--%>
<div id="logdia"></div>

<%--用户修改的对话框--%>
<div id="updateUserDialog"></div>