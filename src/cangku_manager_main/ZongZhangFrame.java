package cangku_manager_main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import cangku_manager_ck.ck_menager;
import cangku_manager_cp.cp_menager;
import cangku_manager_rk.rk_menager;
import cangku_menager_zzh.zzh_manager;


public class ZongZhangFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ZongZhangFrame() {
		denglu dl=new denglu();
		String[] QuanXianPanDuan = denglu.fn;
		dl.jfrm.dispose();
		JMenu jm_yhgl=null;
		JMenu jm_rkgl=null;
		JMenu jm_ckgl=null;
		JMenu jm_zzcx=null;
		JMenu jm_cpgl=null;
		String wel = "'&#32;'&#32;欢迎您，"+(String)denglu.uname;
		//String QuanXianPanDuan;
		this.setSize(800,800);
		this.setLocationRelativeTo(null);
		
		this.setTitle("库存系统管理界面"+wel);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JMenuBar jb = new JMenuBar();
		jm_rkgl = new JMenu("入库管理");
		jm_ckgl = new JMenu("出库管理");
		jm_yhgl = new JMenu("用户管理");
		jm_zzcx = new JMenu("总账管理");
		jm_cpgl = new JMenu("产品管理");
		
		jm_rkgl.setVisible(false);
		jm_ckgl.setVisible(false);
		jm_zzcx.setVisible(false);
		jm_yhgl.setVisible(false);
		jm_cpgl.setVisible(false);
		
		JMenuItem jmi1 = new JMenuItem("入库明细");
		JMenuItem jmi2 = new JMenuItem("增加入库单");
		JMenuItem jmi3 = new JMenuItem("查询删除入库单");
		JMenuItem jmi4 = new JMenuItem("查询修改入库单");
		JMenuItem jmi5 = new JMenuItem("出库明细");
		JMenuItem jmi6 = new JMenuItem("增加出库单");
		JMenuItem jmi7 = new JMenuItem("查询删除出库单");
		JMenuItem jmi8 = new JMenuItem("查询修改出库单");
		JMenuItem jmi9= new JMenuItem("产品明细");
		JMenuItem jmi10 = new JMenuItem("增加产品");
		JMenuItem jmi11 = new JMenuItem("查询修改产品");
		JMenuItem jmi12 = new JMenuItem("查询删除产品");
		JMenuItem jmi13 = new JMenuItem("查询明细账单");
		JMenuItem jmi14= new JMenuItem("查询总账");
		JMenuItem jmi_yhgl = new JMenuItem("用户管理");
		JMenuItem jmi_yhjsgl = new JMenuItem("用户角色管理");
		JMenuItem jmi_jsgngl = new JMenuItem("角色功能管理");
		
		
		/*背景图片
        JLabel jLabel=new JLabel(new ImageIcon("image/zhen.jpg"));
       jLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
       this.add(jLabel);
       */
       /*
       String path = "E:\\welcome\\1.jpg"; // 背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
       ImageIcon background = new ImageIcon(path); // 背景图片
       JLabel label = new JLabel(background); // 把背景图片显示在一个标签里面
       label.setBounds(0, 0, this.getWidth(), this.getHeight()); // 把标签的大小位置设置为图片刚好填充整个面板
       JPanel imagePanel = (JPanel) this.getContentPane(); // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
       imagePanel.setOpaque(false);
       this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景
       */
		
		  JLabel jLabel=new JLabel(new ImageIcon("image/zhen.jpg"));
	       jLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
	       jLabel.setBounds(0, 0, this.getWidth(), this.getHeight()); // 把标签的大小位置设置为图片刚好填充整个面板
	      // JPanel imagePanel = (JPanel) this.getContentPane(); // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
	     //  imagePanel.setOpaque(false);
	       JPanel imagePanel = (JPanel) this.getContentPane();
	       imagePanel.setOpaque(false);
	       this.getLayeredPane().add(jLabel, new Integer(Integer.MIN_VALUE)); // 把背景图片添加到分层窗格的最底层作为背景
		
		
		
		/*
		 * 权限判断
		 */
		for(int i=0;i<7;i++){
			
			if(QuanXianPanDuan[i].equals("入库单管理")) {
				
				jm_rkgl.setVisible(true);
			}else if(QuanXianPanDuan[i].equals("销售单管理")) {
				
				jm_ckgl.setVisible(true);
			}else if(QuanXianPanDuan[i].equals("总账查询")) {
				
				jm_zzcx.setVisible(true);
			}else if(QuanXianPanDuan[i].equals("产品管理")) {
				
				jm_cpgl.setVisible(true);
			}else if(QuanXianPanDuan[i].equals("用户管理")) {
				
				jm_yhgl.setVisible(true);
			}
		}
		
		jm_rkgl.add(jmi1);jm_rkgl.add(jmi2);jm_rkgl.add(jmi3);jm_rkgl.add(jmi4);
		jm_ckgl.add(jmi5);jm_ckgl.add(jmi6);jm_ckgl.add(jmi7);jm_ckgl.add(jmi8);
		jm_cpgl.add(jmi9);jm_cpgl.add(jmi10);jm_cpgl.add(jmi11);jm_cpgl.add(jmi12);
		jm_zzcx.add(jmi13);jm_zzcx.add(jmi14);jm_yhgl.add(jmi_jsgngl);jm_yhgl.add(jmi_yhjsgl);jm_yhgl.add(jmi_yhgl);
		
