package com.bonc.codeCenter.type;

public enum ResultType {
	
	SUCCESS              ("01","信息正常返回"),
	ERR_XML              ("02","XML解析错误"),
	ERR_PARAM_DEFICIENCY ("03","参数不匹配"),
	ERR_PARAM_DECODE     ("04","参数解密错误"),
	ERR_IPREFUSE         ("05","请求的IP不被允许"),
	ERR_CA               ("06","CA信息验证错误"),
	ERR_USERPWD          ("07","用户名或密码错误"),
	ERR_NOTEXIST         ("08","用户下不存在该接口信息"),
	ERR_NUMLIMIT         ("09","请求次数超限"),
	ERR_SYS              ("10","系统信息异常"),
	
	//以上为中心错误代码信息
	//以下为SOA错误代码信息定义  具体用户使用的客户端不涉及，以下编码服务开发时用不到
	ERR_PARAM_NONE       ("11","机构信息存在多余(核查比对接口)"),
	ERR_PARAM_ERROR      ("12","查询参数有误"),
	ERR_ORG_NONEXISTENT  ("13","查询无结果"),
	ERR_TIMEOUT          ("14","(用户计费单元总数)已达到约定的查询上限"),
	ERR_ORGRETURN_ERROR  ("15","变更数据文件不存在");
	
	private String reCode;
	private String message;
	
	private ResultType(String reCode,String message){
		this.reCode = reCode;
		this.message = message;
	}

	public String getReCode() {
		return reCode;
	}

	public void setReCode(String reCode) {
		this.reCode = reCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
