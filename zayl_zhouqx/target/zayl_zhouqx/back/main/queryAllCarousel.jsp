<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<script>
    var $dl,$lbt;
    $(function(){
        $dl = $("#dl");//这是datagrid选择器
        $lbt = $("#lbt");


        //初始化datagrid控件
        $dl.datagrid({
            fit:true,
            striped:true,
            fitColumns:true,
            rownumbers:true,
            url:'${pageContext.request.contextPath}/carousel/queryAll',
            remoteSort:false,
            pagination:true,
            columns:[[
                {title:'编号',field:'id',width:50,align:'center',sortable:false},
                {title:'标题',field:'title',width:100,align:'center',sortable:false},
                {title:'描述',field:'descs',width:460,align:'center',sortable:false},
                {title:'路径',field:'path',width:160,align:'center',sortable:false},
                {title:'名称',field:'filename',width:200,align:'center',sortable:false},
                {title:'操作',field:'options',width:180,align:'center',
                    formatter:function(value,row,index){
                        return "<a class='del' data-options=\"plain:true,iconCls:'icon-remove'\" onclick=\"delCarousel('"+row.id+"')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<a class='del' data-options=\"plain:true,iconCls:'icon-edit'\" onclick=\"showImg('"+row.filename+"')\">查看</a>"
                    }
                },
            ]],
            onLoadSuccess:function(){
                $(".del").linkbutton();
            },
            toolbar:'#carousel',


        });

    });

    //处理搜索
    function qq(value,name){
        console.log(value)
        console.log(name);
        $("#dl").datagrid({
            url:'${pageContext.request.contextPath}/carousel/queryBySearch?name='+name+'&value='+value
        })
    }

    function showImg(data){

        console.log(data);

        var newsrc='http://localhost:8099/zayl/upload/'+data;
        // alert(newsrc);
        $("#showImg").dialog({
            title:"查看图片",
            iconCls:'icon-image',
            width:1024,
            height:512,
            fit:false,
            draggable:false,
            method:'POST',
            content:'<img src='+newsrc+'>'
        });
    }


    //打开对话框
    function openlbtlog(){
        //渲染对话框
        $lbt.dialog({
            width:400,
            height:300,
            title:'上传图片',
            iconCls:'icon-man',
            href:'${pageContext.request.contextPath}/back/main/savaCarousel.jsp',
            buttons:[{
                text:'保存图片',
                iconCls:'icon-save',
                handler: saveCarousel,
            },{
                text: '关闭',
                iconCls: 'icon-cancel',
                handler: function () {
                    //关闭当前对话框
                    $lbt.dialog('close',true);
                }
            }]
        });
    };

    //保存用户信息
    function saveCarousel(){
        $("#addCarousel").form('submit',{
            url:'${pageContext.request.contextPath}/carousel/upload'+$(this).serialize(),
            onSubmit:function(){
                //验证表单元素
                return $(this).form('validate');
            },
            success:function(data){
                //data  都是json格式字符串   使用数据时将json转为js对象和数组
                $.messager.show({
                    title:'提示',
                    msg:'上传成功...',
                });

                //关闭当前对话框
                $lbt.dialog('close',true);
                //刷新datagrid
                //$("#dg").datagrid('load');//始终保持在第一页展示
                $("#dl").datagrid('reload');//始终保持在当前页展示
            }
        });
    }


    //删除
    function delCarousel(id){
        console.log(id);
        //友情提醒
        $.messager.confirm('提示','确定要删除吗?',function(r){

            if(r){
                //发送ajax请求删除
                $.post('${pageContext.request.contextPath}/carousel/delete',{"id":id},function(){
                    $.messager.show({
                        title:'提示',
                        msg:'删除轮播图成功...',
                    });

                    $("#dl").datagrid('reload');//始终保持在当前页展示
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
                        $("#dl").datagrid('reload');
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
                $("#dl").datagrid('reload');
            }
        });
    }

</script>


<%--创建datagrid--%>
<table id="dl"></table>


<%--工具栏--%>
<div id="carousel">
    <a href="#" class="easyui-linkbutton" onclick="openlbtlog();" data-options="iconCls:'icon-add',plain:true">添加</a>
    <%--搜索框--%>
    <input id="ss" class="easyui-searchbox"
           data-options="searcher:qq,prompt:'请输入查询条件....',menu:'#mm',width:400"/>
    <div id="mm" data-options="">
        <div data-options="name:'title',">标题</div>
    </div>
</div>


<%--保存日志对话框--%>
<div id="lbt"></div>

<%--用户修改的对话框--%>
<div id="showImg"><img src="" id="img"></div>