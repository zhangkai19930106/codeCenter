package com.bonc.codeCenter.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 代码中心服务请求参数对象
 * @author WangMingjun
 *
 */
@XmlRootElement(name="NACAOREQUEST")
@XmlAccessorType(XmlAccessType.FIELD)
public class NacaoRequest {
	
	/*用户名--由代码中心提供*/
	@XmlElement(name = "USERNAME")
	private String userName;
	
	/*密码--由代码中心提供*/
	@XmlElement(name="PASSWORD")
	private String password;
	
	/*CA信息--由代码中心提供*/
	@XmlElement(name="CAINFO")
	private String caInfo;
	
	/*请求接口信息*/
	@XmlElementRef(name="INTERFACEINFO")
	private InterfaceInfo interfaceinfo;

	public NacaoRequest() {
		super();
	}	

	public NacaoRequest(String userName, String password, String caInfo,
			InterfaceInfo interfaceInfo) {
		super();
		this.userName = userName;
		this.password = password;
		this.caInfo = caInfo;
		this.interfaceinfo = interfaceInfo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCaInfo() {
		return caInfo;
	}

	public void setCaInfo(String caInfo) {
		this.caInfo = caInfo;
	}

	public InterfaceInfo getInterfaceInfo() {
		return interfaceinfo;
	}

	public void setInterfaceInfo(InterfaceInfo interfaceInfo) {
		this.interfaceinfo = interfaceInfo;
	}
}