		jb.add(jm_rkgl);jb.add(jm_ckgl);jb.add(jm_cpgl);jb.add(jm_zzcx);jb.add(jm_yhgl);
		
		this.add(jb,BorderLayout.NORTH);
		
		jmi1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ZongZhangFrame zjm = new ZongZhangFrame();
				System.out.println("這是明細表");
				zjm.add(rk_menager.rk_mingxi_frame(),BorderLayout.CENTER);
				zjm.setVisible(true);
				dispose();
				
			}
		});
			
		jmi2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ZongZhangFrame zjm = new ZongZhangFrame();	
						System.out.println("這是增加入庫表");
						zjm.add(rk_menager.rk_add_frame(),BorderLayout.CENTER);
						zjm.setVisible(true);
						dispose();
						
					}
				});
		jmi3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ZongZhangFrame zjm = new ZongZhangFrame();
				System.out.println("這是入庫表刪除");
				
				zjm.add(rk_menager.rk_delete_frame(),BorderLayout.CENTER);
				zjm.setVisible(true);
				dispose();
			}
		});
		jmi4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ZongZhangFrame zjm = new ZongZhangFrame();
				System.out.println("這是入庫表修改");
				zjm.add(rk_menager.rk_update_frame(),BorderLayout.CENTER);
				zjm.setVisible(true);
				dispose();
			}
		});
		/*
		 * 出库界面
		 */
			jmi5.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							ZongZhangFrame zjm = new ZongZhangFrame();
							System.out.println("這是出庫明細表");
							zjm.add(ck_menager.ck_mingxi_frame(),BorderLayout.CENTER);
							zjm.setVisible(true);
							dispose();
						}
					});
			jmi6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ZongZhangFrame zjm = new ZongZhangFrame();
					System.out.println("這是增加出庫表");
					
					zjm.add(ck_menager.ck_add_frame(),BorderLayout.CENTER);
					zjm.setVisible(true);
					dispose();
				}
			});
			jmi7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ZongZhangFrame zjm = new ZongZhangFrame();
					System.out.println("這是刪除出庫表");
					
					zjm.add(ck_menager.ck_delete_frame(),BorderLayout.CENTER);
					zjm.setVisible(true);
					dispose();
				}
			});
			jmi8.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ZongZhangFrame zjm = new ZongZhangFrame();
					System.out.println("這是修改出庫表");
					
					zjm.add(ck_menager.ck_update_frame(),BorderLayout.CENTER);
					zjm.setVisible(true);
					dispose();
				}
			});
            jmi9.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ZongZhangFrame zjm = new ZongZhangFrame();
					System.out.println("這是产品明细表");
					
					zjm.add(cp_menager.cp_mingxi_frame(),BorderLayout.CENTER);
					zjm.setVisible(true);
					dispose();
				}
			});
              jmi10.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ZongZhangFrame zjm = new ZongZhangFrame();
					System.out.println("這是增加产品表");
					
					zjm.add(cp_menager.cp_add_frame(),BorderLayout.CENTER);
					zjm.setVisible(true);
					dispose();
				}
			});
              jmi11.addActionListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					ZongZhangFrame zjm = new ZongZhangFrame();
  					System.out.println("這是修改产品表");
  					
  					zjm.add(cp_menager.cp_update_frame(),BorderLayout.CENTER);
  					zjm.setVisible(true);
  					dispose();
  				}
  			});
              jmi12.addActionListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					ZongZhangFrame zjm = new ZongZhangFrame();
  					System.out.println("這是刪除产品表");
  					
  					zjm.add(cp_menager.cp_delete_frame(),BorderLayout.CENTER);
  					zjm.setVisible(true);
  					dispose();
  				}
  			});
              jmi13.addActionListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					ZongZhangFrame zjm = new ZongZhangFrame();
  					System.out.println("这是查询明细账单");
  					
  					zjm.add(zzh_manager.zzh_mingxi_frame(),BorderLayout.CENTER);
  					zjm.setVisible(true);
  					dispose();
  				}
  			});
              jmi14.addActionListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					ZongZhangFrame zjm = new ZongZhangFrame();
  					System.out.println("这是查询总账单");
  					
  					zjm.add(zzh_manager.zzh_zzh_frame(),BorderLayout.CENTER);
  					zjm.setVisible(true);
  					dispose();
  				}
  			});
              
//              jm_yhgl.addActionListener(new ActionListener() {
//      			public void actionPerformed(ActionEvent e) {
//      				
//      				ZongZhangFrame zjm = new ZongZhangFrame();
//      				zjm.setVisible(true);
//      			dispose();
//      				
//      			}
//      		});
              jmi_yhgl.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method System.out.println("12313213");
					System.out.println("用户管理");
					ZongZhangFrame zjm = new ZongZhangFrame();
  					zjm.add(user_management.userMmanagement(),BorderLayout.CENTER);
  					zjm.setVisible(true);
  					dispose();
					
				}
			});
             
      		jmi_yhjsgl.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("用户角色管理");
					ZongZhangFrame zjm = new ZongZhangFrame();
  					zjm.add(user_role_management.userRoleManagement(),BorderLayout.CENTER);
  					zjm.setVisible(true);
  					dispose();
				}
			});
      		jmi_jsgngl.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("角色功能管理");
					ZongZhangFrame zjm = new ZongZhangFrame();
  					zjm.add(role_function_management.roleFunctionManagement(),BorderLayout.CENTER);
  					zjm.setVisible(true);
  					dispose();
					
				}
			});
  	}
	
            
	}
	

