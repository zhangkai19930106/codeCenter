<%@page import="org.apache.commons.lang.StringUtils,com.bonc.pure.*,com.bonc.pure.domain.*,net.sf.json.*,net.sf.json.processors.JsonBeanProcessor,java.util.*,java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="b" uri="/bonc-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<b:doctype />
<html>
<head>
<s:head />
<s:head template="head_ext.ftl" />
<script type="text/javascript" src="../struts/pure/js/jstree/jquery.jstree.js"></script>
<script type="text/javascript" src="../struts/pure/js/jstree/css.js"></script>
<link rel="stylesheet" type="text/less" href="../struts/pure/msg/navigation.less" />
<script type="text/javascript" src="../struts/pure/msg/less-1.3.0.min.js"> </script>
<script type="text/javascript" src="../struts/pure/msg/pagingbox.js"> </script>
<script type="text/javascript" src="../struts/pure/msg/jquery.jBox-2.3.min.js"> </script>
<link rel="stylesheet" type="text/css" href="../struts/pure/msg/jbox.css" />
</head>
<body id="<%=SystemConfigProperty.FRAME_LAYOUT%>">
	<div class="pure-frame-body">
		<div id="pure-frame-top">
			<div id="pure-frame-top-logo"></div>
			<div id="pure-frame-top-title"></div>
			<ul id="pure-sys-tool">
				<%if(SystemConfigProperty.IS_DISPLAY_WELCOME_MESSAGE){%><li class="detail-info" ><span>欢迎您：<a id="user-center-info" onclick="userinfo();" ><%=PureUtils.getUser(request).getUserName()%></a></li><%}%>
				<li><a id="sys-tool-msg">消息</a></li>
				<%if(SystemConfigProperty.IS_DISPLAY_ANNOUNCEMENT){%><li><a id="sys-tool-post">公告</a></li><%}%>
				<%if(SystemConfigProperty.IS_DISPLAY_UPDATE_PASSWORD){%><li><a id="modify-password">修改密码</a></li><%}%>
				<%if(SystemConfigProperty.IS_DISPLAY_EXIT_SYSTEM){%><li class="last"><a id="logout">退出系统</a></li><%}%>
			</ul>
		<!--  	<div id="pure-msg" title="新消息" style="cursor:pointer;position:absolute;top:5px;right:5px;background-color:#F6C572;display:none;"><img style="vertical-align:middle;" src="../struts/pure/msg/imgs/msg-tip.gif"><span id="pure-msg-tip" style="vertical-align:middle;" ></span></div>
		-->
		</div>
		<div id="nav-menu-bar">
			<%if(SystemConfigProperty.IS_DISPLAY_SYSTIME){%><div id="nav-menu-bar-datetime">
				<%=new SimpleDateFormat("yyyy年M月d日 EEE",
					Locale.SIMPLIFIED_CHINESE).format(new Date(System
					.currentTimeMillis()))%>
			</div><%}%>
			<s:if test="resources==null||resources.size()==0"><span style="color:red;height:39px;line-height:39px;">您当前没有该系统的任何菜单权限，请联系管理员！</span></s:if>
			<div style="clear: both;"> </div>
		</div>
	</div>
	<script type="text/javascript">
	var userinfo = function(){
		updateContent(Bonc.toFullPath('/pure/UserInfo.action'), '用户中心', 'user-center-info', '用户中心');
	}
	<%
	final String contextPath=request.getContextPath();
    JsonConfig jsonConfig = new JsonConfig();
	jsonConfig.registerJsonBeanProcessor(Resources.class,
			new JsonBeanProcessor() {
				public JSONObject processBean(Object o, JsonConfig jsonConfig) {
					if (o==null||!(o instanceof Resources)) {
							return new JSONObject(true);
						}
					     Resources res = (Resources) o;
						String url="";
						if(StringUtils.isNotBlank(res.getUrl())){
							url=PureUtils.getFullUrl(res.getAppSystem(), res.getUrl(), contextPath);
						}
						JSONObject json = new JSONObject()
								.element("id", res.getResourcesId())
								.element("text", res.getResourcesName())
								.element("parentId", res.getParentId())
								.element("ord", res.getOrd())
								.element("url", url)
						.element("leaf", res.getChildren()==null||res.getChildren().size()==0)
						.element("children",JSONSerializer.toJSON(res.getChildren(), jsonConfig).toString());
						return json;
				}
			}
		);
    %>
 	/**
 	 * 指定url更新内容区。（系统提供打开url接口）
 	 * @param {string} url (必选)内容区使用url
 	 * @param {string} pageName (必选)菜单名称
 	 * @param {string} menuId (必选)菜单编号，用于选项卡方式展示菜单内容时，标识选项卡与菜单的对应关系
 	 * @param {String} nav (必选)非选项卡方式展示内容时，菜单所在的位置导航
 	 * @param {byte} opType (可选)菜单展开类型。0-内容区展开，1-打开新窗口。默认为0
 	 * @return {boolean} 是否打开页面
 	 */
    updateContent = function(url, pageName, menuId, nav, opType){
		frame.updateContent(url, pageName, menuId, nav, opType);
    }
	/**
	 * 复写框架中url路径集中处理接口
     * @param {Object} menuInfo (必选)菜单信息对象
     * @return {String} 当前应用中菜单访问路径
     * @public 
	 */
    Bonc.frame.getUrl = function(menuInfo){
    	if(!menuInfo){
        	return false;
        }
    	var url = menuInfo.url, menuId = menuInfo.id;
    	if (url && url != null && url !== 'null'){
			//添加日志记录参数
            if(url.indexOf('?') == -1){
					url += '?';
			}else{
					url += '&';
			}
			url += ('__PID=' + menuId);
			if(/^(http|https):\/\//.test(url)){//如果不是本系统,则由Dispatch转发，从而记录访问日志
				url = Bonc.toFullPath('/pure/proxy/Dispatch.action')+'?<%=PureConstant.PAGE_PARAMETER_NAME%>='+menuId+'&url='+url;
			}else if('<%=request.getContextPath() %>' != Bonc.getContextPath() && url.indexOf('/') == 0){
				var virtualContentPath = Bonc.getContextPath(); //虚拟应用路径
				virtualContentPath = virtualContentPath.substr(0, virtualContentPath.length - '<%=request.getContextPath() %>'.length);
				url = virtualContentPath + url;
			}
			return url;
    	}else{
        	return false;
        }
    }
    $j(document).ready(function(){
	    frame = Bonc.frame.createFrame({
	        renderTo : 'body > .pure-frame-body',
			root:<%=JSONSerializer.toJSON(request.getAttribute("resources"), jsonConfig).toString()%>,
			cardNumb : <%=SystemConfigProperty.MAX_TAB%>,
			cardWidth : 130,
			menuBar : '#nav-menu-bar',
			menuRenderTo : function(menu){menu.insertAfter('#nav-menu-bar-datetime');},
			menuType : '<%=SystemConfigProperty.MENU_TYPE%>',
			totalLevel : <%=SystemConfigProperty.MENU_TOTAL_LEVEL%>,
			tabOperationMode : '<%=SystemConfigProperty.TAB_OPERATION_MODE%>',
			displayTreeMenu : <%=SystemConfigProperty.IS_DISPLAY_TREE_MENU%>
	    });
		/* 设置iframe的高度，由于IE存在bug，因此采用延迟执行的方式解决假死状态 */
		$j(window).resize(function(){
			setTimeout(function(){
				//$j('#mainIframe').height($j(window).height() - $j('#nav-tool').height() - $j('#nav-location').height() -$j('#nav-menu-bar').height()-3);
			
				frame.resize({width:$j('body > .pure-frame-body').width(), height: $j(window).height() - $j('#pure-frame-top').height()});
			},100);
		});
		$j(window).resize();
    });
		$j('#modify-password').click(function(){
			//$j('#mainIframe').attr('src', Bonc.toFullPath('/pure/ModifyPwd'));
			updateContent(Bonc.toFullPath('/pure/ModifyPwd'), '修改密码', 'modify-password', '修改密码');
		});
		$j('#logout').click(function(){
			if(confirm('您确定要退出登录吗?')){
				location.href=Bonc.toFullPath('/Logout.action');
				//如果使用单点集成，请参照以下修改为合适的路径
				//location.href='/cas/logout?service=<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/';
			}
		})
		$j('#sys-tool-post').click(function(){
 			new Bonc.Window({
				id:'sys-tool-post-window',
				resizable: true,
				dragable:false,
				height:350,
				width:610,
	            title:'系统公告',
	            url:Bonc.toFullPath('/pure/Post!latest.action')
        	});
		});
		//个人消息
		$j('#sys-tool-msg').click(function(){
		//	var url = Bonc.toFullPath('/pure/Message!getReceived.action?msgBoxType=receive');
		//	window.open(url,'个人消息','width=780,height=500,menubar=no,toolbar=no,location=no,directories=no,status=no, scrollbars=yes,resizable=yes');
			$j.ajax({
				url:Bonc.toFullPath('/pure/message/messagebox'),
			    data:{},
			    success:function(data){				 
		    		var msgBox=$j.jBox.open('html:'+data, "消息中心", 640,540,{loaded: function (h) { 
			  			$j(".jbox input[type='text']").keydown(function(e){
							 if(e.keyCode==13){
								 return false;
							 }
						});
			  			
		    		},top:10,left:0,buttons: {'关闭': true},
						closed:function(){
							if(currAutoGetId){
								 window.clearInterval(currAutoGetId);
							}
							
						}});
			    }
				});
			}); 
		
            $j.ajax({
               url:Bonc.toFullPath('/pure/message/msgCount'),
               data:{},
               success:function(data){
                   if(jQuery(data).get(0).msgCount>0){
                     jQuery("#sys-tool-msg").text("消息("+jQuery(data).get(0).msgCount+")");    
             
                   }
                   else{
                	 jQuery("#sys-tool-msg").text("消息");   
               
                   }
                   }
           });
            if(!$){//暂时解决消息中jBox的$问题
    			var $=$j;
    		}
 	</script>
</body>
</html>