package com.soulsplit.core.api.utils;

import java.awt.Image;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Time;

import javax.imageio.ImageIO;

public class Utils {

	public static void getUrl(String link, String dir){
		URL url;
		URLConnection c;
		DataInputStream in;
		FileOutputStream out;
		byte[] fileData;
		try {
			url = new URL(link);
			c = url.openConnection();
			in = new DataInputStream(c.getInputStream());
			fileData = new byte[c.getContentLength()];
			for (int q = 0; q < fileData.length; q++){
				fileData[q] = in.readByte();
			}
			out = new FileOutputStream(new File(dir));
			out.write(fileData);
			out.close();
			in.close();
			log(url + " " + dir);
		} catch (Exception m) {
			System.out.println(m);
		}
	}
	
	public static void log(String line){
		System.out.println(line);
	}
	
	public static Image getImage(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (IOException e) {
			return null;
		}
	}
	
	
}
