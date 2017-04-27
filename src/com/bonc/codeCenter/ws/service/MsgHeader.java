package com.bonc.codeCenter.ws.service;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for MsgHeader complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;MsgHeader&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;SOURCE_SYSTEM_ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;SOURCE_SYSTEM_NAME&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;USER_ID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;USER_NAME&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;SUBMIT_DATE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}dateTime&quot;/&gt;
 *         &lt;element name=&quot;PAGE_SIZE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot;/&gt;
 *         &lt;element name=&quot;CURRENT_PAGE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot;/&gt;
 *         &lt;element name=&quot;TOTAL_RECORD&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot;/&gt;
 *         &lt;element name=&quot;PROVINCE_CODE&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;ENVIRONMENT_NAME&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsgHeader", namespace = "http://soa.mss.unicom.com/MsgHeader", propOrder = {
		"sourcesystemid", "sourcesystemname", "userid", "username",
		"submitdate", "pagesize", "currentpage", "totalrecord", "provincecode",
		"environmentname" })
public class MsgHeader {

	@XmlElement(name = "SOURCE_SYSTEM_ID", required = true, nillable = true)
	protected String sourcesystemid;
	@XmlElement(name = "SOURCE_SYSTEM_NAME", required = true, nillable = true)
	protected String sourcesystemname;
	@XmlElement(name = "USER_ID", required = true, nillable = true)
	protected String userid;
	@XmlElement(name = "USER_NAME", required = true, nillable = true)
	protected String username;
	@XmlElement(name = "SUBMIT_DATE", required = true, nillable = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar submitdate;
	@XmlElement(name = "PAGE_SIZE", required = true, nillable = true)
	protected BigDecimal pagesize;
	@XmlElement(name = "CURRENT_PAGE", required = true, nillable = true)
	protected BigDecimal currentpage;
	@XmlElement(name = "TOTAL_RECORD", required = true, nillable = true)
	protected BigDecimal totalrecord;
	@XmlElement(name = "PROVINCE_CODE", required = true, nillable = true)
	protected String provincecode;
	@XmlElement(name = "ENVIRONMENT_NAME", required = true, nillable = true)
	protected String environmentname;

	/**
	 * Gets the value of the sourcesystemid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSOURCESYSTEMID() {
		return sourcesystemid;
	}

	/**
	 * Sets the value of the sourcesystemid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSOURCESYSTEMID(String value) {
		this.sourcesystemid = value;
	}

	/**
	 * Gets the value of the sourcesystemname property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSOURCESYSTEMNAME() {
		return sourcesystemname;
	}

	/**
	 * Sets the value of the sourcesystemname property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSOURCESYSTEMNAME(String value) {
		this.sourcesystemname = value;
	}

	/**
	 * Gets the value of the userid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUSERID() {
		return userid;
	}

	/**
	 * Sets the value of the userid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUSERID(String value) {
		this.userid = value;
	}

	/**
	 * Gets the value of the username property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUSERNAME() {
		return username;
	}

	/**
	 * Sets the value of the username property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUSERNAME(String value) {
		this.username = value;
	}

	/**
	 * Gets the value of the submitdate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getSUBMITDATE() {
		return submitdate;
	}

	/**
	 * Sets the value of the submitdate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setSUBMITDATE(XMLGregorianCalendar value) {
		this.submitdate = value;
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
	 * Gets the value of the provincecode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPROVINCECODE() {
		return provincecode;
	}

	/**
	 * Sets the value of the provincecode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPROVINCECODE(String value) {
		this.provincecode = value;
	}

	/**
	 * Gets the value of the environmentname property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getENVIRONMENTNAME() {
		return environmentname;
	}

	/**
	 * Sets the value of the environmentname property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setENVIRONMENTNAME(String value) {
		this.environmentname = value;
	}

}
