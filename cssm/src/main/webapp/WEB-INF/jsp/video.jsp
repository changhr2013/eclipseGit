<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script type="text/javascript" src="../resources/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="../resources/js/rating.min.js"></script>
    <link rel="stylesheet" href="../resources/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../resources/build/css/app.css" media="all">
    <link rel="stylesheet" href="../resources/css/style.css" media="all">
    <link rel="stylesheet" href="../resources/iconfont/iconfont.css" media="all">
    <style type="text/css">
        .videoPlayer{
            border: 1px solid #000;
            width: 600px;
        }
        #video{
            margin-top: 0px;
        }
    </style>
</head>
<body>
    <div class="layui-fluid main">
        <div class="layui-row hmfg">
            <div class="layui-col-sm12 layui-col-md12">
                <a href="javascript:;" class="one"><i class="iconfont">&#xea58;</i>一画面</a>
                <a href="javascript:;" class="four active"><i class="iconfont">&#xea50;</i>四画面</a>
            </div>
            
        </div>
        <div class="layui-row video">
            <!-- 1条视频 -->
            <div class="layui-col-sm10 layui-col-md10 videoone" style="display:none;">
                <div class="layui-row">
                    <div class="layui-col-sm12 layui-col-md12  videolist">
                        <!-- <img src="images/video.png" class="layui-img"> -->
                        <canvas id="video-canvas11" style="width:100%;"></canvas>
                    </div>
                </div>
            </div>
            <!-- 4条视频 -->
            <div class="layui-col-sm9 layui-col-md9 videofour" >
                <!-- 视频列表 -->
                <div class="layui-row">
                    <div class="layui-col-sm12 layui-col-md6 videolist">
                        <canvas id="video-canvas21" style="width:100%;"></canvas>
                        <!-- <img src="images/video.png" class="layui-img"> -->
                    </div>
                    <div class="layui-col-sm12 layui-col-md6 videolist">
                        <canvas id="video-canvas22" style="width:100%;"></canvas>
                        <!-- <img src="images/video.png" class="layui-img"> -->
                    </div>
                    <div class="layui-col-sm12 layui-col-md6 videolist">
                        <canvas id="video-canvas23" style="width:100%;"></canvas>
                        <!-- <img src="images/video.png" class="layui-img"> -->
                    </div>
                    <div class="layui-col-sm12 layui-col-md6 videolist">
                        <canvas id="video-canvas24" style="width:100%;"></canvas>
                        <!-- <img src="images/video.png" class="layui-img"> -->
                    </div>
                </div>
            </div>
            <div class="layui-col-sm3 layui-col-md3 webright ">
			<div class="right-top">
				<div class="layui-row btngroup">
					<button>全部</button>
					<button>全部</button>
					<button>全部</button>
				</div>
				
				<table class="layui-table" id="videostream" lay-filter="demo"></table>
			</div>
                <div class="control">
                    <div class="control1">
                        <div class="control1-left">
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                            <select>
                                <option>灯光</option>
                                <option>色调</option>
                                <option>其他</option>
                            </select>
                        </div>
                        
                        <div class="control1-right">
                            <div>
                                <i class="iconfont">&#xe641;</i>
                                <button>开</button>
                           </div>
                           <div>
                                <i class="iconfont">&#xe643;</i>
                                <button>关</button>
                           </div>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                    <div class="direction">
                        <ul>
                            <li><a href=""></a></li>
                            <li><a href=""></a></li>
                            <li><a href=""></a></li>
                            <li><a href=""></a></li>
                            <li><a href=""></a></li>
                            <li><a href=""></a></li>
                            <li><a href=""></a></li>
                            <li><a href=""></a></li>
                        </ul>
                        <div class="dir-con">
                            <div>
                                <label>放大</label>
                                <span><button>-</button><button>+</button></span>
                            </div>
                            <div>
                                <label>焦距</label>
                                <span><button>-</button><button>+</button></span>
                            </div>
                            <div>
                                <label>光圈</label>
                                <span><button>-</button><button>+</button></span>
                            </div>
                            <div>
                                <select>
                                    <option>巡航1</option>
                                    <option>巡航2</option>
                                    <option>巡航3</option>
                                </select>
                            </div>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                    <div class="speed">
                        <label>云台速度</label>
                        <div class="speedbg" id="rating-31"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <%-- layui js库 --%>
    <script type="text/javascript" src="../resources/plugins/layui/layui.js"></script>
    
    <%-- jsmpeg依赖的js库 --%>
    <script type="text/javascript" src="../resources/jsmpeg.min.js"></script>
    
	<%-- 表格控制按钮模板  --%>
    <script type="text/html" id="statcontrol">
	<a class="layui-btn layui-btn-xs" lay-event="connect">播放</a>
    <a class="layui-btn layui-btn-xs" lay-event="open">开</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="close">关</a>
	</script>
	
	<%-- 表格状态按钮模板 --%>
	<script type="text/html" id="ffmpegpid">
  	{{#  if(d.ffmpegpid === 0){ }}
		<i class="layui-icon" style="font-size: 30px;color: #fb3d38;">&#x1007;</i>  
  	{{#  } else if(d.gradename!==0) { }}
    	<i class="layui-icon" style="font-size: 30px;color: #009485;">&#xe616;</i>  
	{{#  } }}
	</script>
	
	
    <script type="text/javascript">

        //速度控制线
        $(document).ready(function () {
            $('#rating-31').slidy();
        })

        //右侧设备选项卡
        //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
        layui.use('element', function(){
            var element = layui.element;
        });

        
    //画面分割按钮
    $('.one').click(function(){
        $(".one").addClass("active");
        $(".four").removeClass("active");
        $('.videoone').css("display","block");
        $('.videofour').css("display","none");

    });
    $('.four').click(function(){
        $(".four").addClass("active");
        $(".one").removeClass("active");

        $('.videoone').css("display","none");
        $('.videofour').css("display","block");
    });

     $(".direction li:even").mouseover(function(){
         $(this).addClass("show1");
     });
     $(".direction li:even").mouseout(function(){
         $(this).removeClass("show1");
    });

        var canvas1 = document.getElementById('video-canvas11');
        var url1 = 'ws://192.168.0.90:18144/';
		var player1 = new JSMpeg.Player(url1, {canvas: canvas1});

        var canvas2 = document.getElementById('video-canvas21');
		var url2 = 'ws://192.168.0.90:36719/';
		var player2 = new JSMpeg.Player(url2, {canvas: canvas2});

        var canvas3 = document.getElementById('video-canvas22');
		var url3 = 'ws://192.168.0.90:18144/';
		var player3 = new JSMpeg.Player(url3, {canvas: canvas3});

        var canvas4 = document.getElementById('video-canvas23');
		var url4 = 'ws://192.168.0.90:9339/';
		var player4 = new JSMpeg.Player(url4, {canvas: canvas4});

        var canvas5 = document.getElementById('video-canvas24');
		var url5 = 'ws://192.168.0.90:9339/';
		var player5 = new JSMpeg.Player(url5, {canvas: canvas5});

        window.onbeforeunload = onbeforeunload_handler;
        function onbeforeunload_handler(){
            player1.destroy();
            player2.destroy();
            player3.destroy();
            player4.destroy();
            player5.destroy();
        }
        
        layui.use(['laypage', 'layer', 'table', 'element'], function(){
        	  var laypage = layui.laypage //分页
        	  layer = layui.layer //弹层
        	  ,table = layui.table //表格
        	  ,element = layui.element; //元素操作
        	  
        	  
        	  //执行一个 table 实例
        	  var tableIns=table.render({
        	    elem: '#videostream'
        	    ,height: 332
        	    ,url: 'currentjfmpeglist' //数据接口
        	    ,page: true //开启分页
        	    ,cols: [[ //表头
        	      {field: 'streamUrl', title: 'rtsp', width:80, fixed: 'left'}
        	      ,{field: 'ffmpegpid', title: '状态', width:60, fixed: 'left',templet:'#ffmpegpid'}
        	      ,{fixed: 'right',width: 230,title:'操作', align:'center', toolbar: '#statcontrol'}
        	    ]]
        	  });
        	  
        	  
        	  //监听工具条
        	  table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        	    var data = obj.data //获得当前行数据
        	    ,layEvent = obj.event; //获得 lay-event 对应的值
    	    	var streamUrl=data.streamUrl;
        	    console.log(data);
        	    if(layEvent === 'open'){
        	      //layer.msg('开启视频流');
        	      tableIns.reload({
			  		 url: 'opensinglejfmpeg'
			  		,where: {rtspUrl:streamUrl,
			  			rtspUsername:data.rtspUsername,
			  			rtspPassword:data.rtspPassword,
			  			jsmpegPassword:data.password}
        	      	,method: 'post'
        	      	});

        	    } else if(layEvent === 'close'){
          	      tableIns.reload({
 			  		 url: 'closesinglejfmpeg'
 			  		,where: {rtspUrl:streamUrl}
         	      	,method: 'get'
         	      	});
        	    }else if(layEvent === 'connect'){
        	    	player1.destroy();
        	    	var wsUrl="ws://192.168.0.90:"+data.outPort;
        	    	player1 = new JSMpeg.Player(wsUrl, {canvas: canvas1});
             	}
        	    
        	  });
        	  
        	  
        	  //分页
        	  laypage.render({
        	    elem: 'pageDemo' //分页容器的id
        	    ,count: 100 //总页数
        	    ,skin: '#1E9FFF' //自定义选中色值
        	    //,skip: true //开启跳页
        	    ,jump: function(obj, first){
        	      if(!first){
        	        layer.msg('第'+ obj.curr +'页');
        	      }
        	    }
        	  });
        	  
        	});

    </script>
</body>
</html>