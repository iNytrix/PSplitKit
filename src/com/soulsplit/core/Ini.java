package com.soulsplit.core;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

public class INI {

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
	 
	 public static String getSelectionValueof(String value) throws IOException{
		 Wini ini = new Wini(new File(Data.ini.getAbsolutePath()));
		Map<String, String> map = ini.get("Settings");
		String v = map.get(value);
		return v;
		 
	 }
}
