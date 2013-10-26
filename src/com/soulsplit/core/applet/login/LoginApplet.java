package com.soulsplit.core.applet.login;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.ini4j.Wini;
import org.pushingpixels.substance.api.SubstanceConstants;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteGlassLookAndFeel;

import com.soulsplit.core.Data;
import com.soulsplit.core.api.Encryption;
import com.soulsplit.core.api.utils.Ini;
import com.soulsplit.core.applet.main.MainPanel;

import javax.swing.*;

import java.awt.event.*;

public class LoginApplet {

	/**
	 * @author Jordan/PriceJordan
	 * @author Yannick/P0wnd
	 * @author Mick/Virtual Void
	 **/

	private JFrame window = new JFrame("Login Panel");
	private JTextField textUser;
	private JPasswordField textPass;

	public LoginApplet() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					try {
						UIManager.setLookAndFeel(Ini.getSectionValueof(
								"Settings", "Theme"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					UIManager
							.put(SubstanceLookAndFeel.TABBED_PANE_CONTENT_BORDER_KIND,
									SubstanceConstants.TabContentPaneBorderKind.SINGLE_FULL);

					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);

				} catch (ClassNotFoundException | IllegalAccessException
						| InstantiationException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				JFrame.setDefaultLookAndFeelDecorated(true);
				JPopupMenu.setDefaultLightWeightPopupEnabled(false);
				window.setSize(299, 200);
				window.setLocationRelativeTo(null);
				window.setResizable(false);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JPanel panel = new JPanel();
				window.getContentPane().add(panel, BorderLayout.CENTER);
				panel.setLayout(null);

				JButton btnLogin = new JButton("Login");
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String user = null;
						String pass = null;
						try {
							pass = Encryption.decrypt(Ini.getSectionValueof(
									"Account", "Password"));
							user = Ini.getSectionValueof("Account", "Username");

							if (!textUser.getText().equals(user)
									&& textPass.getText().equals(pass))
								JOptionPane.showMessageDialog(null,
										"Incorrect username!",
										"Incorrect username!",
										JOptionPane.ERROR_MESSAGE);

							if (textUser.getText().equals(user)
									&& !textPass.getText().equals(pass))
								JOptionPane.showMessageDialog(null,
										"Incorrect password!",
										"Incorrect password!",
										JOptionPane.ERROR_MESSAGE);

							if (!textUser.getText().equals(user)
									&& !textPass.getText().equals(pass))
								JOptionPane.showMessageDialog(null,
										"Incorrect account details!",
										"Incorrect account details!",
										JOptionPane.ERROR_MESSAGE);

							if (textUser.getText().equals(user)
									&& textPass.getText().equals(pass))
								window.dispose();

						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							MainPanel p = new MainPanel();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}

				});
				btnLogin.setBounds(10, 142, 273, 23);
				panel.add(btnLogin);

				textUser = new JTextField();
				textUser.setBounds(91, 8, 192, 20);
				panel.add(textUser);
				textUser.setColumns(10);

				textPass = new JPasswordField();
				textPass.setBounds(91, 36, 192, 20);
				panel.add(textPass);

				JLabel lblUsername = new JLabel("Username");
				lblUsername.setBounds(10, 11, 71, 14);
				panel.add(lblUsername);

				JLabel lblPassword = new JLabel("Password");
				lblPassword.setBounds(10, 39, 71, 14);
				panel.add(lblPassword);

				JButton btnRegister = new JButton("Register");
				btnRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String user;
						String pass;
						JPasswordField passpane = new JPasswordField();
						user = JOptionPane.showInputDialog("Username: ");
						pass = JOptionPane.showInputDialog("Password: ");
						if (user.length() <= 2 || user.length() >= 13
								|| pass.length() <= 5 || pass.length() >= 15) {
							user = "";
							pass = "";

							JOptionPane
									.showMessageDialog(
											null,
											"Username must contain at least 3 characters and as maximum 12. "
													+ "Password must contain atleast 6 characters and as maximum 14 characters.",
											"Account Error",
											JOptionPane.ERROR_MESSAGE);

						} else {
							try {
								Wini ini = new Wini(new File(Data.ini
										.getAbsolutePath()));
								ini.add("Account", "Username", user);
								ini.add("Account", "Password",
										Encryption.encrypt(pass));
								ini.store();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				});

				btnRegister.setBounds(194, 67, 89, 23);
				panel.add(btnRegister);

				window.setVisible(true);
			}
		});
	}
}