package com.soulsplit.core.applet.main;

import java.applet.Applet;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.pushingpixels.substance.api.SubstanceConstants;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteGlassLookAndFeel;

import com.soulsplit.core.Data;
import com.soulsplit.core.api.utils.Ini;
import com.soulsplit.core.api.utils.Utils;
import com.soulsplit.loader.Main;

public class MainPanel extends JFrame {
	JFrame frame = new JFrame(Data.APP_NAME + " " + Data.CODENAME + " "
			+ Ini.getVersion());
	Applet applet = new Applet();
	JMenuBar bar = new JMenuBar();
	JMenu menu = new JMenu("Profile");
	JMenu pluginMenu = new JMenu("Plugin");
	JFileChooser chooser = new JFileChooser();
	JMenuItem menuItem1;
	JMenuItem menuItem2;
	JMenuItem menuItem3;
	

	FileNameExtensionFilter filterClass = new FileNameExtensionFilter("Class files","class");
	FileNameExtensionFilter filterJava = new FileNameExtensionFilter("Java files","java");
	
	 public Process p;
	
	public MainPanel() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Frame //
				try {
					UIManager.setLookAndFeel(Ini.getSectionValueof("Settings",
							"Theme"));
					UIManager
							.put(SubstanceLookAndFeel.TABBED_PANE_CONTENT_BORDER_KIND,
									SubstanceConstants.TabContentPaneBorderKind.SINGLE_FULL);

					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

				frame.setVisible(true);
				frame.setExtendedState(MAXIMIZED_BOTH);
				frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

				// Menu //
				menu.setMnemonic(KeyEvent.VK_A);
				menu.getAccessibleContext().setAccessibleDescription("p");
				
				bar.add(menu);
				menu.add(pluginMenu);

				menuItem1 = new JMenuItem("Load plugin");
				menuItem2 = new JMenuItem("Stop plugin");
				menuItem3 = new JMenuItem("Add plugin");
				
				pluginMenu.add(menuItem1);
				pluginMenu.add(menuItem2);
				pluginMenu.add(menuItem3);
				
				frame.setJMenuBar(bar);
				
				// Load plugin //
				menuItem1.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						chooser.setCurrentDirectory(new File(Data.plugin.getAbsolutePath()));
						chooser.setDialogTitle("Plugin Loader");
						chooser.setSize(400,400);
						chooser.setFileFilter(filterClass);
						chooser.showOpenDialog(null);
						
						File file = chooser.getSelectedFile();
						if(file.canExecute()){
							try {
								p = Runtime.getRuntime().exec("cmd /c start " + file.getAbsolutePath());
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						}
					
				});
				// Stop plugin //
				menuItem2.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						p.destroy();
						System.gc();
					}
				});
				// add plugin //
				menuItem3.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO compile raw .java version to class and save to plugins.
						chooser.setCurrentDirectory(new File(Data.raw.getAbsolutePath()));
						chooser.setDialogTitle("Plugin Loader");
						chooser.setSize(400,400);
						chooser.setFileFilter(filterClass);
						chooser.showOpenDialog(null);
						
						File file = chooser.getSelectedFile();
						
					}
				});

			}

		});
	}
}