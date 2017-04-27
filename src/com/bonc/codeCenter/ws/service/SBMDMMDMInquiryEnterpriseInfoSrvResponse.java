package com.bonc.codeCenter.ws.service;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SB_MDM_MDM_InquiryEnterpriseInfoSrvResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;SB_MDM_MDM_InquiryEnterpriseInfoSrvResponse&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;SERVICE_FLAG&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;SERVICE_MESSAGE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;INSTANCE_ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot;/&gt;
 *         &lt;element name=&quot;TOTAL_RECORD&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot;/&gt;
 *         &lt;element name=&quot;TOTAL_PAGE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot;/&gt;
 *         &lt;element name=&quot;PAGE_SIZE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot;/&gt;
 *         &lt;element name=&quot;CURRENT_PAGE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot;/&gt;
 *         &lt;element name=&quot;SB_MDM_MDM_InquiryEnterpriseInfoSrvOutputCollection&quot; type=&quot;{http://mss.unicom.com/SB_MDM_MDM_InquiryEnterpriseInfoSrv}SB_MDM_MDM_InquiryEnterpriseInfoSrvOutputCollection&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SB_MDM_MDM_InquiryEnterpriseInfoSrvResponse", propOrder = {
		"serviceflag", "servicemessage", "instanceid", "totalrecord",
		"totalpage", "pagesize", "currentpage",
		"sbmdmmdmInquiryEnterpriseInfoSrvOutputCollection" })
public class SBMDMMDMInquiryEnterpriseInfoSrvResponse {

	@XmlElement(name = "SERVICE_FLAG", required = true, nillable = true)
	protected String serviceflag;
	@XmlElement(name = "SERVICE_MESSAGE", required = true, nillable = true)
	protected String servicemessage;
	@XmlElement(name = "INSTANCE_ID", required = true, nillable = true)
	protected BigDecimal instanceid;
	@XmlElement(name = "TOTAL_RECORD", required = true, nillable = true)
	protected BigDecimal totalrecord;
	@XmlElement(name = "TOTAL_PAGE", required = true, nillable = true)
	protected BigDecimal totalpage;
	@XmlElement(name = "PAGE_SIZE", required = true, nillable = true)
	protected BigDecimal pagesize;
	@XmlElement(name = "CURRENT_PAGE", required = true, nillable = true)
	protected BigDecimal currentpage;
	@XmlElement(name = "SB_MDM_MDM_InquiryEnterpriseInfoSrvOutputCollection", required = true)
	protected SBMDMMDMInquiryEnterpriseInfoSrvOutputCollection sbmdmmdmInquiryEnterpriseInfoSrvOutputCollection;

	/**
	 * Gets the value of the serviceflag property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSERVICEFLAG() {
		return serviceflag;
	}

	/**
	 * Sets the value of the serviceflag property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSERVICEFLAG(String value) {
		this.serviceflag = value;
	}

	/**
	 * Gets the value of the servicemessage property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSERVICEMESSAGE() {
		return servicemessage;
	}

	/**
	 * Sets the value of the servicemessage property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSERVICEMESSAGE(String value) {
		this.servicemessage = value;
	}

	/**
	 * Gets the value of the instanceid property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getINSTANCEID() {
		return instanceid;
	}

	/**
	 * Sets the value of the instanceid property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setINSTANCEID(BigDecimal value) {
		this.instanceid = value;
	}

	/**
	 * Gets the value of the totalrecord property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getTOTALRECORD() {
		return totalrecord;
	}

	/**
	 * Sets the value of the totalrecord property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setTOTALRECORD(BigDecimal value) {
		this.totalrecord = value;
	}

	/**
	 * Gets the value of the totalpage property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getTOTALPAGE() {
		return totalpage;
	}

	/**
	 * Sets the value of the totalpage property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setTOTALPAGE(BigDecimal value) {
		this.totalpage = value;
	}

	/**
	 * Gets the value of the pagesize property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getPAGESIZE() {
		return pagesize;
	}

	/**
	 * Sets the value of the pagesize property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setPAGESIZE(BigDecimal value) {
		this.pagesize = value;
	}

	/**
	 * Gets the value of the currentpage property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getCURRENTPAGE() {
		return currentpage;
	}

	/**
	 * Sets the value of the currentpage property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setCURRENTPAGE(BigDecimal value) {
		this.currentpage = value;
	}

	/**
	 * Gets the value of the sbmdmmdmInquiryEnterpriseInfoSrvOutputCollection
	 * property.
	 * 
	 * @return possible object is
	 *         {@link SBMDMMDMInquiryEnterpriseInfoSrvOutputCollection }
	 * 
	 */
	public SBMDMMDMInquiryEnterpriseInfoSrvOutputCollection getSBMDMMDMInquiryEnterpriseInfoSrvOutputCollection() {
		return sbmdmmdmInquiryEnterpriseInfoSrvOutputCollection;
	}

	/**
	 * Sets the value of the sbmdmmdmInquiryEnterpriseInfoSrvOutputCollection
	 * property.
	 * 
	 * @param value
	 *            allowed object is
	 *            {@link SBMDMMDMInquiryEnterpriseInfoSrvOutputCollection }
	 * 
	 */
	public void setSBMDMMDMInquiryEnterpriseInfoSrvOutputCollection(
			SBMDMMDMInquiryEnterpriseInfoSrvOutputCollection value) {
		this.sbmdmmdmInquiryEnterpriseInfoSrvOutputCollection = value;
	}

}
