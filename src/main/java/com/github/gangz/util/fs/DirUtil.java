package com.github.gangz.util.fs;

import java.io.File;
import java.io.IOException;

public class DirUtil {

	public static File createSubDir(File parentFolder, String subDirName) {
		File file = new File(parentFolder.getAbsolutePath()+ File.separator + subDirName);
		if (file.exists()) return file;
		file.mkdirs();	
		return file;
	}
	
	public static File createFile(File parentFolder, String fileName) throws IOException{
		File file = new File(parentFolder.getAbsolutePath()+ File.separator + fileName);
		if (file.exists()) return file;
		file.createNewFile();
		return file;
	}

}
