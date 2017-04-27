<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="b" uri="/bonc-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<b:doctype/>
<html>
<head>
<s:head />
</head>
<body>
	<b:appletBox title="模块访问排名" showMM="false" />
	
	<s:form action="VisitModuleOrd">
		<table class="form">
			<tr>
				<td>模块编号:<s:textfield name="resourcesId" /></td>
				<td>模块名称:<s:textfield name="resourcesName" /></td>
				<td>应用系统:<s:select name="appSystemId" listKey="appSystemId" listValue="appSystemName" list="allSystems" headerKey="-2" headerValue="全部"/></td>
				<td align="right"><input type="submit" class="submit" value="查询" /></td>
			</tr>
		</table>
	</s:form>
		<table class="grid">
			<thead>
				<b:gHead action="VisitModuleOrd">
					<tr>
						<th><b:gh col="resourcesId">模块编号</b:gh></th>
						<th><b:gh col="resourcesName">模块名称</b:gh></th>
						<th><b:gh col="appSystem.appSystemName">应用系统</b:gh></th>
						<th><b:gh col="visitTimes">访问次数</b:gh></th>
						<th><b:gh col="lastVisitTime">最后访问时间</b:gh></th>
						<th><b:gh col="lastUserName">最后访问人</b:gh></th>
					</tr>
				</b:gHead>
			</thead>
			<tbody>
				<s:iterator value="dataList" status="rowstatus">
					<tr class="${rowstatus.odd?'odd':'even'}">
						<td>${resourcesId}</td>
						<td>${resourcesName}</td>
						<td>${appSystem.appSystemName }</td>
						<td align="right"><fmt:formatNumber type="long" value="${visitTimes }" pattern="#,##0"></fmt:formatNumber></td>
						<td class="date"><fmt:formatDate value="${lastVisitTime}" type="date" pattern="yyyy-MM-dd HH:mm"/></td>
						<td>${lastUserName}</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	<b:pagiLink action="VisitModuleOrd" />
</body>
</html>