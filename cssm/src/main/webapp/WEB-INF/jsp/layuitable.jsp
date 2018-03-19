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

	<table class="layui-table" id="videostream" lay-filter="switchdemo"></table>

    <%-- layui js库 --%>
    <script type="text/javascript" src="../resources/plugins/layui/layui.js"></script>
    
	<script>
    //layui相关的操作
    layui.use(['laypage', 'layer', 'table', 'element','form'], function(){
    	  var laypage = layui.laypage //分页
    	  layer = layui.layer //弹层
    	  ,table = layui.table //表格
    	  ,element = layui.element //元素操作
    	  ,form=layui.form;
    	  
    	  
    	  //执行一个 table 实例
    	  var tableIns=table.render({
    	    elem: '#videostream'
    	    ,height: 400
    	    ,url: 'curstreamlist' //数据接口
    	    ,page: true //开启分页
    	    ,cols: [[ //表头
    	      {field: 'streamUrl', title: 'rtsp', width:140, fixed: 'left'}
    	      ,{field: 'ffmpegpid', title: '状态', width:60, fixed: 'left',templet:'#status'}
//     	      ,{width: 220,title:'操作', align:'center', toolbar: '#statcontrol'}
    	      ,{field:'jsmpegpid', title:'操作', width:200, toolbar:'#switchTpl',unresize: true}
    	    ]]
    	  	,done: function(res, curr, count){
      		  console.log(res);
      		  let data=res.data;
      		  
      		  for(let i=0;i<count;i++){
      			  
			  let parser=document.createElement('a');
			  parser.href='http://'+data[i].streamUrl
			  let port=parser.port;
      	    	$.post("getstatus",{
      	    		url:'rtsp://'+data[i].rtspUsername+':'+data[i].rtspPassword+'@'+data[i].streamUrl
      	    		,ip:data[i].streamUrl.split(':')[0]
      	    		,port:port
      	    		,status:'0'
      	    		,index:i
      	    	}).done(function(newdata){
      	    		console.log(newdata);
      	    		let successStatus='<i class="layui-icon" style="font-size:25px;">&#x1005;</i>';
      	    		let failStatus='<i class="layui-icon" style="font-size:25px;">&#x1007;</i>';
            		let nodelist=$('.layui-table-cell.laytable-cell-1-ffmpegpid');
      	    		if(newdata.status==='0'){
                		let index= parseInt(newdata.index)+1;
                		nodelist[index].innerHTML=failStatus;
                		nodelist[index+count+1].innerHTML=failStatus;
                		return;
      	    		}else if(newdata.status==='1'){
                		let sucindex= parseInt(newdata.index)+1;
                		nodelist[sucindex].innerHTML=successStatus;
                		nodelist[sucindex+count+1].innerHTML=successStatus;
                		return;
      	    		}
    	    	});
      		  }
      	  }
    	  });
    });
	</script>
</body>
</html>