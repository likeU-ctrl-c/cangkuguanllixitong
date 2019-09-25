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
		String wel = "'&#32;'&#32;��ӭ����"+(String)denglu.uname;
		//String QuanXianPanDuan;
		this.setSize(800,800);
		this.setLocationRelativeTo(null);
		
		this.setTitle("���ϵͳ�������"+wel);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JMenuBar jb = new JMenuBar();
		jm_rkgl = new JMenu("������");
		jm_ckgl = new JMenu("�������");
		jm_yhgl = new JMenu("�û�����");
		jm_zzcx = new JMenu("���˹���");
		jm_cpgl = new JMenu("��Ʒ����");
		
		jm_rkgl.setVisible(false);
		jm_ckgl.setVisible(false);
		jm_zzcx.setVisible(false);
		jm_yhgl.setVisible(false);
		jm_cpgl.setVisible(false);
		
		JMenuItem jmi1 = new JMenuItem("�����ϸ");
		JMenuItem jmi2 = new JMenuItem("������ⵥ");
		JMenuItem jmi3 = new JMenuItem("��ѯɾ����ⵥ");
		JMenuItem jmi4 = new JMenuItem("��ѯ�޸���ⵥ");
		JMenuItem jmi5 = new JMenuItem("������ϸ");
		JMenuItem jmi6 = new JMenuItem("���ӳ��ⵥ");
		JMenuItem jmi7 = new JMenuItem("��ѯɾ�����ⵥ");
		JMenuItem jmi8 = new JMenuItem("��ѯ�޸ĳ��ⵥ");
		JMenuItem jmi9= new JMenuItem("��Ʒ��ϸ");
		JMenuItem jmi10 = new JMenuItem("���Ӳ�Ʒ");
		JMenuItem jmi11 = new JMenuItem("��ѯ�޸Ĳ�Ʒ");
		JMenuItem jmi12 = new JMenuItem("��ѯɾ����Ʒ");
		JMenuItem jmi13 = new JMenuItem("��ѯ��ϸ�˵�");
		JMenuItem jmi14= new JMenuItem("��ѯ����");
		JMenuItem jmi_yhgl = new JMenuItem("�û�����");
		JMenuItem jmi_yhjsgl = new JMenuItem("�û���ɫ����");
		JMenuItem jmi_jsgngl = new JMenuItem("��ɫ���ܹ���");
		
		
		/*����ͼƬ
        JLabel jLabel=new JLabel(new ImageIcon("image/zhen.jpg"));
       jLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
       this.add(jLabel);
       */
       /*
       String path = "E:\\welcome\\1.jpg"; // ����ͼƬ��·���������·�����߾���·��������ͼƬ����"java��Ŀ��"���ļ��£�
       ImageIcon background = new ImageIcon(path); // ����ͼƬ
       JLabel label = new JLabel(background); // �ѱ���ͼƬ��ʾ��һ����ǩ����
       label.setBounds(0, 0, this.getWidth(), this.getHeight()); // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
       JPanel imagePanel = (JPanel) this.getContentPane(); // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
       imagePanel.setOpaque(false);
       this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
       */
		
		  JLabel jLabel=new JLabel(new ImageIcon("image/zhen.jpg"));
	       jLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
	       jLabel.setBounds(0, 0, this.getWidth(), this.getHeight()); // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
	      // JPanel imagePanel = (JPanel) this.getContentPane(); // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
	     //  imagePanel.setOpaque(false);
	       JPanel imagePanel = (JPanel) this.getContentPane();
	       imagePanel.setOpaque(false);
	       this.getLayeredPane().add(jLabel, new Integer(Integer.MIN_VALUE)); // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		
		
		
		/*
		 * Ȩ���ж�
		 */
		for(int i=0;i<7;i++){
			
			if(QuanXianPanDuan[i].equals("��ⵥ����")) {
				
				jm_rkgl.setVisible(true);
			}else if(QuanXianPanDuan[i].equals("���۵�����")) {
				
				jm_ckgl.setVisible(true);
			}else if(QuanXianPanDuan[i].equals("���˲�ѯ")) {
				
				jm_zzcx.setVisible(true);
			}else if(QuanXianPanDuan[i].equals("��Ʒ����")) {
				
				jm_cpgl.setVisible(true);
			}else if(QuanXianPanDuan[i].equals("�û�����")) {
				
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
				System.out.println("�@��������");
				zjm.add(rk_menager.rk_mingxi_frame(),BorderLayout.CENTER);
				zjm.setVisible(true);
				dispose();
				
			}
		});
			
		jmi2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ZongZhangFrame zjm = new ZongZhangFrame();	
						System.out.println("�@����������");
						zjm.add(rk_menager.rk_add_frame(),BorderLayout.CENTER);
						zjm.setVisible(true);
						dispose();
						
					}
				});
		jmi3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ZongZhangFrame zjm = new ZongZhangFrame();
				System.out.println("�@������h��");
				
				zjm.add(rk_menager.rk_delete_frame(),BorderLayout.CENTER);
				zjm.setVisible(true);
				dispose();
			}
		});
		jmi4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ZongZhangFrame zjm = new ZongZhangFrame();
				System.out.println("�@�������޸�");
				zjm.add(rk_menager.rk_update_frame(),BorderLayout.CENTER);
				zjm.setVisible(true);
				dispose();
			}
		});
		/*
		 * �������
		 */
			jmi5.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							ZongZhangFrame zjm = new ZongZhangFrame();
							System.out.println("�@�ǳ���������");
							zjm.add(ck_menager.ck_mingxi_frame(),BorderLayout.CENTER);
							zjm.setVisible(true);
							dispose();
						}
					});
			jmi6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ZongZhangFrame zjm = new ZongZhangFrame();
					System.out.println("�@�����ӳ����");
					
					zjm.add(ck_menager.ck_add_frame(),BorderLayout.CENTER);
					zjm.setVisible(true);
					dispose();
				}
			});
			jmi7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ZongZhangFrame zjm = new ZongZhangFrame();
					System.out.println("�@�Ǆh�������");
					
					zjm.add(ck_menager.ck_delete_frame(),BorderLayout.CENTER);
					zjm.setVisible(true);
					dispose();
				}
			});
			jmi8.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ZongZhangFrame zjm = new ZongZhangFrame();
					System.out.println("�@���޸ĳ����");
					
					zjm.add(ck_menager.ck_update_frame(),BorderLayout.CENTER);
					zjm.setVisible(true);
					dispose();
				}
			});
            jmi9.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ZongZhangFrame zjm = new ZongZhangFrame();
					System.out.println("�@�ǲ�Ʒ��ϸ��");
					
					zjm.add(cp_menager.cp_mingxi_frame(),BorderLayout.CENTER);
					zjm.setVisible(true);
					dispose();
				}
			});
              jmi10.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ZongZhangFrame zjm = new ZongZhangFrame();
					System.out.println("�@�����Ӳ�Ʒ��");
					
					zjm.add(cp_menager.cp_add_frame(),BorderLayout.CENTER);
					zjm.setVisible(true);
					dispose();
				}
			});
              jmi11.addActionListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					ZongZhangFrame zjm = new ZongZhangFrame();
  					System.out.println("�@���޸Ĳ�Ʒ��");
  					
  					zjm.add(cp_menager.cp_update_frame(),BorderLayout.CENTER);
  					zjm.setVisible(true);
  					dispose();
  				}
  			});
              jmi12.addActionListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					ZongZhangFrame zjm = new ZongZhangFrame();
  					System.out.println("�@�Ǆh����Ʒ��");
  					
  					zjm.add(cp_menager.cp_delete_frame(),BorderLayout.CENTER);
  					zjm.setVisible(true);
  					dispose();
  				}
  			});
              jmi13.addActionListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					ZongZhangFrame zjm = new ZongZhangFrame();
  					System.out.println("���ǲ�ѯ��ϸ�˵�");
  					
  					zjm.add(zzh_manager.zzh_mingxi_frame(),BorderLayout.CENTER);
  					zjm.setVisible(true);
  					dispose();
  				}
  			});
              jmi14.addActionListener(new ActionListener() {
  				
  				@Override
  				public void actionPerformed(ActionEvent e) {
  					ZongZhangFrame zjm = new ZongZhangFrame();
  					System.out.println("���ǲ�ѯ���˵�");
  					
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
					System.out.println("�û�����");
					ZongZhangFrame zjm = new ZongZhangFrame();
  					zjm.add(user_management.userMmanagement(),BorderLayout.CENTER);
  					zjm.setVisible(true);
  					dispose();
					
				}
			});
             
      		jmi_yhjsgl.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("�û���ɫ����");
					ZongZhangFrame zjm = new ZongZhangFrame();
  					zjm.add(user_role_management.userRoleManagement(),BorderLayout.CENTER);
  					zjm.setVisible(true);
  					dispose();
				}
			});
      		jmi_jsgngl.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("��ɫ���ܹ���");
					ZongZhangFrame zjm = new ZongZhangFrame();
  					zjm.add(role_function_management.roleFunctionManagement(),BorderLayout.CENTER);
  					zjm.setVisible(true);
  					dispose();
					
				}
			});
  	}
	
            
	}
	

