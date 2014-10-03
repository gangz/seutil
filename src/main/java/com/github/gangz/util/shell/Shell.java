package com.github.gangz.util.shell;
import java.io.File;
import java.io.InputStream;
public class Shell {
	public int invokeCmd(String cmd, String outputFilename, String workDir)  {
		Process child;
		int result =-1;
		try {
			child = Runtime.getRuntime().exec(cmd, null, new File(workDir));
		InputStream stdin = child.getInputStream(); //
		InputStream stderr = child.getErrorStream();
		Thread in = new Thread(new ConsoleSimulator(stdin, ConsoleSimulator.INFO, outputFilename));
		Thread err = new Thread(new ConsoleSimulator(stderr, ConsoleSimulator.ERROR, null));
		in.start();
		err.start();
		result = child.waitFor();
		in.join();
		err.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
