package com.soulsplit.core.applet.boot;

import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileSystemView;

import org.ini4j.Wini;

import com.soulsplit.core.Data;
import com.soulsplit.core.Ini;
import com.soulsplit.core.api.utils.Utils;
import com.soulsplit.core.updater.Updater;

public class BootApplet extends JFrame{
		
	public BootApplet(){
		
		JDialog dialog = new JDialog();
		JLabel label = new JLabel();
		
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		dialog.setResizable(false);
		dialog.setSize(100,100);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		
		dialog.add(label, BorderLayout.CENTER);
		System.out.println(FileSystemView.getFileSystemView().getRoots()[0]);
		label.setText("Please wait a minute!");
		Updater.getLatestVersion();
		if(!Data.ini.exists()){
		//TODO Create ini File

}
	}
}
	
	

