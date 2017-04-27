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
		<s:form action="Log.action" id="logListForm">
			<table class="form">
				<tr>
					<td>日志分类:
					<select class="chzn-select" style="width:120px;" name="logType">
						<option value="" >全部</option>
						<option value="C" <s:if test='logType eq "C"'>  selected="selected" </s:if>>客户端请求日志</option>
						<option value="S" <s:if test='logType eq "S"'>  selected="selected" </s:if>>服务端响应日志</option>
					</select>
					</td>
					<td>
						结果类型：
						<select class="chzn-select" style="width:120px;" name="resultType">
							<option value="" >全部</option>
							<option value="01" <s:if test='resultType eq "01"'>  selected="selected" </s:if>>信息正常返回</option>
							<option value="02" <s:if test='resultType eq "02"'>  selected="selected" </s:if>>XML解析错误</option>
							<option value="03" <s:if test='resultType eq "03"'>  selected="selected" </s:if>>参数不完整</option>
							<option value="04" <s:if test='resultType eq "04"'>  selected="selected" </s:if>>参数解密错误</option>
							<option value="05" <s:if test='resultType eq "05"'>  selected="selected" </s:if>>请求的IP不被允许</option>
							<option value="06" <s:if test='resultType eq "06"'>  selected="selected" </s:if>>CA信息验证错误</option>
							<option value="07" <s:if test='resultType eq "07"'>  selected="selected" </s:if>>用户名或密码错误</option>
							<option value="08" <s:if test='resultType eq "08"'>  selected="selected" </s:if>>用户下不存在该接口信息</option>
							<option value="09" <s:if test='resultType eq "09"'>  selected="selected" </s:if>>请求次数超限</option>
							<option value="10" <s:if test='resultType eq "10"'>  selected="selected" </s:if>>系统程序异常</option>
						</select>
					</td>
					<td colspan="2"> <b:datetimepicker formatPattern="yyyy-MM-dd"
						id="createBeginDate" name="beginDate" readonly="true" label="日志时间"
						maxDate="#F{$dp.$D(\\\'createEndDate\\\')}" /> -<b:datetimepicker
						formatPattern="yyyy-MM-dd" id="createEndDate"
						name="endDate" readonly="true"
						minDate="#F{$dp.$D(\\\'createBeginDate\\\')}" />
				    </td>
					<td align="right"><input type="submit" class="submit" value="查询"  id="logListQuery"/></td>
				</tr>
				<!-- 
				<tr><td  colspan=4 align="right">
					<div>
						总记录数：${pagiParam.totalRowNum}
						成功记录数：${sucNum}
						失败记录数：${falNum}
					</div>
				</td></tr>		 -->
			</table>
		</s:form>	
		<s:actionerror />
		<s:actionmessage/>
	
		<form id="listForm">
			<table class="grid" style="min-width: 1000px;width: expression((documentElement.clientWidth < 1000)?'1000px':'auto');">
				<thead>
					<b:gHead>
						<tr>
							<th style="width:40px"><p:auth optType="DELETE" resourcesId="alg_1">序号</p:auth></th>
							<th>日志类型</th>
							<th>请求时间</th>
							<th>请求结果</th>
							<th></th>
							<th style="width:50px"></th>
						</tr>
					</b:gHead>
				</thead>
				<tbody>
					<s:iterator value="logsList" status="rowstatus">
					<tr class="${rowstatus.odd?'odd':'even'}" align="center">
						<td class="text-center grid-row-number" style="width:60px;">${pagiParam.firstResult+rowstatus.index+1}.</td>
						<td>
						${logType }
							<s:if test="#logType eq 'C'">
								客户端
							</s:if>
							<s:else>
								服务端
							</s:else>	
						</td>
						<td>
							<s:bean name="java.util.Date" id="ct">
								<s:param name="time">${requestTime}</s:param>
							</s:bean>
							<s:date name="#ct" format="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>${resultDesc}</td>
						<td>
							<div style="height:10px;display:none;" >${requestParam}</div>
						</td>
						<td class="text-center operation-data-row" style="width: 300px;">
							<center>
								<p:auth optType="UPDATE" resourcesId="alg_1"><a id="param" onclick="showParam(this)" class="icon-vcard-edit">查看请求参数</a></p:auth>
							</center>
						</td>
					</tr>
				</s:iterator>
				</tbody>
			</table>
			<div style="margin-left:20px; font-size:12;font-weight: bold;font-style: italic;">
						总记录数：${pagiParam.totalRowNum}
						成功记录数：${sucNum}
						失败记录数：${falNum}
			</div>
		</form>		
		<b:pagiLink action="Log.action" />
		<!-- '${requestParam}' -->
	    <script type="text/javascript">
	    	function showParam(a){
	    		alert(jQuery(a).parent().parent().parent().find('div').html());
	    	}
	    </script>
	</body>
</html>