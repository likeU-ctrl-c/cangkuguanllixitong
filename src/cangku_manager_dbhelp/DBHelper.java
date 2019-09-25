package cangku_manager_dbhelp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	Connection conn= ConnectionFactory.getInstance().mankeConnection();
	Statement statement=null;
	/*
	 * 向数据库里增加数据
	 */
	public DBHelper() {
		try {
			 statement=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insert(String sql1,String sql2) {
		try {
			
			int rs=statement.executeUpdate(sql1);
			 rs+=statement.executeUpdate(sql2);
			 System.out.println("向数据库里插入了"+rs+"条查询");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	/*
	 * 向数据库里增加数据
	 */
	public void insert(String sql1) {
		try {
			int rs=statement.executeUpdate(sql1);
			System.out.println("向数据库中加入了"+rs+"条数据");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	/*
	 * 向数据库里更新数据
	 */
	public void update(String sql) {
		try {
			 int rs=statement.executeUpdate(sql);
			System.out.println("向数据库里更新了"+rs+"条数据");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	/*
	 * 向数据库里删除数据
	 */
	public void delete(String sql1,String sql2) {
		
		try {
			int rs=statement.executeUpdate(sql1);
			 rs+=statement.executeUpdate(sql2);
			 System.out.println("向数据库中删除了"+rs+"条数据");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	public void delete(String sql1) {
			
			try {
				int rs=statement.executeUpdate(sql1);
				 System.out.println("向数据库中删除了"+rs+"条数据");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
	/*
	 * 从数据库里选取数据
	 */
	public ResultSet select(String sql1) {
		ResultSet rs=null;
		try {
			 rs=statement.executeQuery(sql1);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return rs;
	}
	
}
