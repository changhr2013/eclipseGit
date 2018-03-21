<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index Control Page</title>
    <link rel="stylesheet" href="../resources/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../resources/build/css/app.css" media="all">
    <link rel="stylesheet" href="../resources/iconfont/iconfont.css" media="all">
</head>
<body>
    <div class="layui-layout layui-layout-admin kit-layout-admin">
        <div class="layui-header">
            <div class="layui-logo">小浪底视频</div>
            <div class="layui-logo kit-logo-mobile">K</div>
        </div>
        <div class="layui-side layui-bg-black kit-side">
            <div class="layui-side-scroll">
                <div class="kit-side-fold">
                    <i class="fa fa-navicon" aria-hidden="true"></i>
                </div>
<!--                 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree" lay-filter="kitNavbar" kit-navbar>
                    <li class="layui-nav-item">
                        <a class="" href="javascript:;"data-url="video.html" data-icon="fa-user" data-title="视频" kit-target data-id='-1'>
                            <i class="iconfont" aria-hidden="true">&#xe647;</i>
                            <span> 视频</span>
                        </a>
                    </li>
                   
                    <li class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;" kit-target data-options="{url:'videotape.html',icon:'&#xe6ed;',title:'录像',id:'1'}">
                            <i class="iconfont" aria-hidden="true">&#xe6dc;</i>
                            <span>录像</span>
                        </a>
                    </li>
                    
                </ul>
            </div>
        </div>
        <div class="layui-body" id="container">
            内容主体区域
            <div style="padding: 15px;">主体内容加载中,请稍等...</div>
        </div>

        <div class="layui-footer">
            底部固定区域
            2017 &copy;
            <a href="http://kit.zhengjinfan.cn/">kit.zhengjinfan.cn/</a> MIT license

        </div>
    </div>

    <script src="../resources/plugins/layui/layui.js"></script>

    <script>
        var message;
        layui.config({
            base: '../resources/build/js/'
        }).use(['app', 'message'], function () {
            var app = layui.app,
                $ = layui.jquery,
                layer = layui.layer;
            //将message设置为全局以便子页面调用
            message = layui.message;
            //主入口
            app.set({
                type: 'iframe'
            }).init();
            $('#pay').on('click', function () {
                layer.open({
                    title: false,
                    type: 1,
                    content: '<img src="../resources/build/images/pay.png" />',
                    area: ['500px', '250px'],
                    shadeClose: true
                });
            });
        });

    </script>
</body>
</html>