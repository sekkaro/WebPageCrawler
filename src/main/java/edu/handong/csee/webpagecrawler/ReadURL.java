package edu.handong.csee.webpagecrawler;

import java.io.*;
import java.net.*;
import java.util.*;

public class ReadURL {
	private String url;
	private URL newUrl;
	private ArrayList<String> html = new ArrayList<>();

	public ReadURL(String url) {
		this.url = url;
	}

	public void readUrl() {
		try {
			newUrl = new URL(url);

			BufferedReader in = new BufferedReader(new InputStreamReader(newUrl.openStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				html.add(inputLine);
			}
			in.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getInfo() {
		return html;
	}

}
