package edu.handong.csee.webpagecrawler;

import org.apache.commons.cli.*;
import java.util.*;

public class WebPageCrawler {
	private static String url; 
	private static String dirpath;

	public static void main(String[] args) {
		Options options = createOptions();
		if(parseOptions(options,args)) {
			ReadURL urlReader = new ReadURL(url);
			urlReader.readUrl();
			ArrayList<String> html = urlReader.getInfo();

			SaveURL urlSaver = new SaveURL(dirpath);
			urlSaver.writeUrl(html);
		}
	}

	public static Options createOptions() {
		Options options = new Options();  
		options.addOption(Option.builder("u").longOpt("url") 
				.desc("url that the html should be leading to") 
				.hasArg() 
				.argName("url") 
				.required() 
				.build());

		options.addOption(Option.builder("d").longOpt("dirpath")
				.desc("Set a directory path that saves the html file") 
				.hasArg() 
				.argName("File directory path") 
				.required() 
				.build()); 
		return options; 
	}

	public static boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args); 

			url = cmd.getOptionValue("u");
			dirpath = cmd.getOptionValue("d");

		} 
		catch (Exception e) {
			printHelp(options); 
			return false; 
		}

		return true; 
	}

	public static void printHelp(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		String header = "CLI test program"; 
		String footer ="\nPlease report issues at https://github.com/sekkaro/WebPageCrawler";
		formatter.printHelp("CLIExample", header, options, footer, true); 
	}

}
