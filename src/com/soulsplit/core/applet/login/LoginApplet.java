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

public class LoginApplet extends JFrame{
	private JFrame frame = new JFrame(Data.APP_NAME + " Login Panel");
	private JButton logButton = new JButton("Login");
	private JPanel loginPanel;
	
	private JLabel usernameL, passwordL = new JLabel();
	private JTextField usernameTxt = new JTextField(13); //chars
	private JPasswordField passwordTxt = new JPasswordField(13); //chars
	
	public LoginApplet(){
	frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	frame.setSize(250,200);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	frame.setVisible(true);
	
	loginPanel = new JPanel(new BorderLayout());
	frame.add(loginPanel, BorderLayout.CENTER);
	
	loginPanel.add(logButton, BorderLayout.SOUTH);
	
	}
}
