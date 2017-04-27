/**
 * Copyright (c) 2012，北京东方国信科技股份有限公司版权所有
 */
package com.bonc.codeCenter.action.org;

import java.util.List;

import com.bonc.base.dao.PagiParam;
import com.bonc.codeCenter.domain.CCOrg;
import com.bonc.codeCenter.service.CCOrgService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * OrgCodeAction 组织机构信息查看
 * 
 * @version 1.0 2014-11-13
 * @author WangMingjun
 * @since 1.0
 */
public class OrgAction extends ActionSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** 注入 Service */
	private CCOrgService orgCodeService;
	
	/** 日志列表 */
	private List<CCOrg> orgCodeList;
	
	/** 查询条件 */
	/* 日志类型：C:客户端请求日志；S：服务端响应日志 */
	private String jgdm = "";
	private String jgmc;
	private String djh;
	/** 列表查询分页对象 */
	@SuppressWarnings("deprecation")
	private PagiParam pagiParam;
	/** 是否重新查询记录总条数 */
	private boolean exactTotal = false;
	/** 是否在首页展示 */
	private int homePage;
	
	public String execute(){
		
		getOrgCodeDatailList();
		return "list";
	}
	
	@SuppressWarnings("deprecation")
	public void getOrgCodeDatailList() {
		try {
			if (pagiParam == null) {
				pagiParam = new PagiParam();
				if (homePage == 1) {
					pagiParam.setPageSize(5);
				}
			}
			orgCodeList = orgCodeService.findPage(jgdm, jgmc, djh, pagiParam,  exactTotal);
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("获取日志列表异常!");
		}
	}
	
	public void saveOrgCode(){
		CCOrg OrgCode = new CCOrg();
		OrgCode.setId(2L);
		OrgCode.setJgdm(jgdm);
		OrgCode.setJgmc(jgmc);
		OrgCode.setDjh(djh);
		
		boolean result = orgCodeService.insert(OrgCode);
		if(result)
			System.out.println("成功");
		else
			System.out.println("失败");
	}

	/**
	 * 初始化基础数据,后期建议用数据码表维护
	 */
	private void init() {
		// 初始化方法
	}
	public PagiParam getPagiParam() {
		return pagiParam;
	}

	public void setPagiParam(PagiParam pagiParam) {
		this.pagiParam = pagiParam;
	}
	public boolean isExactTotal() {
		return exactTotal;
	}
	public int getHomePage() {
		return homePage;
	}

	public void setHomePage(int homePage) {
		this.homePage = homePage;
	}

	public void setExactTotal(boolean exactTotal) {
		this.exactTotal = exactTotal;
	}
	
	public CCOrgService getOrgCodeService() {
		return orgCodeService;
	}

	public void setOrgCodeService(CCOrgService orgCodeService) {
		this.orgCodeService = orgCodeService;
	}

	public List<CCOrg> getOrgCodeList() {
		return orgCodeList;
	}

	public void setOrgCodeList(List<CCOrg> orgCodeList) {
		this.orgCodeList = orgCodeList;
	}

	public String getJgdm() {
		return jgdm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	public String getJgmc() {
		return jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public String getDjh() {
		return djh;
	}

	public void setDjh(String djh) {
		this.djh = djh;
	}
	
	
}