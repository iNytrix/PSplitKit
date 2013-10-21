package com.soulsplit.core.applet.login;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.io.*;

public class LoginApplet {
	
	/**
	 * @Author Jordan/PriceJordan
	 **/
	
	private JFrame window = new JFrame("Login Panel");
	private JTextField textUser;
	private JPasswordField textPass;

	public LoginApplet() {
		window.setSize(299, 200);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		window.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = null;
				String pass = null;
				BufferedReader br = null;
				try {
					String CurrentLine;

					br = new BufferedReader(new FileReader(
							"C:/JSplit/Creds.txt"));

					while ((CurrentLine = br.readLine()) != null) {
						if (CurrentLine.startsWith("Username")) {
							user = CurrentLine.substring(10);
						} else if (CurrentLine.startsWith("Password")) {
							pass = CurrentLine.substring(10);
						}
					}

					if (textUser.getText().equals(user)
							&& textPass.getText().equals(Encryption.decrypt(pass))) {
							//Open main program
						window.dispose();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(10, 142, 273, 23);
		panel.add(btnLogin);

		textUser = new JTextField();
		textUser.setBounds(91, 8, 192, 20);
		panel.add(textUser);
		textUser.setColumns(10);

		textPass = new JPasswordField();
		textPass.setBounds(91, 36, 192, 20);
		panel.add(textPass);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 11, 71, 14);
		panel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 39, 71, 14);
		panel.add(lblPassword);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user;
				String pass;
				user = JOptionPane.showInputDialog("Username: ");
				pass = JOptionPane.showInputDialog("Password: ");
				if (user.length() <= 2 || user.length() >= 13
						|| pass.length() <= 5 || pass.length() >= 15) {
					user = "";
					pass = "";
					
					//Add messagebox saying that the length is not right
					
				} else {
					try {
						File writeCreds = new File("C:/JSplit/Creds.txt");

						if (!writeCreds.exists()) {
							writeCreds.createNewFile();
						}

						FileWriter fw = new FileWriter(writeCreds
								.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write("Username: " + user + "\nPassword: "
								+ Encryption.encrypt(pass));
						bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnRegister.setBounds(194, 67, 89, 23);
		panel.add(btnRegister);

		window.setVisible(true);
	}
}
