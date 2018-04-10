<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" language="java" %>


    <script>
        $(function(){
            KindEditor.create('#editor', {
                //指定主题风格可设置:default”、”simple”，指定simple时需要引入simple.css。
                //themeType : "simple",//修改主题
                height : "500px",
                //工具插件
                items : [ "source", "preview",
                    "fullscreen", "clearhtml", "|",
                    "undo", "redo", "|", "copy",
                    "paste", "plainpaste",
                    "wordpaste", "|",
                    "justifycenter",
                    "justifyright", "justifyfull",
                    "insertorderedlist",
                    "insertunorderedlist",
                    "indent", "outdent", "|",
                    "formatblock", "fontname",
                    "fontsize", "forecolor",
                    "hilitecolor", "bold",
                    "italic", "underline",
                    "strikethrough", "lineheight",
                    "removeformat", "|", "image",
                    "table", "hr", "emoticons",
                    "baidumap", "pagebreak",
                    "anchor", "link", "unlink" ],
                langType : 'zh_CN',
                //同步数据的方式，可设置""、"form"，值为form时提交form时自动同步，空时不会自动同步。
                syncType : "form",
                //true时根据 htmlTags 过滤HTML代码，false时允许输入任何代码。数据类型: Boolean 默认值: true
                filterMode : false,
                //可指定分页符HTML。
                pagebreakHtml : '<hr class="pageBreak" \/>',

                //true时显示浏览远程服务器按钮。
                allowFileManager : true,
                //相当于input file name
                filePostName : "image",
                //指定浏览远程图片的服务器端程序
                fileManagerJson : "${pageContext.request.contextPath }/imgs/browser",
                uploadJson : "${pageContext.request.contextPath }/imgs/uploadImg",
                //上传图片、Flash、视音频、文件时，支持添加别的参数一并传到服务器。 {item_id : 1000,category_id : 1}
                extraFileUploadParams : {
                    token : getCookie("token")
                },
                /*  afterCreate : function() {
                 elocalStorage();
                 }, */
                //编辑器内容发生变化后执行的回调函数。
                afterChange : function() {
                    this.sync();
                }, afterCreate: function () {
                    this.sync();
                }, afterBlur: function () {
                    this.sync();
                },

            });
            // 给id为btnData设置点击事件
            $("#sub").on("click", function () {
                //获取富文本输入框的值
                var htmlStr = KindEditor.instances[0].html().trim();

                console.log("未加密:\n" + htmlStr);

                console.log("加密:\n" + escape(htmlStr));

                $.post("${pageContext.request.contextPath}/article/saveArticle",{content:htmlStr}, function (result) {

                    $.messager.alert(result.msg)

                }, "JSON");
            });




            });


    </script>

</head>
<body>
<div>
<form name="example" method="post" action="">
    <input id="sub" type="submit" name="button" value="提交内容" />
    <textarea id="editor" name="content" cols="100" rows="8" style=" width: 69%; height: 50%; display: block; "></textarea>
    <br />
</form>
    </div>
<%--</body>
</html>--%>


