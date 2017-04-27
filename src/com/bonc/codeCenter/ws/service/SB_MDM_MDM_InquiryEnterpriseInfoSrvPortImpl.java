package com.bonc.codeCenter.ws.service;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.bonc.codeCenter.domain.CCOrg;
import com.bonc.codeCenter.domain.Envelope;
import com.bonc.codeCenter.domain.InterfaceInfo;
import com.bonc.codeCenter.domain.LocalResponse;
import com.bonc.codeCenter.domain.NacaoRequest;
import com.bonc.codeCenter.service.LocalCCService;
import com.bonc.codeCenter.type.ResultType;
import com.bonc.common.XmlJaxbUtil;

@javax.jws.WebService(endpointInterface = "com.bonc.codeCenter.ws.service.SBMDMMDMInquiryEnterpriseInfoSrv", 
						targetNamespace = "http://mss.unicom.com/SB_MDM_MDM_InquiryEnterpriseInfoSrv", 
						serviceName = "SB_MDM_MDM_InquiryEnterpriseInfoSrv", 
						portName = "SB_MDM_MDM_InquiryEnterpriseInfoSrvPort", 
						wsdlLocation = "file:/home/bonc/app/EIS2/WEB-INF/classes/com/bonc/codeCenter/ws/service/SB_MDM_MDM_InquiryEnterpriseInfoSrv.wsdl")
public class SB_MDM_MDM_InquiryEnterpriseInfoSrvPortImpl {
	/** 注入 Service */
	private LocalCCService localCCService;
	
	private SBMDMMDMInquiryEnterpriseInfoSrvOutputCollection outCollection ;
	private List<SBMDMMDMInquiryEnterpriseInfoSrvOutputItem> outItems;
	
	/** 是否查询缓存表,为0时直接到代码中心服务中查询 */
	private static String IS_LOCAL = "0";
	
