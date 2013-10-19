package com.soulsplit.core.updater;

import java.awt.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

import com.soulsplit.core.Data;

/**
 * 
 * @author Yannick
 *
 */
public class Updater {

	static File dir = new File("C:/" + Data.APP_NAME);
	  static File cv = new File("C:/SplitKit/cversion.txt");

	  public static int c_version = Data.MAJOR_VERSION + Data.MINNOR_VERSION;
	  public static int n_version;

	  public static void main(String[] args)
	    throws IOException
	  {
	    getLatestVersion();
	  }

	  public static boolean getLatestVersion() {
	    if ((!dir.exists()) || (!cv.exists())) {
	      log("Creating Directory");
	      makeDir();
	    } else {
	      getUrl();
	    }
	    return false;
	  }

	  private static void getUrl()
	  {
	    try
	    {
	      URL url = new URL("https://dl.dropbox.com/s/fnalrn16h651drj/version.txt");
	      URLConnection c = url.openConnection();
	      DataInputStream in = new DataInputStream(c.getInputStream());
	      byte[] fileData = new byte[c.getContentLength()];
	      for (int q = 0; q < fileData.length; q++) {
	        fileData[q] = in.readByte();
	      }
	      in.close();
	      FileOutputStream out = new FileOutputStream(new File("C:/SplitKit/version.txt"));
	      out.write(fileData);
	      out.close();
	      System.out.println("Got latest version id downloaded.");
	    }
	    catch (Exception m) {
	      System.out.println(m);
	    }
	    getVersion();
	  }

	  private static void getVersion()
	  {
	    String text = "";
	    int N = 1048576;
	    char[] buffer = new char[N];
	    try {
	      FileReader fr = new FileReader("C:/SplitKit/version.txt");
	      BufferedReader br = new BufferedReader(fr);
	      int read;
	      do { read = br.read(buffer, 0, N);
	        text = text + new String(buffer, 0, read);
	      }
	      while (read >= N);
	    }
	    catch (Exception ex)
	    {
	      ex.printStackTrace();
	    }
	    n_version = Integer.parseInt(text);
	    System.out.println(n_version);

	    if (!isUpToDate()) {
	      log("We're updating the tool!");
	      update();
	    } else {
	      log("Tool is up to date!");
	      setCurrentVersion();
	    }
	  }

	  private static void update()
	  {
	    try
	    {
	      URL url = new URL("https://dl.dropbox.com/s/7gnib7xednnnlzg/SplitKit.jar");
	      URLConnection c = url.openConnection();
	      DataInputStream in = new DataInputStream(c.getInputStream());
	      byte[] fileData = new byte[c.getContentLength()];
	      for (int q = 0; q < fileData.length; q++) {
	        fileData[q] = in.readByte();
	      }
	      FileOutputStream out = new FileOutputStream(new File("C:/SplitKit/SplitKit.jar"));
	      out.write(fileData);
	      out.close();
	      in.close();
	      System.out.println("Downloaded newest version!");
	      c_version = n_version;
	    }
	    catch (Exception m) {
	      System.out.println(m);
	    }
	    if (isUpToDate()) {
	      log("Updated!");
	      setCurrentVersion();
	    }
	  }

	  private static void setCurrentVersion() {
	    try {
	      String text = Integer.toString(n_version);
	      BufferedWriter out = new BufferedWriter(new FileWriter("C:/SplitKit/cversion.txt"));
	      out.write(text);
	      out.close();
	    }
	    catch (IOException e)
	    {
	      System.out.println(e);
	    }
	  }

	  private static boolean isUpToDate()
	  {
	    return c_version == n_version;
	  }

	  private static void makeDir() {
	    if (!dir.exists()) {
	      dir.mkdir();
	      log("Dir made.");
	    }
	    if ((dir.exists()) && (!cv.exists())) {
	      String text = Integer.toString(c_version);
	      try {
	        BufferedWriter op = new BufferedWriter(new FileWriter(cv));
	        op.write(text);
	        op.close();
	        log("cv made.");
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    }

	    getUrl();
	  }
	  public static void log(String line) {
	    System.out.println(line);
	  }
}
