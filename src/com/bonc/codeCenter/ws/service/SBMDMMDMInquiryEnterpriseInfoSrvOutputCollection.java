package com.bonc.codeCenter.ws.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SB_MDM_MDM_InquiryEnterpriseInfoSrvOutputCollection complex
 * type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;SB_MDM_MDM_InquiryEnterpriseInfoSrvOutputCollection&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;SB_MDM_MDM_InquiryEnterpriseInfoSrvOutputItem&quot; type=&quot;{http://mss.unicom.com/SB_MDM_MDM_InquiryEnterpriseInfoSrv}SB_MDM_MDM_InquiryEnterpriseInfoSrvOutputItem&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SB_MDM_MDM_InquiryEnterpriseInfoSrvOutputCollection", propOrder = { "sbmdmmdmInquiryEnterpriseInfoSrvOutputItem" })
public class SBMDMMDMInquiryEnterpriseInfoSrvOutputCollection {

	@XmlElement(name = "SB_MDM_MDM_InquiryEnterpriseInfoSrvOutputItem")
	protected List<SBMDMMDMInquiryEnterpriseInfoSrvOutputItem> sbmdmmdmInquiryEnterpriseInfoSrvOutputItem;

	/**
	 * Gets the value of the sbmdmmdmInquiryEnterpriseInfoSrvOutputItem
	 * property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the
	 * sbmdmmdmInquiryEnterpriseInfoSrvOutputItem property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSBMDMMDMInquiryEnterpriseInfoSrvOutputItem().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link SBMDMMDMInquiryEnterpriseInfoSrvOutputItem }
	 * 
	 * 
	 */
	public List<SBMDMMDMInquiryEnterpriseInfoSrvOutputItem> getSBMDMMDMInquiryEnterpriseInfoSrvOutputItem() {
		if (sbmdmmdmInquiryEnterpriseInfoSrvOutputItem == null) {
			sbmdmmdmInquiryEnterpriseInfoSrvOutputItem = new ArrayList<SBMDMMDMInquiryEnterpriseInfoSrvOutputItem>();
		}
		return this.sbmdmmdmInquiryEnterpriseInfoSrvOutputItem;
	}

}
