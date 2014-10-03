package com.github.gangz.util.fs;
import java.io.*;

import org.junit.*;
import org.junit.rules.TemporaryFolder;

import static org.mockito.Mockito.*;

public class FileTraversalTest {
	@Rule
	public TemporaryFolder testFolder= new TemporaryFolder();
	    
	public void createFiles() throws IOException{
		File folder_1 = testFolder.newFolder("dir_1");
		File folder_2 = testFolder.newFolder("dir_2");
		testFolder.newFile("file_0");
		DirUtil.createFile(folder_1,"file_1_1");
		DirUtil.createFile(folder_2,"file_2_1");
	}
	
	public void removeFiles(){
		testFolder.delete();
	}
	
	@Test
	public void should_visit_every_files() throws IOException{
		createFiles();
		
		IFileVisitor visitor = mock(IFileVisitor.class);
		FileTraversal fileTrav = new FileTraversal(visitor);
		fileTrav.travers(testFolder.getRoot());
		
		verify(visitor,times(3)).visit((File)any());
		
		removeFiles();
	}
}
