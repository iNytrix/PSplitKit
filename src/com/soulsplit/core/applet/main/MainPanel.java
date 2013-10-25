package com.soulsplit.core.applet.main;

import java.applet.Applet;

import javax.swing.JFrame;

import com.soulsplit.core.Data;
import com.soulsplit.core.api.utils.Ini;
import com.soulsplit.loader.Main;

public class MainPanel extends JFrame{
	JFrame frame = new JFrame(Data.APP_NAME + " " + Data.CODENAME + " " + Ini.getVersion());
	Applet applet = new Applet();
	
	public MainPanel(){
		frame.setSize(getMaximumSize());
		frame.setVisible(true);
		
		frame.add(applet);
		

		
	}
}
