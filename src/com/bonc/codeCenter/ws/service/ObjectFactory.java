package com.bonc.codeCenter.ws.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.bonc.codeCenter.ws.service package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _SBMDMMDMInquiryEnterpriseInfoSrvRequest_QNAME = new QName(
			"http://mss.unicom.com/SB_MDM_MDM_InquiryEnterpriseInfoSrv",
			"SB_MDM_MDM_InquiryEnterpriseInfoSrvRequest");
	private final static QName _SBMDMMDMInquiryEnterpriseInfoSrvResponse_QNAME = new QName(
			"http://mss.unicom.com/SB_MDM_MDM_InquiryEnterpriseInfoSrv",
			"SB_MDM_MDM_InquiryEnterpriseInfoSrvResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.bonc.codeCenter.ws.service
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link SBMDMMDMInquiryEnterpriseInfoSrvResponse }
	 * 
	 */
	public SBMDMMDMInquiryEnterpriseInfoSrvResponse createSBMDMMDMInquiryEnterpriseInfoSrvResponse() {
		return new SBMDMMDMInquiryEnterpriseInfoSrvResponse();
	}

	/**
	 * Create an instance of {@link MsgHeader }
	 * 
	 */
	public MsgHeader createMsgHeader() {
		return new MsgHeader();
	}

	/**
	 * Create an instance of {@link SBMDMMDMInquiryEnterpriseInfoSrvRequest }
	 * 
	 */
	public SBMDMMDMInquiryEnterpriseInfoSrvRequest createSBMDMMDMInquiryEnterpriseInfoSrvRequest() {
		return new SBMDMMDMInquiryEnterpriseInfoSrvRequest();
	}

	/**
	 * Create an instance of
	 * {@link SBMDMMDMInquiryEnterpriseInfoSrvOutputCollection }
	 * 
	 */
	public SBMDMMDMInquiryEnterpriseInfoSrvOutputCollection createSBMDMMDMInquiryEnterpriseInfoSrvOutputCollection() {
		return new SBMDMMDMInquiryEnterpriseInfoSrvOutputCollection();
	}

	/**
	 * Create an instance of {@link SBMDMMDMInquiryEnterpriseInfoSrvOutputItem }
	 * 
	 */
	public SBMDMMDMInquiryEnterpriseInfoSrvOutputItem createSBMDMMDMInquiryEnterpriseInfoSrvOutputItem() {
		return new SBMDMMDMInquiryEnterpriseInfoSrvOutputItem();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link SBMDMMDMInquiryEnterpriseInfoSrvRequest }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://mss.unicom.com/SB_MDM_MDM_InquiryEnterpriseInfoSrv", name = "SB_MDM_MDM_InquiryEnterpriseInfoSrvRequest")
	public JAXBElement<SBMDMMDMInquiryEnterpriseInfoSrvRequest> createSBMDMMDMInquiryEnterpriseInfoSrvRequest(
			SBMDMMDMInquiryEnterpriseInfoSrvRequest value) {
		return new JAXBElement<SBMDMMDMInquiryEnterpriseInfoSrvRequest>(
				_SBMDMMDMInquiryEnterpriseInfoSrvRequest_QNAME,
				SBMDMMDMInquiryEnterpriseInfoSrvRequest.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link SBMDMMDMInquiryEnterpriseInfoSrvResponse }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://mss.unicom.com/SB_MDM_MDM_InquiryEnterpriseInfoSrv", name = "SB_MDM_MDM_InquiryEnterpriseInfoSrvResponse")
	public JAXBElement<SBMDMMDMInquiryEnterpriseInfoSrvResponse> createSBMDMMDMInquiryEnterpriseInfoSrvResponse(
			SBMDMMDMInquiryEnterpriseInfoSrvResponse value) {
		return new JAXBElement<SBMDMMDMInquiryEnterpriseInfoSrvResponse>(
				_SBMDMMDMInquiryEnterpriseInfoSrvResponse_QNAME,
				SBMDMMDMInquiryEnterpriseInfoSrvResponse.class, null, value);
	}

}
