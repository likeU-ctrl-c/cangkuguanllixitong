package cangku_manager_cp;

import java.sql.*;
import cangku_manager_dbhelp.DBHelper;

public class cp_model {
		DBHelper dbhelper = new DBHelper();
		
		public void insert(String cpid,String ming ,String dan,String sheng) {
			
				String sql = "INSERT INTO 产品表   "+
				"VALUES('"+cpid+"','"+ming+"','"+dan+"','"+sheng+"');";
				System.out.println("sql="+sql);
				dbhelper.insert(sql);
		}
		public void update(String cpid,String ming ,String dan,String sheng) {
			
				String sql2 = "update 产品表 set 名称='"+ming+"', 单位='"+dan+"' ,生成地='"+sheng+"'where 产品代码='"+cpid+"';";
				dbhelper.update(sql2);	
		}

		public void delete(String cpid) {
			
				String sql1 = "delete from 产品表 where 产品代码='"+cpid+"';";
				dbhelper.delete(sql1);
		}
		public ResultSet select1(String cpid) {
			
				String sql1 = "select *  from 产品表 where 产品代码='"+cpid+"';";
				ResultSet rs = dbhelper.select(sql1);
				return rs;
		}
		public ResultSet select(String cpid) {
		
				String sql1 = "select 名称,单位,生成地 from 产品表 where 产品代码='"+cpid+"';";	
				ResultSet rs = dbhelper.select(sql1);
				return rs;
		}
		public ResultSet select() {

				String sql1 = "select  * from 产品表;";
				ResultSet rs = dbhelper.select(sql1);
				return rs;
		}
	
	

}
