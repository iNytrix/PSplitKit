package com.soulsplit.core.applet.login;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

import com.soulsplit.core.Data;
import com.soulsplit.core.api.Encryption;
import com.soulsplit.core.api.utils.Ini;

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
					//TODO add Ini file reading support
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
				//TODO add register method
			}
		});
		btnRegister.setBounds(194, 67, 89, 23);
		panel.add(btnRegister);

		window.setVisible(true);
	}
}
