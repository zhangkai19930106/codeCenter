package com.bonc.codeCenter.ws.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SB_MDM_MDM_InquiryEnterpriseInfoSrvRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;SB_MDM_MDM_InquiryEnterpriseInfoSrvRequest&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;MsgHeader&quot; type=&quot;{http://soa.mss.unicom.com/MsgHeader}MsgHeader&quot;/&gt;
 *         &lt;element name=&quot;VENDOR_NAME&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;ORG_CODE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;ENROLL_CODE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;SEARCH_FLAG&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;V_RESERVED_1&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;V_RESERVED_2&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;V_RESERVED_3&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;V_RESERVED_4&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;V_RESERVED_5&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SB_MDM_MDM_InquiryEnterpriseInfoSrvRequest", propOrder = {
		"msgHeader", "vendorname", "orgcode", "enrollcode", "searchflag",
		"vreserved1", "vreserved2", "vreserved3", "vreserved4", "vreserved5" })
public class SBMDMMDMInquiryEnterpriseInfoSrvRequest {

	@XmlElement(name = "MsgHeader", required = true, nillable = true)
	protected MsgHeader msgHeader;
	@XmlElement(name = "VENDOR_NAME", required = true, nillable = true)
	protected String vendorname;
	@XmlElement(name = "ORG_CODE", required = true, nillable = true)
	protected String orgcode;
	@XmlElement(name = "ENROLL_CODE", required = true, nillable = true)
	protected String enrollcode;
	@XmlElement(name = "SEARCH_FLAG", required = true, nillable = true)
	protected String searchflag;
	@XmlElement(name = "V_RESERVED_1", required = true, nillable = true)
	protected String vreserved1;
	@XmlElement(name = "V_RESERVED_2", required = true, nillable = true)
	protected String vreserved2;
	@XmlElement(name = "V_RESERVED_3", required = true, nillable = true)
	protected String vreserved3;
	@XmlElement(name = "V_RESERVED_4", required = true, nillable = true)
	protected String vreserved4;
	@XmlElement(name = "V_RESERVED_5", required = true, nillable = true)
	protected String vreserved5;

	/**
	 * Gets the value of the msgHeader property.
	 * 
	 * @return possible object is {@link MsgHeader }
	 * 
	 */
	public MsgHeader getMsgHeader() {
		return msgHeader;
	}

	/**
	 * Sets the value of the msgHeader property.
	 * 
	 * @param value
	 *            allowed object is {@link MsgHeader }
	 * 
	 */
	public void setMsgHeader(MsgHeader value) {
		this.msgHeader = value;
	}

	/**
	 * Gets the value of the vendorname property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVENDORNAME() {
		return vendorname;
	}

	/**
	 * Sets the value of the vendorname property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVENDORNAME(String value) {
		this.vendorname = value;
	}

	/**
	 * Gets the value of the orgcode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getORGCODE() {
		return orgcode;
	}

	/**
	 * Sets the value of the orgcode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setORGCODE(String value) {
		this.orgcode = value;
	}

	/**
	 * Gets the value of the enrollcode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getENROLLCODE() {
		return enrollcode;
	}

	/**
	 * Sets the value of the enrollcode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setENROLLCODE(String value) {
		this.enrollcode = value;
	}

	/**
	 * Gets the value of the searchflag property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSEARCHFLAG() {
		return searchflag;
	}

	/**
	 * Sets the value of the searchflag property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSEARCHFLAG(String value) {
		this.searchflag = value;
	}

	/**
	 * Gets the value of the vreserved1 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVRESERVED1() {
		return vreserved1;
	}

	/**
	 * Sets the value of the vreserved1 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVRESERVED1(String value) {
		this.vreserved1 = value;
	}

	/**
	 * Gets the value of the vreserved2 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVRESERVED2() {
		return vreserved2;
	}

	/**
	 * Sets the value of the vreserved2 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVRESERVED2(String value) {
		this.vreserved2 = value;
	}

	/**
	 * Gets the value of the vreserved3 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVRESERVED3() {
		return vreserved3;
	}

	/**
	 * Sets the value of the vreserved3 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVRESERVED3(String value) {
		this.vreserved3 = value;
	}

	/**
	 * Gets the value of the vreserved4 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVRESERVED4() {
		return vreserved4;
	}

	/**
	 * Sets the value of the vreserved4 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVRESERVED4(String value) {
		this.vreserved4 = value;
	}

	/**
	 * Gets the value of the vreserved5 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVRESERVED5() {
		return vreserved5;
	}

	/**
	 * Sets the value of the vreserved5 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVRESERVED5(String value) {
		this.vreserved5 = value;
	}

}
