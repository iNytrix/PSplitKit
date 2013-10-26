package com.soulsplit.core.applet.main;

import java.applet.Applet;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.pushingpixels.substance.api.SubstanceConstants;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteGlassLookAndFeel;

import com.soulsplit.core.Data;
import com.soulsplit.core.api.utils.Ini;
import com.soulsplit.loader.Main;

public class MainPanel extends JFrame{
	JFrame frame = new JFrame(Data.APP_NAME + " " + Data.CODENAME + " " + Ini.getVersion());
	Applet applet = new Applet();
	JMenuBar bar = new JMenuBar();
	
	public MainPanel(){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//Theme
				try {
					UIManager
							.setLookAndFeel(Ini.getSectionValueof("Settings", "Theme"));
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
	}

		});
}
}