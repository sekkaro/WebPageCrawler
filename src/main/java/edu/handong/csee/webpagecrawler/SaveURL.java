package edu.handong.csee.webpagecrawler;

import java.io.*;
import java.util.*;

public class SaveURL {
	private String dirpath;

	public SaveURL(String dirpath) {
		this.dirpath = dirpath;
	}

	public void writeUrl(ArrayList<String> html) {
		try {
			File file = new File(dirpath+File.separator+"url.html");
			file.createNewFile();
			BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			for(String line : html) {
				outputStream.write(line + "\n");
			}
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
