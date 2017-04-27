<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="b" uri="/bonc-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="/pure-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<b:doctype/>
<html>
<head>
<s:head />
</head>
<body>
	<b:appletBox title="用户角色" showMM="false" />
	
	<s:form action="UserRole">
		<table class="form">
			<tr>
				<td>登录ID:<s:textfield name="loginId" /></td>
				<td>用户名:<s:textfield name="userName" /></td>
				<td><s:hidden name="roleId" /></td>
				<td align="right"><input type="submit" class="submit" value="查询" /></td>
			</tr>
		</table>
	</s:form>
	
	<div class="operation-container">
		<a class="icon-vcard-delete" id="del-btn">收回</a>
	</div>
	
	<s:actionerror />
	<s:actionmessage/>
	
	<form action="UserRole!deletePemission.action"id="listForm">
		<s:hidden name="roleId" />
		<table class="grid">
			<thead>
				<b:gHead action="UserRole">
					<tr>
						<th><input type="checkbox" id="checkAll"/></th>
						<th style="width:40px">全选</th>
						<th><b:gh col="loginId">登录ID</b:gh></th>
						<th><b:gh col="userName">用户名</b:gh></th>
						<th>角色ID</th>
						<th></th>
					</tr>
				</b:gHead>
			</thead>
			<tbody>
				<s:iterator value="dataList" status="rowstatus">
					<tr class="${rowstatus.odd?'odd':'even'}">
						<td align="center"><input type="checkbox" value="${userId}" name="ids" /></td>
						<td class="text-center grid-row-number">${rowstatus.index+1}.</td>
						<td>${loginId}</td>
						<td>${userName}</td>
						<td>${roleId}</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</form>
	<b:pagiLink action="UserRole"/>
	<script type="text/javascript">
		$j('#checkAll').bindCheckAll(':checkbox[name="ids"]');
		$j('#del-btn').bindCommitBatch('#listForm :checkbox[name="ids"]','请选择您要收回权限的用户!','您确认要收回这些用户的权限吗？');
	</script>
</body>
</html>