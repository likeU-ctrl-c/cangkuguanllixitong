package cangku_manager_cp;

import java.sql.*;
import cangku_manager_dbhelp.DBHelper;

public class cp_model {
		DBHelper dbhelper = new DBHelper();
		
		public void insert(String cpid,String ming ,String dan,String sheng) {
			
				String sql = "INSERT INTO ��Ʒ��   "+
				"VALUES('"+cpid+"','"+ming+"','"+dan+"','"+sheng+"');";
				System.out.println("sql="+sql);
				dbhelper.insert(sql);
		}
		public void update(String cpid,String ming ,String dan,String sheng) {
			
				String sql2 = "update ��Ʒ�� set ����='"+ming+"', ��λ='"+dan+"' ,���ɵ�='"+sheng+"'where ��Ʒ����='"+cpid+"';";
				dbhelper.update(sql2);	
		}

		public void delete(String cpid) {
			
				String sql1 = "delete from ��Ʒ�� where ��Ʒ����='"+cpid+"';";
				dbhelper.delete(sql1);
		}
		public ResultSet select1(String cpid) {
			
				String sql1 = "select *  from ��Ʒ�� where ��Ʒ����='"+cpid+"';";
				ResultSet rs = dbhelper.select(sql1);
				return rs;
		}
		public ResultSet select(String cpid) {
		
				String sql1 = "select ����,��λ,���ɵ� from ��Ʒ�� where ��Ʒ����='"+cpid+"';";	
				ResultSet rs = dbhelper.select(sql1);
				return rs;
		}
		public ResultSet select() {

				String sql1 = "select  * from ��Ʒ��;";
				ResultSet rs = dbhelper.select(sql1);
				return rs;
		}
	
	

}
