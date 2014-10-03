package com.github.gangz.util.fs;

import java.io.File;

public class FileTraversal {
	IFileVisitor visitor;
	public FileTraversal(IFileVisitor visitor){
		this.visitor = visitor;
	}

	public void travers(String path) {
		File dir = new File(path);
		travers(dir);
	}

	public void travers(File root) {
		File[] files = root.listFiles();

		if (files == null)
			return;
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				travers(files[i]);
			} else {
				visitor.visit(files[i]);
			}
		}		
	}

}