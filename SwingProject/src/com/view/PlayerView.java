package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Player;
import com.model.PlayerDAO;
import com.model.PlayerDAOImpl;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PlayerView extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField tfNum;
	private JLabel lblNewLabel_1;
	private JTextField tfName;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField tfBirth;
	private JTextField tfWeight;
	private JTextField tfHeight;
	private JComboBox<String> cb;
	private JButton btnInsert;
	private JButton btnView;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JSplitPane splitPane_1;
	private JScrollPane scrollPane;
	private JTextArea ta;
	private JPanel panel_1;
	private JComboBox comSearch;
	private JTextField tfSearch;
	private JButton btnSearch;
	PlayerDAO dao = new PlayerDAOImpl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerView frame = new PlayerView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlayerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setDividerSize(1);
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(400);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getTfNum());
			panel.add(getLblNewLabel_1());
			panel.add(getTfName());
			panel.add(getLblNewLabel_2());
			panel.add(getLblNewLabel_3());
			panel.add(getLblNewLabel_4());
			panel.add(getLblNewLabel_5());
			panel.add(getTfBirth());
			panel.add(getTfWeight());
			panel.add(getTfHeight());
			panel.add(getCb());
			panel.add(getBtnInsert());
			panel.add(getBtnView());
			panel.add(getBtnUpdate());
			panel.add(getBtnDelete());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("번호");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setBounds(27, 45, 57, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTfNum() {
		if (tfNum == null) {
			tfNum = new JTextField();
			tfNum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int num =Integer.parseInt(tfNum.getText());
						Player p = dao.view(num);
						tfName.setText(p.getName());
						tfBirth.setText(p.getBirth());
						tfHeight.setText(p.getHeight()+"");
						tfWeight.setText(p.getWeight()+"");
						cb.setSelectedItem(p.getKind());
					}catch(NumberFormatException n)  {
						JOptionPane.showMessageDialog(null, "숫자를 입력하세요");
					}catch(NullPointerException n2) {
						JOptionPane.showMessageDialog(null, "해당 선수 없습니다.");
					}
				
					
				}
			});
			tfNum.setBounds(107, 38, 186, 30);
			tfNum.setColumns(10);
		}
		return tfNum;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setBounds(27, 98, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(107, 95, 186, 30);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("생일");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setBounds(27, 164, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("몸무게");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_3.setBounds(27, 227, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("키");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_4.setBounds(27, 269, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("종목");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_5.setBounds(27, 312, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setBounds(107, 152, 186, 30);
			tfBirth.setColumns(10);
		}
		return tfBirth;
	}
	private JTextField getTfWeight() {
		if (tfWeight == null) {
			tfWeight = new JTextField();
			tfWeight.setBounds(107, 215, 186, 30);
			tfWeight.setColumns(10);
		}
		return tfWeight;
	}
	private JTextField getTfHeight() {
		if (tfHeight == null) {
			tfHeight = new JTextField();
			tfHeight.setBounds(107, 259, 186, 35);
			tfHeight.setColumns(10);
		}
		return tfHeight;
	}
	private JComboBox getCb() {
		if (cb == null) {
			cb = new JComboBox();
			cb.setModel(new DefaultComboBoxModel(new String[] {"야구", "축구", "기타"}));
			cb.setBounds(107, 308, 120, 30);
//			cb.addItem("야구");
//			cb.addItem("축구");
//			cb.addItem("기타");
			
		}
		return cb;
	}
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("추가");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Player p = new Player();
					p.setBirth(tfBirth.getText());
					p.setHeight(Double.parseDouble(tfHeight.getText()));
					p.setWeight(Double.parseDouble(tfWeight.getText()));
					p.setKind((String)cb.getSelectedItem());
					p.setName(tfName.getText());
					dao.insert(p);
					btnView.doClick();
					
				}
			});
			btnInsert.setBounds(49, 370, 97, 23);
		}
		return btnInsert;
	}
	private JButton getBtnView() {
		if (btnView == null) {
			btnView = new JButton("보기");
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ta.setText("");
				 ArrayList<Player> arr = dao.selectAll();
				 for(Player p   : arr) {
					 ta.append("번호 : " +p.getNum()+"\n");
					 ta.append("이름 : " +p.getName()+"\n");
					 ta.append("생일 : " +p.getBirth()+"\n");
					 ta.append("키 : " +p.getHeight()+"\n");
					 ta.append("몸무게 : " +p.getWeight()+"\n");
					 ta.append("종목 : " +p.getKind()+"\n\n");
				 }
				}
			});
			btnView.setBounds(180, 370, 97, 23);
		}
		return btnView;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Player p = new Player();
					p.setBirth(tfBirth.getText());
					p.setHeight(Double.parseDouble(tfHeight.getText()));
					p.setWeight(Double.parseDouble(tfWeight.getText()));
					p.setKind((String)cb.getSelectedItem());
					p.setName(tfName.getText());
					p.setNum(Integer.parseInt(tfNum.getText()));
					dao.update(p);
					btnView.doClick();
				}
			});
			btnUpdate.setBounds(49, 421, 97, 23);
		}
		return btnUpdate;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				try {
					 int num = Integer.parseInt(tfNum.getText());
					 if(JOptionPane.showConfirmDialog(null,"정말 삭제할까요","삭제",JOptionPane.YES_NO_OPTION)
							 ==JOptionPane.NO_OPTION) 
						 return;
					 dao.delete(num);
					 btnView.doClick();
				 }catch(NumberFormatException n) {
					 JOptionPane.showMessageDialog(null, "숫자를 입력하세요");
				 }
			
				}
			});
			btnDelete.setBounds(180, 421, 97, 23);
		}
		return btnDelete;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setDividerSize(2);
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setLeftComponent(getScrollPane());
			splitPane_1.setRightComponent(getPanel_1());
			splitPane_1.setDividerLocation(350);
		}
		return splitPane_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTa());
		}
		return scrollPane;
	}
	private JTextArea getTa() {
		if (ta == null) {
			ta = new JTextArea();
		}
		return ta;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getComSearch());
			panel_1.add(getTfSearch());
			panel_1.add(getBtnSearch());
		}
		return panel_1;
	}
	private JComboBox getComSearch() {
		if (comSearch == null) {
			comSearch = new JComboBox();
			comSearch.setModel(new DefaultComboBoxModel(new String[] {"이름", "종목"}));
			comSearch.setBounds(12, 50, 51, 23);
		}
		return comSearch;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(78, 51, 149, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String field ="";
					if(comSearch.getSelectedIndex()==0) {
						field="name";
					}else if(comSearch.getSelectedIndex()==1) {
						field="kind";
					}
					String word = tfSearch.getText();
					if(word.isEmpty()) {
						JOptionPane.showMessageDialog(null, "검색어를 입력하세요");
						return;
					}
					ArrayList<Player> sarr = dao.search(field, word);
					ta.setText("");
					for(Player p : sarr) {
						ta.append("이름 : " + p.getName()+"\n");
						ta.append("키 : " + p.getHeight()+"\n");
						ta.append("몸무게 : " + p.getWeight()+"\n");
						ta.append("종목 : " + p.getKind()+"\n\n");
					}
				}
			});
			btnSearch.setBounds(239, 50, 72, 23);
		}
		return btnSearch;
	}
}
