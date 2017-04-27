package com.bonc.codeCenter.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 代码中心接口返回对象(明细信息-一条)
 * @author WangMingjun
 *
 */
@XmlRootElement(name="NACAORESPONSE")
@XmlAccessorType(XmlAccessType.FIELD)
public class NacaoResponseDetail {
	@XmlElementRef(name="ENVELOPE")
	private Envelope envelope;
	
	@XmlElementWrapper(name="DATAINFO")
	@XmlElement(name="ENTERPRISE")
	private List<EnterpriseDetail> dataInfo;
	
	public NacaoResponseDetail() {
		super();
	}

	public Envelope getEnvelope() {
		return envelope;
	}

	public void setEnvelope(Envelope envelope) {
		this.envelope = envelope;
	}

	public List<EnterpriseDetail> getDataInfo() {
		return dataInfo;
	}

	public void setDataInfo(List<EnterpriseDetail> dataInfo) {
		this.dataInfo = dataInfo;
	}	
}
