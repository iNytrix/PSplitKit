package com.soulsplit.core.applet.splashscreen;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import com.soulsplit.core.Data;
import com.soulsplit.core.api.utils.Ini;
import com.soulsplit.core.applet.login.LoginApplet;
import com.soulsplit.core.updater.Updater;

public class Splashscreen{
	
	JWindow screen = new JWindow();
	final JProgressBar bar = new JProgressBar(0,100); //TODO draw bar
	
	public Splashscreen (){
		try {
		screen.getContentPane().add(new JLabel("", new ImageIcon(new URL("http://imgur.com/38o9pCL.png")),SwingConstants.CENTER));
		screen.setSize(280, 180);
		screen.setLocationRelativeTo(null);
		screen.setVisible(true);
		screen.add(bar);
		
		bar.setIndeterminate(true);
		

		Updater.getLatestVersion();
		if(!Data.ini.exists()){
			if(Data.ini.createNewFile());
		Ini.setIni();
		}
		screen.dispose();
		LoginApplet applet = new LoginApplet();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

