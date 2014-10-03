package com.github.gangz.util.shell;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.github.gangz.util.fs.FileUtil;

public class ShellCommandTest {

	@Rule
	public TemporaryFolder testFolder= new TemporaryFolder();
	
	@Test
	public void test_shell_command() {
		Shell shell = new Shell();
		shell.invokeCmd("mkdir abc", null,testFolder.getRoot().getAbsolutePath());
		File f = new File(testFolder.getRoot().getAbsolutePath()+File.separator+"abc");
		assertTrue(f.exists());
		testFolder.delete();
	}
	
	@Test
	public void test_shell_command_with_file_output() throws IOException {
		Shell shell = new Shell();
		String testFile = testFolder.getRoot().getAbsolutePath()+File.separator+"content";
		String logFile = testFolder.getRoot().getAbsolutePath()+File.separator+"log";
		FileUtil.writeContentToFile(new File(testFile), "a test file");
		shell.invokeCmd("cat content" , logFile,testFolder.getRoot().getAbsolutePath());
		File f = new File(logFile);
		assertEquals("a test file\n",FileUtil.readFileToString(f));
		testFolder.delete();
	}

}