	public SBMDMMDMInquiryEnterpriseInfoSrvResponse process(
			SBMDMMDMInquiryEnterpriseInfoSrvRequest payload) throws ParseException {
		 System.out.println("请求时间:"+new Date().toLocaleString());
		Long sameOpr = new Date().getTime();
		/**	LocalResponse对象 */
		LocalResponse localResponseDetail = new LocalResponse();
		/** SBMDMMDMInquiryEnterpriseInfoSrvResponse接口返回对象 */
		SBMDMMDMInquiryEnterpriseInfoSrvResponse srvResponse 
										=  new SBMDMMDMInquiryEnterpriseInfoSrvResponse();
		
		outCollection = new SBMDMMDMInquiryEnterpriseInfoSrvOutputCollection();
		outItems = new ArrayList<SBMDMMDMInquiryEnterpriseInfoSrvOutputItem>();
		/** 将传入的参数赋到本地对象中NacaoRequest */
		NacaoRequest nacaooRequest = new NacaoRequest();
		/** 将传入的参数赋到本地对象中NacaoRequest的InterfaceInfo对象 */
		InterfaceInfo interfaceInfo = new InterfaceInfo();
		//9位和18位都可以用JGDM请求
		interfaceInfo.setJgdm(payload.getORGCODE());//组织机构代码
		interfaceInfo.setTydm("");
		interfaceInfo.setJgmc(payload.getVENDORNAME());//供应商名称
		interfaceInfo.setDjh(payload.getENROLLCODE());//登记号，就是老接口的注册号
		/** 将InterfaceInfo对象赋给本地对象NacaoRequest */
		nacaooRequest.setInterfaceInfo(interfaceInfo);
		
		String logType = "S";
		String requestXmlParam = null;
		
		String searchFlag = payload.getSEARCHFLAG();

		try {
			requestXmlParam = XmlJaxbUtil.bean2xml(SBMDMMDMInquiryEnterpriseInfoSrvRequest.class, payload);
			/** 判断三个字段至少有一个不为空 */
			if(StringUtils.isNotBlank(payload.getORGCODE())||StringUtils.isNotBlank(payload.getVENDORNAME())||StringUtils.isNotBlank(payload.getENROLLCODE())){
				/** 调用localService返回localResponseDetail对象 */
				if(searchFlag.equals(IS_LOCAL)){//从代码中心获取
					localResponseDetail = localCCService.getCCDMInfo(nacaooRequest,sameOpr);
				}else{//从本地数据库
					localResponseDetail = localCCService.getLocalCCDMInfo(nacaooRequest,sameOpr,searchFlag);
					if(localResponseDetail.getOrgList().size()==0){
						localResponseDetail = localCCService.getCCDMInfo(nacaooRequest,sameOpr);
					}
				}
/*					localResponseDetail = localCCService.getLocalCCDMInfo(nacaooRequest,sameOpr,searchFlag);
					if(localResponseDetail.getOrgList().size()==0){
						localResponseDetail = localCCService.getCCDMInfo(nacaooRequest,sameOpr);
					}*/
				
				/**
				 * 输出msgheader
				 * 服务标示，服务消息，BPEL实例ID，记录总数，总页数，页大小，当前页码
				 */
				if(localResponseDetail.getEnvelope().getRecode().equals(ResultType.SUCCESS.getReCode())){
					srvResponse.setSERVICEFLAG("TRUE");//服务标识
				
					srvResponse.setSERVICEMESSAGE(localResponseDetail.getEnvelope().getMessage());//服务信息
					srvResponse.setINSTANCEID(null);//BPEL实例ID
					/** 记录总数 */
					int datasize = localResponseDetail.getEnvelope().getDatasize();
					srvResponse.setTOTALRECORD(new BigDecimal(datasize));
					srvResponse.setTOTALPAGE(new BigDecimal(1));//总页数
					srvResponse.setPAGESIZE(new BigDecimal(datasize));//页大小
					srvResponse.setCURRENTPAGE(new BigDecimal(1));//当前页码
					/** 机构详细信息 */
					SBMDMMDMInquiryEnterpriseInfoSrvOutputItem outItem;
					System.out.println("3");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
					if(localResponseDetail.getOrgList().size() != 0){//localResponseDetail.getOrgList()!=null
						for(CCOrg detail:localResponseDetail.getOrgList()){
							
							outItem = new SBMDMMDMInquiryEnterpriseInfoSrvOutputItem();
							//默认返回统一信用代码，若统一信用代码为空，则返回组织机构代码
							String dm = detail.getTydm();
							if(null==dm||"".equals(dm)){
								dm = detail.getJgdm();
							}
							outItem.setOrgcode(dm);
							outItem.setVendorname(detail.getJgmc());//机构名称
							outItem.setEnrollcode(detail.getDjh());//这里改过，原来是注册号，现在是登记号
							outItem.setLegalrepresentative(detail.getFddbr());//法人代表
							
							/** 将date类型转为XMLGregorianCalendar */
							GregorianCalendar calBzrq = new GregorianCalendar();
							GregorianCalendar calZfrq = new GregorianCalendar();
							GregorianCalendar calZcrq = new GregorianCalendar();
							GregorianCalendar calupdatedate = new GregorianCalendar();
							
							
							DatatypeFactory dfn = DatatypeFactory.newInstance();
							
							if(detail.getJyqxz()!=null){
//								calBzrq.setTimeInMillis(detail.getBzrq().getTime());
//								outItem.setORGCODESTARTDATE(dfn.newXMLGregorianCalendar(calBzrq));//代码证办证日期
								outItem.setOrgcodestartdate(detail.getJyqxz());
							}
							if(detail.getJyqxe()!=null){
//					        	calZfrq.setTimeInMillis(detail.getZfrq().getTime());
//					        	outItem.setORGCODEENDDATE(dfn.newXMLGregorianCalendar(calZfrq));//代码证作废日期
								outItem.setOrgcodeenddate(detail.getJyqxe());
							}
							
							if(detail.getClrq()!=null){
//					        	calZcrq.setTimeInMillis(detail.getZcrq());
//					        	outItem.setENROLLDATE(dfn.newXMLGregorianCalendar(calZcrq));//注册日期
								outItem.setEnrolldate(detail.getClrq());
							}
							
							if(detail.getUpdateDate()!=null){
//								calupdatedate.setTimeInMillis(detail.getUpdateDate().getTime());
//								outItem.setLASTUPDATEDATE(dfn.newXMLGregorianCalendar(calupdatedate)); //最后更新日期
								outItem.setLastupdatedate(detail.getUpdateDate());
							}
							outItem.setOrgtype(detail.getJglx());//机构类型
							
							if(detail.getZgrs()!=null)
								outItem.setEecount(new BigDecimal(detail.getZgrs()));//职工人数
							
							if(detail.getZczj()!=null)
								outItem.setEnrollfund(new BigDecimal(detail.getZczj()));//注册资金
							outItem.setBussscope(detail.getJyfw());//经营范围					
							outItem.setBusstype(detail.getJjlxdm());//经济类型
							outItem.setBusstrade(detail.getJjhydm());//经济行业
							outItem.setAddress(detail.getZcdz());//机构地址
							outItem.setQusflag(detail.getLy());//质疑标志
							outItem.setRegion(detail.getXzqhmc());//行政区划
							
							/**
							 *省份编码，城市名称
							 */
							outItem.setProvincecode(null);
							outItem.setCityname(null);
							
							outItem.setTelehpone(detail.getDhhm());//电话号码
							outItem.setAdminorg(detail.getZgmc());//主管机构名称
							outItem.setPrivateflag(new BigDecimal(detail.getPrivateFlag()));//是否涉密
							outItem.setCacheflag(new BigDecimal(detail.getCacheFlag()));//是否从缓存库查询
							outItems.add(outItem);
						}
						outCollection.sbmdmmdmInquiryEnterpriseInfoSrvOutputItem = outItems;	
						System.out.println("4");
						srvResponse.setSBMDMMDMInquiryEnterpriseInfoSrvOutputCollection(outCollection);
						System.out.println("5");
					}else{
						srvResponse.setSBMDMMDMInquiryEnterpriseInfoSrvOutputCollection(null);
					}
					localResponseDetail.setSameOpr(sameOpr);
					System.out.println("6");
					localCCService.saveLogs(logType,requestXmlParam,localResponseDetail);
					System.out.println("7");
				}else{
						srvResponse.setSERVICEFLAG("FALSE");
						srvResponse.setSERVICEMESSAGE(localResponseDetail.getEnvelope().getMessage());
						srvResponse.setINSTANCEID(null);//BPEL实例ID
						srvResponse.setTOTALRECORD(null);//总记录数
						srvResponse.setTOTALPAGE(null);//总页数
						srvResponse.setPAGESIZE(null);//页大小
						srvResponse.setCURRENTPAGE(null);//当前页码
						srvResponse.setSBMDMMDMInquiryEnterpriseInfoSrvOutputCollection(null);//查询结果置空
						localResponseDetail.setSameOpr(sameOpr);
						Envelope envelope = new Envelope();
						envelope.setRecode(localResponseDetail.getEnvelope().getRecode());
						envelope.setMessage(localResponseDetail.getEnvelope().getMessage());
						localResponseDetail.setEnvelope(envelope);
						localCCService.saveLogs(logType,requestXmlParam,localResponseDetail);
				}
			}else{
				srvResponse.setSERVICEFLAG("FALSE");//服务标识
				srvResponse.setSERVICEMESSAGE(ResultType.ERR_PARAM_NONE.getMessage());//服务信息
				srvResponse.setINSTANCEID(null);//BPEL实例ID
				srvResponse.setTOTALRECORD(null);//总记录数
				srvResponse.setTOTALPAGE(null);//总页数
				srvResponse.setPAGESIZE(null);//页大小
				srvResponse.setCURRENTPAGE(null);//当前页码
				srvResponse.setSBMDMMDMInquiryEnterpriseInfoSrvOutputCollection(null);//查询结果置空
				localResponseDetail.setSameOpr(sameOpr);
				Envelope envelope = new Envelope();
				envelope.setRecode(ResultType.ERR_PARAM_NONE.getReCode());
				envelope.setMessage(ResultType.ERR_PARAM_NONE.getMessage());
				localResponseDetail.setEnvelope(envelope);
				localCCService.saveLogs(logType,requestXmlParam,localResponseDetail);
			}
		} catch (Exception e) {  
			srvResponse.setSERVICEFLAG("FALSE");//服务标识
			srvResponse.setSERVICEMESSAGE(ResultType.ERR_SYS.getMessage());//服务信息
			srvResponse.setINSTANCEID(null);//BPEL实例ID
			srvResponse.setTOTALRECORD(null);//总记录数
			srvResponse.setTOTALPAGE(null);//总页数
			srvResponse.setPAGESIZE(null);//页大小
			srvResponse.setCURRENTPAGE(null);//当前页码
			srvResponse.setSBMDMMDMInquiryEnterpriseInfoSrvOutputCollection(null);//查询结果置空
			e.printStackTrace();
			localResponseDetail.setSameOpr(sameOpr);
			Envelope envelope = new Envelope();
			envelope.setRecode(ResultType.ERR_SYS.getReCode());
			envelope.setMessage(ResultType.ERR_SYS.getMessage());
			localResponseDetail.setEnvelope(envelope);
			localCCService.saveLogs(logType,requestXmlParam,localResponseDetail);
	    } 
		System.out.println("8");
		return srvResponse;
	}
	
		
	public LocalCCService getLocalCCService() {
		return localCCService;
	}
	public void setLocalCCService(LocalCCService localCCService) {
		this.localCCService = localCCService;
	}
	
	
	//测试方法
	public static void main(String args[]) throws java.lang.Exception{
		Long dataDatail = 1415933880215L;
		//转换为XMLGregorianCalendar
		GregorianCalendar calBzrq = new GregorianCalendar();
		GregorianCalendar calZfrq = new GregorianCalendar();
		GregorianCalendar calZcrq = new GregorianCalendar();
		GregorianCalendar calupdatedate = new GregorianCalendar();
		calBzrq.setTimeInMillis(dataDatail);  
    	calZfrq.setTimeInMillis(dataDatail);
    	calZcrq.setTimeInMillis(dataDatail);
    	calupdatedate.setTimeInMillis(dataDatail);
    	XMLGregorianCalendar gcBzrqDate = null;  
		XMLGregorianCalendar gcZfrqDate = null;
		XMLGregorianCalendar gcZcrqDate = null;
		XMLGregorianCalendar gcupdateDate = null;
		DatatypeFactory dfn = DatatypeFactory.newInstance();
		gcBzrqDate = dfn.newXMLGregorianCalendar(calBzrq);  
        gcZfrqDate = dfn.newXMLGregorianCalendar(calZfrq);
        gcZcrqDate = dfn.newXMLGregorianCalendar(calZcrq);
        gcupdateDate = dfn.newXMLGregorianCalendar(calupdatedate);
        
        System.out.println(gcBzrqDate);
        System.out.println(gcZfrqDate);
        System.out.println(gcZcrqDate);
        System.out.println(gcupdateDate);
	}

}