package com.bonc.codeCenter.ws.service;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for SB_MDM_MDM_InquiryEnterpriseInfoSrvOutputItem complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;SB_MDM_MDM_InquiryEnterpriseInfoSrvOutputItem&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;ORG_CODE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;VENDOR_NAME&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;ENROLL_CODE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;LEGAL_REPRESENTATIVE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;ORGCODE_START_DATE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot;/&gt;
 *         &lt;element name=&quot;ORGCODE_END_DATE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot;/&gt;
 *         &lt;element name=&quot;ORG_TYPE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;EE_COUNT&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot;/&gt;
 *         &lt;element name=&quot;ENROLL_FUND&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot;/&gt;
 *         &lt;element name=&quot;CURRENCY_TYPE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;BUSS_SCOPE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;ENROLL_DATE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot;/&gt;
 *         &lt;element name=&quot;BUSS_TYPE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;BUSS_TRADE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;ADDRESS&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;QUS_FLAG&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;REGION&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;PROVINCE_CODE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;CITY_NAME&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;TELEHPONE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;ADMIN_ORG&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;ADMIN_ORG_CODE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;PRIVATE_FLAG&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot;/&gt;
 *         &lt;element name=&quot;CACHE_FLAG&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot;/&gt;
 *         &lt;element name=&quot;LAST_UPDATE_DATE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot;/&gt;
 *         &lt;element name=&quot;RESERVED_1&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;RESERVED_2&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;RESERVED_3&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;RESERVED_4&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;RESERVED_5&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;RESERVED_6&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;RESERVED_7&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;RESERVED_8&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;RESERVED_9&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;RESERVED_10&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SB_MDM_MDM_InquiryEnterpriseInfoSrvOutputItem", propOrder = {
		"orgcode", "vendorname", "enrollcode", "legalrepresentative",
		"orgcodestartdate", "orgcodeenddate", "orgtype", "eecount",
		"enrollfund", "currencytype", "bussscope", "enrolldate", "busstype",
		"busstrade", "address", "qusflag", "region", "provincecode",
		"cityname", "telehpone", "adminorg", "adminorgcode", "privateflag",
		"cacheflag", "lastupdatedate", "reserved1", "reserved2", "reserved3",
		"reserved4", "reserved5", "reserved6", "reserved7", "reserved8",
		"reserved9", "reserved10" })
public class SBMDMMDMInquiryEnterpriseInfoSrvOutputItem {

