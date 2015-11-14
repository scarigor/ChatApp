import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import java.awt.CardLayout;

import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

public class Contacts extends JFrame {

	private JPanel contentPane;

	public Contacts() {
		Add frameAdd = new Add();
		frameAdd.setVisible(false);

		setResizable(false);
		setTitle("Contacts");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 310, 349);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList list = new JList();
		list.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		list.setBounds(10, 11, 274, 255);
		contentPane.add(list);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!frameAdd.isActive()) {
					try {

						frameAdd.setVisible(true);
					} catch (Exception E) {
						E.printStackTrace();
					}
				}
			}
		});
		btnAdd.setBounds(10, 277, 79, 23);
		contentPane.add(btnAdd);

		JButton button = new JButton("Edit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(99, 277, 89, 23);
		contentPane.add(button);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(198, 277, 89, 23);
		contentPane.add(btnRemove);
	}

}
