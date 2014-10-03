package com.github.gangz.util.fs;

import java.io.*;

public class FileUtil {
	public static String readFileToString(File file) throws IOException {
		
		StringBuffer buffer = new StringBuffer();
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while (null != (line = in.readLine())) {
			buffer.append(line + '\n');
		}
		in.close();
		return buffer.toString();		
	}

	public static void writeContentToFile(File file, String contents) throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write(contents);
        out.close();
	}
}
