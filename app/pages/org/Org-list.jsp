<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.bonc.pure.PureUtils"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="b" uri="/bonc-tags"%>
<%@ taglib prefix="p" uri="/pure-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<s:head />
		<link rel="stylesheet" type="text/css" href="../js/chosen/chosen.css">
		<SCRIPT type="text/javascript" src="../js/chosen/chosen.jquery.js"></SCRIPT>
	</head>
<body>
		<s:form action="Org.action" id="OrgCodeListForm">
			<table class="form">
				<tr>
					<td>
						机构代码：<input type="text" name="jgdm" value="${jgdm}" /> 
					</td>
					<td>
						机构名称：<input type="text" name="jgmc" value="${jgmc}" />
					</td>
					<td>
						注册号：<input type="text" name="zch" value="${zch}" />
					</td>
					<td align="right"><input type="submit" class="submit" value="查询"  id="logsListQuery"/></td>
				</tr>
			</table>
		</s:form>
		<s:actionerror />
		<s:actionmessage/>
	
		<form id="listForm">
			<table class="grid" style="min-width: 1000px;width: expression((documentElement.clientWidth < 1000)?'1000px':'auto');">
					<thead>
						<b:gHead>
							<tr>
								<th>更新时间</th>
								<th>机构代码</th>
								<th>机构名称</th>
								<th>注册号</th>
								<th>法定代表人</th>
								<th>代码证办证日期</th>
								<th>代码证作废日期</th>
								<th>机构类型</th>
								<th>职工人数</th>
								<th>货币种类</th>
								<th>经营范围</th>
								<th>注册日期</th>
								<th>经济类型</th>
								<th>经济行业</th>
								<th>机构地址</th>
								<th>质疑标志</th>
								<th>行政区划</th>
								<th>电话号码</th>
								<th>主管机构名称</th>
								<th>主管机构代码</th>
								<th>邮政编码</th>
								<th style="width:50px"></th>
							</tr>
						</b:gHead>
					</thead>
					<tbody>
						<s:iterator value="orgCodeList" status="rowstatus">
						<tr class="${rowstatus.odd?'odd':'even'}" align="center">
							<td>${updateDate}</td>
							<td>${jgdm}</td>
							<td>${jgmc}</td>
							<td>${zch}</td>
							<td>${fddbr}</td>
							<td>${bzrq}</td>
							<td>${zfrq}</td>
							<td>${jglx}</td>
							<td>${zgrs}</td>
							<td>${hbzl}</td>
							<td>${jyfw}</td>
							<td>${zcrq}</td>
							<td>${jjlx}</td>
							<td>${njjhy}</td>
							<td>${jgdz}</td>
							<td>${zybz}</td>
							<td>${xzqh}</td>
							<td>${dhhm}</td>
							<td>${zgmc}</td>
							<td>${zgdm}</td>
							<td>${yzbm}</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</form>	
		<b:pagiLink action="Org.action" />
	</body>
</html>	