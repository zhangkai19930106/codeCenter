package com.bonc.codeCenter.domain;

import java.util.List;

public class LocalResponse extends NacaoResponseDetail {
	//一致性标记
	private Long sameOpr;
	//服务日志-详细错误信息
	private String errormessage;
	
	private List<CCOrg> orgList;

	public List<CCOrg> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<CCOrg> orgList) {
		this.orgList = orgList;
	}


	public Long getSameOpr() {
		return sameOpr;
	}

	public void setSameOpr(Long sameOpr) {
		this.sameOpr = sameOpr;
	}


	public String getErrormessage() {
		return errormessage;
	}


	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	
	
}
