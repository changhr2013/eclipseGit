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
            <div class="layui-col-sm9 layui-col-md9 videoone" style="display:none;">
                <div class="layui-row">
                    <div class="layui-col-sm12 layui-col-md12 videolist videolist1">
                        <canvas id="video-canvas11" style="width:100%;"></canvas>
                        <a href="javascript:;" id="cicon-0" onclick="closePlayer(parseInt(id.slice(-1)))" class="close"></a>
                    </div>
                </div>
            </div>
            <!-- 4条视频 -->
            <div class="layui-col-sm9 layui-col-md9 videofour" >
                <!-- 视频列表 -->
                <div class="layui-row">
                    <div class="layui-col-sm12 layui-col-md6 videolist">
                        <canvas id="video-canvas21" style="width:100%;"></canvas>
                        <a href="javascript:;" id="cicon-1" onclick="closePlayer(parseInt(id.slice(-1)))" class="close"></a>
                    </div>
                    <div class="layui-col-sm12 layui-col-md6 videolist">
                        <canvas id="video-canvas22" style="width:100%;"></canvas>
                        <a href="javascript:;" id="cicon-2" onclick="closePlayer(parseInt(id.slice(-1)))" class="close"></a>
                    </div>
                    <div class="layui-col-sm12 layui-col-md6 videolist">
                        <canvas id="video-canvas23" style="width:100%;"></canvas>
                        <a href="javascript:;" id="cicon-3" onclick="closePlayer(parseInt(id.slice(-1)))" class="close"></a>
                    </div>
                    <div class="layui-col-sm12 layui-col-md6 videolist">
                        <canvas id="video-canvas24" style="width:100%;"></canvas>
                        <a href="javascript:;" id="cicon-4" onclick="closePlayer(parseInt(id.slice(-1)))" class="close"></a>
                    </div>
                </div>
            </div>
            <div class="layui-col-sm3 layui-col-md3 webright ">
			<div class="right-top">
			
			  
<!-- 				<div class="layui-row btngroup"> -->
<!-- 					<form class="layui-form" action=""> -->
<!-- 						<a lay-submit lay-filter="openconfig">开启配置流</a> -->
<!-- 						<a lay-submit lay-filter="closeconfig">关闭配置流</a> -->
<!-- 						<a lay-submit lay-filter="reset">重置环境</a> -->
<!-- 					</form> -->
<!-- 				</div> -->

<!-- 			<div class="layui-row" style="text-align:center;"> -->
<!-- 			<form class="layui-form" action="" style="margin-top:10px;"> -->
			
<!-- 			    <div class="layui-inline"> -->
<!-- 			      <div class="layui-input-inline"> -->
<!-- 			        <select name="modules" lay-verify="required" lay-search=""> -->
<!-- 			          <option value="">直接选择或搜索选择</option> -->
<!-- 			          <option value="1">layer</option> -->
<!-- 			          <option value="2">form</option> -->
<!-- 			          <option value="3">layim</option> -->
<!-- 			          <option value="4">element</option> -->
<!-- 			          <option value="5">laytpl</option> -->
<!-- 			        </select> -->
<!-- 			      </div> -->
<!-- 			    </div> -->
<!-- 			      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button> -->
<!-- 			</form> -->
<!-- 			</div> -->
			
				<div class="layui-row" style="text-align:center;">
				
