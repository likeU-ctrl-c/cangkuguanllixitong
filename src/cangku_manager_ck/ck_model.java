package cangku_manager_ck;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cangku_manager_dbhelp.DBHelper;

public class ck_model {
	DBHelper dbhelper = new DBHelper();
	public void insert(String inid,String inname,String intime,String cpid,int innum) {
		
			String sql1 = "INSERT INTO ckdan(outid,outname,outtime)"+
			"VALUES('"+inid+"','"+inname+"','"+intime+"')";
			String sql2 = "INSERT INTO ckmingxi(cpid,outnum,outid)"+
					"VALUES('"+cpid+"','"+innum+"','"+inid+"')";
			dbhelper.insert(sql1, sql2);
	}
	public void insert(String inid,String inname,String cpid,int innum) {
		
			String sql2 = "INSERT INTO ckmingxi(outid,outnum,outid)"+
					"VALUES('"+cpid+"','"+innum+"','"+inid+"')";
			dbhelper.insert(sql2);
	}
	public void update(String inid,String cpid,int innum) {
		
			String sql2 = "update ckmingxi set outnum='"+innum+"'where outid='"+inid+"'and cpid='"+cpid+"';";
			dbhelper.update(sql2);	
	}
	public void delete(String inid,String cpid) {
		
			
			String sql2 = "delete from ckmingxi where outid='"+inid+"'and cpid='"+cpid+"';";
			dbhelper.delete(sql2);
			
	}
	public void delete(String inid) {
		
			String sql1 = "delete from ckdan where outid='"+inid+"';";
			String sql2 = "delete from ckmingxi where outid='"+inid+"';";
			dbhelper.delete(sql1, sql2);
	}
	public ResultSet select(String inid,String cpid) {
		
			String sql1 = "select cpid,outtime,outnum,outtime from ckdan,ckmingxi where outid='"+inid+"'and cpid='"+cpid+"';";
			ResultSet rs = dbhelper.select(sql1);
			return rs;
	}
	public ResultSet select(String inid) {
	
			String sql1 = "select cpid,outtime,outnum from ckdan,ckmingxi where ckdan.outid=ckmingxi.outid and  ckmingxi.outid='"+inid+"';";	
			ResultSet rs = dbhelper.select(sql1);
			return rs;
	}
	public ResultSet select() {

			String sql1 = "select ckdan.outid,outtime,cpid,outnum from ckdan,ckmingxi WHERE ckdan.outid=ckmingxi.outid order by outid;";
			ResultSet rs = dbhelper.select(sql1);
			return rs;
	}
	public String selectmax() {
		String inid="";
			String sql1 = "select max(distinct outid) from ckdan  ;";
			ResultSet rs = dbhelper.select(sql1);
			try {
				rs.next();
				inid = rs.getString("max(distinct outid)");
			} catch (SQLException e) {
				System.out.println("选择最大订单号的时候出错");
				e.printStackTrace();
			}
			 
		return inid;
	}
	public String getInid() {
		String inid;
		String data2 = null;
		int i=0;
		Format count=new DecimalFormat("000");
		 Date currentTime = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		   String dateString = formatter.format(currentTime);
		String inidmax=selectmax();
		
		//判断data
		System.out.println(inidmax);
		if(inidmax==null) {	
			i=1;
		}else {
			data2=inidmax.substring(2,10);
			 
			String count2=inidmax.substring(10,13);

			i=Integer.parseInt(count2);
			if(data2.equals(dateString) ) i+=1;else i=1;
		}
		System.out.println(data2);
		
		
	
		String c = count.format(i);
		 
		inid= "ck"+dateString+c;
		
		return inid;
	}
	public String getIntime() {
		 Date currentTime = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		   String dateString = formatter.format(currentTime);
		return dateString;
	}
	public ArrayList<String> getCPid()  {
		String sql1 = "select * from 产品表  ;";
		ResultSet rs = dbhelper.select(sql1);
		ArrayList<String> cpid_list=new ArrayList<>();
		try {
			while (rs.next()) {
			 cpid_list.add((String)rs.getString("产品代码"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cpid_list;
	}
	public int get_jieyu_num( String cpid) {
		/*
		String sql1 = "select sum(入库量)-sum(出库量) from v_mingxi where 产品代码='"+ cpid +"';";
		ResultSet rs = dbhelper.select(sql1);
		int num = 0 ;
			try {
				if(rs.next()) {
					num=rs.getInt("");
				}else {
					System.out.println("库存里没有！");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
		}
		return num;
		
	}
	*/
		
		String sql1 = "select sum(innum) from rkmingxi where cpid= '"+ cpid +"';";
		ResultSet inrs = dbhelper.select(sql1);
		int num = 0 ;
		int innum=0;
		int cknum=0;
			try {
				if(inrs.next()) {
					innum=inrs.getInt("sum(innum)");
				}else {
					System.out.println("入库  库存里没有！");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
		}
			
			String sql2 = "select sum(outnum) from ckmingxi where cpid= '"+ cpid +"';";
			ResultSet outrs = dbhelper.select(sql2);
				try {
					if(outrs.next()) {
						cknum=outrs.getInt("sum(outnum)");
					}else {
						System.out.println("出库 库存里没有！");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();	
			}
		num=innum-cknum;
		return num;
	}	

}
