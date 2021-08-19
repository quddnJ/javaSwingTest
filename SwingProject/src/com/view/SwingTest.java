package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingTest extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingTest frame = new SwingTest();
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
	public SwingTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn = new JButton("클릭");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf.setText("안녕");
			}
		});
		btn.setBounds(45, 46, 97, 23);
		contentPane.add(btn);
		
		tf = new JTextField();
		tf.setBounds(177, 102, 148, 55);
		contentPane.add(tf);
		tf.setColumns(10);
		contentPane.add(getBtnNewButton());
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tf.setText("반갑습니다");
				}
			});
			btnNewButton.setBounds(30, 172, 97, 23);
		}
		return btnNewButton;
	}
}
