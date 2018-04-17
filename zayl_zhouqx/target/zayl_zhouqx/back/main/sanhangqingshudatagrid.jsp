<%@page  pageEncoding="UTF-8"  contentType="text/html;UTF-8"  isELIgnored="false" %>


    <script  type="text/javascript">
        $(function(){

            $("#dshqs").datagrid({
                fit:true,
                striped:true,
                remoteSort:false,//对数据进行排序时，先关闭远程的排序
                method:'GET',
                loadMsg:'正在加载.....',
                url:'/zayl/article/showSan',
                columns:[[

                    {title:'编号',field:'id',width:60,align:'center',sortable:false},
                    {title:'作者id',field:'userid',width:60,align:'center',sortable:false},
                    {title:'发布时间',field:'date',width:120,align:'center',sortable:false},
                    {title:'文章内容',field:'content',width:120,align:'center',sortable:false},
                    {title:'状态',field:'status',width:460,align:'center',sortable:false},
                    {title:'阅读量',field:'readCount',width:60,align:'center',sortable:false},
                    {title:'喜爱人数',field:'clickcount',width:60,align:'center',sortable:false},
                    {title:'操作',field:'options',width:180,align:'center',
                        formatter:function(value,row,index){
                            return "<a class='del' data-options=\"plain:true,iconCls:'icon-remove'\" onclick=\"delSHQS('"+row.id+"')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                                "<a class='del' data-options=\"plain:true,iconCls:'icon-edit'\" onclick=\"updateSHQS('"+row.id+"')\">修改</a>"
                        }
                    },

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

        //修改的对话框
        function  updateSHQS(id){

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
                        $("#dshqs").datagrid('reload')//始终保持在当前页展示
                    });
                }
            });
        }




        //处理搜索
        function qq(value,name){
            console.log(value)
            console.log(name);
            if(name!=null){
                $("#dshqs").datagrid({
                    url:"/easyui-work/emp/search?name="+name+"&value="+value
                });
            }else{
                return "请输入查询条件...";
            }
        }
        //删除
        function delSHQS(id){
            console.log(id);
            //友情提醒
            $.messager.confirm('提示','确定要删除吗?',function(r){

                if(r){
                    //发送ajax请求删除
                    $.post('${pageContext.request.contextPath}/article/delete',{"id":id},function(){
                        $.messager.show({
                            title:'提示',
                            msg:'删除三行情书成功...',
                        });

                        $("#dshqs").datagrid('reload');//始终保持在当前页展示
                    });
                }

            });
        }

    </script>


   <table  id="dshqs" ></table>


   <div id="tb">


       <%--搜索框--%>
       <div id="mm" data-options="">
           <div data-options="name:'ename',">姓名</div>
           <div   data-options="name:'bir'">生日</div>
           <div data-options="name:'age'">年龄</div>
       </div>
       <input id="ss" class="easyui-searchbox"
              data-options="searcher:qq,prompt:'请输入查询条件....',menu:'#mm',width:200"/>
   </div>



   <div id="addDialog" /> </div>
   <div id="editDialog"/>
