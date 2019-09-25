package cangku_manager_main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import cangku_manager_dbhelp.ConnectionFactory;

public class role_function_management extends JFrame {
	

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 static Connection conn= ConnectionFactory.getInstance().mankeConnection();
	public  static JComponent roleFunctionManagement(){
		JPanel jfrm;
    	JPanel jpan,jpan1,jpan2;
    	JLabel a1,a2,a3,a4;
		final JLabel aa1;
		final JLabel aa2;
        final JTextField b1;
		final JTextField b2;
		final JTextField b3;
		final JTextField b4;
        JButton jb1,jb2;
       
        
		jfrm = new JPanel();
    	jfrm.setSize(600,600);
    	
    	jfrm.setLayout(null);
    	
        jpan=new JPanel();
        jpan.setSize(600,600);
        jpan.setLayout(null);
        
        jpan1=new JPanel();
        jpan1.setSize(600,200);
        jpan1.setLayout(null);
        
        jpan2=new JPanel();
        jpan2.setSize(600,200);
        jpan2.setLocation(0, 200);
        jpan2.setLayout(null);
        
        a1=new JLabel("��ɫ���ƣ�");
        a1.setBounds(100,40,100,30);
        
        b1=new JTextField(20);
        b1.setBounds(180,40,200,30);
        b1.setBackground(Color.WHITE);
        
        a2=new JLabel("�������ƣ�");
        a2.setBounds(100,80,100,30);
        
        b2=new JTextField(20);
        b2.setBounds(180,80,200,30);
        b2.setBackground(Color.WHITE);
        
        jb1=new JButton("���");
        jb1.setBounds(220,130,80,30);
        jb1.setBackground(Color.YELLOW);
        
        aa1=new JLabel();
        aa1.setBounds(400, 130, 100, 30);
        aa1.setForeground(Color.RED);
        
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String b_1=b1.getText();
            	String b_2=b2.getText();
        		Statement stmt=null;
        		Connection conn= ConnectionFactory.getInstance().mankeConnection();
        		try {
        			String sql="insert into role_function values('"+b_1+"','"+b_2+"')";
        			stmt=conn.createStatement();
    				stmt.executeUpdate(sql);
    				aa1.setText("�����ɹ�");
        			stmt.close();
        			conn.close();
        		}
        		catch (Exception e1) {
        			e1.printStackTrace();
        			aa1.setText("����ʧ��");
        		}
            }
        });
        
        jpan1.add(a1);jpan1.add(a2);jpan1.add(b1);jpan1.add(b2);jpan1.add(jb1);jpan1.add(aa1);
        jpan1.setBorder(new TitledBorder("���ӽ�ɫ����"));
        
        
        a3=new JLabel("��ɫ���ƣ�");
        a3.setBounds(100,40,100,30);
        
        b3=new JTextField(20);
        b3.setBounds(180,40,200,30);
        b3.setBackground(Color.WHITE);
        
        a4=new JLabel("�������ƣ�");
        a4.setBounds(100,80,100,30);
        
        b4=new JTextField(20);
        b4.setBounds(180,80,200,30);
        b4.setBackground(Color.WHITE);
        
        jb2=new JButton("ɾ��");
        jb2.setBounds(220,130,80,30);
        jb2.setBackground(Color.YELLOW);
        
        aa2=new JLabel();
        aa2.setBounds(400, 130, 200, 30);
        aa2.setForeground(Color.RED);
        
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String b_3=b3.getText();
            	String b_4=b4.getText();
        		Statement stmt=null;
        		ResultSet rs1=null,rs2=null;
        		
        		try {
        			Connection conn= ConnectionFactory.getInstance().mankeConnection();
        			String sql1="select rname from role_function where rname='"+b_3+"'";
        			String sql2="select rname from role_function where rname='"+b_3+"' and fname='"+b_4+"'";
        			String sql3="delete from role_function where rname='"+b_3+"' and fname='"+b_4+"'";
        			stmt=conn.createStatement();
        			rs1=stmt.executeQuery(sql1);
        			
        			if(rs1.next()){
        				rs2=stmt.executeQuery(sql2);
        				if(rs2.next()){
        					stmt.executeUpdate(sql3);
            				aa2.setText("�����ɹ�");
        				}
        				else{
        					aa2.setText("����ʧ�ܣ��˽�ɫû�иù���");
        				}	
        			}
        			else{
        				aa2.setText("����ʧ�ܣ�û�д˽�ɫ");
        			}
        			stmt.close();
        			conn.close();
        		}
        		catch (Exception e1) {
        			e1.printStackTrace();
        			aa2.setText("����ʧ��");
        		}
            }
        });
        
        jpan2.add(a3);jpan2.add(a4);jpan2.add(b3);jpan2.add(b4);jpan2.add(jb2);jpan2.add(aa2);
        jpan2.setBorder(new TitledBorder("ɾ����ɫ����"));
        
        jpan.add(jpan1);jfrm.add(jpan2);
        jfrm.add(jpan);
        
        
        return jfrm;
	}

	

}
