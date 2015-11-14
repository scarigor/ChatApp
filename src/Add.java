import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField ipField;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Add() {
		setResizable(false);
		setTitle("Editing contact");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 348, 198);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		nameField = new JTextField();
		nameField.setBounds(115, 18, 176, 29);
		contentPane.add(nameField);
		nameField.setColumns(10);

		ipField = new JTextField();
		ipField.setColumns(10);
		ipField.setBounds(115, 65, 176, 29);
		contentPane.add(ipField);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(24, 126, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nameField.setText("");
				ipField.setText("");
			}
		});

		btnClear.setBounds(123, 126, 89, 23);

		contentPane.add(btnClear);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(222, 126, 89, 23);
		contentPane.add(btnCancel);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(24, 11, 69, 43);
		contentPane.add(lblName);

		JLabel lblIpAdress = new JLabel("IP Adress");
		lblIpAdress.setBounds(24, 65, 69, 43);
		contentPane.add(lblIpAdress);
	}
}
