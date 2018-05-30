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
 * select测试
 * @author guoyansi
 *
 */
public class TestSelect {
	public static void main(String[] args)  throws Exception{
		MybatisDataSoruce mds=new MybatisDataSoruce("run-mybatis-config.xml");
		mds.openSession();
		IBaseMyBatisDao<GysBean, GysInBean, GysOutBean> dao=mds.getDao(IGysDao.class);
		GysInBean gys=new GysInBean();
		gys.setSqlRoleNameLike(true);
		//gys.setSqlRoleNameLeftLike(true);
		//gys.setSqlRoleNameRightLike(true);
		//gys.setSqlRoleNameD(true);
		//gys.setSqlRoleNameDd(true);
		//gys.setSqlRoleNameX(true);
		//gys.setSqlRoleNameXd(true);gys.setSqlRoleNameInList(new ArrayList<String>());
//		gys.setSqlOrderBy("order by id");
//		gys.setSqlLimit(true);
//		gys.setSqlCurrentPage(1);
//		gys.setSqlPageSize(10);
		//gys.setRoleName("7");
		
		//selectList
		List<GysOutBean> list=dao.selectList(gys);
		for(GysOutBean g:list){
			System.out.println("id:"+g.getId()+";roleName:"+g.getRoleName()+";note:"+g.getNote()+";rn:"+g.getRn());
		}
//		System.out.println("=============");
//		IBaseMyBatisByIdDao<GysBean> daoById=mds.getDao(IGysDao.class);
//		GysBean bean=daoById.selectOneById(22);
//		System.out.println("id:"+bean.getId()+";roleName:"+bean.getRoleName()+";");
		mds.closeSession();
	}
}
