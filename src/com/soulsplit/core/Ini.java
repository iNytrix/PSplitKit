package com.soulsplit.core;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.ini4j.Wini;

public class Ini {

	 public static void getINI(String filename) throws IOException
	    {
	        Wini ini = new Wini(new File(filename));
	        String age = ini.get("Main Settings", "Version", String.class);
	       
}
	 public static void setINI(String filename) throws IOException
	 {
		 Wini ini = new Wini(new File(filename));
		 ini.put("Main Settings", "Version", Data.MAJOR_VERSION + "." + Data.MINNOR_VERSION);
		 ini.store();
		 
	 }
	 public static void createIni(File file) throws IOException
	    {
	        Wini ini = new Wini();
	        ini = new Wini(new FileReader(file));
	        File copy = File.createTempFile("Settings", ".ini");
	        ini.store(copy);
}
}
