<%@page  pageEncoding="UTF-8"  contentType="text/html;UTF-8"  isELIgnored="false" %>


    <script  type="text/javascript">
        $(function(){

            $("#ddw").datagrid({
                fit:true,
                striped:true,
                remoteSort:false,//对数据进行排序时，先关闭远程的排序
                method:'GET',
                loadMsg:'正在加载.....',
                url:'${pageContext.request.contextPath}/article/showDuan',
                columns:[[

                    {title:'编号',field:'id',width:260,align:'center',sortable:false},
                    {title:'作者id',field:'userid',width:260,align:'center',sortable:false},
                    {title:'发布时间',field:'date',width:260,align:'center',sortable:false},
                    {title:'文章内容',field:'content',width:260,align:'center',sortable:false},
                    {title:'状态',field:'status',width:260,align:'center',sortable:false},
                    {title:'阅读量',field:'readCount',width:260,align:'center',sortable:false},
                    {title:'喜爱人数',field:'clickcount',width:260,align:'center',sortable:false},

                    {field:'options',title:'操作',width:300,align:'center',
                    formatter:function(value,row,index){

                       return "<a class='del' data-options=\"plain:true,iconCls:'icon-remove'\" onclick=\"delDwen('"+row.id+"')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                           "<a class='del'  data-options=\" plain:true,iconCls:'icon-edit'\"  onClick=\"updateDwen('"+row.id+"');\">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"



                    }

                   }
               ]],

               fitColumns:true,
               autoRowHeight:true,
               striped:true,
               pagination:true,
               pageSize: 5,         //分页大小
               pageNumber:1,         //第几页显示（默认第一页，可以省略）
               pageList: [5, 10, 15], //设置每页记录条数的列表
               rownumbers:true,
               ctrlSelect:true,
               sortOrder:'desc',
               multiSort:true,
               scrollbarSize:18,
               resizeHandle:'both',
               left:100,
               top:200,
               collapsible:true,
               minimizable:true,
               maximizable:true


        })

        });

        //修改用户的对话框
        function  updateDwen(id){

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
                        $("#ddw").datagrid('reload')//始终保持在当前页展示
                    });
                }
            });
        }
        //删除
        function delDwen(id){
            console.log(id);
            //友情提醒
            $.messager.confirm('提示','确定要删除吗?',function(r){

                if(r){
                    //发送ajax请求删除
                    $.post('${pageContext.request.contextPath}/article/delete',{"id":id},function(){
                        $.messager.show({
                            title:'提示',
                            msg:'删除短文成功...',
                        });

                        $("#ddw").datagrid('reload');//始终保持在当前页展示
                    });
                }

            });
        }

    </script>


   <table  id="ddw" ></table>




   <div id="addDialog" /> </div>
   <div id="editDialog"/>
