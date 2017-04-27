package com.bonc.codeCenter.service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.ws.WebServiceException;

import org.apache.commons.lang.StringUtils;

import com.bonc.codeCenter.domain.CCLog;
import com.bonc.codeCenter.domain.CCOrg;
import com.bonc.codeCenter.domain.Enterprise;
import com.bonc.codeCenter.domain.EnterpriseDetail;
import com.bonc.codeCenter.domain.Envelope;
import com.bonc.codeCenter.domain.InterfaceInfo;
import com.bonc.codeCenter.domain.LocalResponse;
import com.bonc.codeCenter.domain.NacaoRequest;
import com.bonc.codeCenter.domain.NacaoResponse;
import com.bonc.codeCenter.domain.NacaoResponseDetail;
import com.bonc.codeCenter.type.ResultType;
import com.bonc.codeCenter.ws.client.CodeCenterWSProxy;
import com.bonc.common.Arithmetic;
import com.bonc.common.XmlJaxbUtil;
import com.bonc.commons.orm.hibernate.HibernateDao;
/**
 * 代码中心客户端业务本地化接口
 * @author WangMingjun
 *
 */
public class LocalCCService {
	/**
	 *  用户名：Chinaunicom    （测试环境）
		密码：01066259590    （测试环境）  
		密钥：23C2920FB761E0D3F62E53B977274A2D   测试环境）
		接口名称：chinaunicom_dm_mc_zc    （测试环境）
		返回日期：2014-11-27    （测试环境）
	 */
	/**
	 *  用户名：	chinaunicom    （正式环境）
		密码：	01066259590     （正式环境）
		CA信息：	94ECBBD9528526298FCC08BCAA99CA43     （正式环境）
		接口编号：	chinaunicom_dm_mc_zc    （正式环境）
		返回日期：	2015-04-03     （正式环境）
	 */
	private CodeCenterWSProxy dcPort;
	
//	private static String CENTER_INTERFACE_SEED = "23C2920FB761E0D3F62E53B977274A2D";//加密种子
//	
//	private static String CENTER_INTERFACE_USER = "chinaunicom";//接口用户吿
//	
//	private static String CENTER_INTERFACE_PWD = "01066259590";//接口用户密码
//	
//	private static String CNETER_INTERFACE_CA = "";//CA信息
//	
//	private static String CENTER_INTERFACE_CODE = "chinaunicom_dm_mc_zc";//接口编号
	
	private static String CENTER_INTERFACE_SEED = "94ECBBD9528526298FCC08BCAA99CA43";//加密种子
	
	private static String CENTER_INTERFACE_USER = "chinaunicom";//接口用户吿
	
	private static String CENTER_INTERFACE_PWD = "18601242991";//接口用户密码
	
	private static String CNETER_INTERFACE_CA = "";//CA信息
	
	private static String CENTER_INTERFACE_CODE = "chinaunicom_dm_mc_zc";//接口编号
	
	/** 注入 Service */
	private CCLogService logService;
	private CCOrgService orgCodeService;
	
	/** Spring注入DAO */
	private HibernateDao<CCOrg, Long> hibernateDao = null;

