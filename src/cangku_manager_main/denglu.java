package cangku_manager_main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import cangku_manager_dbhelp.ConnectionFactory;

public class denglu extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame jfrm;
	JPanel jpan;
    JButton jbLogin;//按钮
    JLabel a1,a2,a3,a4;//标签
    JTextField b;//文本框
    JPasswordField pw;//密码框
    static String id;
    static String pass;
    static String uname;
    static String[] fn={"","","","","","",""};
    static int ii=0;
    boolean panduan=true;
    static Connection conn= ConnectionFactory.getInstance().mankeConnection();
    
    Font f = new Font("宋体",Font.PLAIN,16); 
    
    
    @SuppressWarnings("null")
	public static void sql() {
		
		Statement stmt=null;
		ResultSet rs=null;
		try {
			String sql="select fname from user_role,role_function where user_role.rname=role_function.rname and uid="+id;
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				String fname=rs.getString("fname");
				fn[ii]=fname;
				ii++;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
//		finally{
//			try{
//				if(rs!=null) rs.close();
//				if(stmt!=null) stmt.close();
//				//if(conn!=null) conn.close();
//			}
//			catch(Exception e){
//				e.printStackTrace();
//			}
//		}
	}
    
    public denglu(){
    	jfrm=new JFrame("登录");
    	jfrm.setSize(600,400);
    	jfrm.setLocation(600, 300);
    	jfrm.setLayout(null);
    	
        jpan=new JPanel();
        jpan.setSize(600,400);
        jpan.setLayout(null);
          
        a1=new JLabel("登录");


        a1.setFont(f);
        a1.setBounds(250,10,100,100);
        a1.setForeground(Color.WHITE);
        
        a2=new JLabel("用户ID：");
        a2.setBounds(100,85,100,60);
        a2.setFont(f);
        a2.setForeground(Color.WHITE);
        
        b=new JTextField(20);
        b.setBounds(180,100,200,30);
        b.setBackground(Color.WHITE);
        
        a3=new JLabel("密    码：");
        a3.setBounds(100,145,100,60);
        a3.setFont(f);
        a3.setForeground(Color.WHITE);
        
        pw=new JPasswordField(20);
        pw.setBounds(180,160,200,30);
        pw.setBackground(Color.WHITE);
        
        jbLogin=new JButton("登录");  
        jbLogin.setBounds(220,250,80,40);  
        jbLogin.setBackground(Color.YELLOW);  
        
        a4=new JLabel("");
        a4.setBounds(220, 300, 150, 40);
        a4.setForeground(Color.RED);
        
        jbLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	id=b.getText();
            	pass=new String(pw.getPassword());
            	
            	
            	
        		Statement stmt=null;
        		ResultSet rs=null;
        		
        		try {
        			
        			String sql="select uid,upassword,uname from users where uid="+id;
        			stmt=conn.createStatement();
        			rs=stmt.executeQuery(sql);
        			while(rs.next()){
        				panduan=false;
        				String upassword=rs.getString("upassword");
        				uname=rs.getString("uname");
//        				System.out.println(id+" "+pass+" "+upassword);
        				if(upassword.equals(pass)){
        					a4.setText("登录成功");
        					sql();
        					ZongZhangFrame ajm=new ZongZhangFrame();
        					ajm.setVisible(true);
        					jfrm.dispose();
        				}
        				else{
        					a4.setText("用户ID或密码错误");
        				}
        				
        			}
        			if(panduan){
        				a4.setText("用户ID不存在");
        			}
        			panduan=true;
        		}
        		catch (Exception e1) {
        			e1.printStackTrace();
        		}
            }
        });
        jpan.add(a1);
        jpan.add(a2);
        jpan.add(b);
        jpan.add(a3);
        jpan.add(pw);
        jpan.add(jbLogin);
        jpan.add(a4);
        jfrm.add(jpan);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*背景图片*/
        JLabel jLabel=new JLabel(new ImageIcon("image/login.jpg"));
       jLabel.setBounds(0, 0, jpan.getWidth(), jpan.getHeight());
       jpan.add(jLabel);

        


    }
    
    public static void main(String [] args){
    	denglu dl=new denglu();
    	dl.jfrm.setVisible(true);;
    }
 }