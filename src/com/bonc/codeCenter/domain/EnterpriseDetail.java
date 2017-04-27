package com.bonc.codeCenter.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*组织机构详细信息*/
@XmlRootElement(name="ENTERPRISE")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnterpriseDetail extends Enterprise {

	/*机构类型*/
	@XmlElement(name="JGLX")
	private String jglx;
	/*经营范围*/
	@XmlElement(name="JYFW")
	private String jyfw;
	/*登记号*/
	@XmlElement(name="DJH")
	private String djh;
	/*状态*/
	@XmlElement(name="JYZT")
	private String jyzt;
	/*法定代表人*/
	@XmlElement(name="FDDBR")
	private String fddbr;
	/*注册资金*/
	@XmlElement(name="ZCZJ")
	private Long zczj;
	/*校核标志*/
	@XmlElement(name="JHBZ")
	private String jhbz;
	/*成立日期*/
	@XmlElement(name="CLRQ")
	private String clrq;
	/*登记机关*/
	@XmlElement(name="DJBMMC")
	private String djbmmc;
	/*行政区划*/
	@XmlElement(name="XZQHMC")
	private String xzqhmc;
	/*经营期限自*/
	@XmlElement(name="JYQXZ")
	private String jyqxz;
	/*经营期限至*/
	@XmlElement(name="JYQXE")
	private String jyqxe;
	/*经营类型*/
	@XmlElement(name="JJLXDM")
	private String jjlxdm;
	/*最后更新日期*/
	@XmlElement(name="BGRQ")
	private String bgrq;
	/*生产经营地址*/
	@XmlElement(name="JYDZ")
	private String jydz;
	/*经济行业*/
	@XmlElement(name="JJHYDM")
	private String jjhydm;
	/*上级主管部门*/
	@XmlElement(name="ZGMC")
	private String zgmc;
	/*电话号码*/
	@XmlElement(name="DHHM")
	private String dhhm;
	/*电子邮箱*/
	@XmlElement(name="EMAIL")
	private String email;
	/*职工人数*/
	@XmlElement(name="ZGRS")
	private String zgrs;
	/*网址*/
	@XmlElement(name="URL")
	private String url;

	public EnterpriseDetail() {
		super();
	}

	public String getJglx() {
		return jglx;
	}

	public void setJglx(String jglx) {
		this.jglx = jglx;
	}

	public String getJyfw() {
		return jyfw;
	}

	public void setJyfw(String jyfw) {
		this.jyfw = jyfw;
	}

	public String getJyzt() {
		return jyzt;
	}

	public void setJyzt(String jyzt) {
		this.jyzt = jyzt;
	}

	public String getJhbz() {
		return jhbz;
	}

	public void setJhbz(String jhbz) {
		this.jhbz = jhbz;
	}

	public String getDjh() {
		return djh;
	}

	public void setDjh(String djh) {
		this.djh = djh;
	}

	public Long getZczj() {
		return zczj;
	}

	public void setZczj(Long zczj) {
		this.zczj = zczj;
	}

	public String getFddbr() {
		return fddbr;
	}

	public void setFddbr(String fddbr) {
		this.fddbr = fddbr;
	}

	public String getDjbmmc() {
		return djbmmc;
	}

	public void setDjbmmc(String djbmmc) {
		this.djbmmc = djbmmc;
	}

	public String getXzqhmc() {
		return xzqhmc;
	}

	public void setXzqhmc(String xzqhmc) {
		this.xzqhmc = xzqhmc;
	}

	public String getJjlxdm() {
		return jjlxdm;
	}

	public void setJjlxdm(String jjlxdm) {
		this.jjlxdm = jjlxdm;
	}

	public String getJydz() {
		return jydz;
	}

	public void setJydz(String jydz) {
		this.jydz = jydz;
	}

	public String getJjhydm() {
		return jjhydm;
	}

	public void setJjhydm(String jjhydm) {
		this.jjhydm = jjhydm;
	}

	public String getZgmc() {
		return zgmc;
	}

	public void setZgmc(String zgmc) {
		this.zgmc = zgmc;
	}

	public String getDhhm() {
		return dhhm;
	}

	public void setDhhm(String dhhm) {
		this.dhhm = dhhm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getZgrs() {
		return zgrs;
	}

	public void setZgrs(String zgrs) {
		this.zgrs = zgrs;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getClrq() {
		return clrq;
	}

	public void setClrq(String clrq) {
		this.clrq = clrq;
	}

	public String getJyqxz() {
		return jyqxz;
	}

	public void setJyqxz(String jyqxz) {
		this.jyqxz = jyqxz;
	}

	public String getJyqxe() {
		return jyqxe;
	}

	public void setJyqxe(String jyqxe) {
		this.jyqxe = jyqxe;
	}

	public String getBgrq() {
		return bgrq;
	}

	public void setBgrq(String bgrq) {
		this.bgrq = bgrq;
	}
	
}