	public LocalCCService(){
		CodeCenterWSProxy dcService = new CodeCenterWSProxy();
		this.dcPort = dcService;
	}	

	
	/**
	 * 从代码中心获取组织机构信息
	 * @return
	 */
	public LocalResponse getCCDMInfo(NacaoRequest requestParam,Long sameOpr){
		String requestXmlParam =  null;
		String resposeXmlResult = null;
		
		LocalResponse localRespose = new LocalResponse();
		List<CCOrg> orgList = new ArrayList<CCOrg>();
		
		String logType = "C";
		localRespose.setSameOpr(sameOpr);
		
		NacaoResponseDetail responseDetail = new NacaoResponseDetail();
		Envelope envelope = new Envelope();
		try {
			//接口权限信息
			requestParam.setUserName(CENTER_INTERFACE_USER);
			requestParam.setPassword(CENTER_INTERFACE_PWD);
			requestParam.setCaInfo(CNETER_INTERFACE_CA);
			
			//请求参数进行加密处理			
			InterfaceInfo info = requestParam.getInterfaceInfo();
			info.setCode(CENTER_INTERFACE_CODE);
			
			if(info.getJgdm() != null && !"".equals(info.getJgdm())){
				info.setJgdm(Arithmetic.getEncString(info.getJgdm(), CENTER_INTERFACE_SEED));
			}
			if(info.getJgmc() != null && !"".equals(info.getJgmc())){
				info.setJgmc(Arithmetic.getEncString(info.getJgmc(), CENTER_INTERFACE_SEED));
			}
			
			if(info.getDjh() != null && !"".equals(info.getDjh())){
				info.setDjh(Arithmetic.getEncString(info.getDjh(), CENTER_INTERFACE_SEED));
			}
			
			requestParam.setInterfaceInfo(info);
			requestXmlParam = XmlJaxbUtil.bean2xml(NacaoRequest.class, requestParam);
			System.out.println(requestXmlParam);
			//向"全国组织机构代码管理中心"服务发起获取服务机构信息请求
			resposeXmlResult = this.dcPort.CCService(requestXmlParam);
			System.out.println(resposeXmlResult);
			//将请求结果resposeXmlResult转换成本地对象responseDetail
			responseDetail = XmlJaxbUtil.xml2bean(NacaoResponseDetail.class, resposeXmlResult);
			if(responseDetail.getEnvelope().getDatasize()!=0){
				for(EnterpriseDetail enterpriseDetail :responseDetail.getDataInfo()){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
					
					System.out.println(enterpriseDetail.getDjh());
					//组织机构代码
					if(enterpriseDetail.getJgdm() != null){
						enterpriseDetail.setJgdm(enterpriseDetail.getJgdm());
					}
					//统一社会信用代码
					if(enterpriseDetail.getTydm() != null){
						enterpriseDetail.setTydm(
				    			Arithmetic.getDesString(enterpriseDetail.getTydm(), CENTER_INTERFACE_SEED));
					}
					//质疑标志
					if(enterpriseDetail.getLy() != null){
						enterpriseDetail.setLy(
				    			Arithmetic.getDesString(enterpriseDetail.getLy(), CENTER_INTERFACE_SEED));
					}
					//登记号
					if(enterpriseDetail.getDjh() != null){
						System.out.println(enterpriseDetail.getDjh());
						enterpriseDetail.setDjh(
				    			Arithmetic.getDesString(enterpriseDetail.getDjh(), CENTER_INTERFACE_SEED));
						System.out.println(enterpriseDetail.getDjh());
					}
					//注册地址
					if(enterpriseDetail.getZcdz() != null){
						enterpriseDetail.setZcdz(
				    			Arithmetic.getDesString(enterpriseDetail.getZcdz(), CENTER_INTERFACE_SEED));
					}
					//经营状态
					if(enterpriseDetail.getJyzt() != null){
						enterpriseDetail.setJyzt(
								Arithmetic.getDesString(enterpriseDetail.getJyzt(), CENTER_INTERFACE_SEED));
					}
					//校核标志
					if(enterpriseDetail.getJhbz() != null){
						enterpriseDetail.setJhbz(
								Arithmetic.getDesString(enterpriseDetail.getJhbz(), CENTER_INTERFACE_SEED));
					}
					//登记机关
					if(enterpriseDetail.getDjbmmc() != null){
						enterpriseDetail.setDjbmmc(
								Arithmetic.getDesString(enterpriseDetail.getDjbmmc(), CENTER_INTERFACE_SEED));
					}
					//行政区划名称
					if(enterpriseDetail.getXzqhmc() != null){
						enterpriseDetail.setXzqhmc(
								Arithmetic.getDesString(enterpriseDetail.getXzqhmc(), CENTER_INTERFACE_SEED));
					}
					//经营期限自
					if(enterpriseDetail.getJyqxz() != null && enterpriseDetail.getJyqxz()!=""){
						enterpriseDetail.setJyqxz(
								Arithmetic.getDesString(enterpriseDetail.getJyqxz(), CENTER_INTERFACE_SEED));
					}
					//经营期限至
					if(enterpriseDetail.getJyqxe() != null && enterpriseDetail.getJyqxe()!=""){
						enterpriseDetail.setJyqxe(
								Arithmetic.getDesString(enterpriseDetail.getJyqxe(), CENTER_INTERFACE_SEED));
					}
					//经济类型代码
					if(enterpriseDetail.getJjlxdm() != null){
						enterpriseDetail.setJjlxdm(
								Arithmetic.getDesString(enterpriseDetail.getJjlxdm(), CENTER_INTERFACE_SEED));
					}
					//最后更新日期
					if(enterpriseDetail.getBgrq() != null && enterpriseDetail.getBgrq()!=""){
						enterpriseDetail.setBgrq(
								Arithmetic.getDesString(enterpriseDetail.getBgrq().toString(), CENTER_INTERFACE_SEED));
					}
					//经营地址
					if(enterpriseDetail.getJydz() != null){
						enterpriseDetail.setJydz(
								Arithmetic.getDesString(enterpriseDetail.getJydz(), CENTER_INTERFACE_SEED));
					}
					//经济行业代码
					if(enterpriseDetail.getJjhydm() != null){
						enterpriseDetail.setJjhydm(
								Arithmetic.getDesString(enterpriseDetail.getJjhydm(), CENTER_INTERFACE_SEED));
					}
					//邮件
					if(enterpriseDetail.getEmail() != null){
						enterpriseDetail.setEmail(
								Arithmetic.getDesString(enterpriseDetail.getEmail(), CENTER_INTERFACE_SEED));
						
					}
					//职工人数
					if(enterpriseDetail.getZgrs() != null){
						enterpriseDetail.setZgrs(
								Arithmetic.getDesString(enterpriseDetail.getZgrs(), CENTER_INTERFACE_SEED));
					}
					//Url
					if(enterpriseDetail.getUrl() != null){
						enterpriseDetail.setUrl(
								Arithmetic.getDesString(enterpriseDetail.getUrl(), CENTER_INTERFACE_SEED));
						System.out.println(enterpriseDetail.getUrl());
					}
					//成立日期
					if(enterpriseDetail.getClrq() != null && enterpriseDetail.getClrq()!=""){
						enterpriseDetail.setClrq(
								Arithmetic.getDesString(enterpriseDetail.getClrq().toString(), CENTER_INTERFACE_SEED));
					}
					//电话号码
					if(enterpriseDetail.getDhhm() != null){
						enterpriseDetail.setDhhm(
								Arithmetic.getDesString(enterpriseDetail.getDhhm(), CENTER_INTERFACE_SEED));
					}
					//法定代表人
					if(enterpriseDetail.getFddbr() != null){
						enterpriseDetail.setFddbr(
								Arithmetic.getDesString(enterpriseDetail.getFddbr(), CENTER_INTERFACE_SEED));
					}
					//机构类型
					if(enterpriseDetail.getJglx() != null){
						enterpriseDetail.setJglx(
								Arithmetic.getDesString(enterpriseDetail.getJglx(), CENTER_INTERFACE_SEED));
					}
					//机构名称
					if(enterpriseDetail.getJgmc() != null){
						enterpriseDetail.setJgmc(
								Arithmetic.getDesString(enterpriseDetail.getJgmc(), CENTER_INTERFACE_SEED));
					}
					//经营范围
					if(enterpriseDetail.getJyfw() != null){
						enterpriseDetail.setJyfw(
								Arithmetic.getDesString(enterpriseDetail.getJyfw(), CENTER_INTERFACE_SEED));
					}
			
					//注册资金
					if(enterpriseDetail.getZczj() != null){
						enterpriseDetail.setZczj(
								Long.parseLong(
										Arithmetic.getDesString(enterpriseDetail.getZczj().toString(), CENTER_INTERFACE_SEED)
										));
					}
					//上级主管部门
					if(enterpriseDetail.getZgmc() != null){
						enterpriseDetail.setZgmc(
								Arithmetic.getDesString(enterpriseDetail.getZgmc(), CENTER_INTERFACE_SEED));
					}
	
				}
			}
			localRespose.setEnvelope(responseDetail.getEnvelope());	
			if(responseDetail.getEnvelope().getRecode().equals(ResultType.SUCCESS.getReCode())){			
			    //返回结果多余一条，直接返回给服务消费方，消费方确认后，再次请求，否则返回详细信息
			    if(responseDetail.getEnvelope().getDatasize()==1){
			    	String jgdm ;
			    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			    	//存入本地数据库
			    	Date updateDate = (new Date());//Long   .getTime()
			    	CCOrg org = new CCOrg();
			    	//org = (CCOrg)responseDetail.getDataInfo().get(0);
			    	EnterpriseDetail responseEnterp = responseDetail.getDataInfo().get(0);
			    	org.setBgrq(sdf.parse(responseEnterp.getBgrq()));
			    	org.setClrq(sdf.parse(responseEnterp.getClrq()));
			    	org.setDhhm(responseEnterp.getDhhm());
			    	org.setDjbmmc(responseEnterp.getDjbmmc());
			    	org.setEmail(responseEnterp.getEmail());
			    	org.setFddbr(responseEnterp.getFddbr());
			    	org.setJgdm(responseEnterp.getJgdm());
			    	org.setJglx(responseEnterp.getJglx());
			    	org.setDjh(responseEnterp.getDjh());
			    	org.setJgmc(responseEnterp.getJgmc());
			    	org.setJhbz(responseEnterp.getJhbz());
			    	org.setJjhydm(responseEnterp.getJjhydm());
			    	org.setJjlxdm(responseEnterp.getJjlxdm());
			    	org.setJydz(responseEnterp.getJydz());
			    	org.setJyfw(responseEnterp.getJyfw());
			    	org.setJyqxe(sdf.parse(responseEnterp.getJyqxe()));
			    	org.setJyqxz(sdf.parse(responseEnterp.getJyqxz()));
			    	org.setJyzt(responseEnterp.getJyzt());
			    	org.setLy(responseEnterp.getLy());
			    	org.setTydm(responseEnterp.getTydm());
			    	org.setUrl(responseEnterp.getUrl());
			    	org.setXzqhmc(responseEnterp.getXzqhmc());
			    	org.setZcdz(responseEnterp.getZcdz());
			    	org.setZczj(responseEnterp.getZczj());
			    	org.setZgmc(responseEnterp.getZgmc());
			    	org.setZgrs(Long.parseLong(responseEnterp.getZgrs()));
			    	
			    	Long privateFlag = checkPrivate(responseEnterp)?new Long(1):new Long(0);
			    	org.setPrivateFlag(privateFlag);
			    	org.setUpdateDate(updateDate);
			    	org.setCacheFlag(new Long(0));
			    	
			    	orgCodeService.update(org);
			    	
			    	orgList.add(org);
			    	localRespose.setOrgList(orgList);
			    }else if(responseDetail.getEnvelope().getDatasize()==0){
			    	envelope.setRecode(ResultType.ERR_ORG_NONEXISTENT.getReCode());
					envelope.setMessage(ResultType.ERR_ORG_NONEXISTENT.getMessage());
					envelope.setDatasize(0);
					localRespose.setEnvelope(envelope);
					localRespose.setOrgList(null);
			    }else{
			    	for(EnterpriseDetail detail : responseDetail.getDataInfo()){
			    		Date updateDates = (new Date());
			    		CCOrg org = new CCOrg();
			    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			    		//org = (CCOrg)detail;
			    		org.setUpdateDate(updateDates);				//最后更新时间
			    		org.setCacheFlag(new Long(0));      //是否缓存库查询标记 1是；0否
			    		
				    	org.setBgrq(sdf.parse(detail.getBgrq()));
				    	org.setDjh(detail.getDjh());
				    	org.setClrq(sdf.parse(detail.getClrq()));
				    	org.setDhhm(detail.getDhhm());
				    	org.setDjbmmc(detail.getDjbmmc());
				    	org.setEmail(detail.getEmail());
				    	org.setFddbr(detail.getFddbr());
				    	org.setJgdm(detail.getJgdm());
				    	org.setJglx(detail.getJglx());
				    	org.setJgmc(detail.getJgmc());
				    	org.setJhbz(detail.getJhbz());
				    	org.setJjhydm(detail.getJjhydm());
				    	org.setJjlxdm(detail.getJjlxdm());
				    	org.setJydz(detail.getJydz());
				    	org.setJyfw(detail.getJyfw());
				    	org.setJyqxe(sdf.parse(detail.getJyqxe()));
				    	org.setJyqxz(sdf.parse(detail.getJyqxz()));
				    	org.setJyzt(detail.getJyzt());
				    	org.setLy(detail.getLy());
				    	org.setTydm(detail.getTydm());
				    	org.setUrl(detail.getUrl());
				    	org.setXzqhmc(detail.getXzqhmc());
				    	org.setZcdz(detail.getZcdz());
				    	org.setZczj(detail.getZczj());
				    	org.setZgmc(detail.getZgmc());
				    	org.setZgrs(Long.parseLong(detail.getZgrs()));
				    	
				    	Long privateFlag = checkPrivate(detail)?new Long(1):new Long(0);
				    	org.setPrivateFlag(privateFlag);
				    	orgList.add(org);
			    	}
			    	localRespose.setOrgList(orgList);
			    }
			}
			//写请求日志
			saveLogs(logType,requestXmlParam,localRespose);
			System.out.println("2");
		}catch(WebServiceException e){
			envelope.setDatasize(0);
			envelope.setRecode(ResultType.ERR_TIMEOUT.getReCode());
			envelope.setMessage(ResultType.ERR_TIMEOUT.getMessage());
			localRespose.setEnvelope(envelope);
			localRespose.setOrgList(null);	
			localRespose.setErrormessage(e.getMessage());
			saveLogs(logType,requestXmlParam,localRespose);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
			envelope.setDatasize(0);
			envelope.setRecode(ResultType.ERR_ORGRETURN_ERROR.getReCode());
			envelope.setMessage(ResultType.ERR_ORGRETURN_ERROR.getMessage());
			localRespose.setEnvelope(envelope);
			localRespose.setOrgList(null);
			localRespose.setErrormessage(e.getMessage());
			saveLogs(logType,requestXmlParam,localRespose);
			e.printStackTrace();
		}
		
		return localRespose;
	}
	
