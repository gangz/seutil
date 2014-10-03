package com.github.gangz.util.shell;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFileWriter implements OutputWriter{
	FileWriter writer;
	String filename;
	public OutputFileWriter(final String filename) {
		this.filename=filename;
		startWrite();
	}
	public void startWrite() {
		try {
			File file = new File(filename);
			writer = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
	public void close(){
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void write(String string) {
		try {
			writer.write(string + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}	