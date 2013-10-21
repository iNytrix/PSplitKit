package com.soulsplit.core.api.utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

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
         
         public static String getSelectionValueof(String section, String value) throws IOException{
                 Wini ini = new Wini(new File(Data.ini.getAbsolutePath()));
                Map<String, String> map = ini.get(section);
                return map.get(value);
                 
         }
         
         public static void setAccount() throws IOException{
        		Wini ini = new Wini(new File(Data.ini.getAbsolutePath()));
        	 ini.add("Account", "Password", Encryption.encrypt(Data.PASSWORD));
        		ini.add("Account", "Username", Data.USERNAME);
        		ini.store();
         }
}
