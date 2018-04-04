<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script type="text/javascript" src="./resources/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="./resources/js/rating.min.js"></script>
    <link rel="stylesheet" href="./resources/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./resources/build/css/app.css" media="all">
    <link rel="stylesheet" href="./resources/iconfont/iconfont.css" media="all">
</head>
<body>
   <table id="demo" lay-filter="test"></table>
   <script src="./resources/plugins/layui/layui.js"></script>
<script>
layui.use('table', function(){
  var table = layui.table;
  
  //第一个实例
  table.render({
    elem: '#demo'
    ,height: 'full-20'
    ,url: 'grid' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头
      {field: 'monitor', title: 'monitor', width:160, sort: false, fixed: 'left'}
      ,{field: 'rtspstreamurl', title: 'rtspstreamurl', width:240}
      ,{field: 'rtsppsd', title: 'rtsppsd', width:160, sort: false}
      ,{field: 'rtspusername', title: 'rtspusername', width:120} 
      ,{field: 'password', title: 'password', width: 120}
      ,{field: 'regionid', title: 'regionid', width: 120, sort: false}
    ]]
  });
  
});
</script>
</body>
</html>
