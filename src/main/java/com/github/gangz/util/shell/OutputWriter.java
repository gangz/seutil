package com.github.gangz.util.shell;

public interface OutputWriter {
	public void startWrite();
	public void close();
	public void write(String string);
}
