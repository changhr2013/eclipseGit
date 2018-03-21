<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>视频</title>
    <script type="text/javascript" src="../resources/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="../resources/js/rating.min.js"></script>
     <script type="text/javascript" src="../resources/js/backplay.js"></script> 
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
    <div class="layui-fluid">
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
                        <img src="../resources/images/video.png" class="layui-img">
                    </div>
                    
                </div>
            </div>
            <!-- 4条视频 -->
            <div class="layui-col-sm10 layui-col-md10 videofour" >
                <!-- 视频列表 -->
                <div class="layui-row layui-col-space10">
                    <div class="layui-col-sm12 layui-col-md6 videolist">
                        <img src="../resources/images/video.png" class="layui-img">
                    </div>
                    <div class="layui-col-sm12 layui-col-md6 videolist">
                        <img src="../resources/images/video.png" class="layui-img">
                    </div>
                    <div class="layui-col-sm12 layui-col-md6 videolist">
                        <img src="../resources/images/video.png" class="layui-img">
                    </div>
                    <div class="layui-col-sm12 layui-col-md6 videolist">
                        <img src="../resources/images/video.png" class="layui-img">
                    </div>
                </div>
            </div>
            <div class="layui-row">
                <div class="layui-col-sm10 layui-md10">
                    <!-- 播放进度条 -->
                    <div class="layui-row">
                        <div class="layui-col-sm12 layui-col-md12" style="margin-top:10px;">
                            <video id="video" width="49.5%" height="360" preload controls>
                                <source src="http://nettuts.s3.amazonaws.com/763_sammyJSIntro/trailer_test.mp4" type='video/mp4'>
                                <source src="http://nettuts.s3.amazonaws.com/763_sammyJSIntro/trailer_test.ogg" type='video/ogg'>
                            </video>
                        </div>
                        <div class="layui-col-sm12 layui-col-md12">
                            <div class="video1"></div>
                            <div id="videoControls"> 
                                <div id="progressWrap">  
                                    <div id="playProgress">  
                                        <span id="showProgress">0</span> 
                                    </div>
                                </div>
                                <div class="dian">
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                </div>
                                <div class="dian2">
                                    <span>0时</span>
                                    <span>6时</span>
                                    <span>12时</span>
                                    <span>18时<small>24时</small></span>
                                    
                                </div>
                                <div>
                                    <button id="playBtn" title="Play"> 播放 </button> 
                                    <button id="fullScreenBtn" title="FullScreen Toggle"></button>
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-col-sm2 layui-col-md2 webright ">
                <div class="layui-tab">
                    <ul class="layui-tab-title">
                        <li class="layui-this">设备</li>
                        <!-- <li>用户管理</li>
                        <li>权限分配</li>
                        <li>商品管理</li> -->
                    </ul>
                    <div class="layui-tab-content">
                        <div class="layui-tab-item layui-show" id="demo"></div>
                        <!-- <div class="layui-tab-item">内容2</div>
                        <div class="layui-tab-item">内容3</div>
                        <div class="layui-tab-item">内容4</div>
                        <div class="layui-tab-item">内容5</div> -->
                    </div>
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
    <script type="text/javascript" src="../resources/plugins/layui/layui.js"></script>
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

        // 树形结构
        layui.use('tree', function(){
            layui.tree({
                elem: '#demo', //传入元素选择器
                nodes: [{
                        name: '父节点1',
                        children: [{ 
                            name: '子节点11',
                            children: [{
                                name: '父节点111',
                                href:''
                            }]
                        }]
                    },
                    {
                        name:'父节点2',
                        children:[{
                            name:'子节点21',
                            children:[{
                                name:'子节点211',
                            }]
                        }]
                    },
                    {
                        name:'父节点3',
                        children:[{
                            name:'子节点31',
                            children:[{
                                name:'子节点311',
                                href:''
                            }]
                        }]
                    }
                ]
            });
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
    </script>
</body>

</html>
