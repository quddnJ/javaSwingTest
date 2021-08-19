package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.model.Book;
import com.model.BookDBA;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookView extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JSplitPane splitPane_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField tfTitle;
	private JTextField tfWriter;
	private JTextField tfIndate;
	private JTextField tfOutdate;
	private JTextField tfGubun;
	private JTextField tfPrice;
	private JButton btnInsert;
	private JSplitPane splitPane_2;
	private JScrollPane scrollPane_1;
	private JTextArea taView;
	private JPanel panel_1;
	private JButton btnView;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JComboBox cb;
	private JTextField tfSearch;
	BookDBA dao = new BookDBA();
	ArrayList<Book> arr;
	int selectedNum = 0; //////////////////num

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookView frame = new BookView();
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
	public BookView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setDividerSize(2);
			splitPane.setLeftComponent(getSplitPane_1());
			splitPane.setRightComponent(getSplitPane_2());
			splitPane.setDividerLocation(300);
		}
		return splitPane;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setLeftComponent(getScrollPane());
			splitPane_1.setRightComponent(getPanel());
			splitPane_1.setDividerLocation(200);
		}
		return splitPane_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int i = table.getSelectedRow(); //테이블에 선택된 행의 인덱스 값
					//taView에 출력
					taView.append("번호 : " + arr.get(i).getNum() + "\n");
					taView.append("제목 : " + arr.get(i).getTitle() + "\n");
					taView.append("저자 : " + arr.get(i).getWriter() + "\n");
					taView.append("입고일 : " + arr.get(i).getIndate() + "\n");
					taView.append("출고일 : " + arr.get(i).getOutdate() + "\n");
					taView.append("구분 : " + arr.get(i).getGubun() + "\n");
					taView.append("가격 : " + arr.get(i).getPrice() + "\n");
					taView.append("---------------------------------\n");
					
					//입력 textField에 출력
					tfTitle.setText(arr.get(i).getTitle());
					tfWriter.setText(arr.get(i).getWriter());
					tfIndate.setText(arr.get(i).getIndate());
					tfOutdate.setText(arr.get(i).getOutdate());
					tfGubun.setText(arr.get(i).getGubun());
					tfPrice.setText(arr.get(i).getPrice()+"");
					
					selectedNum = arr.get(i).getNum();////////////
				}
			});
			
			String[] cols = {"TITLE", "WRITER", "OUTDATE", "PRICE"};
			DefaultTableModel dt = new DefaultTableModel(cols, 0);
			table.setModel(dt);
			
			
		}
		return table;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getLblNewLabel_1());
			panel.add(getLblNewLabel_2());
			panel.add(getLblNewLabel_3());
			panel.add(getLblNewLabel_4());
			panel.add(getLblNewLabel_5());
			panel.add(getTfTitle());
			panel.add(getTfWriter());
			panel.add(getTfIndate());
			panel.add(getTfOutdate());
			panel.add(getTfGubun());
			panel.add(getTfPrice());
			panel.add(getBtnInsert());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("제목");
			lblNewLabel.setBounds(12, 33, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("저자");
			lblNewLabel_1.setBounds(12, 81, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("입고날짜");
			lblNewLabel_2.setBounds(12, 129, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("출고날짜");
			lblNewLabel_3.setBounds(12, 177, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("분류");
			lblNewLabel_4.setBounds(12, 225, 57, 15);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("가격");
			lblNewLabel_5.setBounds(12, 273, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JTextField getTfTitle() {
		if (tfTitle == null) {
			tfTitle = new JTextField();
			tfTitle.setBounds(93, 30, 173, 21);
			tfTitle.setColumns(10);
		}
		return tfTitle;
	}
	private JTextField getTfWriter() {
		if (tfWriter == null) {
			tfWriter = new JTextField();
			tfWriter.setBounds(93, 78, 173, 21);
			tfWriter.setColumns(10);
		}
		return tfWriter;
	}
	private JTextField getTfIndate() {
		if (tfIndate == null) {
			tfIndate = new JTextField();
			tfIndate.setBounds(93, 126, 173, 21);
			tfIndate.setColumns(10);
		}
		return tfIndate;
	}
	private JTextField getTfOutdate() {
		if (tfOutdate == null) {
			tfOutdate = new JTextField();
			tfOutdate.setBounds(93, 174, 173, 21);
			tfOutdate.setColumns(10);
		}
		return tfOutdate;
	}
	private JTextField getTfGubun() {
		if (tfGubun == null) {
			tfGubun = new JTextField();
			tfGubun.setBounds(93, 222, 173, 21);
			tfGubun.setColumns(10);
		}
		return tfGubun;
	}
	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setBounds(93, 270, 173, 21);
			tfPrice.setColumns(10);
		}
		return tfPrice;
	}
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("입력하기");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String title = tfTitle.getText();
					String writer = tfWriter.getText();
					String indate = tfIndate.getText();
					String outdate = tfOutdate.getText();
					String gubun = tfGubun.getText();
					int price = Integer.parseInt(tfPrice.getText());
					Book book = new Book(title, writer, indate, outdate, gubun, price);
					dao.bookInsert(book);
					btnView.doClick();
					clearTextField();
				}
			});
			btnInsert.setBounds(93, 301, 108, 32);
		}
		return btnInsert;
	}
	private JSplitPane getSplitPane_2() {
		if (splitPane_2 == null) {
			splitPane_2 = new JSplitPane();
			splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_2.setLeftComponent(getScrollPane_1());
			splitPane_2.setRightComponent(getPanel_1());
			splitPane_2.setDividerLocation(400);
		}
		return splitPane_2;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTaView());
		}
		return scrollPane_1;
	}
	private JTextArea getTaView() {
		if (taView == null) {
			taView = new JTextArea();
		}
		return taView;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getBtnView());
			panel_1.add(getBtnUpdate());
			panel_1.add(getBtnDelete());
			panel_1.add(getCb());
			panel_1.add(getTfSearch());
		}
		return panel_1;
	}
	private JButton getBtnView() {
		if (btnView == null) {
			btnView = new JButton("목록");
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					taView.setText("");
					arr = dao.bookSelectAll();
					//taView에 출력//					for(Book b : arr) {
//						taView.append("번호   : " + b.getNum() + "\n");
//						taView.append("제목   : " + b.getTitle() + "\n");
//						taView.append("저자   : " + b.getWriter() + "\n");
//						taView.append("가격   : " + b.getPrice() + "\n");
//						taView.append("-------------------------" + "\n");
//					}
					
					//table에 출력
					String[] cols = {"TITLE", "WRITER", "OUTDATE", "PRICE"};
					DefaultTableModel dt = new DefaultTableModel(cols, arr.size());
					table.setModel(dt);
					for(int i = 0; i < arr.size(); i++) {
						dt.setValueAt(arr.get(i).getTitle(), i, 0);
						dt.setValueAt(arr.get(i).getWriter(), i, 1);
						dt.setValueAt(arr.get(i).getOutdate(), i, 2);
						dt.setValueAt(arr.get(i).getPrice(), i, 3);
					}
				}
			});
			btnView.setBounds(19, 10, 63, 23);
		}
		return btnView;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(selectedNum == 0) {
						JOptionPane.showMessageDialog(null, "수정번호 선택");
						return;
					}
					String title = tfTitle.getText();
					String writer = tfWriter.getText();
					String indate = tfIndate.getText();
					String outdate = tfOutdate.getText();
					String gubun = tfGubun.getText();
					int price = Integer.parseInt(tfPrice.getText());
					Book book = new Book(title, writer, indate, outdate, gubun, price);
					book.setNum(selectedNum);
					dao.bookUpdate(book);
					btnView.doClick();
					clearTextField();
				}
			});
			btnUpdate.setBounds(101, 10, 63, 23);
		}
		return btnUpdate;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(selectedNum == 0) {
						JOptionPane.showMessageDialog(null, "삭제번호 선택");
						return;
					}
					if(JOptionPane.showConfirmDialog(null, "정말 삭제할까요?", "삭제", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.CANCEL_OPTION) {
						return;
					}
					dao.bookDelete(selectedNum);
					btnView.doClick();
					clearTextField();
				}
			});
			btnDelete.setBounds(183, 10, 63, 23);
		}
		return btnDelete;
	}
	private JComboBox getCb() {
		if (cb == null) {
			cb = new JComboBox();
			cb.setModel(new DefaultComboBoxModel(new String[] {"제목", "저자", "구분"}));
			cb.setBounds(19, 47, 63, 23);
		}
		return cb;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					taView.setText("");
					int idx = cb.getSelectedIndex();
					String field = "title"; // 제목,저자,구분
					if(idx==1) {
						field = "writer";
					}else if (idx==2) {
						field ="gubun";
					}
					String word = tfSearch.getText();
					ArrayList<Book>sarr=dao.bookSearch(field,word);
					for(Book b : sarr) {
						taView.append("제목: " + b.getTitle()+"\n");
						taView.append("저자: " + b.getWriter()+"\n");
						taView.append("가격: " + b.getPrice()+"\n");
						taView.append("구분: " + b.getGubun()+"\n\n");
					}
				}
			});
			tfSearch.setBounds(101, 48, 145, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	
	private void clearTextField() {
		tfTitle.setText("");
		tfWriter.setText("");
		tfIndate.setText("");
		tfOutdate.setText("");
		tfGubun.setText("");
		tfPrice.setText("");
	}
}
