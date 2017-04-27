package com.bonc.codeCenter.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import com.bonc.codeCenter.domain.CCLog;
import com.bonc.codeCenter.domain.CCOrg;
import com.bonc.commons.orm.PagiParam;
import com.bonc.commons.orm.hibernate.HibernateDao;

public class CCLogService {
	/** Spring注入DAO */
	private HibernateDao<CCLog, Long> hibernateDao = null;

	@SuppressWarnings("unchecked")
	public List<CCLog> findToPage(String logType, Date beginDate,
			Date endDate, String resultType, PagiParam pagiParam, boolean exactTotal, boolean isAsc)
			throws DataAccessException {
		Session session = hibernateDao.getHSession();
		Criteria criteria = session.createCriteria(CCLog.class);
		if (StringUtils.isNotBlank(logType)) {
			criteria.add(Restrictions.eq("logType", logType));
		}
		if (StringUtils.isNotBlank(resultType)) {
			criteria.add(Restrictions.eq("resultCode", resultType));
		}

		if (beginDate != null)
			criteria.add(Restrictions.ge("requestTime", beginDate.getTime()));
		if (endDate != null)
			criteria.add(Restrictions.le("requestTime", endDate.getTime()));

		// 设置分页
		hibernateDao.setTotalPagiParam(criteria, pagiParam, exactTotal);
		// 排序条件
		criteria.addOrder(Order.desc("requestTime"));
		List<CCLog> cclogResult = new ArrayList<CCLog>();
		cclogResult = criteria.list();
		session.close();
		return cclogResult;
	}
	
	public boolean insertLog(CCLog log){
		boolean result=false;
		Session session = hibernateDao.getHSession();
		Transaction transaction = null;
		Long id = 0L;
		try {
			transaction = session.beginTransaction();
			id = (Long) session.save(log);
			transaction.commit();
			result = true;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}  finally {
			session.close();
		}
		return result;
	}
	/** 查询ResultType  */
	public int findResultCode(String logType,String resultType) {
		
		String sql = null;
		if(logType.equals("")){
			 sql = "SELECT COUNT(*) FROM CC_LOG WHERE RESULT_CODE = '01'";
		}else{
			 sql = "SELECT COUNT(*) FROM CC_LOG WHERE RESULT_CODE = '01' AND LOG_TYPE = :logType";
		}
		Session session = hibernateDao.getHSession();
		String findSucNum = null;
		try {
			SQLQuery query = session.createSQLQuery(sql);
			if(logType.equals("")){
				
			}else{
				query.setString("logType", logType);
			}
			findSucNum = query.uniqueResult().toString();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return Integer.valueOf(findSucNum);
	}
	
	public HibernateDao<CCLog, Long> getHibernateDao() {
		return hibernateDao;
	}

	public void setHibernateDao(HibernateDao<CCLog, Long> hibernateDao) {
		this.hibernateDao = hibernateDao;
	}
}
