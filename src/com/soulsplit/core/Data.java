package com.soulsplit.core;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

/**
 * 
 * @author Yannick
 *
 */
public class Data {
	//Account
	
	//INI
	public static boolean DOWNLOAD_FILES = false;
	
	//Misc
	public static File ROOT = FileSystemView.getFileSystemView().getRoots()[0]; //desktop
	
	//Version
	public static String APP_NAME = "SplitKit";
	public static String CODENAME = "Alpha";
	public static int MAJOR_VERSION = 1;
	public static int MINOR_VERSION = 15;
	
	//Files
	public static File dir = new File("C:/" + APP_NAME); 
	public static File plugin = new File(dir + "/plugins");
	public static File raw = new File(plugin + "/raw");
	public static File res = new File(dir +"/resources");
	public static String VERSION_URL = "https://dl.dropbox.com/s/fnalrn16h651drj/version.txt";
	public static File ini = new File(dir+ "/settings.ini");
	
}
