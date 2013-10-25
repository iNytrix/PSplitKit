package com.soulsplit.core.applet.splashscreen;

import java.awt.Cursor;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import com.soulsplit.core.Data;
import com.soulsplit.core.api.utils.Ini;
import com.soulsplit.core.api.utils.Utils;
import com.soulsplit.core.applet.login.LoginApplet;
import com.soulsplit.core.updater.Updater;

public class Splashscreen {

	JWindow screen = new JWindow();
	final JProgressBar bar = new JProgressBar(0, 100); // TODO draw bar

	public Splashscreen() {
		try {
			screen.getContentPane().add(
					new JLabel("", new ImageIcon(new URL(
							"http://imgur.com/38o9pCL.png")),
							SwingConstants.CENTER));
			screen.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			screen.setSize(280, 180);
			screen.setLocationRelativeTo(null);
			screen.setVisible(true);
			screen.add(bar);
			bar.setIndeterminate(true);
			
			if (!Data.dir.exists())
				Utils.log("Makes");
					Data.dir.mkdir();

			if (!Data.ini.exists()) {
				if (Data.ini.createNewFile())
					Ini.setIni();
			}
			Ini.setVersion();
			Updater.getLatestVersion();
			screen.dispose();
			
			LoginApplet applet = new LoginApplet();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
