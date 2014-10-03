package com.github.gangz.util.shell;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Class for console simulation
 */
public class ConsoleSimulator implements Runnable {
	private volatile boolean isStop = false;

	public static final int INFO = 0;
	public static final int ERROR = 1;

	private InputStream is;

	private int type;

	private OutputWriter output = null;

	public ConsoleSimulator(InputStream is, int type, String outputFilename) {
		this.is = is;
		this.type = type;
		if (outputFilename==null)
			output = new OutputNullWriter();
		else
			output = new OutputFileWriter(outputFilename);
	}

	public void run() {
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader reader = new BufferedReader(isr);
		String s;
		try {
			while ((!isStop) && (s = reader.readLine()) != null) {
				if (s.length() != 0) {
					if (type == INFO) {
						System.out.println(s);
					} else {
						System.err.println(s);
					}
					if (output!=null)
					{
						output.write(s);
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			}
			stop();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void stop() {
		isStop = true;
		output.close();
	}
}