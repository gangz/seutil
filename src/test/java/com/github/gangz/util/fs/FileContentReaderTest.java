package com.github.gangz.util.fs;
import java.io.*;

import org.junit.*;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FileContentReaderTest {
	@Rule
	public TemporaryFolder testFolder= new TemporaryFolder();
	    
	public File createFile() throws IOException{
		File file = testFolder.newFile("file_0");
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write("Line 1\n");
        out.write("Line 2\n");
        out.close();
		return file;
	}
	
	public void removeFiles(){
		testFolder.delete();
	}
	
	@Test
	public void should_visit_every_files() throws IOException{
		String content = FileUtil.readFileToString(createFile());
		assertEquals("Line 1\nLine 2\n",content);
		removeFiles();
	}
}
