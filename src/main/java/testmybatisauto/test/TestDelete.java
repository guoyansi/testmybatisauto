package testmybatisauto.test;

import java.util.List;

import mybatisauto.create.IBaseMyBatisByIdDao;
import mybatisauto.create.IBaseMyBatisDao;
import mybatisauto.test.MybatisDataSoruce;
import bean.GysBean;
import bean.in.GysInBean;
import bean.out.GysOutBean;
import dao.IGysDao;

/**
 * 删除测试
 * @author guoyansi
 *
 */
public class TestDelete {
	public static void main(String[] args)  throws Exception{
		MybatisDataSoruce mds=new MybatisDataSoruce("run-mybatis-config.xml");
		mds.openSession();
		
//		IBaseMyBatisDao<GysBean, GysInBean, GysOutBean> dao=mds.getDao(IGysDao.class);
//		GysInBean gysIn=new GysInBean();
//		gysIn.setNote("9");
//		gysIn.setSqlNoteLike(true);
//		int i=dao.delete(gysIn);
//		System.out.println("受影响的行数："+i);
		
//		System.out.println("=============");
		IBaseMyBatisByIdDao<GysBean> daoById=mds.getDao(IGysDao.class);
		int i=daoById.deleteById(71);
		System.out.println("受影响的行数："+i);
		mds.commit();
		mds.closeSession();
	}
}
