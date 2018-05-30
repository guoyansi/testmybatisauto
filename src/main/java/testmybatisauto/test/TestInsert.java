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
 * insert测试
 * @author guoyansi
 *
 */
public class TestInsert {
	public static void main(String[] args)  throws Exception{
		MybatisDataSoruce mds=new MybatisDataSoruce("run-mybatis-config.xml");
		mds.openSession();
		IBaseMyBatisDao<GysBean, GysInBean, GysOutBean> dao=mds.getDao(IGysDao.class);
		GysBean gys=new GysBean();
		gys.setNote("test");
		gys.setRoleName("test");
//		int i=dao.insert(gys);
//		System.out.println("受影响的行数："+i);
		System.out.println("=============");
		IBaseMyBatisByIdDao<GysBean> daoById=mds.getDao(IGysDao.class);
		int i=daoById.insertGetId(gys);
//		System.out.println("id:"+bean.getId()+";roleName:"+bean.getRoleName()+";");
		System.out.println("受影响的行数："+i+";插入数据的id:"+gys.getId());
		mds.commit();
		mds.closeSession();
	}
}
