package com.bonc.codeCenter.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 请求接口信息
 * @author WangMingjun
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="INTERFACEINFO")
public class InterfaceInfo {
	/*接口编号--由代码中心提供*/
	@XmlElement(name="CODE")
	private String code;
	
	/*组织机构代码-参数值必须为加密后的*/
	@XmlElement(name="JGDM")
	private String jgdm;
	
	/*组织机构代码-参数值必须为加密后的*/
	@XmlElement(name="TYDM")
	private String tydm;
	
	/*组织机构名称-参数值必须为加密后的*/
	@XmlElement(name="JGMC")
	private String jgmc;
	
	/*登记号-参数值必须为加密后的*/
	@XmlElement(name="DJH")
	private String djh;
	
	public InterfaceInfo() {
		super();
	}

	public InterfaceInfo(String code, String jgdm,String tydm, String jgmc, String djh) {
		super();
		this.code = code;
		this.jgdm = jgdm;
		this.tydm = tydm;
		this.jgmc = jgmc;
		this.djh = djh;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getTydm() {
		return tydm;
	}

	public void setTydm(String tydm) {
		this.tydm = tydm;
	}

	public String getDjh() {
		return djh;
	}

	public void setDjh(String djh) {
		this.djh = djh;
	}

}
