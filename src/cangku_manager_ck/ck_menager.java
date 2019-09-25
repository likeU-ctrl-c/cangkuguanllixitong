package cangku_manager_ck;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ck_menager {
	static ck_model ckm = new ck_model();
	static int flag =0;
	// 明细页面
	public static JComponent ck_mingxi_frame() {

		JButton b1 = new JButton("刷新");
		JPanel jp1 = new JPanel(new BorderLayout());
		JPanel jp2 = new JPanel(new FlowLayout());
		JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel label1 = new JLabel("出库明细表 ");
		jp2.add(label1);
		String[] columnNames = { "出库编号", "出库时间", "产品代码", "出库量" };
		final DefaultTableModel Model = new DefaultTableModel(columnNames, 0);
		JTable jta = new JTable(Model) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				return false;
			}// 表格不允许被被编辑
		};
		jta.setModel(Model);
		int row = Model.getRowCount() - 1;
		if (row != -1) {
			for (int i = row; i >= 0; i--) {
				Model.removeRow(i);// 删除Jtable中所有的行
			}
			Model.setRowCount(0);// 将JTable中的行数设为0；
		}
		JScrollPane jsp = new JScrollPane();
		jsp.setViewportView(jta);
		jta.setEnabled(false);
		jp3.add(b1);
		/*
		 * 是数据居中对齐
		 */
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jta.setDefaultRenderer(Object.class, r);
		
		
		
		/***
		 * 数据打开直接显示
		 * 
		 * 
		 */
		
		String inid;
		String intime;
		String cpid;
		int innum = 0;
		ResultSet rs = ckm.select();

		String[] data = new String[4];
		try {
			while (rs.next()) {

				inid = rs.getString("outid");
				data[0] = inid;
				intime = rs.getString("outtime");
				data[1] = intime;
				cpid = rs.getString("cpid");
				data[2] = cpid;
				innum = rs.getInt("outnum");
				data[3] = innum + "";

				Model.addRow(data);
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		
		
		/***
		 * 点击按钮事件
		 */	
		
		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int row = Model.getRowCount() - 1;
				if (row != -1) {
					for (int i = row; i >= 0; i--) {
						Model.removeRow(i);// 删除Jtable中所有的行
					}
					Model.setRowCount(0);// 将JTable中的行数设为0；
				}

				String inid;
				String intime;
				String cpid;
				int innum = 0;
				ResultSet rs = ckm.select();

				String[] data = new String[4];
				try {
					while (rs.next()) {

						inid = rs.getString("outid");
						data[0] = inid;
						intime = rs.getString("outtime");
						data[1] = intime;
						cpid = rs.getString("cpid");
						data[2] = cpid;
						innum = rs.getInt("outnum");
						data[3] = innum + "";

						Model.addRow(data);
					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});

		jp1.add(jp2, BorderLayout.NORTH);
		jp1.add(jsp, BorderLayout.CENTER);
		jp1.add(jp3, BorderLayout.SOUTH);

		return jp1;
	}

	// 增加方法
	public static JComponent ck_add_frame() {

		JButton b1 = new JButton("添加");
		JButton b2 = new JButton("下一个");
		JButton b3 = new JButton("完成");
		final JPanel jp1 = new JPanel(new BorderLayout());
		final JPanel jp2 = new JPanel(new GridLayout(2, 1));
		JPanel jp3 = new JPanel(new GridLayout(4, 1));
		JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JPanel jp6 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JPanel jp7 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JPanel jp8 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JPanel jp9 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		// jp7.add(b1);
		jp7.add(b2);
		jp7.add(b3);
		final JTextField jtf1 = new JTextField(15);
		final JTextField jtf2 = new JTextField(15);
		final JTextField jtf3 = new JTextField("李华", 15);
		final JTextField jtf4 = new JTextField(15);
		final JTextField jtf5 = new JTextField(15);
		jtf1.setText(ckm.getInid());
		jtf2.setText(ckm.getIntime());
		jtf1.setEditable(false);
		jtf2.setEditable(false);

		JLabel label1 = new JLabel("新建出库单");
		JLabel label2 = new JLabel(" 编   号  ");
		JLabel label3 = new JLabel("出库时间");
		JLabel label4 = new JLabel("操作人：");
		JLabel label5 = new JLabel("产品代码");
		JLabel label6 = new JLabel("出  库  量");
		jp8.add(label5);
		jp8.add(jtf4);
		jp9.add(label6);
		jp9.add(jtf5);
		jp9.add(b1);
		final String[] columnNames = { "产品代码", "出库量" };

		jp4.add(label1);
		jp5.add(label2);
		jp5.add(jtf1, label2);
		jp5.add(label4, label2);
		jp5.add(jtf3, label2);
		jp6.add(label3);
		jp6.add(jtf2);

		jp3.add(jp4);
		jp3.add(jp5);
		jp3.add(jp6);
		jp3.add(jp8);
		jp3.add(jp9);
		jp2.add(jp3);

		jp1.add(jp4, BorderLayout.NORTH);
		jp1.add(jp2, BorderLayout.CENTER);
		jp1.add(jp7, BorderLayout.SOUTH);

		final DefaultTableModel Model = new DefaultTableModel(columnNames, 0);
		JTable jta = new JTable(Model) ;
		jta.setModel(Model);
		int row = Model.getRowCount() - 1;
		if (row != -1) {
			for (int i = row; i >= 0; i--) {
				Model.removeRow(i);// 删除Jtable中所有的行
			}
			Model.setRowCount(0);// 将JTable中的行数设为0；
		}
		JScrollPane jsp = new JScrollPane();
		jsp.setViewportView(jta);

		jp2.add(jsp);
		/*
		 * 使数据居中对齐
		 */
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jta.setDefaultRenderer(Object.class, r);
		// 按钮监听--往jtable中添加数据
		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("往jtable中添加数据");
				String[] count = new String[2];
				
				boolean biaozhi = true;
				if (jtf4.getText().isEmpty() || jtf5.getText().isEmpty()) {
					biaozhi = false;
					JOptionPane.showMessageDialog(jp1, "不可增加空产品", "错误", JOptionPane.WARNING_MESSAGE);
				} else {
					int n = Model.getRowCount();
					String old = null;
					ArrayList<String> cpid_list=ckm.getCPid();
					int cp_exit=0;
					int size = cpid_list.size();
					for(int i =0;i<size;i++) {
						
						if(jtf4.getText().equals(cpid_list.get(i))) {
							cp_exit=1;
						}
						
					}
					if(cp_exit==0) {
						biaozhi = false;
						JOptionPane.showMessageDialog(jp1, "没有此产品！不可添加", "错误", JOptionPane.WARNING_MESSAGE);
					}else {
							System.out.println((String)jtf4.getText());
							int sheng_yu_shu=ckm.get_jieyu_num((String)jtf4.getText());
							for (int i = 0; i < n; i++) {
								old = (String) Model.getValueAt(i, 0);
								if (old.equals(jtf4.getText())) {
									JOptionPane.showMessageDialog(jp1, "产品输入重复", "错误", JOptionPane.WARNING_MESSAGE);
									biaozhi = false;
									break;
								}
							}
							
								int xinzengshuliang = Integer.parseInt(jtf5.getText());
								System.out.println(xinzengshuliang);
								System.out.println(sheng_yu_shu);
								String tixing_cuowu = jtf4.getText()+"产品数量不足，库存还剩"+sheng_yu_shu+"!";
								if(xinzengshuliang>sheng_yu_shu) {
									JOptionPane.showMessageDialog(jp1,tixing_cuowu , "错误", JOptionPane.WARNING_MESSAGE);
									biaozhi = false;
								}
							}
							if (biaozhi) {
								count[0] = jtf4.getText();
								count[1] = jtf5.getText();
								Model.addRow(count);
								}
							
						}
						
						jtf4.setText("");
						jtf5.setText("");
						
					}
	
		});
		b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int row = Model.getRowCount() - 1;
				if(row == -1) {
					//flag=0;
				}else {
									
					if(flag==0) {
					System.out.println("正在往数据库添加数据");
					int n = Model.getRowCount();
	
					for (int i = 0; i < n; i++) {
						if (i + 1 == 1) {
							String cpi = (String)Model.getValueAt(i, 0);
							String numi = (String) Model.getValueAt(i, 1);
							if(cpi.isEmpty()||numi.isEmpty()) {
								
							}else {
								ckm.insert(jtf1.getText(), jtf3.getText(), jtf2.getText(), cpi,
										Integer.parseInt(numi));
							}
							
						} else {
							String cpi = (String)Model.getValueAt(i, 0);
							String numi = (String) Model.getValueAt(i, 1);
							if(cpi.isEmpty()||numi.isEmpty()) {
								
							}else {
								ckm.insert(jtf1.getText(), jtf3.getText(), cpi,
										Integer.parseInt(numi));
							}
							
						}
	
					}
					JOptionPane.showMessageDialog(jp1, "添加已完成", "提醒", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("添加数据成功");
					flag+=1;
				}else if(flag!=0) {
					JOptionPane.showMessageDialog(jp1, "不要重复点击完成", "警告", JOptionPane.WARNING_MESSAGE);
					
				}
			}
			}
		});
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				flag=0;
				jtf1.setText(ckm.getInid());
				jtf2.setText(ckm.getIntime());
				int row = Model.getRowCount() - 1;
				if (row != -1) {
					for (int i = row; i >= 0; i--) {
						Model.removeRow(i);// 删除Jtable中所有的行
					}
					Model.setRowCount(0);// 将JTable中的行数设为0；
				}
				System.out.println("出库单更新完毕");
			}
		});

		return jp1;
	}

	// 修改数据
	public static JComponent ck_update_frame() {
		
		/***
		 * 界面设计
		 */
		JButton b1 = new JButton("查询");
		JButton b2 = new JButton("取消");
		JButton b3 = new JButton("完成");
		JButton b_zenghang = new JButton("增加一行");
		JButton b_delete_empty = new JButton("删除空行");
		final JPanel jp1 = new JPanel(new BorderLayout());
		JPanel jp2 = new JPanel(new GridLayout(2, 1));
		JPanel jp3 = new JPanel(new GridLayout(2, 1));
		JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JPanel jp6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jp_xinzeng = new JPanel(new FlowLayout(FlowLayout.CENTER,50,30));
		jp_xinzeng.add(b_delete_empty);jp_xinzeng.add(b_zenghang);
		final JTextField jtf1 = new JTextField(15);
		final JTextField jtf2 = new JTextField(15);

		jtf2.setEditable(false);

		JLabel label1 = new JLabel("更改出库单 ");
		JLabel label2 = new JLabel(" 编   号  ");
		JLabel label3 = new JLabel("出库时间");

		String[] columnNames = { "产品代码", "出库量" };
		final DefaultTableModel Model = new DefaultTableModel(columnNames, 0);
		JTable jta = new JTable(Model);
		jta.setModel(Model);
		int row = Model.getRowCount() - 1;
		if (row != -1) {
			for (int i = row; i >= 0; i--) {
				Model.removeRow(i);// 删除Jtable中所有的行
			}
			Model.setRowCount(0);// 将JTable中的行数设为0；
		}
		JScrollPane jsp = new JScrollPane();
		jsp.setViewportView(jta);

		/*
		 * 使数据居中对齐
		 */
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jta.setDefaultRenderer(Object.class, r);

		/*
		 * 容器添加
		 */
		jp6.add(label1);
		jp4.add(label2);
		jp4.add(jtf1);
		jp4.add(b1);
		jp5.add(label3);
		jp5.add(jtf2);
		jp5.add(b2);
		jp5.add(b3);
		jp3.add(jp4);
		jp3.add(jp5);
		jp2.add(jp3);
		jp2.add(jsp);
		jp1.add(jp6, BorderLayout.NORTH);
		jp1.add(jp2, BorderLayout.CENTER);
		jp1.add(jp_xinzeng,BorderLayout.SOUTH);
		/*//jtable鼠标双击事件监听
				jta.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount()==2) {//实现双击
							int colum=((JTable)e.getSource()).columnAtPoint(e.getPoint());//获得行位置
							if(colum==0) {
								JOptionPane.showConfirmDialog(jp1, "不可更改产品代码","警告",JOptionPane.WARNING_MESSAGE);
							}
						}
						
					}
				});*/
		/***
		 * 按钮监听
		 */
		// 查询按钮监听
		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (jtf1.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(jp1, "查询的订单号不能是空的！", "警告", JOptionPane.ERROR_MESSAGE);
				} else {
					int row = Model.getRowCount() - 1;
					if (row != -1) {
						for (int i = row; i >= 0; i--) {
							Model.removeRow(i);// 删除Jtable中所有的行
						}
						Model.setRowCount(0);// 将JTable中的行数设为0；
					}
				String cpid;
				int innum = 0;
				String inid = jtf1.getText();
				ResultSet rs = ckm.select(inid);
				String intime = null;
				String[] data = new String[2];

				try {
					//判断 如果没有这个订单号 弹出提示
					if(rs.next()) {
						while (rs.next()) {
							cpid = rs.getString("cpid");
							data[0] = cpid;
							innum = rs.getInt("outnum");
							data[1] = innum + "";
							intime = rs.getString("outtime");

							Model.addRow(data);
							}
					}
					else {
						JOptionPane.showConfirmDialog(jp1, "没有这个订单号哦~仔细看看！！", "警告", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

				jtf2.setText(intime);
				}
			}
		});
		// 完成按钮监听
		b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (jtf1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(jp1, "修改不能为空", "提醒", JOptionPane.INFORMATION_MESSAGE);
				} else {
					System.out.println("正在修改数据");
					int n = Model.getRowCount();
					String inid = jtf1.getText();
					int hangshu_biaoji =0;//如果把订单全部删除了
					for (int i = 0; i < n; i++) {
						String cpid_empty = (String) Model.getValueAt(i, 0);
						if(cpid_empty.isEmpty()) {
							hangshu_biaoji+=1;
						}else {
							ArrayList<String> cpid_list=ckm.getCPid();
							int cp_exit=0;
							int size = cpid_list.size();
							for(int ii =0;i<size;i++) {
								
								if(cpid_empty.equals(cpid_list.get(ii))) {
									cp_exit=1;
								}
								
							}
							if(cp_exit==0) {
								String tixing_panduanchanpin="没有"+cpid_empty+"产品！不可添加";
								JOptionPane.showMessageDialog(jp1, tixing_panduanchanpin, "错误", JOptionPane.WARNING_MESSAGE);
							}else {
								cp_exit=0;
								ckm.update(inid, cpid_empty,
										Integer.parseInt((String) Model.getValueAt(i, 1)));
								JOptionPane.showMessageDialog(jp1, "修改已完成", "提醒", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("修改数据成功");
							}
						}
					}
					if(hangshu_biaoji==n) {
						hangshu_biaoji=0;
						JOptionPane.showMessageDialog(jp1, "修改失败，请用删除操作！","修改空订单！",JOptionPane.WARNING_MESSAGE);
					}
					
					int row = Model.getRowCount() - 1;
					if (row != -1) {
						for (int i = row; i >= 0; i--) {
							Model.removeRow(i);// 删除Jtable中所有的行
						}
						Model.setRowCount(0);// 将JTable中的行数设为0；
					}
					jtf1.setText("");
					jtf2.setText("");
				}
			}
		});
		// 取消按钮监听
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int row = Model.getRowCount() - 1;
				if (row != -1) {
					for (int i = row; i >= 0; i--) {
						Model.removeRow(i);
					}
					Model.setRowCount(0);
				}
				
				/*String cpid;
				int innum = 0;
				String inid = jtf1.getText();
				ResultSet rs = ckm.select(inid);
				String intime = null;
				String[] data = new String[2];

				try {
					while (rs.next()) {
						cpid = rs.getString("cpid");
						data[0] = cpid;
						innum = rs.getInt("innum");
						data[1] = innum + "";
						intime = rs.getString("rktime");

						Model.addRow(data);
					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}*/

				//jtf2.setText(intime);
				jtf1.setText("");
				jtf2.setText("");
			}
		});
		/*
		 * 删除空行的监听事件
		 */
		b_delete_empty.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int n = Model.getRowCount();
				for(int i =0;i<n;i++) {
					String cpid=(String)Model.getValueAt(i, 0);
					if(cpid.isEmpty()){
				Model.removeRow(i);
				n--;
		}
				}
				
			}
		});
		/*
		 * 新增一行的监听事件
		 */
		b_zenghang.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String[] row_empty= {"",""};
				Model.addRow(row_empty);
				
			}
		});


		return jp1;
	}

	// 删除界面设计
	public static JComponent ck_delete_frame() {
		JButton b2 = new JButton("删除");
		JButton b1 = new JButton("查询");
		JButton b3 = new JButton("取消");
		final JPanel jp1 = new JPanel(new BorderLayout());
		JPanel jp2 = new JPanel(new GridLayout(3, 1));
		JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jp6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jp7 = new JPanel(new GridLayout(2, 1));
		JLabel label1 = new JLabel("删除出 库 单 ");
		JLabel label2 = new JLabel(" 编  号   ");
		JLabel label3 = new JLabel("出库时间");
		JLabel label4 = new JLabel("产品编号");

		final JTextField jtf1 = new JTextField(15);
		final JTextField jtf2 = new JTextField(15);
		final JTextField jtf3 = new JTextField(15);
		jtf2.setEnabled(false);
		/*
		 * 表格模型
		 */
		String[] columnNames = { "产品代码", "出库量" };
		final DefaultTableModel Model = new DefaultTableModel(columnNames, 0);
		JTable jta = new JTable(Model) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}// 表格不允许被被编辑
		};
		jta.setModel(Model);
		int row = Model.getRowCount() - 1;
		if (row != -1) {
			for (int i = row; i >= 0; i--) {
				Model.removeRow(i);// 删除Jtable中所有的行
			}
			Model.setRowCount(0);// 将JTable中的行数设为0；
		}
		JScrollPane jsp = new JScrollPane();
		jsp.setViewportView(jta);

		/*
		 * 使数据居中对齐
		 */
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jta.setDefaultRenderer(Object.class, r);

		/*
		 * 容器添加
		 */
		jp6.add(label1);
		jp3.add(label2);
		jp3.add(jtf1);
		jp3.add(b1);
		jp4.add(label3);
		jp4.add(jtf2);
		jp5.add(label4);
		jp5.add(jtf3);
		jp5.add(b2);
		jp5.add(b3);
		jp2.add(jp3);
		jp2.add(jp4);
		jp2.add(jp5);
		jp7.add(jp2);
		jp7.add(jsp);
		jp1.add(jp6, BorderLayout.NORTH);
		jp1.add(jp7, BorderLayout.CENTER);
		/*
		 * 按钮的监听事件
		 */
		// 查询的监听事件
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jtf1.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(jp1, "查询的订单号不能是空的！", "警告", JOptionPane.ERROR_MESSAGE);
				} else {
					int row = Model.getRowCount() - 1;
					if (row != -1) {
						for (int i = row; i >= 0; i--) {
							Model.removeRow(i);// 删除Jtable中所有的行
						}
						Model.setRowCount(0);// 将JTable中的行数设为0；
					}
					if (jtf3.getText().isEmpty()) {

						String cpid;
						int innum = 0;
						String inid = jtf1.getText();
						ResultSet rs = ckm.select(inid);
						String intime = null;
						String[] data = new String[2];

						try {
							if(rs.next()) {
								while (rs.next()) {
									cpid = rs.getString("cpid");
									data[0] = cpid;
									innum = rs.getInt("outnum");
									data[1] = innum + "";
									intime = rs.getString("outtime");

									Model.addRow(data);
								}
							}else {
								JOptionPane.showConfirmDialog(jp1, "没有这个订单号哦~看看打错了没！", "警告", JOptionPane.ERROR_MESSAGE);
							}
							
						} catch (SQLException e1) {

							e1.printStackTrace();
						}

						jtf2.setText(intime);
					} else {

						int innum = 0;
						String inid = jtf1.getText();
						String cpid_jtf = jtf3.getText();
						ResultSet rs = ckm.select(inid, cpid_jtf);
						String intime = null;
						String[] data = new String[2];

						try {
							while (rs.next()) {

								data[0] = jtf3.getText();
								innum = rs.getInt("outnum");
								data[1] = innum + "";
								intime = rs.getString("outtime");

								Model.addRow(data);
							}
						} catch (SQLException e1) {

							e1.printStackTrace();
						}

						jtf2.setText(intime);
					}
				}
			}

		});
		// 删除按钮的监听事件
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (jtf1.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(jp1, "删除的订单号不能是空的！", "警告", JOptionPane.ERROR_MESSAGE);
				} else {
					if (jtf3.getText().isEmpty()) {

						String inid = jtf1.getText();
						ckm.delete(inid);

						jtf1.setText("");
						jtf2.setText("");
						jtf3.setText("");
						int row = Model.getRowCount() - 1;
						if (row != -1) {
							for (int i = row; i >= 0; i--) {
								Model.removeRow(i);// 删除Jtable中所有的行
							}
							Model.setRowCount(0);// 将JTable中的行数设为0；
						}

						JOptionPane.showConfirmDialog(jp1, "订单删除完成！", "信息", JOptionPane.INFORMATION_MESSAGE);

					} else {

						String inid = jtf1.getText();
						String cpid_jtf = jtf3.getText();
						ckm.delete(inid, cpid_jtf);

						jtf1.setText("");
						jtf2.setText("");
						jtf3.setText("");
						int row = Model.getRowCount() - 1;
						if (row != -1) {
							for (int i = row; i >= 0; i--) {
								Model.removeRow(i);// 删除Jtable中所有的行
							}
							Model.setRowCount(0);// 将JTable中的行数设为0；
						}

						JOptionPane.showConfirmDialog(jp1, "订单中的产品删除完成！", "信息", JOptionPane.INFORMATION_MESSAGE);
					}

				}
			}

		});
		// 取消按钮的监听事件
		b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				int row = Model.getRowCount() - 1;
				if (row != -1) {
					for (int i = row; i >= 0; i--) {
						Model.removeRow(i);// 删除Jtable中所有的行
					}
					Model.setRowCount(0);// 将JTable中的行数设为0；
				}
			}

		});

		/*
		 * 返回一个容器
		 */
		return jp1;
	}
}
