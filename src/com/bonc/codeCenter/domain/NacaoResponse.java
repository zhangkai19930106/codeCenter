package com.bonc.codeCenter.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 代码中心接口返回对象（选择对象-多条）
 * @author WangMingjun
 *
 */
@XmlRootElement(name="NACAORESPONSE")
@XmlAccessorType(XmlAccessType.FIELD)
public class NacaoResponse {
	
	@XmlElementRef(name="ENVELOPE")
	private Envelope envelope;
	
	@XmlElementWrapper(name="DATAINFO")
	@XmlElement(name="ENTERPRISE")
	private List<Enterprise> dataInfo;
	
	public NacaoResponse() {
		super();
		dataInfo = new ArrayList<Enterprise>();
	}
	
	public void add(Enterprise enterprise){
		dataInfo.add(enterprise);
	}
	
	public Iterator<Enterprise> iterator(){
        return dataInfo.iterator();
    }

	public Envelope getEnvelope() {
		return envelope;
	}

	public void setEnvelope(Envelope envelope) {
		this.envelope = envelope;
	}
	
	public List<Enterprise> getDataInfo() {
		return dataInfo;
	}

	public void setDataInfo(List<Enterprise> dataInfo) {
		this.dataInfo = dataInfo;
	}
}
