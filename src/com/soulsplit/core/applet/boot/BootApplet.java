package com.soulsplit.core.applet.boot;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileSystemView;

import com.soulsplit.core.Data;
import com.soulsplit.core.api.utils.Ini;
import com.soulsplit.core.applet.login.LoginApplet;
import com.soulsplit.core.updater.Updater;

public class BootApplet extends JFrame{
	
	public BootApplet(){
		
		JDialog dialog = new JDialog();
		JLabel label = new JLabel();
		
		dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		dialog.setResizable(false);
		dialog.setSize(130,100);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		
		dialog.add(label, BorderLayout.CENTER);
		System.out.println(FileSystemView.getFileSystemView().getRoots()[0]);
		label.setText("Please wait a minute!");
		Updater.getLatestVersion();
		try {
			label.setText("Creating settings.");
		if(!Data.ini.exists()){
			if(Data.ini.createNewFile());
		Ini.setIni();
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dialog.dispose();
		LoginApplet lg = new LoginApplet();
	}
}
	
	

