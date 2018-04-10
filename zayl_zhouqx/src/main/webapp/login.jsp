<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>



<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.easyui.validater.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">

        $.fn.datebox.defaults.formatter = function(date){
            var y = date.getFullYear();
            var m = date.getMonth()+1;
            var d = date.getDate();
            return y+'/'+m+'/'+d;
        }
        $.fn.datebox.defaults.parser = function(s){
            if (!s) return new Date();
            var ss = s.split('/');
            var y = parseInt(ss[0],10);
            var m = parseInt(ss[1],10);
            var d = parseInt(ss[2],10);
            if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
                return new Date(y,m-1,d);
            } else {
                return new Date();
            }
        };

        $.extend($.fn.validatebox.defaults.rules, {
            minLength: {
                validator: function(value, param){
                    return value.length >= param[0];
                },
                message:'密码需大于6位'
            }
        });

    </script>

</head>
<body>


    <div  id="dialog"  class="easyui-dialog" data-options="width:800,height:450,
     collapsible:true,minimizable:true,maximizable:true,draggable:false,
        title:'管理员登录',
        buttons:[{
				text:'登录',
				handler:function(){

                    $('#formInput').form('submit', {
                    url:'${pageContext.request.contextPath}/manager/login'+$(this).serialize(),
                     onSubmit : function() {
                    //表单验证
                      return $(this).form('validate');
                     },


                   success:function(result){

                        var res=eval('('+result+')')
                        if(res.success){
                             location.href='${pageContext.request.contextPath}/back/main/main.jsp'
                             $.messager.alert('提示消息',res.msg,'info');
                        }else{
                             $.messager.alert('错误消息',res.msg,'warning');
                        }




                    }
                });


				}
			},{
				text:'重置',
				handler:function(){
				   $('#formInput').form('clear');

    }
			}]">


        <h2 align="center" style="font-style: italic">管理员登录</h2><br/>

        <form action="" method="post" id="formInput">

        <table style=" position:absolute;left:35%;top:15%;">

            <tr>
                <td colspan="2">
                    <input name="mname" id="username"  class="easyui-textbox"
                           data-options="iconCls:'icon-man',iconAlign:'left',width:250,height:30,prompt:'请输入用户名...',required:true,validType:'loginName'"/><br/><br/>

                    <input name="password" id="pwd" class="easyui-passwordbox" data-options="
                            iconCls:'icon-lock',validType:'minLength[6]',width:250,height:30,iconAlign:'left',prompt:'请输入密码...',required:true,showEye:false"/><br/><br/>
               <br/><br/>

                </td>

            </tr>
            <tr>
                <td>
                    <input name="code" id="validatecode" class="easyui-textbox" data-options="width:130,height:35,
                            iconCls:'icon-edit',iconAlign:'left',prompt:'验证码...'"/>


                </td>
                <td>
                    <img src="${pageContext.request.contextPath}/manager/getImage" style="margin-right: 0;"/>
                </td>

            </tr>



        </table>


        </form>



    </div>



</body>
</html>
