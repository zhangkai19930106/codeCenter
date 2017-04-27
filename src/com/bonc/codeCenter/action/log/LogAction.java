/**
 * Copyright (c) 2012，北京东方国信科技股份有限公司版权所有
 */
package com.bonc.codeCenter.action.log;

import java.util.Date;
import java.util.List;

import com.bonc.base.dao.PagiParam;
import com.bonc.codeCenter.domain.CCLog;
import com.bonc.codeCenter.service.CCLogService;
import com.bonc.codeCenter.type.ResultType;
import com.opensymphony.xwork2.ActionSupport;

/**
 * LogsAction 日志查看
 * 
 * @version 1.0 2014-11-13
 * @author WangMingjun
 * @since 1.0
 */
public class LogAction extends ActionSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** 注入 Service */
	private CCLogService logService;

	/** 日志列表 */
	private List<CCLog> logsList;

	/** 列表查询分页对象 */
	@SuppressWarnings("deprecation")
	private PagiParam pagiParam;
	/** 排序属性 */
	private String propertyName = "id";

	/** 是否升序 */
	private boolean isAsc;
	/** 是否重新查询记录总条数 */
	private boolean exactTotal = false;

	/** 是否在首页展示 */
	private int homePage;
	
	/** 成功记录数 */
	private int sucNum;
	
	/** 失败记录数 */
	private int falNum;
	
	/** 查询条件 */
	/* 日志类型：C:客户端请求日志；S：服务端响应日志 */
	private String logType = "";
	private Date beginDate;
	private Date endDate;
	private String resultType = "";

	public String execute(){
		
		getLogsDetailList();
		return "list";
	}
	
	@SuppressWarnings("deprecation")
	public void getLogsDetailList() {
		try {
			if (pagiParam == null) {
				pagiParam = new PagiParam();
				if (homePage == 1) {
					pagiParam.setPageSize(5);
				}
			}
			
			logsList = logService.findToPage(logType, beginDate, endDate,
					resultType, pagiParam, exactTotal, isAsc);
			sucNum = 0;
			for(int i=0;i<logsList.size();i++){
				if(logsList.get(i).getResultCode().equals(ResultType.SUCCESS.getReCode())){
					sucNum += 1;
				}
			}
			falNum = pagiParam.getTotalRowNum()-sucNum;
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("获取日志列表异常!");
		}
	}
	
	public void saveLog(){
		CCLog log = new CCLog();
		log.setId(2L);
		log.setLogType("C");
		log.setRequestParam("aaa");
		log.setRequestTime((new Date()).getTime());
		
		boolean result = logService.insertLog(log);
		if(result)
			System.out.println("成功");
		else
			System.out.println("失败");
	}

	/**
	 * 初始化基础数据,后期建议用数据码表维护
	 */
	private void init() {
		// 初始化方法
	}

	public PagiParam getPagiParam() {
		return pagiParam;
	}

	public void setPagiParam(PagiParam pagiParam) {
		this.pagiParam = pagiParam;
	}

	public boolean isAsc() {
		return isAsc;
	}

	public void setAsc(boolean isAsc) {
		this.isAsc = isAsc;
	}

	public boolean isExactTotal() {
		return exactTotal;
	}

	public void setExactTotal(boolean exactTotal) {
		this.exactTotal = exactTotal;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getHomePage() {
		return homePage;
	}

	public void setHomePage(int homePage) {
		this.homePage = homePage;
	}

	public CCLogService getLogService() {
		return logService;
	}

	public void setLogService(CCLogService logService) {
		this.logService = logService;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public void setLogsList(List<CCLog> logsList) {
		this.logsList = logsList;
	}
	
	public List<CCLog> getLogsList() {
		return logsList;
	}

	public int getSucNum() {
		return sucNum;
	}

	public void setSucNum(int sucNum) {
		this.sucNum = sucNum;
	}

	public int getFalNum() {
		return falNum;
	}

	public void setFalNum(int falNum) {
		this.falNum = falNum;
	}
}
