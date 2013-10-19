package com.soulsplit.core.applet.login;

import javax.swing.JFrame;
import com.soulsplit.core.Data;

public class LoginApplet {

	public LoginApplet(){
		JFrame frame = new JFrame(Data.APP_NAME + " Login Panel");
		
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
	}
}
