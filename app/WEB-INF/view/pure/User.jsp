<%@page import="java.util.List,net.sf.json.JsonConfig,net.sf.json.*,net.sf.json.JSONObject,net.sf.json.processors.JsonBeanProcessor,com.bonc.pure.domain.*,com.bonc.pure.PureUtils"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="b" uri="/bonc-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="/pure-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<b:doctype/>
<html>
<head>
<s:head />
<s:head template="head_ext.ftl" />
<script type="text/javascript" src="<s:url value="/struts/xheditor/xheditor-zh-cn.min.js"/>"></script>
</head>
<body>
	<b:appletBox title="用户管理" showMM="false" />
	
	<s:form action="User">
		<table class="form">
			<tr>
				<td>用户登录号:<s:textfield name="loginId" /></td>
				<td>用户姓名:<s:textfield name="userName" /></td>
				<td>所属机构:
				   <s:textfield id="orgTextField" name="orgName"   readonly="true" />
			       <input id="orgId" type="hidden" name="orgId" value="${orgId }">
				</td>
				<td>创建人:<s:textfield name="createrName" /></td>
				<td>性别:<s:select name="sex" listKey="key" listValue="value" list="@com.bonc.pure.PureUtils@SexOptions" headerKey="" headerValue="全部"/></td>
				<td>用户状态:<s:select name="state" listKey="key" listValue="value" list="@com.bonc.pure.PureUtils@StateOptions" headerKey="" headerValue="全部"/></td>
				<td align="right"><input type="submit" class="submit" value="查询" /></td>
			</tr>
		</table>
	</s:form>

	<div class="operation-container">
		<p:auth resourcesId="PURE_USER" optType="<%=PureUtils.AUTH_CREATE %>">
			<a href="User!create.action" class="icon-vcard-add">新增</a>
		</p:auth>
	   <p:auth resourcesId="PURE_USER" optType="<%=PureUtils.AUTH_DELETE %>">
			<a class="icon-vcard-delete" id="del-btn">停用</a>
		</p:auth>
	</div>

	<s:actionerror />
	<s:actionmessage/>
	
	<form <p:auth resourcesId="PURE_USER" optType="<%=PureUtils.AUTH_DELETE %>">action="User!delete.action"</p:auth> id="listForm">
		<table class="grid">
			<thead>
				<b:gHead action="User">
					<tr>
						<p:auth resourcesId="PURE_USER" optType="<%=PureUtils.AUTH_DELETE %>"><th style="width:30px"><input type="checkbox" id="checkAll"/></th></p:auth>
						<th style="width:40px"><p:auth resourcesId="PURE_USER" optType="<%=PureUtils.AUTH_DELETE %>">全选</p:auth></th>
						<th><b:gh col="loginId">登录用户名</b:gh></th>
						<th><b:gh col="userName">用户姓名</b:gh></th>
						<th><b:gh col="org">所属机构</b:gh></th>
						<th style="width:50px"><b:gh col="userId">工号</b:gh></th>
						<th style="width:50px"><b:gh col="sex">性别</b:gh></th>
						<th style="width:50px"><b:gh col="state">启用</b:gh></th>
						<th style="width:80px"><b:gh col="pwdState">密码状态</b:gh></th>
						<th style="width:180px"><b:gh col="regDate">注册时间</b:gh></th>
						<th style="width:100px"><b:gh col="creater">创建人</b:gh></th>
						<th style="width:170px;"></th>
					</tr>
				</b:gHead>
			</thead>
			<tbody>
			  <s:if test="dataList==null||dataList.size()==0">
			     <tr><td colspan="12" style="text-align:center;">没有符合条件的用户信息</td></tr>
			  </s:if>
			  <s:else>
				<s:iterator value="dataList" status="rowstatus">
					<tr class="${rowstatus.odd?'odd':'even'}">
						<p:auth resourcesId="PURE_USER" optType="<%=PureUtils.AUTH_DELETE %>"><td align="center"><input type="checkbox" value="${userId}" name="ids"/></td></p:auth>
						<td class="text-center grid-row-number">${pagiParam.firstResult+rowstatus.index+1}.</td>
						<td>${loginId}</td>
						<td>${userName}</td>
						<td>${org.orgName}</td>
						<td>${userId}</td>
						<td><s:property value="@com.bonc.pure.PureUtils@SexOptions.{?#this.key== #attr.sex}[0].value"/></td>
						<td><s:property value="@com.bonc.pure.PureUtils@StateOptions.{?#this.key== #attr.state}[0].value"/></td>
						<td><s:property value="@com.bonc.pure.PureUtils@PasswordStateOptions.{?#this.key== #attr.pwdState}[0].value"/></td>
						<td class="date"><fmt:formatDate value="${regDate}" type="date" pattern="yyyy-MM-dd"/></td>
					    <td><s:if test="creater==null"></s:if><s:else>${creater.userName}</s:else></td>
						<td class="text-center operation-data-row">
							<p:auth resourcesId="PURE_USER" optType="<%=PureUtils.AUTH_UPDATE %>"><a href="User!update.action?id=${userId}" class="icon-vcard-edit">编辑</a></p:auth>
							<p:auth resourcesId="PURE_USER" optType="<%=PureUtils.AUTH_DELETE %>">
								<s:if test="state==1">
									<a uid="${userId}" class="icon-vcard-delete">停用</a>
								</s:if>
								<s:else>
									<a  class="icon-vcard-delete" style="color: red; cursor: default; text-decoration: none;">已停用</a>
								</s:else>
							</p:auth>
							<p:auth resourcesId="PURE_USER_PERMISSION" optType="<%=PureUtils.AUTH_AUTH %>"><a href="UserPermission.action?userId=${userId}" class="icon-vcard-role">授权</a></p:auth>
						</td>
					</tr>
				</s:iterator>
			  </s:else>
			</tbody>
		</table>
	</form>
	<b:pagiLink action="User" />
	<script type="text/javascript">
	<%if(null!=request.getAttribute("tree")){%>
	//组织机构树
	var tree=new Bonc.FormExt.TreeClickSelect({
			arg:'post',
			title:'选择机构',
			jsonConfig:true,
			showTbar:true,
		    descInputId:'orgTextField',
			inputId:'orgId',
			 <%
		        JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.registerJsonBeanProcessor(Org.class,
						new JsonBeanProcessor() {
							public JSONObject processBean(Object o, JsonConfig jsonConfig) {
								if (o==null||!(o instanceof Org)) {
									return new JSONObject(true);
								}
								Org bean = (Org) o;
								JSONObject json = new JSONObject()
										.element("id",bean.getOrgId())
										.element("text", bean.getOrgName())
										.element("parentId", bean.getParentId())
										.element("path", bean.getPath())
										.element("leaf",bean.getChildren()==null)
										.element("children", JSONSerializer.toJSON(bean.getChildren(), jsonConfig).toString());
								return json;
							}
						}
				);
		        %>
		        root:new Ext.tree.AsyncTreeNode(<%=JSONSerializer.toJSON(request.getAttribute("tree"), jsonConfig).toString()%>)
	});
	<%}%>
    </script>
	<p:auth resourcesId="PURE_USER" optType="<%=PureUtils.AUTH_DELETE %>">
	<script type="text/javascript">    
		$j('#checkAll').bindCheckAll(':checkbox[name="ids"]');
		$j('#listForm').delegate('a.icon-vcard-delete[uid]','click',function(){
			if(confirm('用户停用后将不能登录系统.您确认要停用所选项用户吗?')){
				location.href='User!delete.action?ids='+this.getAttribute('uid');
			}
		});
		$j('#del-btn').bindCommitBatch('#listForm :checkbox[name="ids"]','请选择您要停用的用户！','用户停用后将不能登录系统.\n您确认要停用所选项用户吗?');
	</script>
	</p:auth>
</body>
</html>