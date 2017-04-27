package com.bonc.codeCenter.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import com.bonc.codeCenter.domain.CCOrg;
import com.bonc.codeCenter.domain.EnterpriseDetail;
import com.bonc.commons.orm.PagiParam;
import com.bonc.commons.orm.hibernate.HibernateDao;

public class CCOrgService {
	/** Spring注入DAO */
	private HibernateDao<CCOrg, Long> hibernateDao = null;
	
	//页面--模糊查询
	public List<CCOrg> findPage(String jgdm,String jgmc,String djh,PagiParam pagiParam, boolean exactTotal)
		      throws DataAccessException{
		Session session = hibernateDao.getHSession();
		List<CCOrg> tmpList = new ArrayList<CCOrg>();
			Criteria criteria = session.createCriteria(CCOrg.class);
			if (StringUtils.isNotBlank(jgdm)) {
				criteria.add(Restrictions.like("jgdm", "%"+jgdm+"%"));
			}
			if(StringUtils.isNotBlank(jgmc)){
				criteria.add(Restrictions.like("jgmc", "%"+jgmc+"%"));
			}
			if(StringUtils.isNotBlank(djh)){
				criteria.add(Restrictions.like("djh", "%"+djh+"%"));
			}
			// 设置分页
			hibernateDao.setTotalPagiParam(criteria, pagiParam, exactTotal);
			// 排序条件
			criteria.addOrder(Order.desc("jgdm"));
			tmpList = criteria.list();
			session.close();
		
		return tmpList;
	}
	
	/**
	 * 通过 组织机构代码、组织机构名称、注册号 查询本地库中的组织机构信息
	 */
	@SuppressWarnings("unchecked")
	public List<CCOrg> getOrgInfo(String jgdm,String jgmc,String djh )throws DataAccessException {
		Session session = hibernateDao.getHSession();
		List<CCOrg> tmpList = new ArrayList<CCOrg>();
			Criteria criteria = session.createCriteria(CCOrg.class);
			if (StringUtils.isNotBlank(jgdm)) {
				criteria.add(Restrictions.eq("jgdm",jgdm));
			}
			if(StringUtils.isNotBlank(jgmc)){
				criteria.add(Restrictions.eq("jgmc",jgmc));
			}
			if(StringUtils.isNotBlank(djh)){
				criteria.add(Restrictions.eq("djh",djh));
			}
	//		criteria.add(Restrictions.or(Restrictions.eq("jgdm", jgdm),
	//					Restrictions.or(Restrictions.eq("jgmc", jgmc),Restrictions.eq("djh", djh))));
	
			// 排序条件
			criteria.addOrder(Order.desc("jgdm"));
			System.out.println("查询前");
			
			tmpList = criteria.list();
			System.out.println("查询后");
		
			session.close();
		
		
		return tmpList;
	}
	/** 
	 * 将组织机构信息写入本地库 
	 */
	public boolean insert(CCOrg org){
		boolean result=false;
		Session session = hibernateDao.getHSession();
		Transaction transaction = null;
		Long id = 0L;
		try {
			transaction = session.beginTransaction();
			id = (Long) session.save(org);
			transaction.commit();
			session.flush();
			result = true;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}  finally {
			session.close();
		}
		return result;
	}	

	/**
	 * 在LocalCCervixe中调用更新本地库
	 * @return
	 */
	public boolean update(CCOrg org){
		boolean result=false;
		Session session = null;
		Transaction transaction = null;
		Long id = 0L;
		try {
			session = hibernateDao.getHSession();
			transaction = session.beginTransaction();
			List<CCOrg> orgList = getOrgInfo(org.getJgdm(),org.getJgmc(),org.getDjh());
			/** 查询本地库，返回结果的个数为0则将将org写入本地库，不为0则删除原来的org */
			if(orgList.size()!=0){
				//删除原来的CCOrg
				String hql = "delete from CCOrg where id = :Id";
				Query query = session.createQuery(hql);
				for(CCOrg orgs:orgList){
					query.setLong("Id", orgs.getId());
					query.executeUpdate();	
				}
			}
			id = (Long) session.save(org);
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
	
	public HibernateDao<CCOrg, Long> getHibernateDao() {
		return hibernateDao;
	}

	public void setHibernateDao(HibernateDao<CCOrg, Long> hibernateDao) {
		this.hibernateDao = hibernateDao;
	}	
}
