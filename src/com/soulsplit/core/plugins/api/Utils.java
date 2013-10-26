package com.soulsplit.core.plugins.api;

import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.crypto.dsig.spec.XPathType.Filter;

import org.pushingpixels.substance.api.SubstanceConstants;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;

import com.soulsplit.core.Data;

public class Utils {

	public static void setTheme(String scheme){
		try {
			UIManager
					.setLookAndFeel(scheme);
			UIManager
					.put(SubstanceLookAndFeel.TABBED_PANE_CONTENT_BORDER_KIND,
							SubstanceConstants.TabContentPaneBorderKind.SINGLE_FULL);

			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
		} catch (UnsupportedLookAndFeelException  | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static void getPlugins(){
		File folder = new File(Data.plugin.getAbsolutePath());
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println("File " + listOfFiles[i].getName());
		      } 
		    }
	}
	
	/**
	 * @author developers
	 * @return Returns one type files
	 */
	public static void getPlugins(String fileType){
		File folder = new File(Data.plugin.getAbsolutePath());
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].getName().endsWith(fileType)) {
		        System.out.println("File " + listOfFiles[i].getName());
		      }
		    }
	}
}