<!-- 				  <div class="layui-btn-group" style=""> -->
				  <div style="margin:8px 0;">
				    <button lay-submit lay-filter="openconfig" class="layui-btn" style="border-radius:10px;height:30px;line-height:30px;">开启所有</button>
				    <button lay-submit lay-filter="closeconfig" class="layui-btn" style="border-radius:10px;height:30px;line-height:30px;">关闭所有</button>
				    <button lay-submit lay-filter="reset" class="layui-btn" style="border-radius:10px;height:30px;line-height:30px;">重置环境</button>
				  </div>
				  
				<form class="layui-form" action="" style="margin-bottom:-10px;">
		        <select id="regionSelect" name="region" lay-filter="region" lay-verify="required" lay-search="">
		          <option value="">搜索或选择区域</option>
		        </select>
				</form>
				
				</div>
			
								
				<table class="layui-table" id="videostream" lay-filter="switchdemo"></table>
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
    <a class="layui-btn layui-btn-xs class="btn_on" lay-event="open">开</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="close">关</a>
	</script>
	
	<script type="text/html" id="switchTpl">
	<a class="layui-btn layui-btn-xs layui-btn-radius" style="height:28px;line-height:28px;position: absolute;left: 34px;top: 0px;" lay-event="connect">播放</a>
	<a lay-event="{{ d.jsmpegpid != 0 ? 'checked' : 'unchecked' }}" class="layui-row switch {{ d.jsmpegpid != 0 ? 'switchon' : 'switchoff' }}">
                        <em></em>
                        <i></i>
                    </a>
	</script>
	
	<%-- 表格状态按钮模板 --%>
	<script type="text/html" id="ffmpegpid">
  	{{#  if(d.ffmpegpid === 0){ }}
		<i class="layui-icon" style="font-size: 30px;color: #fb3d38;">&#x1007;</i>  
  	{{#  } else if(d.gradename!==0) { }}
    	<i class="layui-icon" style="font-size: 30px;color: #009485;">&#xe616;</i>  
	{{#  } }}
	</script>
	
	<%-- rtsp流状态模板 --%>
	<script type="text/html" id="status">
  	{{#  if(d.ffmpegpid === 0){ }}
		<i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop">&#xe63e;</i>
  	{{#  } else if(d.gradename!==0) { }}
    	<i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop">&#xe63e;</i>
	{{#  } }}
	</script>
	
	
    <script type="text/javascript">
    //全局对象，用来存储WebServer返回的常量
	var STREAM_SERVER={};
    
	    //页面初始化
	    $(function(){  
	    	//页面初始化时向服务请求区域列表并动态加载到select中
	    	$.get('regionlist').done(function(data){
	    		for(var i=0;i<data.length;i++){
		       	    var obj=document.getElementById('regionSelect'); 
		       	    obj.options.add(new Option(data[i].regionName,data[i].regionId)); 
	    		}
	    	});
	    	
	    	//获取webservice的ip地址
	    	$.get("serverip").done(function(data){
	    		STREAM_SERVER.ip=data;
	    	});
	    });  
    
    
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
     
     //视频关闭
     $(".videolist").each(function(index,element){
         $(element).mouseover(function(){
             $(element).find("a").css("display","block");
             //在这里给a添加事件
         });
         $(element).mouseout(function(){
             $(element).find("a").css("display","none");
         });
     })

     //关闭销毁jsmpeg播放器对象的方法
     function closePlayer(index){
    	 
         playerList[index].destroy();
         playerList.splice(index,1,undefined);
         
         //获取webgl对象，将canvas画布设为黑色。
         var ctx=canvasList[index].getContext('webgl');
         //console.log(ctx);
         ctx.clearColor(0, 0, 0, 3)
         ctx.clearDepth(0.5);
         ctx.clearStencil(1);
         ctx.clear(ctx.DEPTH_BUFFER_BIT | ctx.COLOR_BUFFER_BIT);

     }

    	//初始化cavas画布和Player播放器变量
        var canvas1 = document.getElementById('video-canvas11');
        var canvas2 = document.getElementById('video-canvas21');
        var canvas3 = document.getElementById('video-canvas22');
        var canvas4 = document.getElementById('video-canvas23');
        var canvas5 = document.getElementById('video-canvas24');
        
		var player1,player2,player3,player4,player5;
		
		var playerList=[player1,player2,player3,player4,player5]; 
		var canvasList=[canvas1,canvas2,canvas3,canvas4,canvas5];

        //客户端刷新或者退出页面时关闭视频连接
        window.onbeforeunload = onbeforeunload_handler;
        function onbeforeunload_handler(){
            
            for(let i=0;i<playerList.length;i++){
            	if(playerList[i]!==undefined){
                	playerList[i].destroy();
            	}
            }
            
        }
        
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
//         	      ,{width: 220,title:'操作', align:'center', toolbar: '#statcontrol'}
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
          	    		if(newdata.status==='0'){
                    		let nodelist=$('.layui-table-cell.laytable-cell-1-ffmpegpid');
                    		let index= parseInt(newdata.index)+1;
                    		nodelist[index].innerHTML='<i class="layui-icon">&#x1007;</i>';
                    		nodelist[index+count+1].innerHTML='<i class="layui-icon">&#x1007;</i>';
                    		return;
          	    		}else if(newdata.status==='1'){
                    		let nodelist=$('.layui-table-cell.laytable-cell-1-ffmpegpid');
                    		let sucindex= parseInt(newdata.index)+1;
                    		nodelist[sucindex].innerHTML='<i class="layui-icon">&#x1005;</i>';
                    		nodelist[sucindex+count+1].innerHTML='<i class="layui-icon">&#x1005;</i>';
                    		return;
          	    		}
        	    	});
          		  }
          		  

          		  
// 	        	  for(let i=0;i<nodelist.length;i++){
// 	        		  if((i!==0)&&(i!==nodelist.length/2)){
// 	        			  nodelist[i].innerHTML='<i class="layui-icon">&#xe616;</i>';
// 	        		  }
//         	  }
          		
          	  }
        	  });
        	  
        	  
        	  //监听工具条（弃用）
        	  table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        	    var data = obj.data //获得当前行数据
        	    ,layEvent = obj.event; //获得 lay-event 对应的值
    	    	var streamUrl=data.streamUrl;
        	    //console.log(data);
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
        	    	
        	    	for(let i=0;i<playerList.length;i++){
        	    		
        	    		if(playerList[i]===undefined){
        	    			let wsUrl="ws://192.168.0.90:"+data.outPort;
        	    			let imgUrl="../resources/images/video.png";
        	    			//console.log(wsUrl);
        	    			playerList[i] = new JSMpeg.Player(wsUrl, {canvas: canvasList[i],poster:imgUrl});
        	    			console.log(playerList[i]);
    	    				layer.msg("加载中...",{time:1000});
        	    			setTimeout(function(index){
            	    			if(playerList[index].demuxer.bits===null){
            	    				layer.open({
            	    					  title: '信息提示'
            	    					  ,content: '播放失败，请检查视频源或后台服务进程。'
            	    					});
            	    				playerList[index].destroy();
            	    				playerList.splice(index,1,undefined);
            	    			}
        	    			},2000, i);

        	    			return;
        	    		}
        	    		
        	    		if(i===playerList.length-1){
        	    			playerList[0].destroy();
        	    			let wsUrl="ws://192.168.0.90:"+data.outPort;
        	    			playerList[0] = new JSMpeg.Player(wsUrl, {canvas: canvasList[0]});
        	    			console.log(playerList);
        	    		}
        	    	}
             	}
        	    
        	  });
        	  
        	  //监听switch开关操作
        	  table.on('tool(switchdemo)', function(obj){
        	  
          	    var data = obj.data //获得当前行数据
          	    ,layEvent = obj.event; //获得 lay-event 对应的值
      	    	var streamUrl=data.streamUrl;
          	    //console.log(data);
          	    if(layEvent === 'unchecked'){
          	      //layer.msg('开启视频流');
          	      tableIns.reload({
  			  		 url: 'opensinglejfmpeg'
  			  		,where: {
  			  			rtspUrl:streamUrl
  			  			,rtspUsername:data.rtspUsername
  			  			,rtspPassword:data.rtspPassword
  			  			,jsmpegPassword:data.password
  			  			}
          	      	,method: 'post'
          	      	});
//           	      console.log(obj);
// 					obj.update({ffmpegpid:123,jsmpegpid:456
						
// 					});

          	    } else if(layEvent === 'checked'){
            	      tableIns.reload({
   			  		 url: 'closesinglejfmpeg'
   			  		,where: {rtspUrl:streamUrl}
           	      	,method: 'get'
           	      	});
          	    }else if(layEvent === 'connect'){
        	    	
        	    	for(let i=0;i<playerList.length;i++){
        	    		
        	    		if(playerList[i]===undefined){
        	    			let wsUrl="ws://"+STREAM_SERVER.ip+":"+data.outPort;
        	    			let imgUrl="../resources/images/video.png";
        	    			//console.log(wsUrl);
        	    			playerList[i] = new JSMpeg.Player(wsUrl, {canvas: canvasList[i],poster:imgUrl});
        	    			console.log(playerList[i]);
    	    				layer.msg("加载中...",{time:1000});
        	    			setTimeout(function(index){
            	    			if(playerList[index].demuxer.bits===null){
            	    				layer.open({
            	    					  title: '信息提示'
            	    					  ,content: '播放失败，请检查视频源或后台服务进程。'
            	    					});
            	    				playerList[index].destroy();
            	    				playerList.splice(index,1,undefined);
            	    			}
        	    			},2000, i);

        	    			return;
        	    		}
        	    		
        	    		if(i===playerList.length-1){
        	    			playerList[0].destroy();
        	    			let wsUrl="ws://"+STREAM_SERVER.ip+":"+data.outPort;
        	    			playerList[0] = new JSMpeg.Player(wsUrl, {canvas: canvasList[0]});
        	    			console.log(playerList);
        	    		}
        	    	}
             	}
        	  });
        	  
        	  //总控按钮：启动配置流，关闭配置流，重置环境
        	  form.on('submit(openconfig)', function(data){
        		  STREAM_SERVER.regionId=$("#regionSelect option:selected").val();
        	      tableIns.reload({
        		  		 url: 'openjfmpeg'
   	  			  		,where: {
   	  			  		regionId:STREAM_SERVER.regionId
   	  			  			}
   	          	      	,method: 'post'
        		      	});
        	  });
        	  form.on('submit(closeconfig)', function(data){
        		  STREAM_SERVER.regionId=$("#regionSelect option:selected").val();
        	      tableIns.reload({
        		  		 url: 'closejfmpeg'
   	  			  		,where: {
   	   	  			  		regionId:STREAM_SERVER.regionId
   	   	  			  			}
        		      	,method: 'post'
        		      	});
        	  });
        	  form.on('submit(reset)', function(data){
        	      tableIns.reload({
        		  		 url: 'reset'
        		      	,method: 'get'
        		      	});
        	  });
        	  
        	  form.on('select(region)', function(data){
        		  console.log(data);
        		  STREAM_SERVER.regionId=$("#regionSelect option:selected").val();
        	      tableIns.reload({
        		  		 url: 'curstreamlist'
 	  			  		,where: {
   	   	  			  		regionId:STREAM_SERVER.regionId
   	   	  			  			}
        		      	,method: 'post'
        		      	});
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