	@XmlElement(name = "ORG_CODE", required = true, nillable = true)
	protected String orgcode;
	@XmlElement(name = "VENDOR_NAME", required = true, nillable = true)
	protected String vendorname;
	@XmlElement(name = "ENROLL_CODE", required = true, nillable = true)
	protected String enrollcode;
	@XmlElement(name = "LEGAL_REPRESENTATIVE", required = true, nillable = true)
	protected String legalrepresentative;
	@XmlElement(name = "ORGCODE_START_DATE", required = true, nillable = true)
	//@XmlSchemaType(name = "dateTime")
	protected Date orgcodestartdate;//XMLGregorianCalendar
	@XmlElement(name = "ORGCODE_END_DATE", required = true, nillable = true)
	//@XmlSchemaType(name = "dateTime")
	protected Date orgcodeenddate;
	@XmlElement(name = "ORG_TYPE", required = true, nillable = true)
	protected String orgtype;
	@XmlElement(name = "EE_COUNT", required = true, nillable = true)
	protected BigDecimal eecount;
	@XmlElement(name = "ENROLL_FUND", required = true, nillable = true)
	protected BigDecimal enrollfund;
	@XmlElement(name = "CURRENCY_TYPE", required = true, nillable = true)
	protected String currencytype;
	@XmlElement(name = "BUSS_SCOPE", required = true, nillable = true)
	protected String bussscope;
	@XmlElement(name = "ENROLL_DATE", required = true, nillable = true)
	//@XmlSchemaType(name = "dateTime")
	protected Date enrolldate;
	@XmlElement(name = "BUSS_TYPE", required = true, nillable = true)
	protected String busstype;
	@XmlElement(name = "BUSS_TRADE", required = true, nillable = true)
	protected String busstrade;
	@XmlElement(name = "ADDRESS", required = true, nillable = true)
	protected String address;
	@XmlElement(name = "QUS_FLAG", required = true, nillable = true)
	protected String qusflag;
	@XmlElement(name = "REGION", required = true, nillable = true)
	protected String region;
	@XmlElement(name = "PROVINCE_CODE", required = true, nillable = true)
	protected String provincecode;
	@XmlElement(name = "CITY_NAME", required = true, nillable = true)
	protected String cityname;
	@XmlElement(name = "TELEHPONE", required = true, nillable = true)
	protected String telehpone;
	@XmlElement(name = "ADMIN_ORG", required = true, nillable = true)
	protected String adminorg;
	@XmlElement(name = "ADMIN_ORG_CODE", required = true, nillable = true)
	protected String adminorgcode;
	@XmlElement(name = "PRIVATE_FLAG", required = true, nillable = true)
	protected BigDecimal privateflag;
	@XmlElement(name = "CACHE_FLAG", required = true, nillable = true)
	protected BigDecimal cacheflag;
	@XmlElement(name = "LAST_UPDATE_DATE", required = true, nillable = true)
	protected Date lastupdatedate;
	@XmlElement(name = "RESERVED_1", required = true, nillable = true)
	protected String reserved1;
	@XmlElement(name = "RESERVED_2", required = true, nillable = true)
	protected String reserved2;
	@XmlElement(name = "RESERVED_3", required = true, nillable = true)
	protected String reserved3;
	@XmlElement(name = "RESERVED_4", required = true, nillable = true)
	protected String reserved4;
	@XmlElement(name = "RESERVED_5", required = true, nillable = true)
	protected String reserved5;
	@XmlElement(name = "RESERVED_6", required = true, nillable = true)
	protected String reserved6;
	@XmlElement(name = "RESERVED_7", required = true, nillable = true)
	protected String reserved7;
	@XmlElement(name = "RESERVED_8", required = true, nillable = true)
	protected String reserved8;
	@XmlElement(name = "RESERVED_9", required = true, nillable = true)
	protected String reserved9;
	@XmlElement(name = "RESERVED_10", required = true, nillable = true)
	protected String reserved10;
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public String getVendorname() {
		return vendorname;
	}
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	public String getEnrollcode() {
		return enrollcode;
	}
	public void setEnrollcode(String enrollcode) {
		this.enrollcode = enrollcode;
	}
	public String getLegalrepresentative() {
		return legalrepresentative;
	}
	public void setLegalrepresentative(String legalrepresentative) {
		this.legalrepresentative = legalrepresentative;
	}
	public Date getOrgcodestartdate() {
		return orgcodestartdate;
	}
	public void setOrgcodestartdate(Date orgcodestartdate) {
		this.orgcodestartdate = orgcodestartdate;
	}
	public Date getOrgcodeenddate() {
		return orgcodeenddate;
	}
	public void setOrgcodeenddate(Date orgcodeenddate) {
		this.orgcodeenddate = orgcodeenddate;
	}
	public String getOrgtype() {
		return orgtype;
	}
	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}
	public BigDecimal getEecount() {
		return eecount;
	}
	public void setEecount(BigDecimal eecount) {
		this.eecount = eecount;
	}
	public BigDecimal getEnrollfund() {
		return enrollfund;
	}
	public void setEnrollfund(BigDecimal enrollfund) {
		this.enrollfund = enrollfund;
	}
	public String getCurrencytype() {
		return currencytype;
	}
	public void setCurrencytype(String currencytype) {
		this.currencytype = currencytype;
	}
	public String getBussscope() {
		return bussscope;
	}
	public void setBussscope(String bussscope) {
		this.bussscope = bussscope;
	}
	public Date getEnrolldate() {
		return enrolldate;
	}
	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}
	public String getBusstype() {
		return busstype;
	}
	public void setBusstype(String busstype) {
		this.busstype = busstype;
	}
	public String getBusstrade() {
		return busstrade;
	}
	public void setBusstrade(String busstrade) {
		this.busstrade = busstrade;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQusflag() {
		return qusflag;
	}
	public void setQusflag(String qusflag) {
		this.qusflag = qusflag;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getProvincecode() {
		return provincecode;
	}
	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getTelehpone() {
		return telehpone;
	}
	public void setTelehpone(String telehpone) {
		this.telehpone = telehpone;
	}
	public String getAdminorg() {
		return adminorg;
	}
	public void setAdminorg(String adminorg) {
		this.adminorg = adminorg;
	}
	public String getAdminorgcode() {
		return adminorgcode;
	}
	public void setAdminorgcode(String adminorgcode) {
		this.adminorgcode = adminorgcode;
	}
	public BigDecimal getPrivateflag() {
		return privateflag;
	}
	public void setPrivateflag(BigDecimal privateflag) {
		this.privateflag = privateflag;
	}
	public BigDecimal getCacheflag() {
		return cacheflag;
	}
	public void setCacheflag(BigDecimal cacheflag) {
		this.cacheflag = cacheflag;
	}
	public Date getLastupdatedate() {
		return lastupdatedate;
	}
	public void setLastupdatedate(Date lastupdatedate) {
		this.lastupdatedate = lastupdatedate;
	}
	public String getReserved1() {
		return reserved1;
	}
	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}
	public String getReserved2() {
		return reserved2;
	}
	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}
	public String getReserved3() {
		return reserved3;
	}
	public void setReserved3(String reserved3) {
		this.reserved3 = reserved3;
	}
	public String getReserved4() {
		return reserved4;
	}
	public void setReserved4(String reserved4) {
		this.reserved4 = reserved4;
	}
	public String getReserved5() {
		return reserved5;
	}
	public void setReserved5(String reserved5) {
		this.reserved5 = reserved5;
	}
	public String getReserved6() {
		return reserved6;
	}
	public void setReserved6(String reserved6) {
		this.reserved6 = reserved6;
	}
	public String getReserved7() {
		return reserved7;
	}
	public void setReserved7(String reserved7) {
		this.reserved7 = reserved7;
	}
	public String getReserved8() {
		return reserved8;
	}
	public void setReserved8(String reserved8) {
		this.reserved8 = reserved8;
	}
	public String getReserved9() {
		return reserved9;
	}
	public void setReserved9(String reserved9) {
		this.reserved9 = reserved9;
	}
	public String getReserved10() {
		return reserved10;
	}
	public void setReserved10(String reserved10) {
		this.reserved10 = reserved10;
	}



}
