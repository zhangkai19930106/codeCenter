﻿<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.bonc.pure.PureUtils"%>
<%@ taglib prefix="b" uri="/bonc-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="/pure-tags"%>
<b:doctype />
<html>
<head>
<s:head />
</head>
<body>
	<b:appletBox title="新增应用系统" showMM="false" />
	<s:actionerror />
	<s:form action="AppSystem!doCreate" validate="true" cssClass="notTipError">
		<p>
			<s:textfield name="appSystem.appSystemId" label="应用系统编码" cssClass="{required:true,maxlength:20,wordinput:true,remote:{url:'AppSystem!validAppSystemId.action',type:'post',data:{'id':function (){return $j('#AppSystem_appSystem_appSystemId').val();}}}, messages:{required:'请输入应用系统编码',remote:'应用系统编码已存在'}}" />
		</p>
		<p>
			<s:textfield name="appSystem.appSystemName" label="应用系统名称" cssClass="{required:true,maxlength:50, messages:{required:'请输入应用系统名称'}}" />
		</p>
		<p>
			<s:textfield name="appSystem.serverHost" label="服务器地址" cssClass="{maxlength:50}" />
			<span class="icon-info input-tip">格式：http://192.168.0.1:8080。</span>
		</p>
		<p>
			<s:textfield name="appSystem.contextPath" label="部署应用名" cssClass="{maxlength:20}" />
			<span class="icon-info input-tip">格式： “/” 或 “/foo”。</span>
		</p>
		<p>
			<s:if test="appSystem==null">
				<s:textfield name="appSystem.ord" value="1" label="排序" cssClass="{number:true, messages:{number:'排序只能填写数字'}}"/>
			</s:if>
			<s:else>
				<s:textfield name="appSystem.ord" label="排序" cssClass="{number:true, messages:{number:'排序只能填写数字'}}"/>
			</s:else>
		</p>
		<p>
			<s:textarea name="appSystem.memo" rows="5" cols="50" label="备注" colSpan="3" cssClass="{maxlength:500}"/>
		</p>
		<p>
			<input type="submit" class="submit" value="提交" style="margin-left:140px;"/>
			<p:auth resourcesId="PURE_RESOURCESGROUP" optType="<%=PureUtils.AUTH_READ %>"><input type="button" class="cancel" value="取消" style="margin-left:140px;" onclick="location.href='AppSystem.action'"/></p:auth>
		</p>
	</s:form>
</body>
</html>