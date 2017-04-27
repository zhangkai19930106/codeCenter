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
	<b:appletBox title="模块访问者排名" showMM="false" />
	
	<s:form action="ModuleVisitorOrd">
		<table class="form">
			<tr>
				<td>登录名:<s:textfield name="loginId" /></td>
				<td>用户姓名:<s:textfield name="userName" /></td>
				<td align="right"><input type="submit" class="submit" value="查询" /></td>
			</tr>
		</table>
	</s:form>
	
		<table class="grid">
			<thead>
				<b:gHead action="ModuleVisitorOrd">
					<tr>
						<th><b:gh col="loginId">登录名</b:gh></th>
						<th><b:gh col="userName">用户名称</b:gh></th>
						<th><b:gh col="visitTimes">访问次数</b:gh></th>
						<th><b:gh col="lastVisitTime">最后访问时间</b:gh></th>
						<th><b:gh col="lastModuleName">最后访模块</b:gh></th>
					</tr>
				</b:gHead>
			</thead>
			<tbody>
				<s:iterator value="dataList" status="rowstatus">
					<tr class="${rowstatus.odd?'odd':'even'}">
						<td>${loginId}</td>
						<td>${userName}</td>
						<td align="right"><fmt:formatNumber type="long" value="${visitTimes }" pattern="#,##0"></fmt:formatNumber></td>
						<td class="date"><fmt:formatDate value="${lastVisitTime}" type="date" pattern="yyyy-MM-dd HH:mm"/></td>
						<td>${lastModuleName}</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	<b:pagiLink action="ModuleVisitorOrd" />
</body>
</html>