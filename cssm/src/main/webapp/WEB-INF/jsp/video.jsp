<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			
				<div class="layui-row" style="text-align:center;">
				
				  <div style="margin:8px 0;">
				    <button lay-submit lay-filter="openconfig" class="layui-btn" style="border-radius:10px;height:30px;line-height:30px;">开启所有</button>
				    <button lay-submit lay-filter="closeconfig" class="layui-btn" style="border-radius:10px;height:30px;line-height:30px;">关闭所有</button>
				    <button lay-submit lay-filter="reset" class="layui-btn" style="border-radius:10px;height:30px;line-height:30px;">重置环境</button>
				  </div>
				  
				<form class="layui-form" action="" style="margin-bottom:-10px;">
		        <select id="regionSelect" name="region" lay-filter="region" lay-verify="required" lay-search="">
		          <option value="">搜索或选择区域...</option>
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
    
	<%-- 流控制按钮模板(旧：带服务控制) --%>
	<script type="text/html" id="switchTpl">
	{{# if(d.cameraStatus == 1){ }}
		<a class="layui-btn layui-btn-xs layui-btn-radius" style="height:28px;line-height:28px;position: absolute;left: 15px;top: 0px;" lay-event="connect">播放</a>
		<a lay-event="{{ d.serviceStatus == true ? 'checked' : 'unchecked' }}" class="layui-row switch {{ d.serviceStatus == true ? 'switchon' : 'switchoff' }}">
    	                    <em></em>
    	                    <i></i>  
    	                </a>
	{{# }else{ }}
		<a class="layui-btn layui-btn-xs layui-btn-disabled layui-btn-radius" style="height:28px;line-height:28px;position: absolute;left: 15px;top: 0px;">播放</a>
		<a lay-event="{{ d.serviceStatus == true ? 'checked' : 'unavailable' }}" class="layui-row switch {{ d.serviceStatus == true ? 'switchon' : 'switchoff' }}">
    	                    <em></em>
    	                    <i></i>  
    	                </a>
	{{# } }}
	</script>
	
	<%-- 流控制按钮模板 (新：不带服务控制)--%>
	<script type="text/html" id="switchTpl-new">
	{{# if(d.cameraStatus == 1){ }}
		<a class="layui-btn layui-btn-xs layui-btn-radius" style="height:28px;line-height:28px;position: absolute;left: 15px;top: 0px;" lay-event="connect">播放</a>
	{{# }else{ }}
		<a class="layui-btn layui-btn-xs layui-btn-disabled layui-btn-radius" style="height:28px;line-height:28px;position: absolute;left: 15px;top: 0px;">播放</a>
	{{# } }}
	</script>
	
	<%-- rtsp流状态模板 --%>
	<script type="text/html" id="status">
	{{# if(d.cameraStatus == 1){}}
		<i class="layui-icon" style="font-size:25px;">&#x1005;</i>
	{{# }else if(d.cameraStatus == 0){}}
		<i class="layui-icon" style="font-size:25px;">&#x1007;</i>
	{{# }}}
	</script>
	
    <script type="text/javascript">
    //全局对象集合，用来统一管理存储全局变量
	var STREAM_SERVER = {};
    //心跳包变量
	STREAM_SERVER.playList = new Set();
	
	//心跳定时任务
	STREAM_SERVER.timer = setInterval(function() {
		//清空心跳set集合开始组装新的心跳包
		STREAM_SERVER.playList.clear();
		for(var player of playerList){
			if(player !== undefined){
				STREAM_SERVER.playList.add(player.rtspUrl);
			}
		}
		//当心跳包数据不为空时向服务端发送心跳数据包
		if(STREAM_SERVER.playList.size>0){
			//发送心跳包
			$.post('heartbeatcheck',{
				clientheart: JSON.stringify(Array.from(STREAM_SERVER.playList))
			});
		}
		//console.log(Array.from(STREAM_SERVER.playList));
		}, 30000);
    
	    //页面初始化
	    $(function(){  
	    	//页面初始化时向服务请求区域列表并动态加载到select中
	    	$.get('regionlist').done(function(regions){
	    		var selDom = $('#regionSelect');
	    		for(var region of regions){
	    			selDom.append('<option value='+region.reginonid+'>'+region.reginonname+'</option>');
	    		}
	    		//重新渲染form表单
				 layui.use('form', function(){
				   var form = layui.form;
				   form.render();
				  });
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

      //一四画面切换按钮
        $('.one').click(function () {
            $(".one").addClass("active");
            $(".four").removeClass("active");
            $('.videoone').css("display", "block");
            $('.videofour').css("display", "none");
        });

        $('.four').click(function () {
            $(".four").addClass("active");
            $(".one").removeClass("active");

            $('.videoone').css("display", "none");
            $('.videofour').css("display", "block");
        });

        $(".direction li:even").mouseover(function () {
            $(this).addClass("show1");
        });
        $(".direction li:even").mouseout(function () {
            $(this).removeClass("show1");
        });

        //视频关闭悬浮按钮
        $(".videolist").each(function (index, element) {
            $(element).mouseover(function () {
                $(element).find("a").css("display", "block");
            });
            $(element).mouseout(function () {
                $(element).find("a").css("display", "none");
            });
        })

        //关闭销毁jsmpeg播放器对象的方法
        function closePlayer(index) {
            playerList[index].destroy();
            playerList.splice(index, 1, undefined);

            //获取webgl对象，将canvas画布设为黑色。
            var ctx = canvasList[index].getContext('webgl');
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

        var playerList = [undefined, undefined, undefined, undefined, undefined];
        var canvasList = [canvas1, canvas2, canvas3, canvas4, canvas5];

        //客户端刷新或者退出页面时关闭视频连接
        window.onbeforeunload = onbeforeunload_handler;
        function onbeforeunload_handler() {
            for (var i = 0; i < playerList.length; i++) {
                if (playerList[i] !== undefined) {
                    playerList[i].destroy();
                }
            }
        }
        
        //layui相关的操作
        layui.use(['laypage', 'layer', 'table', 'element','form'], function(){
        	  var laypage = layui.laypage //分页
        	  ,layer = layui.layer //弹层
        	  ,table = layui.table //表格
        	  ,element = layui.element //元素操作
        	  ,form = layui.form; //表单
        	  
        	  //执行一个 table 实例
        	  var tableIns = table.render({
        	    elem: '#videostream'
        	    ,height: 400
        	    ,url: 'curstreamlist' //数据接口
        	    ,page: true //开启分页
        	    ,limit: 7
        	    ,cols: [[ //表头
//         	      {field: 'streamUrl', title: 'rtsp', width:140}
        	      {field: 'rtspAlias', title: 'rtsp', width:180}
        	      ,{field: 'cameraStatus', title: '状态', width:60, templet:'#status'}
        	      ,{field: 'serviceStatus', title:'操作 | 服务', width:160, toolbar:'#switchTpl',unresize: true}
        	    ]]
        	  });
        	  
        	//监听switch开关操作
        	  table.on('tool(switchdemo)', function (obj) {
        	      //获得当前行数据和 lay-event 对应的值
        	      var data = obj.data, layEvent = obj.event;
        	      var rtspUrl = data.rtspUrl;
        	      var wsUrl = data.wsUrl;

        	      if (layEvent === 'unchecked') {
        	          //重载表格，打开相应的视频流服务
        	          STREAM_SERVER.regionId = $("#regionSelect option:selected").val();
        	          tableIns.reload({
        	              url: 'openjfmpeg'
        	              , where: {
        	                  rtspStreamUrl: rtspUrl
        	                  , regionId: STREAM_SERVER.regionId
        	              }
        	              , method: 'post'
        	          });
        	      } else if (layEvent === 'checked') {
        	          //重载表格，关闭相应的视频流服务
        	          STREAM_SERVER.regionId = $("#regionSelect option:selected").val();
        	          tableIns.reload({
        	              url: 'closejfmpeg'
        	              , where: {
        	                  rtspStreamUrl: rtspUrl
        	                  , regionId: STREAM_SERVER.regionId
        	              }
        	              , method: 'post'
        	          });
					} else if (layEvent === 'connect') {

						for (var i = 0; i < playerList.length; i++) {
							//如果有未占用的canvas，就将视频显示到空闲的canvas上
							if (playerList[i] === undefined) {

								//如果传入的WebSocket流为空，就弹窗提示用户
								if (wsUrl === "" || wsUrl === null) {
									//重载表格，打开相应的视频流服务
									$.get("openoneservice", {
										rtspUrl: rtspUrl
									}).done(function (newdata) {
										obj.update({
											wsUrl: newdata.wsUrl
										});
										//在空闲的canvas上初始化jsmpegPlayer播放器对象
										playerList[i] = new JSMpeg.Player(newdata.wsUrl, { canvas: canvasList[i] });
										//将服务器地址字段存入jsmpegPlayer对象
										playerList[i].rtspUrl = data.rtspUrl;
										//加载中提示信息
										layer.msg("加载中...", { time: 1000 });
										//设置定时器，2s后检测jsmpegPlayer是否有数据流传入
										setTimeout(function (index) {
											//数据流为null就销毁播放器解除占用并提示用户
											if (playerList[index].demuxer.bits === null) {
												layer.open({
													title: '信息提示'
													, content: '播放失败，请检查视频源或后台服务进程。'
												});
												playerList[index].destroy();
												playerList.splice(index, 1, undefined);
											}
										}, 2500, i);
									});
									return;
								}
								//在空闲的canvas上初始化jsmpegPlayer播放器对象
								playerList[i] = new JSMpeg.Player(wsUrl, { canvas: canvasList[i] });
								//将服务器地址字段存入jsmpegPlayer对象
								playerList[i].rtspUrl = data.rtspUrl;
								//加载中提示信息
								layer.msg("加载中...", { time: 1000 });
								//设置定时器，2s后检测jsmpegPlayer是否有数据流传入
								setTimeout(function (index) {
									//数据流为null就销毁播放器解除占用并提示用户
									if (playerList[index].demuxer.bits === null) {
										layer.open({
											title: '信息提示'
											, content: '播放失败，请检查视频源或后台服务进程。'
										});
										playerList[index].destroy();
										playerList.splice(index, 1, undefined);
									}
								}, 2500, i);
								return;
							}
							//如果视频窗口都在占用，就将新的视频显示在第一个窗口上
							if (i === playerList.length - 1) {
								//如果传入的WebSocket流为空，就弹窗提示用户
								if (wsUrl === "" || wsUrl === null) {
									//ajax请求，打开相应的视频流服务
									$.get("openoneservice", {
										rtspUrl: rtspUrl
									}).done(function (newdata) {
										obj.update({
											wsUrl: newdata.wsUrl
										});
										//销毁第一个canvas
										playerList[0].destroy();
										//在第一个canvas上初始化新的jsmpegPlayer播放器对象
										playerList[0] = new JSMpeg.Player(newdata.wsUrl, { canvas: canvasList[i] });
										//将服务器地址字段存入jsmpegPlayer对象
										playerList[0].rtspUrl = data.rtspUrl;
										//加载中提示信息
										layer.msg("加载中...", { time: 1000 });
										//设置定时器，2s后检测jsmpegPlayer是否有数据流传入
										setTimeout(function (index) {
											//数据流为null就销毁播放器解除占用并提示用户
											if (playerList[index].demuxer.bits === null) {
												layer.open({
													title: '信息提示'
													, content: '播放失败，请检查视频源或后台服务进程。'
												});
												playerList[index].destroy();
												playerList.splice(index, 1, undefined);
											}
										}, 2500, 0);
									});
									return;
								}
								playerList[0].destroy();
								playerList[0] = new JSMpeg.Player(wsUrl, { canvas: canvasList[0] });
								playerList[0].rtspUrl = data.rtspUrl;
								//加载中提示信息
								layer.msg("加载中...", { time: 1000 });
								//设置定时器，2s后检测jsmpegPlayer是否有数据流传入
								setTimeout(function (index) {
									//数据流为null就销毁播放器解除占用并提示用户
									if (playerList[index].demuxer.bits === null) {
										layer.open({
											title: '信息提示'
											, content: '播放失败，请检查视频源或后台服务进程。'
										});
										playerList[index].destroy();
										playerList.splice(index, 1, undefined);
									}
								}, 2500, 0);
								return;
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
        	  
        	  //监听下拉列表选中事件
        	  form.on('select(region)', function(data){
        		  //console.log(data);
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
//         	  laypage.render({
//         	    elem: 'pageDemo' //分页容器的id
//         	    ,count: 100 //总页数
//         	    ,skin: '#1E9FFF' //自定义选中色值
//         	    //,skip: true //开启跳页
//         	    ,jump: function(obj, first){
//         	      if(!first){
//         	        layer.msg('第'+ obj.curr +'页');
//         	      }
//         	    }
//         	  });
        	  
        	});
    </script>
</body>
</html>
