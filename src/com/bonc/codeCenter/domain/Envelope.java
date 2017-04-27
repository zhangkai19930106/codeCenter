package com.bonc.codeCenter.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 反馈信息说明
 * @author WangMingjun
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ENVELOPE")
public class Envelope {
	
	/*信息编码*/
	@XmlElement(name="RECODE")
	private String recode;
	
	/*信息说明*/
	@XmlElement(name="MESSAGE")
	private String message;
	
	/*返回信息条数*/
	@XmlElement(name="DATASIZE")
	private int datasize;
	
	public Envelope() {
		super();
	}

	public String getRecode() {
		return recode;
	}

	public void setRecode(String recode) {
		this.recode = recode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getDatasize() {
		return datasize;
	}

	public void setDatasize(int datasize) {
		this.datasize = datasize;
	}
}
