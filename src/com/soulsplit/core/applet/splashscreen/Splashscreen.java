package com.soulsplit.core.applet.splashscreen;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import com.soulsplit.core.Data;
import com.soulsplit.core.api.utils.Ini;
import com.soulsplit.core.applet.login.LoginApplet;
import com.soulsplit.core.updater.Updater;

public class Splashscreen{
	
	JWindow screen = new JWindow();
	
	public Splashscreen () {
		try {
			screen.getContentPane().add(new JLabel("", new ImageIcon(new URL("http://imgur.com/38o9pCL.png")),SwingConstants.CENTER));
		screen.setSize(280, 180);
		screen.setLocationRelativeTo(null);
		screen.setVisible(true);

		Updater.getLatestVersion();
		if(!Data.ini.exists()){
			if(Data.ini.createNewFile());
		Ini.setIni();
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		screen.dispose();
		LoginApplet applet = new LoginApplet();
	}
}

