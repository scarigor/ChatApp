import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.SystemColor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Insets;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainGUI {

	JFrame frameMain;
	JTextField textArea;

	public static void main(String[] args) {
		
	}

	public MainGUI() {
		initialize();
	}

	void initialize() {
		Contacts frameCont = new Contacts();
		frameCont.setVisible(false);

		frameMain = new JFrame();
		frameMain.setResizable(false);
		frameMain.setVisible(true);
		frameMain.setTitle("ChatApp");
		frameMain.setBackground(Color.WHITE);

		frameMain.setBounds(350, 150, 597, 424);
		frameMain.getContentPane().setBackground(
				UIManager.getColor("Table.gridColor"));
		frameMain.getContentPane().setLayout(null);

		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Панель логина

		JPanel loginPanel = new JPanel();
		loginPanel.setBorder(new LineBorder(SystemColor.activeCaption));
		loginPanel.setBackground(UIManager.getColor("Viewport.background"));
		loginPanel.setBounds(10, 11, 219, 127);
		frameMain.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);

		JLabel lblLogin = new JLabel("Your Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(50, 24, 106, 23);
		loginPanel.add(lblLogin);

		JTextField loginField = new JTextField();
		loginField.setHorizontalAlignment(SwingConstants.CENTER);
		loginField.setBounds(43, 46, 132, 20);
		loginPanel.add(loginField);
		loginField.setColumns(10);

		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loginField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Invalid Login!");
				}
			}
		});
		btnApply.setBackground(UIManager
				.getColor("InternalFrame.activeTitleBackground"));
		btnApply.setBounds(62, 77, 94, 23);
		loginPanel.add(btnApply);

		// Панель пользователя

		JPanel remotePanel = new JPanel();
		remotePanel.setBorder(new LineBorder(SystemColor.activeCaption));
		remotePanel.setLayout(null);
		remotePanel.setBackground(UIManager.getColor("Viewport.background"));
		remotePanel.setBounds(10, 142, 219, 243);
		frameMain.getContentPane().add(remotePanel);

		JTextField remoteIPField = new JTextField();
		remoteIPField.setBounds(43, 30, 132, 20);
		remoteIPField.setColumns(10);
		remotePanel.add(remoteIPField);

		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (remoteIPField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Invalid IP adress!");
				}
			}
		});

		btnConnect.setBackground(UIManager
				.getColor("InternalFrame.activeTitleBackground"));
		btnConnect.setBounds(53, 61, 110, 23);
		remotePanel.add(btnConnect);

		JLabel lblRemoteIp = new JLabel("Remote IP");
		lblRemoteIp.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoteIp.setBounds(50, 11, 106, 23);
		remotePanel.add(lblRemoteIp);

		JButton btnDisconnect = new JButton("Disconnect");
		btnDisconnect.setBackground(UIManager
				.getColor("InternalFrame.activeTitleBackground"));
		btnDisconnect.setBounds(52, 90, 110, 23);
		remotePanel.add(btnDisconnect);

		JLabel lblRemoteLogin = new JLabel("Remote Login");
		lblRemoteLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoteLogin.setBounds(60, 124, 96, 23);
		remotePanel.add(lblRemoteLogin);

		JButton btnContacts = new JButton("Contacts");
		btnContacts.setBackground(UIManager
				.getColor("InternalFrame.activeTitleBackground"));
		btnContacts.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (!frameCont.isActive()) {
					try {
						frameCont.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		});
		btnContacts.setBounds(60, 177, 96, 23);
		remotePanel.add(btnContacts);

		JTextField remoteLoginField = new JTextField();
		remoteLoginField.setEditable(false);
		remoteLoginField.setBounds(43, 146, 132, 20);
		remoteLoginField.setBackground(Color.WHITE);
		remoteLoginField.setColumns(10);
		remotePanel.add(remoteLoginField);

// Панель сообщений

		JPanel messPanel = new JPanel();
		messPanel.setBorder(null);
		messPanel.setLayout(null);
		messPanel.setBackground(Color.WHITE);
		messPanel.setBounds(243, 11, 338, 374);
		frameMain.getContentPane().add(messPanel);

		JTextField typingField = new JTextField("Type your message here...");
		typingField.setAlignmentX(Component.LEFT_ALIGNMENT);
		typingField.setBorder(new LineBorder(UIManager
				.getColor("Table.focusCellForeground")));
		typingField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				typingField.setText("");
			}
		});

		textArea = new JTextField();
		textArea.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textArea.setAlignmentX(Component.LEFT_ALIGNMENT);
		textArea.setEditable(false);
		textArea.setMargin(new Insets(290, 6, 2, 2));
		textArea.setHorizontalAlignment(SwingConstants.LEFT);
		textArea.setBounds(10, 11, 319, 318);
		messPanel.add(textArea);
		textArea.setColumns(10);

		typingField.setFont(new Font("Verdana", Font.PLAIN, 9));
		typingField.setBackground(Color.WHITE);
		typingField.setBounds(10, 340, 241, 23);
		messPanel.add(typingField);
		typingField.setColumns(10);

		JButton btnSend = new JButton("Send");
		btnSend.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!typingField.getText().isEmpty()) {
					textArea.setText("user1: " + typingField.getText());
					typingField.setText(null);
				}
			}
		});
		btnSend.setBounds(254, 340, 75, 23);
		messPanel.add(btnSend);

	}
}