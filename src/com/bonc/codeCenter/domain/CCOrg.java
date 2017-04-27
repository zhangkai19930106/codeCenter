package com.bonc.codeCenter.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name="CC_ORG_CODE_NEW")
public class CCOrg implements Serializable  {

	private static final long serialVersionUID = 1L;

	/*ID流水号*/
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(nullable = false, name="ID")
	private Long id;

	/*组织机构代码*/
	@Column(name="JGDM",length=9)
	private String jgdm;
	/*统一社会信用代码*/
	@Column(name="TYDM",length=18)
	private String tydm;
	/*质疑标志*/
	@Column(name="LY",length=1)
	private String ly;
	/*组织机构名称*/
	@Column(name="JGMC",length=400)
	private String jgmc;
	/*登记号*/
	@Column(name="DJH",length=400)
	private String djh;
	/*注册地址*/
	@Column(name="ZCDZ",length=400)
	private String zcdz;
	/*机构类型*/
	@Column(name="JGLX",length=50)
	private String jglx;
	/*经营范围*/
	@Column(name="JYFW",length=2000)
	private String jyfw;
	/*经营状态*/
	@Column(name="JYZT",length=50)
	private String jyzt;
	/*法定代表人*/
	@Column(name="FDDBR",length=100)
	private String fddbr;
	/*注册资金*/
	@Column(name="ZCZJ")
	private Long zczj;
	/*校核标志*/
	@Column(name="JHBZ",length=50)
	private String jhbz;
	/*成立日期*/
	@Column(name="CLRQ")
	private Date clrq;
	/*登记机关*/
	@Column(name="DJBMMC",length=400)
	private String djbmmc;
	/*行政区划名称*/
	@Column(name="XZQHMC",length=50)
	private String xzqhmc;
	/*经营期限自*/
	@Column(name="JYQXZ")
	private Date jyqxz;
	/*经营期限至*/
	@Column(name="JYQXE")
	private Date jyqxe;
	/*经济类型*/
	@Column(name="JJLXDM",length=50)
	private String jjlxdm;
	/*最后更新日期*/
	@Column(name="BGRQ")
	private Date bgrq;
	/*经营地址*/
	@Column(name="JYDZ",length=400)
	private String jydz;
	/*经济行业*/
	@Column(name="JJHYDM",length=50)
	private String jjhydm;
	/*上级主管部门*/
	@Column(name="ZGMC",length=400)
	private String zgmc;
	/*电话号码*/
	@Column(name="DHHM",length=50)
	private String dhhm;
	/*电子邮箱*/
	@Column(name="EMAIL",length=50)
	private String email;
	/*职工人数*/
	@Column(name="ZGRS")
	private Long zgrs;
	/*网址*/
	@Column(name="URL",length=50)
	private String url;
	
	private Date updateDate;
	
	/**
	 * 是否涉密标记  1涉密；0不涉密；
	 */
	private Long privateFlag;
	/**
	 * 是否缓存库查询 1是；0否；
	 */
	private Long cacheFlag;
	


	public CCOrg() {
		super();
	}

	public String getDjh() {
		return djh;
	}

	public void setDjh(String djh) {
		this.djh = djh;
	}

	public void setZgrs(Long zgrs) {
		this.zgrs = zgrs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getLy() {
		return ly;
	}

	public void setLy(String ly) {
		this.ly = ly;
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

	public String getFddbr() {
		return fddbr;
	}

	public void setFddbr(String fddbr) {
		this.fddbr = fddbr;
	}

	public Long getZczj() {
		return zczj;
	}

	public void setZczj(Long zczj) {
		this.zczj = zczj;
	}

	public String getJhbz() {
		return jhbz;
	}

	public void setJhbz(String jhbz) {
		this.jhbz = jhbz;
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

	public Long getZgrs() {
		return zgrs;
	}

	public void setZgrs(long zgrs) {
		this.zgrs = zgrs;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getClrq() {
		return clrq;
	}

	public void setClrq(Date clrq) {
		this.clrq = clrq;
	}

	public Date getJyqxz() {
		return jyqxz;
	}

	public void setJyqxz(Date jyqxz) {
		this.jyqxz = jyqxz;
	}

	public Date getJyqxe() {
		return jyqxe;
	}

	public void setJyqxe(Date jyqxe) {
		this.jyqxe = jyqxe;
	}

	public Date getBgrq() {
		return bgrq;
	}

	public void setBgrq(Date bgrq) {
		this.bgrq = bgrq;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getPrivateFlag() {
//		if(this.bzrq==null&&this.dhhm==null&&this.fddbr==null&&this.hbzl==null&&
//				this.jgdm!=null&&this.jgdz==null&&this.jglx==null&&this.jgmc==null&&
//				this.jjlx==null&&this.jyfw==null&&this.njjhy==null&&this.xzqh==null&&
//				this.yzbm==null&&this.zch==null&&this.zcrq==null&&this.zczj==null&&
//				this.zfrq==null&&this.zgdm==null&&this.zgmc==null&&this.zgrs==null&&
//				this.zybz==null)
//			return BigDecimal.ONE;
//		else
//			return BigDecimal.ZERO;
		return privateFlag;
	}

	public void setPrivateFlag(Long privateFlag) {
		this.privateFlag = privateFlag;
	}

	public Long getCacheFlag() {
		return cacheFlag;
	}

	public void setCacheFlag(Long cacheFlag) {
		this.cacheFlag = cacheFlag;
	}
	
	
}
