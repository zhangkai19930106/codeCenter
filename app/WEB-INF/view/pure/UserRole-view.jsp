<%@page import="com.bonc.pure.PureUtils"%>
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
	
	<s:form action="UserRole!authorize.action">
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
		<a class="icon-vcard-add" id="del-btn">授权</a>
	</div>
	
	<s:actionerror />
	<s:actionmessage/>
	
	<form action="UserRole!updatePemission.action"id="listForm">
		<s:hidden name="roleId" />
		<table class="grid">
			<thead>
				<b:gHead action="UserRole!authorize.action">
					<tr>
						<th><input type="checkbox" id="checkAll"/></th>
						<th>全选</th>
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
	<b:pagiLink action="UserRole!authorize.action"/>
	<script type="text/javascript">
		$j('#checkAll').bindCheckAll(':checkbox[name="ids"]');
		$j('#del-btn').bindCommitBatch('#listForm :checkbox[name="ids"]','请选择您要授权的用户!','您确认要给这些用户授权吗？');
	</script>
</body>
</html>