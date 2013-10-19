package com.soulsplit.core;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ini4j.Wini;

public class Ini {

	 public static void getINI(String filename) throws IOException
	    {
	        Wini ini = new Wini(new File(filename));
	        String version = ini.get("Settings", "Version", String.class);
	       
}
	 public static void setINI() throws IOException
	 {
		 Wini ini = new Wini(new File(Data.ini.getAbsolutePath()));
		 ini.put("Settings", "Version", Data.MAJOR_VERSION + "." + Data.MINOR_VERSION);
		 ini.put("Settings", "Download", Data.DOWNLOAD_FILES);
		 ini.put("Account", "Username", "");
		 ini.put("Account", "Password", "");
		 ini.store();
		 
	 }
}
