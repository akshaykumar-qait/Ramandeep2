package com.qainfotech.tap.training.resourceio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class PropertiesOptionsIO {

	public Object getOptionValue(String optionKey) throws IOException {

		Object my;
		String temp = "";
		try {

			File f = new File("src/main/resources/options.properties");

			BufferedReader b = new BufferedReader(new FileReader(f));

			String readLine = "";

			//System.out.println("Reading file using Buffered Reader "+optionKey);

			String arrsplit[];
			while ((readLine = b.readLine()) != null) {
				// System.out.println(readLine);
				arrsplit = readLine.split("=");
				//System.out.println(arrsplit[0] + "  here   " + arrsplit[1]);

				if (arrsplit[0].equals( optionKey)) {
					my = arrsplit[1];

					return my;
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public void addOption(String optionKey, Object optionValue) throws IOException {

		File f = new File("src/main/resources/options.properties");

		String readLine = "",olddata="";
		BufferedReader b = new BufferedReader(new FileReader(f));
		while ((readLine = b.readLine()) != null)
		   {

			if(olddata=="")
			{
			olddata=olddata+readLine;
			}
			else
			{
				olddata=olddata+"\n"+readLine;
				
			}
			}

		olddata=olddata+"\n";
		
		try {
			FileWriter fw = new FileWriter("src/main/resources/options.properties");
			fw.append(olddata+optionKey+"="+optionValue.toString());
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		System.out.println("Success...");

		throw new UnsupportedOperationException("Not implemented.");
	}

	public static void main(String... S) throws IOException {

		new PropertiesOptionsIO().addOption("ResourceIOTest",(Object)"kya");

	}

}
