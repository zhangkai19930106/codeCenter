package com.bonc.codeCenter.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CC_LOG_NEW")
public class CCLog implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(nullable = false, name="ID")
	private Long id;
	
	/**
	 * 请求类型 C客户端,S服务端*/
	@Column(name="LOG_TYPE",length=8)
	private String logType;
	
	/**请求参数*/
	@Column(name="REQUEST_PARAM",length=4000)
	private String requestParam;
	
	/**请求时间*/
	@Column(name="REQUEST_TIME")
	private Long requestTime;
	
	/**查询结果编码*/
	@Column(name="RESULT_CODE",length=8)
	private String resultCode;
	
	/**查询结果描述*/
	@Column(name="RESULT_DESC",length=32)
	private String resultDesc;
	
	/**是否缓存库查询 1是，0否*/
	@Column(name="IS_LOCAL")
	private long isLocal;	
	
	/** 一致性标记 */
	@Column(name="SAME_OPR")
	private Long sameOpr;
	
	/** 错误信息 */
	@Column(name="ERROR_MESSAGE",length=4000)
	private String error_message;
	
	public CCLog() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getRequestParam() {
		return requestParam;
	}

	public void setRequestParam(String requestParam) {
		this.requestParam = requestParam;
	}

	public Long getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Long requestTime) {
		this.requestTime = requestTime;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public long getIsLocal() {
		return isLocal;
	}

	public void setIsLocal(long isLocal) {
		this.isLocal = isLocal;
	}

	public Long getSameOpr() {
		return sameOpr;
	}

	public void setSameOpr(Long sameOpr) {
		this.sameOpr = sameOpr;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	
	
}
