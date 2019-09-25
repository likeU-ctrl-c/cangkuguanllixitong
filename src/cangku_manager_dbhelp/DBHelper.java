package cangku_manager_dbhelp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	Connection conn= ConnectionFactory.getInstance().mankeConnection();
	Statement statement=null;
	/*
	 * �����ݿ�����������
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
			 System.out.println("�����ݿ��������"+rs+"����ѯ");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	/*
	 * �����ݿ�����������
	 */
	public void insert(String sql1) {
		try {
			int rs=statement.executeUpdate(sql1);
			System.out.println("�����ݿ��м�����"+rs+"������");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	/*
	 * �����ݿ����������
	 */
	public void update(String sql) {
		try {
			 int rs=statement.executeUpdate(sql);
			System.out.println("�����ݿ��������"+rs+"������");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	/*
	 * �����ݿ���ɾ������
	 */
	public void delete(String sql1,String sql2) {
		
		try {
			int rs=statement.executeUpdate(sql1);
			 rs+=statement.executeUpdate(sql2);
			 System.out.println("�����ݿ���ɾ����"+rs+"������");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	public void delete(String sql1) {
			
			try {
				int rs=statement.executeUpdate(sql1);
				 System.out.println("�����ݿ���ɾ����"+rs+"������");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
	/*
	 * �����ݿ���ѡȡ����
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
