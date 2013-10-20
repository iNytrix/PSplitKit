package com.soulsplit.core.applet.login;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.soulsplit.core.Data;

public class LoginApplet extends JFrame{
	JFrame frame = new JFrame(Data.APP_NAME + " Login Panel");
	JPanel panel = new JPanel();
	JTextField username, password = new JTextField();
	

	public LoginApplet(){
		
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setResizable(true);
		frame.setSize(450,300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.add(panel, BorderLayout.CENTER);

		String login;
		String password;
		
		
	}
}
