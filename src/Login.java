import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Database.DbInteraction;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends javax.swing.JFrame {
	DbInteraction dbInteraction;

	void minimize() {
		this.hide();
	}

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;

	public Login() {
		dbInteraction = new DbInteraction();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 547, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(291, 74, 64, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(291, 118, 64, 14);
		frame.getContentPane().add(lblPassword);

		JTextField txtUsername = new JTextField();
		txtUsername.setForeground(new Color(0, 0, 0));
		txtUsername.setBackground(new Color(255, 255, 255));
		txtUsername.setBounds(365, 70, 144, 23);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setBounds(365, 114, 144, 23);
		txtPassword.setEchoChar('*');
		frame.getContentPane().add(txtPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnLogin.setBounds(291, 217, 96, 23);
		btnLogin.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnLogin);

		JButton btnForgetPassword = new JButton("Forget Password");
		btnForgetPassword.setBounds(291, 183, 218, 23);
		btnForgetPassword.setBackground(new Color(255, 255, 255));

		frame.getContentPane().add(btnForgetPassword);

		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Register.run();
			}
		});
		btnRegister.setBounds(413, 217, 96, 23);
		btnRegister.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnRegister);

		JLabel lblPicture = new JLabel("New label");
		lblPicture.setIcon(new ImageIcon("C:\\Users\\etheng\\Desktop\\Admin.png"));
		lblPicture.setBounds(27, 49, 223, 225);
		frame.getContentPane().add(lblPicture);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember my login");
		chckbxNewCheckBox.setBounds(291, 147, 196, 29);
		frame.getContentPane().add(chckbxNewCheckBox);
	}

}
