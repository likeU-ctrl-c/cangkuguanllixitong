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
		// ��ϸҳ��
		public static JComponent cp_mingxi_frame() {

			JButton b1 = new JButton("ˢ��");
			JPanel jp1 = new JPanel(new BorderLayout());
			JPanel jp2 = new JPanel(new FlowLayout());
			JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel label1 = new JLabel("��Ʒ��ϸ�� ");
			jp2.add(label1);
			String[] columnNames = { "��Ʒ����", "����", "��λ", "������" };
			final DefaultTableModel Model = new DefaultTableModel(columnNames, 0);
			JTable jta = new JTable(Model) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}// ����������༭
			};
			jta.setModel(Model);
			int row = Model.getRowCount() - 1;
			if (row != -1) {
				for (int i = row; i >= 0; i--) {
					Model.removeRow(i);// ɾ��Jtable�����е���
				}
				Model.setRowCount(0);// ��JTable�е�������Ϊ0��
			}
			JScrollPane jsp = new JScrollPane();
			jsp.setViewportView(jta);
			jta.setEnabled(false);
			jp3.add(b1);
			/*
			 * �����ݾ��ж���
			 */
			DefaultTableCellRenderer r = new DefaultTableCellRenderer();
			r.setHorizontalAlignment(JLabel.CENTER);
			jta.setDefaultRenderer(Object.class, r);

			/***
			 * �������ֱ����ʾ
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

					cpid = rs.getString("��Ʒ����");
					data[0] = cpid;
					ming = rs.getString("����");
					data[1] = ming;
					dan = rs.getString("��λ");
					data[2] = dan;
					sheng = rs.getString("������");
					data[3] = sheng;

					Model.addRow(data);
				}
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

			
			/***
			 * �����ť�¼�
			 */
			b1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int row = Model.getRowCount() - 1;
					if (row != -1) {
						for (int i = row; i >= 0; i--) {
							Model.removeRow(i);// ɾ��Jtable�����е���
						}
						Model.setRowCount(0);// ��JTable�е�������Ϊ0��
					}

					String cpid;
					String ming;
					String dan;
					String sheng;
					ResultSet rs = cpm.select();
					String[] data = new String[4];
					try {
						while (rs.next()) {

							cpid = rs.getString("��Ʒ����");
							data[0] = cpid;
							ming = rs.getString("����");
							data[1] = ming;
							dan = rs.getString("��λ");
							data[2] = dan;
							sheng = rs.getString("������");
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

		// ���ӷ���
		public static JComponent cp_add_frame() {

			JButton b1 = new JButton("ȡ��");
			JButton b2 = new JButton("���");
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
			
			JLabel label1 = new JLabel("�� �� �� Ʒ");
			JLabel label2 = new JLabel("��Ʒ���룺");
			JLabel label3 = new JLabel("��       �ƣ�");
			JLabel label4 = new JLabel("��Ʒ��λ��");
			JLabel label5 = new JLabel("��  ��  �أ�");
			
			

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

			
			// ȡ����ť����
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
						JOptionPane.showConfirmDialog(jp1, "��Ʒ���벻���ǿյģ�", "����", JOptionPane.ERROR_MESSAGE);
					} else {
					if(flag==0) {
						System.out.println("���������ݿ��������");
						cpm.insert(jtf1.getText(), jtf2.getText(), jtf3.getText(), jtf4.getText());
						JOptionPane.showMessageDialog(jp1, "��������", "����", JOptionPane.INFORMATION_MESSAGE);
						System.out.println("������ݳɹ�");
						flag+=1;
					}else if (flag!=0) {
						JOptionPane.showMessageDialog(jp1, "��Ҫ�ظ�������", "����", JOptionPane.WARNING_MESSAGE);
					}
				}
				}
			});
			

			return jp1;
		}

		// �޸�����
		public static JComponent cp_update_frame() {
			JButton b1 = new JButton("��ѯ");
			JButton b3 = new JButton("�޸�");
			final JPanel jp1 = new JPanel(new BorderLayout());
			JPanel jp2 = new JPanel(new GridLayout(2, 1));
			JPanel jp3 = new JPanel(new GridLayout(2, 1));
			JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
			JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
			JPanel jp6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			final JTextField jtf1 = new JTextField(15);

			JLabel label1 = new JLabel("���Ĳ�Ʒ�� ");
			JLabel label2 = new JLabel(" ��Ʒ���  ");

			String[] columnNames = { "��Ʒ����", "����","��Ʒ��λ","������" };
			final DefaultTableModel Model = new DefaultTableModel(columnNames, 0);
			JTable jta = new JTable(Model);
			jta.setModel(Model);
			int row = Model.getRowCount() - 1;
			if (row != -1) {
				for (int i = row; i >= 0; i--) {
					Model.removeRow(i);// ɾ��Jtable�����е���
				}
				Model.setRowCount(0);// ��JTable�е�������Ϊ0��
			}
			JScrollPane jsp = new JScrollPane();
			jsp.setViewportView(jta);
			/*
			 * ʹ���ݾ��ж���
			 */
			DefaultTableCellRenderer r = new DefaultTableCellRenderer();
			r.setHorizontalAlignment(JLabel.CENTER);
			jta.setDefaultRenderer(Object.class, r);
			/*
			 * �������
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
			//jtable���˫���¼�����

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
							if(e.getClickCount()==2) {//ʵ��˫��
								int colum=((JTable)e.getSource()).columnAtPoint(e.getPoint());//�����λ��
								if(colum==0) {
									JOptionPane.showConfirmDialog(jp1, "���ɸ��Ĳ�Ʒ����","����",JOptionPane.WARNING_MESSAGE);
								}
							}
							
						}
					});
			// ��ѯ��ť����
			b1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (jtf1.getText().isEmpty()) {
						JOptionPane.showConfirmDialog(jp1, "��ѯ�Ĳ�Ʒ��Ų����ǿյģ�", "����", JOptionPane.ERROR_MESSAGE);
					} else {
						int row = Model.getRowCount() - 1;
						if (row != -1) {
							for (int i = row; i >= 0; i--) {
								Model.removeRow(i);// ɾ��Jtable�����е���
							}
							Model.setRowCount(0);// ��JTable�е�������Ϊ0��
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
								cpid = rs.getString("��Ʒ����");
								data[0] = cpid;
								ming = rs.getString("����");
								data[1] = ming;
								dan = rs.getString("��λ");
								data[2] = dan;
								sheng = rs.getString("������");
								data[3] = sheng;
							
								Model.addRow(data);
							}
						}else {
							JOptionPane.showConfirmDialog(jp1, "û�м�¼�أ������ǲ��ǲ�Ʒ�������ˣ�", "����", JOptionPane.ERROR_MESSAGE);
						}
						
					} catch (SQLException e1) {

						e1.printStackTrace();
					}

				
					}
				}
			});
			// ��ɰ�ť����
			b3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (jtf1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(jp1, "�޸Ĳ���Ϊ��", "����", JOptionPane.INFORMATION_MESSAGE);
					} else {
						System.out.println("�����޸�����");
						String cpid= jtf1.getText();
						int n = Model.getRowCount();
						for (int i = 0; i < n; i++) {
							cpm.update( cpid,(String) Model.getValueAt(i, 1),(String) Model.getValueAt(i, 2),
									(String) Model.getValueAt(i, 3));
						}
						JOptionPane.showMessageDialog(jp1, "�޸������", "����", JOptionPane.INFORMATION_MESSAGE);
						System.out.println("�޸����ݳɹ�");
						int row = Model.getRowCount() - 1;
						if (row != -1) {
							for (int i = row; i >= 0; i--) {
								Model.removeRow(i);// ɾ��Jtable�����е���
							}
							Model.setRowCount(0);// ��JTable�е�������Ϊ0��
						}
						jtf1.setText("");
			
					}
				}
			});
	

			return jp1;
		}

		// ɾ���������
		public static JComponent cp_delete_frame() {
			JButton b2 = new JButton("ɾ��");
			JButton b1 = new JButton("��ѯ");
			
			final JPanel jp1 = new JPanel(new BorderLayout());
			JPanel jp2 = new JPanel(new GridLayout(2, 1));
			JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel jp6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JPanel jp7 = new JPanel(new GridLayout(2, 1));
			JLabel label1 = new JLabel("ɾ����Ʒ ");
			JLabel label2 = new JLabel(" ��Ʒ���   ");
		
			
			final JTextField jtf1 = new JTextField(15);
	
	
			/*
			 * ���ģ��
			 */
			String[] columnNames = { "����", "��Ʒ��λ","������" };
			final DefaultTableModel Model = new DefaultTableModel(columnNames, 0);
			JTable jta = new JTable(Model) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}// ����������༭
			};
			jta.setModel(Model);
			int row = Model.getRowCount() - 1;
			if (row != -1) {
				for (int i = row; i >= 0; i--) {
					Model.removeRow(i);// ɾ��Jtable�����е���
				}
				Model.setRowCount(0);// ��JTable�е�������Ϊ0��
			}
			JScrollPane jsp = new JScrollPane();
			jsp.setViewportView(jta);
			jta.setEnabled(false);
			
			/*
			 * ʹ���ݾ��ж���
			 */
			DefaultTableCellRenderer r = new DefaultTableCellRenderer();
			r.setHorizontalAlignment(JLabel.CENTER);
			jta.setDefaultRenderer(Object.class, r);

			/*
			 * �������
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
			 * ��ť�ļ����¼�
			 */
			// ��ѯ�ļ����¼�
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (jtf1.getText().isEmpty()) {
						JOptionPane.showConfirmDialog(jp1, "��ѯ�Ĳ�Ʒ��Ų����ǿյģ�", "����", JOptionPane.ERROR_MESSAGE);
					} else {
						int row = Model.getRowCount() - 1;
						if (row != -1) {
							for (int i = row; i >= 0; i--) {
								Model.removeRow(i);// ɾ��Jtable�����е���
							}
							Model.setRowCount(0);// ��JTable�е�������Ϊ0��
						}
						
						    String cpid = jtf1.getText();
						    String ming;
						    String chan;
						    String sheng;
							ResultSet rs = cpm.select(cpid);
							String[] data = new String[3];
							try {
								while (rs.next()) {
								
									ming = rs.getString("����");
									data[0] =ming ;
									chan = rs.getString("��λ");
									data[1] = chan;
									sheng = rs.getString("���ɵ�");
									data[2] =  sheng;

									Model.addRow(data);
								}
							} catch (SQLException e1) {

								e1.printStackTrace();
							}
						}
					}
			});
			// ɾ����ť�ļ����¼�
			b2.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					if (jtf1.getText().isEmpty()) {
						JOptionPane.showConfirmDialog(jp1, "ɾ���Ĳ�Ʒ��Ų����ǿյģ�", "����", JOptionPane.ERROR_MESSAGE);
					} else {
							String cpid = jtf1.getText();
							cpm.delete(cpid);
							int row = Model.getRowCount() - 1;
							if (row != -1) {
								for (int i = row; i >= 0; i--) {
									Model.removeRow(i);// ɾ��Jtable�����е���
								}
								Model.setRowCount(0);// ��JTable�е�������Ϊ0��
							}
							JOptionPane.showConfirmDialog(jp1, "�Ƿ�ɾ����Ʒ���еĲ�Ʒ", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
   					     	jtf1.setText("");
					}

					}
		
			});
			/*
			 * ����һ������
			 */
			return jp1;
		}
	}


