package cangku_manager_rk;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class rk_menager {
	static rk_model rkm = new rk_model();
	static int flag=0;

	/*
	 * �����ϸ����
	 */
	public static JComponent rk_mingxi_frame() {

		JButton b1 = new JButton("ˢ��");
		JPanel jp1 = new JPanel(new BorderLayout());
		JPanel jp2 = new JPanel(new FlowLayout());
		JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel label1 = new JLabel("�����ϸ�� ");
		jp2.add(label1);

		String[] columnNames = { "�����", "���ʱ��", "��Ʒ����", "�����" };
		final DefaultTableModel Model = new DefaultTableModel(columnNames, 0);
		/*
		 * �ڱ�������ģʽ������Ϊ���ɱ༭
		 */

		JTable jta = new JTable(Model) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jta.setModel(Model);
		/*
		 * ��ʼ����񣬲��������е�����Ϊ��
		 */
		int row = Model.getRowCount() - 1;
		if (row != -1) {
			for (int i = row; i >= 0; i--) {
				Model.removeRow(i);
			}
			Model.setRowCount(0);
		}
		JScrollPane jsp = new JScrollPane();
		jsp.setViewportView(jta);
		jta.setEnabled(false);
		jp3.add(b1);
		/*
		 * ʹ���ݾ��ж���
		 */
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jta.setDefaultRenderer(Object.class, r);
		
		/****
		 * ��ȡ���ݿ�
		 */
		String inid;
		String intime;
		String cpid;
		int innum = 0;
		ResultSet rs = rkm.select();
		String[] data = new String[4];
		try {
			while (rs.next()) {

				inid = rs.getString("inid");
				data[0] = inid;
				intime = rs.getString("rktime");
				data[1] = intime;
				cpid = rs.getString("cpid");
				data[2] = cpid;
				innum = rs.getInt("innum");
				data[3] = innum + "";

				Model.addRow(data);
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		
		
		
		
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

				String inid;
				String intime;
				String cpid;
				int innum = 0;
				ResultSet rs = rkm.select();
				String[] data = new String[4];
				try {
					while (rs.next()) {

						inid = rs.getString("inid");
						data[0] = inid;
						intime = rs.getString("rktime");
						data[1] = intime;
						cpid = rs.getString("cpid");
						data[2] = cpid;
						innum = rs.getInt("innum");
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

	/*
	 * ������ⵥ����
	 */
	public static JComponent rk_add_frame() {
		JButton b1 = new JButton("���");
		JButton b2 = new JButton("��һ��");
		JButton b3 = new JButton("���");
		final JPanel jp1 = new JPanel(new BorderLayout());
		JPanel jp2 = new JPanel(new GridLayout(2, 1));
		JPanel jp3 = new JPanel(new GridLayout(4, 1));
		JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JPanel jp6 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JPanel jp7 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JPanel jp8 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JPanel jp9 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		jp7.add(b3);
		jp7.add(b2);
		final JTextField jtf1 = new JTextField(15);
		final JTextField jtf2 = new JTextField(15);
		final JTextField jtf3 = new JTextField("�", 15);
		final JTextField jtf4 = new JTextField(15);
		final JTextField jtf5 = new JTextField(15);

		jtf1.setText(rkm.getInid());
		jtf2.setText(rkm.getIntime());
		jtf1.setEditable(false);
		jtf2.setEditable(false);

		JLabel label1 = new JLabel("�½���ⵥ");
		JLabel label2 = new JLabel(" ��   ��  ");
		JLabel label3 = new JLabel("���ʱ��");
		JLabel label4 = new JLabel("�����ˣ�");
		JLabel label5 = new JLabel("��Ʒ����");
		JLabel label6 = new JLabel("��  ��  ��");
		jp8.add(label5);
		jp8.add(jtf4);
		jp9.add(label6);
		jp9.add(jtf5);
		jp9.add(b1);
		String[] columnNames = { "��Ʒ����", "�����" };

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

		jp2.add(jsp);
		/*
		 * ʹ���ݾ��ж���
		 */
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jta.setDefaultRenderer(Object.class, r);
		// ��Ӱ�ť����--��jtable���������
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��jtable���������");
				String[] count = new String[2];

				boolean biaozhi = true;
				if (jtf4.getText().isEmpty() || jtf5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(jp1, "�������ӿղ�Ʒ", "����", JOptionPane.WARNING_MESSAGE);
				} else {
					int n = Model.getRowCount();
					String old = null;
					ArrayList<String> cpid_list=rkm.getCPid();
					int cp_exit=0;
					int size = cpid_list.size();
					for(int i =0;i<size;i++) {
						
						if(jtf4.getText().equals(cpid_list.get(i))) {
							cp_exit=1;
						}
						
					}
					if(cp_exit==0) {
						
						JOptionPane.showMessageDialog(jp1, "û�д˲�Ʒ���������", "����", JOptionPane.WARNING_MESSAGE);
					}else {
						for (int i = 0; i < n; i++) {
							old = (String) Model.getValueAt(i, 0);
							if (old.equals(jtf4.getText())) {
								JOptionPane.showMessageDialog(jp1, "��Ʒ�����ظ�", "����", JOptionPane.WARNING_MESSAGE);
								biaozhi = false;
								break;
	
							}
						}
						if (biaozhi) {
							count[0] = jtf4.getText();
							count[1] = jtf5.getText();
							Model.addRow(count);
						}
						jtf4.setText("");
						jtf5.setText("");
						
					}
				}
			}
		});
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = Model.getRowCount() - 1;
				if(row == -1) {
					//flag=0;
				}else {
				
					if(flag==0) {
						flag+=1;
						System.out.println("���������ݿ��������");
						int n = Model.getRowCount();
						
						for (int i = 0; i < n; i++) {
							if (i + 1 == 1) {
								String cpi = (String)Model.getValueAt(i, 0);
								String numi = (String) Model.getValueAt(i, 1);
								if(cpi.isEmpty()||numi.isEmpty()) {
									
								}else {
									rkm.insert(jtf1.getText(), jtf3.getText(), jtf2.getText(), cpi,
											Integer.parseInt(numi));
								}
								
							} else {
								String cpi = (String)Model.getValueAt(i, 0);
								String numi = (String) Model.getValueAt(i, 1);
								if(cpi.isEmpty()||numi.isEmpty()) {
									
								}else {
									rkm.insert(jtf1.getText(), jtf3.getText(), cpi,
											Integer.parseInt(numi));
								}
								
							}
		
						}
						JOptionPane.showMessageDialog(jp1, "��������", "����", JOptionPane.INFORMATION_MESSAGE);
						System.out.println("������ݳɹ�");
					}else if(flag != 0) {
						JOptionPane.showMessageDialog(jp1, "��Ҫ�ظ�������", "����", JOptionPane.WARNING_MESSAGE);
						
					}
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				flag=0;
				jtf1.setText(rkm.getInid());
				jtf2.setText(rkm.getIntime());
				int row = Model.getRowCount() - 1;
				if (row != -1) {
					for (int i = row; i >= 0; i--) {
						Model.removeRow(i);
					}
					Model.setRowCount(0);
				}
				System.out.println("��ⵥ�������");
			}
		});

		return jp1;
	}

	// �޸�����
	public static JComponent rk_update_frame() {
		JButton b1 = new JButton("��ѯ");
		JButton b2 = new JButton("ȡ��");
		JButton b3 = new JButton("���");
		JButton b_zenghang = new JButton("����һ��");
		JButton b_delete_empty = new JButton("ɾ������");
		final JPanel jp1 = new JPanel(new BorderLayout());
		JPanel jp2 = new JPanel(new GridLayout(2, 1));
		JPanel jp3 = new JPanel(new GridLayout(2, 1));
		JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		JPanel jp6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jp_xinzeng = new JPanel(new FlowLayout(FlowLayout.CENTER,50,30));
		final JTextField jtf1 = new JTextField(15);
		final JTextField jtf2 = new JTextField(15);
		jp_xinzeng.add(b_delete_empty);jp_xinzeng.add(b_zenghang);
		jtf2.setEditable(false);

		JLabel label1 = new JLabel("������ⵥ ");
		JLabel label2 = new JLabel(" ��   ��  ");
		JLabel label3 = new JLabel("���ʱ��");

		String[] columnNames = { "��Ʒ����", "�����" };
		final DefaultTableModel Model = new DefaultTableModel(columnNames, 0) /*{

			*//**
			 * 
			 *//*
			private static final long serialVersionUID = 1L;

			
			 * ���ò�Ʒ���һ�в��ɱ༭
			 
			@SuppressWarnings("unused")
			public boolean isCellEditable(int column) {
				if (column == 1) {
					return true;
				} else {
					return false;
				}
			}

		}*/;
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
		/*// jtable���˫���¼�����
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
				if (e.getClickCount() == 1) {// ʵ��˫��
					int colum = ((JTable) e.getSource()).columnAtPoint(e.getPoint());// �����λ��
					if (colum == 0) {
						JOptionPane.showConfirmDialog(jp1, "���ɸ��Ĳ�Ʒ����", "����", JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});*/
		// ��ѯ��ť����
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jtf1.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(jp1, "��ѯ�Ķ����Ų����ǿյģ�", "����", JOptionPane.ERROR_MESSAGE);
				} else {
					int row = Model.getRowCount() - 1;
					if (row != -1) {
						for (int i = row; i >= 0; i--) {
							Model.removeRow(i);// ɾ��Jtable�����е���
						}
						Model.setRowCount(0);// ��JTable�е�������Ϊ0��
					}
					String cpid;
					int innum = 0;
					String inid = jtf1.getText();
					ResultSet rs = rkm.select(inid);
					String intime = null;
					String[] data = new String[2];

					try {
						if(rs.next()) {
							while (rs.next()) {
								cpid = rs.getString("cpid");
								data[0] = cpid;
								innum = rs.getInt("innum");
								data[1] = innum + "";
								intime = rs.getString("rktime");

								Model.addRow(data);
							}
						}else {
							JOptionPane.showConfirmDialog(jp1, "û�м�¼�أ������ǲ��Ƕ����Ŵ���ˣ�", "����", JOptionPane.ERROR_MESSAGE);
						}
						
					} catch (SQLException e1) {

						e1.printStackTrace();
					}

					jtf2.setText(intime);
				}
			}
		});
		// ��ɰ�ť����
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jtf1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(jp1, "�޸Ĳ�ѯ����Ϊ��", "����", JOptionPane.INFORMATION_MESSAGE);
				} else {
					
					
					System.out.println("�����޸�����");
					int n = Model.getRowCount();
					String inid = jtf1.getText();
					int hangshu_biaoji =0;//����Ѷ���ȫ��ɾ����
					for (int i = 0; i < n; i++) {
						String cpid_empty = (String) Model.getValueAt(i, 0);
						if(cpid_empty.isEmpty()) {
							hangshu_biaoji+=1;
						}else {
							ArrayList<String> cpid_list=rkm.getCPid();
							int cp_exit=0;
							int size = cpid_list.size();
							for(int ii =0;i<size;i++) {
								
								if(cpid_empty.equals(cpid_list.get(ii))) {
									cp_exit=1;
								}
								
							}
							if(cp_exit==0) {
								String tixing_panduanchanpin="û��"+cpid_empty+"��Ʒ���������";
								JOptionPane.showMessageDialog(jp1, tixing_panduanchanpin, "����", JOptionPane.WARNING_MESSAGE);
							}else {
								cp_exit=0;
								rkm.update(inid, cpid_empty,
										Integer.parseInt((String) Model.getValueAt(i, 1)));
								JOptionPane.showMessageDialog(jp1, "�޸������", "����", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("�޸����ݳɹ�");
							}
						}
						
					}
					if(hangshu_biaoji==n) {
						hangshu_biaoji=0;
						JOptionPane.showMessageDialog(jp1, "�޸�ʧ�ܣ�����ɾ��������","�޸Ŀն�����",JOptionPane.WARNING_MESSAGE);
					}
					
					
					int row = Model.getRowCount() - 1;
					if (row != -1) {
						for (int i = row; i >= 0; i--) {
							Model.removeRow(i);
						}
						Model.setRowCount(0);
					}
					jtf1.setText("");
					jtf2.setText("");
				}
			}
		});
		// ȡ����ť����
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = Model.getRowCount() - 1;
				if (row != -1) {
					for (int i = row; i >= 0; i--) {
						Model.removeRow(i);
					}
					Model.setRowCount(0);
				}