	/**
	 * 从本地库获取组织机构信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public LocalResponse getLocalCCDMInfo(NacaoRequest requestParam,Long sameOpr,String IS_LOCAL){
		String jgdm,jgmc,djh = null;
		String requestXmlParam =  null;
		LocalResponse localRespose = new LocalResponse();		
		Envelope envelope = new Envelope();
		List<CCOrg> orgs = new ArrayList<CCOrg>();
		
		try {	
			requestXmlParam = XmlJaxbUtil.bean2xml(NacaoRequest.class, requestParam);
			jgdm = requestParam.getInterfaceInfo().getJgdm();
			jgmc = requestParam.getInterfaceInfo().getJgmc();
			djh = requestParam.getInterfaceInfo().getDjh();
			List<CCOrg> tmpList = new ArrayList<CCOrg>();
			tmpList =  orgCodeService.getOrgInfo(jgdm, jgmc, djh);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			EnterpriseDetail enterpriseDetail = new EnterpriseDetail();
			if(!tmpList.isEmpty()){
				CCOrg org = tmpList.get(0);
				org.setCacheFlag(new Long(1));
				if(org.getPrivateFlag() == null){
					enterpriseDetail.setBgrq(sdf.format(org.getBgrq()));
					enterpriseDetail.setClrq(sdf.format(org.getClrq()));
					enterpriseDetail.setJyqxz(sdf.format(org.getJyqxz()));
					enterpriseDetail.setJyqxe(sdf.format(org.getJyqxe()));
					enterpriseDetail.setDhhm(org.getDhhm());
					enterpriseDetail.setDjbmmc(org.getDjbmmc());
					enterpriseDetail.setDjh(org.getDjh());
					enterpriseDetail.setEmail(org.getEmail());
					enterpriseDetail.setFddbr(org.getFddbr());
					enterpriseDetail.setJgdm(org.getJgdm());
					enterpriseDetail.setJglx(org.getJglx());
					enterpriseDetail.setJgmc(org.getJgmc());
					enterpriseDetail.setJhbz(org.getJhbz());
					enterpriseDetail.setJjhydm(org.getJjhydm());
					enterpriseDetail.setJjlxdm(org.getJjlxdm());
					enterpriseDetail.setJydz(org.getJydz());
					enterpriseDetail.setJyfw(org.getJyfw());
					enterpriseDetail.setJyzt(org.getJyzt());
					enterpriseDetail.setLy(org.getLy());
					enterpriseDetail.setTydm(org.getTydm());
					enterpriseDetail.setUrl(org.getUrl());
					enterpriseDetail.setXzqhmc(org.getXzqhmc());
					enterpriseDetail.setZcdz(org.getZcdz());
					enterpriseDetail.setZczj(org.getZczj());
					enterpriseDetail.setZgmc(org.getZgmc());
					enterpriseDetail.setZgrs(org.getZgrs().toString());
					
					org.setPrivateFlag(checkPrivate(enterpriseDetail)?new Long(1):new Long(0));
				}
				orgs.add(org);
				/*if(orgs.size()==1){break;}*/
			}
			//缓存标志为2时，只查询缓存款，查不到就返回
			if(orgs.size()!=0){
				//构建对象NacaoResponseDetail
				envelope.setRecode(ResultType.SUCCESS.getReCode());
				envelope.setMessage(ResultType.SUCCESS.getMessage());
				envelope.setDatasize(orgs.size());
				
				localRespose.setEnvelope(envelope);
				localRespose.setOrgList(orgs);
				System.out.println("1");
			}else{
				if(IS_LOCAL.equals("2")){
					envelope.setRecode(ResultType.ERR_ORG_NONEXISTENT.getReCode());
					envelope.setMessage(ResultType.ERR_ORG_NONEXISTENT.getMessage());
					envelope.setDatasize(orgs.size());
					
					localRespose.setEnvelope(envelope);
					localRespose.setOrgList(orgs);
				}else{
					localRespose = getCCDMInfo(requestParam,sameOpr);
				}
			}	
		
		} catch (Exception e) {
			envelope.setDatasize(0);
			envelope.setRecode(ResultType.ERR_SYS.getReCode());
			envelope.setMessage(ResultType.ERR_SYS.getMessage());
			localRespose.setEnvelope(envelope);
			localRespose.setOrgList(null);	
			e.printStackTrace();
		}
		
		return localRespose;
	}
	
	//是否涉密检查   判断依据：在对外开放的数据库中只存储了组织机构代码一个字段，无法反馈其他字段信息
	private boolean checkPrivate(EnterpriseDetail detail){
		
		boolean privateFlag = false;
		if(detail.getJgdm()!= null){
			if(detail.getBgrq()==null||"".equals(detail.getBgrq())){
				if(detail.getClrq()==null||"".equals(detail.getClrq())){
					if(detail.getDhhm()==null||"".equals(detail.getDhhm())){
					if(detail.getDjbmmc()==null||"".equals(detail.getDjbmmc())){
					if(detail.getEmail()==null||"".equals(detail.getEmail())){
					if(detail.getFddbr()==null||"".equals(detail.getFddbr())){
					if(detail.getJgdm()==null||"".equals(detail.getJgdm())){
					if(detail.getJglx()==null||"".equals(detail.getJglx())){
					if(detail.getJgmc()==null||"".equals(detail.getJgmc())){
					if(detail.getJhbz()==null||"".equals(detail.getJhbz())){
					if(detail.getJjhydm()==null||"".equals(detail.getJjhydm())){
					if(detail.getJjlxdm()==null||"".equals(detail.getJjlxdm())){
					if(detail.getJydz()==null||"".equals(detail.getJydz())){
					if(detail.getJyfw()==null||"".equals(detail.getJyfw())){
					if(detail.getZczj()==null||"".equals(detail.getZczj())){
						
					if(detail.getJyqxe()==null||"".equals(detail.getJyqxe())){
					if(detail.getJyqxz()==null||"".equals(detail.getJyqxz())){
					if(detail.getJyzt()==null||"".equals(detail.getJyzt())){
					if(detail.getLy()==null||"".equals(detail.getLy())){
							
					if(detail.getXzqhmc()==null||"".equals(detail.getXzqhmc())){
								
					if(detail.getZcdz()==null||"".equals(detail.getZcdz())){
									
					if(detail.getZgmc()==null||"".equals(detail.getZgmc())){
					if(detail.getZgrs()==null||"".equals(detail.getZgrs())){
					if(detail.getTydm()==null||"".equals(detail.getTydm())){
						if(detail.getUrl()==null||"".equals(detail.getUrl())){
							privateFlag = true;
						}
					}}}}}}}}}}}}}}}}}}}}}}
				}
			}
		}
		
		return privateFlag;
	}
	//写请求日志
	public  boolean saveLogs(String logType, String requestXmlParam, LocalResponse responseDetail){
		boolean result=false;
		CCLog log = new CCLog();
		log.setLogType(logType);
		log.setRequestParam(requestXmlParam);
		log.setRequestTime((new Date()).getTime());
		log.setResultCode(responseDetail.getEnvelope().getRecode());
		int messageLength = responseDetail.getEnvelope().getMessage().length(); 
		if(messageLength>15){
			log.setResultDesc(responseDetail.getEnvelope().getMessage().substring(12, messageLength));
		}else{
			log.setResultDesc(responseDetail.getEnvelope().getMessage());
		}
		log.setSameOpr(responseDetail.getSameOpr());
		String errormessage = responseDetail.getErrormessage();
		if(errormessage!=null){
			log.setError_message(errormessage);
		}
		if(responseDetail.getOrgList() != null && responseDetail.getOrgList().size()!=0&&responseDetail.getOrgList().get(0).getCacheFlag()!=null){
			log.setIsLocal(responseDetail.getOrgList().get(0).getCacheFlag().longValue());
		}	
		logService.insertLog(log);
		return result;
	}
	
	 /**
	  * 字符串编码转换的实现方法
	  * @param str  待转换编码的字符串
	  * @param newCharset 目标编码
	  * @return
	  * @throws UnsupportedEncodingException
	  */
	 public String changeCharset(String str, String newCharset)
	   throws UnsupportedEncodingException {
		 String result = null;
	  if (str != null) {
	   //用默认字符编码解码字符串。
	   byte[] bs = str.getBytes();//"GBK"
	   //用新的字符编码生成字符串
	   return result = new String(bs, newCharset);
	  }
	  return result;
	 }
	
	public HibernateDao<CCOrg, Long> getHibernateDao() {
		return hibernateDao;
	}

	public void setHibernateDao(HibernateDao<CCOrg, Long> hibernateDao) {
		this.hibernateDao = hibernateDao;
	}

	public CCLogService getLogService() {
		return logService;
	}


	public void setLogService(CCLogService logService) {
		this.logService = logService;
	}


	public CCOrgService getOrgCodeService() {
		return orgCodeService;
	}


	public void setOrgCodeService(CCOrgService orgCodeService) {
		this.orgCodeService = orgCodeService;
	}
}
