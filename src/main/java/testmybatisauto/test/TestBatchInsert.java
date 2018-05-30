package testmybatisauto.test;

import java.util.ArrayList;
import java.util.List;

import mybatisauto.create.IBaseMyBatisByIdDao;
import mybatisauto.create.IBaseMyBatisDao;
import mybatisauto.test.MybatisDataSoruce;
import bean.GysBean;
import bean.in.GysInBean;
import bean.out.GysOutBean;
import dao.IGysDao;

/**
 * 批量插入测试
 * @author guoyansi
 *
 */
public class TestBatchInsert {
	public static void main(String[] args)  throws Exception{
		MybatisDataSoruce mds=new MybatisDataSoruce("run-mybatis-config.xml");
		mds.openSession();
		
		IBaseMyBatisDao<GysBean, GysInBean, GysOutBean> dao=mds.getDao(IGysDao.class);
		List<GysBean> list=getList();
		
		// 第一个参数list
		 //第二个参数sequence名称； 如果是oracle可能是用sequence获取id的
//		int i=dao.batchInsert(list, null);
//		System.out.println("受影响的行数："+i);
		
		
		IBaseMyBatisByIdDao<GysBean> daoById=mds.getDao(IGysDao.class);
		System.out.println("id测试=============");
		int j=daoById.batchInsertGetId(list, null);
		System.out.println("受影响的行数："+j);
		for(GysBean g:list){
			System.out.println("id:"+g.getId());
		}
		mds.commit();
		mds.closeSession();
	}
	private static List<GysBean> getList(){
		List<GysBean> list=new ArrayList<GysBean>();
		for(int i=0;i<20;i++){
			GysBean gys=new GysBean();
			gys.setNote("gysnote"+i);
			gys.setRoleName("gysname"+i);
			list.add(gys);
		}
		return list;
	}
	
}
