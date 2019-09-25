package cangku_manager_main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import cangku_manager_dbhelp.ConnectionFactory;

public class user_management extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    static Connection conn= ConnectionFactory.getInstance().mankeConnection();
	public static JComponent  userMmanagement(){
		JPanel jfrm;
		JPanel jpan,jpan1,jpan2,jpan3;
		JLabel a1,a2,a3,a4,a5,a6,a7;
		final JLabel aa1;
		final JLabel aa2;
		final JLabel aa3;
	    final JTextField b1;
		final JTextField b2;
		final JTextField b3;
		final JTextField b4;
		final JTextField b5;
		final JTextField b6;
		final JTextField b7;
	    JButton jb1,jb2,jb3,jb4;
		jfrm=new JPanel();
    	jfrm.setSize(600,600);
    	jfrm.setLocation(600, 300);
    	jfrm.setLayout(null);
    	
        jpan=new JPanel();
        jpan.setSize(600,600);
        jpan.setLayout(null);
        
        jpan1=new JPanel();
        jpan1.setSize(600,200);
        jpan1.setLayout(null);
        
        jpan2=new JPanel();
        jpan2.setSize(600,150);
        jpan2.setLocation(0, 200);
        jpan2.setLayout(null);
        
        jpan3=new JPanel();
        jpan3.setSize(600,200);
        jpan3.setLocation(0, 350);
        jpan3.setLayout(null);
        
        a1=new JLabel("用户ID：");
        a1.setBounds(100,40,100,30);
        
        b1=new JTextField(20);
        b1.setBounds(180,40,200,30);
        b1.setBackground(Color.WHITE);
        
        a2=new JLabel("用户密码：");
        a2.setBounds(100,80,100,30);
        
        b2=new JTextField(20);
        b2.setBounds(180,80,200,30);
        b2.setBackground(Color.WHITE);
        
        a3=new JLabel("用户姓名：");
        a3.setBounds(100,120,100,30);
        
        b3=new JTextField(20);
        b3.setBounds(180,120,200,30);
        b3.setBackground(Color.WHITE);
        
        jb1=new JButton("添加");
        jb1.setBounds(220,160,80,30);
        jb1.setBackground(Color.YELLOW);
        
        aa1=new JLabel();
        aa1.setBounds(400, 160, 100, 30);
        aa1.setForeground(Color.RED);
        
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String b_1=b1.getText();
            	String b_2=b2.getText();
            	String b_3=b3.getText();
        		Statement stmt=null;
        		ResultSet rs=null;
        		
        		try {
        			
        			String sql="insert into users values('"+b_1+"','"+b_2+"','"+b_3+"')";
        			String sql2="select uid from users where uid="+b_1;
        			stmt=conn.createStatement();
        			rs=stmt.executeQuery(sql2);		//查询数据
        			if(rs.next()){
        				aa1.setText("用户ID重复");
        			}
        			else{
        				stmt.executeUpdate(sql);	//操作数据
        				aa1.setText("操作成功");
        			}
        		}
        		catch (Exception e1) {
        			e1.printStackTrace();
        		}
            }
        });
        
        jpan1.add(a1);jpan1.add(a2);jpan1.add(a3);jpan1.add(b1);jpan1.add(b2);jpan1.add(b3);jpan1.add(jb1);jpan1.add(aa1);
        jpan1.setBorder(new TitledBorder("增加用户"));
        
        a4=new JLabel("用户ID：");
        a4.setBounds(100,40,100,30);
        
        b4=new JTextField(20);
        b4.setBounds(180,40,200,30);
        b4.setBackground(Color.WHITE);
        
        jb2=new JButton("删除");
        jb2.setBounds(220,90,80,30);
        jb2.setBackground(Color.YELLOW);
        
        aa2=new JLabel();
        aa2.setBounds(400, 90, 100, 30);
        aa2.setForeground(Color.RED);
        
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String b_4=b4.getText();
        		Statement stmt=null;
        		ResultSet rs=null;
        		
        		try {
        			
        			String sql="delete from users where uid="+b_4;
        			String sql2="select uid from users where uid="+b_4;
        			stmt=conn.createStatement();
        			rs=stmt.executeQuery(sql2);
        			if(rs.next()){
        				stmt.executeUpdate(sql);
        				aa2.setText("操作成功");
        			}
        			else{
        				aa2.setText("没有此用户ID");
        			}
        		}
        		catch (Exception e1) {
        			e1.printStackTrace();
        		}
            }
        });
        
        jpan2.add(a4);jpan2.add(b4);jpan2.add(jb2);jpan2.add(aa2);
        jpan2.setBorder(new TitledBorder("删除用户"));
        
        a5=new JLabel("要修改的ID：");
        a5.setBounds(100,40,100,30);
        
        b5=new JTextField(20);
        b5.setBounds(180,40,200,30);
        b5.setBackground(Color.WHITE);
        
        a6=new JLabel("新密码：");
        a6.setBounds(100,80,100,30);
        
        b6=new JTextField(20);
        b6.setBounds(180,80,200,30);
        b6.setBackground(Color.WHITE);
        
        a7=new JLabel("新姓名：");
        a7.setBounds(100,120,100,30);
        
        b7=new JTextField(20);
        b7.setBounds(180,120,200,30);
        b7.setBackground(Color.WHITE);
        
        jb3=new JButton("修改");
        jb3.setBounds(400,80,80,30);
        jb3.setBackground(Color.YELLOW);
        
        jb4=new JButton("修改");
        jb4.setBounds(400,120,80,30);
        jb4.setBackground(Color.YELLOW);
        
        aa3=new JLabel();
        aa3.setBounds(220, 160, 100, 30);
        aa3.setForeground(Color.RED);
        
        jb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String b_5=b5.getText();
            	String b_6=b6.getText();
        		Statement stmt=null;
        		ResultSet rs=null;
        		
        		try {
        			
        			String sql="update users set upassword="+b_6+" where uid="+b_5;
        			String sql2="select uid from users where uid="+b_5;
        			stmt=conn.createStatement();
        			rs=stmt.executeQuery(sql2);
        			if(rs.next()){
        				stmt.executeUpdate(sql);
        				aa3.setText("操作成功");
        			}
        			else{
        				aa3.setText("没有此用户ID");
        			}
        		}
        		catch (Exception e1) {
        			e1.printStackTrace();
        		}
            }
        });
        
        jb4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String b_5=b5.getText();
            	String b_7=b7.getText();
        		Statement stmt=null;
        		ResultSet rs=null;
        		
        		try {
        			
        			String sql="update users set uname="+b_7+" where uid="+b_5;
        			String sql2="select uid from users where uid="+b_5;
        			stmt=conn.createStatement();
        			rs=stmt.executeQuery(sql2);
        			if(rs.next()){
        				stmt.executeUpdate(sql);
        				aa3.setText("操作成功");
        			}
        			else{
        				aa3.setText("没有此用户ID");
        			}
        		}
        		catch (Exception e1) {
        			e1.printStackTrace();
        		}
            }
        });
        
        jpan3.add(a5);jpan3.add(a6);jpan3.add(a7);jpan3.add(b5);jpan3.add(b6);jpan3.add(b7);jpan3.add(jb3);jpan3.add(jb4);jpan3.add(aa3);
        jpan3.setBorder(new TitledBorder("修改用户"));
        
        jpan.add(jpan1);jfrm.add(jpan2);jfrm.add(jpan3);
        jfrm.add(jpan);
        //jfrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       // jfrm.setVisible(true);
        return jfrm;
	}
	
	
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		user_management um=new user_management();
//	}

}
