package com.soulsplit.core.api.utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.ini4j.Wini;

import com.soulsplit.core.Data;

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
         
         public static String getSectionValueof(String value) throws IOException{
                 Wini ini = new Wini(new File(Data.ini.getAbsolutePath()));
                Map<String, String> map = ini.get("Settings");
                return map.get(value);
                
                 
         }
}
