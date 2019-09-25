package cangku_manager_cp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class cp_menager {
		static cp_model cpm = new cp_model();
		static int flag =0;
		// 明细页面
		public static JComponent cp_mingxi_frame() {

			JButton b1 = new JButton("刷新");
			JPanel jp1 = new JPanel(new BorderLayout());
			JPanel jp2 = new JPanel(new FlowLayout());
			JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel label1 = new JLabel("产品明细表 ");
			jp2.add(label1);
			String[] columnNames = { "产品代码", "名称", "单位", "生产地" };
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
			jta.setEnabled(false);
			jp3.add(b1);
			/*
			 * 是数据居中对齐
			 */
			DefaultTableCellRenderer r = new DefaultTableCellRenderer();
			r.setHorizontalAlignment(JLabel.CENTER);
			jta.setDefaultRenderer(Object.class, r);

			/***
			 * 点击窗体直接显示
			 * 
			 */
			String cpid;
			String ming;
			String dan;
			String sheng;
			ResultSet rs = cpm.select();
			String[] data = new String[4];
			try {
				while (rs.next()) {

					cpid = rs.getString("产品代码");
					data[0] = cpid;
					ming = rs.getString("名称");
					data[1] = ming;
					dan = rs.getString("单位");
					data[2] = dan;
					sheng = rs.getString("生产地");
					data[3] = sheng;

					Model.addRow(data);
				}
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

			
			/***
			 * 点击按钮事件
			 */
			b1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int row = Model.getRowCount() - 1;
					if (row != -1) {
						for (int i = row; i >= 0; i--) {
							Model.removeRow(i);// 删除Jtable中所有的行
						}
						Model.setRowCount(0);// 将JTable中的行数设为0；
					}

					String cpid;
					String ming;
					String dan;
					String sheng;
					ResultSet rs = cpm.select();
					String[] data = new String[4];
					try {
						while (rs.next()) {

							cpid = rs.getString("产品代码");
							data[0] = cpid;
							ming = rs.getString("名称");
							data[1] = ming;
							dan = rs.getString("单位");
							data[2] = dan;
							sheng = rs.getString("生产地");
							data[3] = sheng;

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
		public static JComponent cp_add_frame() {

			JButton b1 = new JButton("取消");
			JButton b2 = new JButton("完成");
			final JPanel jp1 = new JPanel(new BorderLayout());
			JPanel jp2 = new JPanel(new GridLayout(1, 1));
			JPanel jp3 = new JPanel(new GridLayout(4, 1));
			JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
			JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
			JPanel jp6 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
			JPanel jp7 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
			JPanel jp8 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
			JPanel jp9 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
			jp7.add(b1);
			jp7.add(b2);
			final JTextField jtf1 = new JTextField(15);
			final JTextField jtf2 = new JTextField(15);
			final JTextField jtf3 = new JTextField(15);
			final JTextField jtf4 = new JTextField(15);
			
			JLabel label1 = new JLabel("新 增 产 品");
			JLabel label2 = new JLabel("产品代码：");
			JLabel label3 = new JLabel("名       称：");
			JLabel label4 = new JLabel("产品单位：");
			JLabel label5 = new JLabel("生  产  地：");
			
			

			jp4.add(label1);
			jp5.add(label2);
			jp5.add(jtf1 );
			jp6.add(label3);
			jp6.add(jtf2);
			jp7.add(label4);
			jp7.add(jtf3);
			jp8.add(label5);
			jp8.add(jtf4);
			
			jp3.add(jp5);
			jp3.add(jp6);
			jp3.add(jp7);
			jp3.add(jp8);
			
			jp2.add(jp3);
			jp9.add(b1);
			jp9.add(b2);
			jp1.add(jp4, BorderLayout.NORTH);
			jp1.add(jp2, BorderLayout.CENTER);
			jp1.add(jp9, BorderLayout.SOUTH);

			
			// 取消按钮监听
			b1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					jtf1.setText("");
					jtf2.setText("");
					jtf3.setText("");
					jtf4.setText("");
					flag=0;
				}
			});
			b2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (jtf1.getText().isEmpty()) {
						JOptionPane.showConfirmDialog(jp1, "产品代码不能是空的！", "警告", JOptionPane.ERROR_MESSAGE);
					} else {
					if(flag==0) {
						System.out.println("正在往数据库添加数据");
						cpm.insert(jtf1.getText(), jtf2.getText(), jtf3.getText(), jtf4.getText());
						JOptionPane.showMessageDialog(jp1, "添加已完成", "提醒", JOptionPane.INFORMATION_MESSAGE);
						System.out.println("添加数据成功");
						flag+=1;
					}else if (flag!=0) {
						JOptionPane.showMessageDialog(jp1, "不要重复点击完成", "警告", JOptionPane.WARNING_MESSAGE);
					}
				}
				}
			});
			

			return jp1;
		}

		// 修改数据
		public static JComponent cp_update_frame() {
			JButton b1 = new JButton("查询");
			JButton b3 = new JButton("修改");
			final JPanel jp1 = new JPanel(new BorderLayout());
			JPanel jp2 = new JPanel(new GridLayout(2, 1));
			JPanel jp3 = new JPanel(new GridLayout(2, 1));
			JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
			JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
			JPanel jp6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			final JTextField jtf1 = new JTextField(15);

			JLabel label1 = new JLabel("更改产品单 ");
			JLabel label2 = new JLabel(" 产品编号  ");

			String[] columnNames = { "产品代码", "名称","产品单位","生产地" };
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
		
			jp4.add(b3);
			jp3.add(jp4);
			jp3.add(jp5);
			jp2.add(jp3);
			jp2.add(jsp);
			jp1.add(jp6, BorderLayout.NORTH);
			jp1.add(jp2, BorderLayout.CENTER);
			//jtable鼠标双击事件监听

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
					});
			// 查询按钮监听
			b1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (jtf1.getText().isEmpty()) {
						JOptionPane.showConfirmDialog(jp1, "查询的产品编号不能是空的！", "警告", JOptionPane.ERROR_MESSAGE);
					} else {
						int row = Model.getRowCount() - 1;
						if (row != -1) {
							for (int i = row; i >= 0; i--) {
								Model.removeRow(i);// 删除Jtable中所有的行
							}
							Model.setRowCount(0);// 将JTable中的行数设为0；
						}
					String cpid;
					String ming;
					String dan;
					String sheng;
					
					String cpid1 = jtf1.getText();
					ResultSet rs = cpm.select1(cpid1);
				
					String[] data = new String[4];

					try {
						if(rs.next()) {
							while (rs.next()) {
								cpid = rs.getString("产品代码");
								data[0] = cpid;
								ming = rs.getString("名称");
								data[1] = ming;
								dan = rs.getString("单位");
								data[2] = dan;
								sheng = rs.getString("生产地");
								data[3] = sheng;
							
								Model.addRow(data);
							}
						}else {
							JOptionPane.showConfirmDialog(jp1, "没有记录呢，看看是不是产品代码打错了！", "警告", JOptionPane.ERROR_MESSAGE);
						}
						
					} catch (SQLException e1) {

						e1.printStackTrace();
					}

				
					}
				}
			});
			// 完成按钮监听
			b3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (jtf1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(jp1, "修改不能为空", "提醒", JOptionPane.INFORMATION_MESSAGE);
					} else {
						System.out.println("正在修改数据");
						String cpid= jtf1.getText();
						int n = Model.getRowCount();
						for (int i = 0; i < n; i++) {
							cpm.update( cpid,(String) Model.getValueAt(i, 1),(String) Model.getValueAt(i, 2),
									(String) Model.getValueAt(i, 3));
						}
						JOptionPane.showMessageDialog(jp1, "修改已完成", "提醒", JOptionPane.INFORMATION_MESSAGE);
						System.out.println("修改数据成功");
						int row = Model.getRowCount() - 1;
						if (row != -1) {
							for (int i = row; i >= 0; i--) {
								Model.removeRow(i);// 删除Jtable中所有的行
							}
							Model.setRowCount(0);// 将JTable中的行数设为0；
						}
						jtf1.setText("");
			
					}
				}
			});
	

			return jp1;
		}

		// 删除界面设计
		public static JComponent cp_delete_frame() {
			JButton b2 = new JButton("删除");
			JButton b1 = new JButton("查询");
			
			final JPanel jp1 = new JPanel(new BorderLayout());
			JPanel jp2 = new JPanel(new GridLayout(2, 1));
			JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel jp6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JPanel jp7 = new JPanel(new GridLayout(2, 1));
			JLabel label1 = new JLabel("删除产品 ");
			JLabel label2 = new JLabel(" 产品编号   ");
		
			
			final JTextField jtf1 = new JTextField(15);
	
	
			/*
			 * 表格模型
			 */
			String[] columnNames = { "名称", "产品单位","生产地" };
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
			jta.setEnabled(false);
			
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
			jp3.add(b2);
		
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
						JOptionPane.showConfirmDialog(jp1, "查询的产品编号不能是空的！", "警告", JOptionPane.ERROR_MESSAGE);
					} else {
						int row = Model.getRowCount() - 1;
						if (row != -1) {
							for (int i = row; i >= 0; i--) {
								Model.removeRow(i);// 删除Jtable中所有的行
							}
							Model.setRowCount(0);// 将JTable中的行数设为0；
						}
						
						    String cpid = jtf1.getText();
						    String ming;
						    String chan;
						    String sheng;
							ResultSet rs = cpm.select(cpid);
							String[] data = new String[3];
							try {
								while (rs.next()) {
								
									ming = rs.getString("名称");
									data[0] =ming ;
									chan = rs.getString("单位");
									data[1] = chan;
									sheng = rs.getString("生成地");
									data[2] =  sheng;

									Model.addRow(data);
								}
							} catch (SQLException e1) {

								e1.printStackTrace();
							}
						}
					}
			});
			// 删除按钮的监听事件
			b2.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					if (jtf1.getText().isEmpty()) {
						JOptionPane.showConfirmDialog(jp1, "删除的产品编号不能是空的！", "警告", JOptionPane.ERROR_MESSAGE);
					} else {
							String cpid = jtf1.getText();
							cpm.delete(cpid);
							int row = Model.getRowCount() - 1;
							if (row != -1) {
								for (int i = row; i >= 0; i--) {
									Model.removeRow(i);// 删除Jtable中所有的行
								}
								Model.setRowCount(0);// 将JTable中的行数设为0；
							}
							JOptionPane.showConfirmDialog(jp1, "是否删除产品单中的产品", "信息", JOptionPane.INFORMATION_MESSAGE);
   					     	jtf1.setText("");
					}

					}
		
			});
			/*
			 * 返回一个容器
			 */
			return jp1;
		}
	}


