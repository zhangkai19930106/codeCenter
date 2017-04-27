package com.bonc.codeCenter.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*组织机构信息*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="DATAINFO")
public class Enterprise {
	/*组织机构代码*/
	@XmlElement(name="JGDM")
	private String jgdm;
	/*统一社会信用代码*/
	@XmlElement(name="TYDM")
	private String tydm;
	/*质疑标志*/
	@XmlElement(name="LY")
	private String ly;
	/*组织机构名称*/
	@XmlElement(name="JGMC")
	private String jgmc;
	/*注册地址*/
	@XmlElement(name="ZCDZ")
	private String zcdz;

	
	public Enterprise() {
		super();
	}

	public String getJgdm() {
		return jgdm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	public String getTydm() {
		return tydm;
	}

	public void setTydm(String tydm) {
		this.tydm = tydm;
	}

	public String getJgmc() {
		return jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public String getZcdz() {
		return zcdz;
	}

	public void setZcdz(String zcdz) {
		this.zcdz = zcdz;
	}

	public String getLy() {
		return ly;
	}

	public void setLy(String ly) {
		this.ly = ly;
	}	
}