/*				String cpid;
				int innum = 0;
				String inid = jtf1.getText();
				ResultSet rs = rkm.select(inid);
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
				}

				jtf2.setText(intime);
				JOptionPane.showMessageDialog(jp1, "�����", "����", JOptionPane.INFORMATION_MESSAGE);*/
				jtf1.setText("");
				jtf2.setText("");
			}
		});
		/*
		 * ɾ�����еļ����¼�
		 */
		b_delete_empty.addActionListener(new ActionListener() {
			
			@Override
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
		 * ����һ�еļ����¼�
		 */
		b_zenghang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] row_empty= {"",""};
				Model.addRow(row_empty);
				
			}
		});

		return jp1;
	}

	// ɾ���������
	public static JComponent rk_delete_frame() {
		JButton b2 = new JButton("ɾ��");
		JButton b1 = new JButton("��ѯ");
		JButton b3 = new JButton("ȡ��");
		final JPanel jp1 = new JPanel(new BorderLayout());
		JPanel jp2 = new JPanel(new GridLayout(3, 1));
		JPanel jp3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jp5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jp6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jp7 = new JPanel(new GridLayout(2, 1));
		JLabel label1 = new JLabel("ɾ���� �� �� ");
		JLabel label2 = new JLabel(" ��  ��   ");
		JLabel label3 = new JLabel("���ʱ��");
		JLabel label4 = new JLabel("��Ʒ���");

		final JTextField jtf1 = new JTextField(15);
		final JTextField jtf2 = new JTextField(15);
		final JTextField jtf3 = new JTextField(15);
		jtf2.setEnabled(false);
		/*
		 * ���ģ��
		 */
		String[] columnNames = { "��Ʒ����", "�����" };
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
		 * ��ť�ļ����¼�
		 */
		// ��ѯ�ļ����¼�
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jtf1.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(jp1, "��ѯ�Ķ����Ų����ǿյģ�", "����", JOptionPane.ERROR_MESSAGE);
				} else {
					int row = Model.getRowCount() - 1;
					if (row != -1) {
						for (int i = row; i >= 0; i--) {
							Model.removeRow(i);// ɾ��Jtable�����е���
						}
						Model.setRowCount(0);// ��JTable�е�������Ϊ0��
					}
					if (jtf3.getText().isEmpty()) {

						String cpid;
						int innum = 0;
						String inid = jtf1.getText();
						ResultSet rs = rkm.select(inid);
						String intime = null;
						String[] data = new String[2];

						try {
							if(rs.next()) {
								while (rs.next()) {
									cpid = rs.getString("cpid");
									data[0] = cpid;
									innum = rs.getInt("innum");
									data[1] = innum + "";
									intime = rs.getString("rktime");

									Model.addRow(data);
								}
							}else {
								JOptionPane.showConfirmDialog(jp1, "û�в鵽��¼�أ��ǲ��Ƕ����Ŵ���ˣ�", "����", JOptionPane.ERROR_MESSAGE);
							}
							
						} catch (SQLException e1) {

							e1.printStackTrace();
						}

						jtf2.setText(intime);
					} else {

						int innum = 0;
						String inid = jtf1.getText();
						String cpid_jtf = jtf3.getText();
						ResultSet rs = rkm.select(inid, cpid_jtf);
						String intime = null;
						String[] data = new String[2];

						try {
							if(rs.next()) {
								while (rs.next()) {

									data[0] = jtf3.getText();
									innum = rs.getInt("innum");
									data[1] = innum + "";
									intime = rs.getString("rktime");

									Model.addRow(data);
								}
							}else {
								JOptionPane.showConfirmDialog(jp1, "û�в鵽��¼�أ��ǲ��Ƕ����Ŵ���ˣ����߲�Ʒ������ˣ�", "����", JOptionPane.ERROR_MESSAGE);
							}
							
						} catch (SQLException e1) {

							e1.printStackTrace();
						}

						jtf2.setText(intime);
					}
				}
			}

		});
		// ɾ����ť�ļ����¼�
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (jtf1.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(jp1, "ɾ���Ķ����Ų����ǿյģ�", "����", JOptionPane.ERROR_MESSAGE);
				} else {
					if (jtf3.getText().isEmpty()) {

						String inid = jtf1.getText();
						rkm.delete(inid);

						jtf1.setText("");
						jtf2.setText("");
						jtf3.setText("");
						int row = Model.getRowCount() - 1;
						if (row != -1) {
							for (int i = row; i >= 0; i--) {
								Model.removeRow(i);// ɾ��Jtable�����е���
							}
							Model.setRowCount(0);// ��JTable�е�������Ϊ0��
						}

						JOptionPane.showConfirmDialog(jp1, "����ɾ����ɣ�", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);

					} else {

						String inid = jtf1.getText();
						String cpid_jtf = jtf3.getText();
						rkm.delete(inid, cpid_jtf);

						jtf1.setText("");
						jtf2.setText("");
						jtf3.setText("");
						int row = Model.getRowCount() - 1;
						if (row != -1) {
							for (int i = row; i >= 0; i--) {
								Model.removeRow(i);// ɾ��Jtable�����е���
							}
							Model.setRowCount(0);// ��JTable�е�������Ϊ0��
						}

						JOptionPane.showConfirmDialog(jp1, "�����еĲ�Ʒɾ����ɣ�", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
					}

				}
			}

		});
		// ȡ����ť�ļ����¼�
		b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				int row = Model.getRowCount() - 1;
				if (row != -1) {
					for (int i = row; i >= 0; i--) {
						Model.removeRow(i);// ɾ��Jtable�����е���
					}
					Model.setRowCount(0);// ��JTable�е�������Ϊ0��
				}
			}

		});

		/*
		 * ����һ������
		 */
		return jp1;
	}
}
