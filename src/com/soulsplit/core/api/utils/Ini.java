package com.soulsplit.core.api.utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

import com.soulsplit.core.Data;
import com.soulsplit.core.api.Encryption;

public class Ini {


         public static void setIni() throws IOException
         {
                 Wini ini = new Wini(new File(Data.ini.getAbsolutePath()));
                 ini.put("Settings", "Version", Data.MAJOR_VERSION + "." + Data.MINOR_VERSION);
                 ini.put("Settings", "Download", Data.DOWNLOAD_FILES);
                 ini.put("Account", "Username", "");
                 ini.put("Account", "Password", "");
                 ini.store();
                 
         }
         
         public static String getSectionValueof(String section, String value) throws IOException{
                 Wini ini = new Wini(new File(Data.ini.getAbsolutePath()));
                Map<String, String> map = ini.get(section);
                return map.get(value);
                 
         }
         
         public static void setVersion() throws IOException {
        	 Wini ini = new Wini(new File(Data.ini.getAbsolutePath()));
        	 ini.put("Settings", "Version", Data.MAJOR_VERSION + "." + Data.MINOR_VERSION);
        	 ini.store();
         }
         
         public static String getVersion(){
        	 Wini ini = null;
			try {
				ini = new Wini(new File(Data.ini.getAbsolutePath()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 return ini.get("Settings", "Version");
         }
}
