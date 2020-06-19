package com.diesgut.ecriptionfiles.misc;

import java.io.BufferedReader;
import java.io.FileReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {

	private static final Logger log = LoggerFactory.getLogger(Util.class);

	public static void printFile(String fileAbsolutePath) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileAbsolutePath));
			String line = br.readLine();

			while (line != null) {
				log.debug(line);
				// sb.append(System.lineSeparator());
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
