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
 * update测试
 * @author guoyansi
 *
 */
public class TestUpdate {
	public static void main(String[] args)  throws Exception{
		MybatisDataSoruce mds=new MybatisDataSoruce("run-mybatis-config.xml");
		mds.openSession();
//		IBaseMyBatisDao<GysBean, GysInBean, GysOutBean> dao=mds.getDao(IGysDao.class);
//		GysBean value=new GysBean();
//		value.setNote("ggg");
//		value.setRoleName("gggg");
//		GysInBean where=new GysInBean();
//		where.setNote("test");
//		int i=dao.update(value, where);
//		System.out.println("受影响的行数："+i);
		System.out.println("=============");
		IBaseMyBatisByIdDao<GysBean> daoById=mds.getDao(IGysDao.class);
		GysBean gys=new GysBean();
		gys.setId(75);
		gys.setRoleName("ggg");
		gys.setNote("ggg");
		int i=daoById.updateById(gys);
		System.out.println("受影响的行数："+i);
		mds.commit();
		mds.closeSession();
	}
}
