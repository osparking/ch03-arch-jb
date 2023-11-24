package rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class RuleTester {
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	private static File createdFolder;
	private static File createdFile;

	@Test
	public void testTemporaryfolder() throws IOException {
		createdFolder = folder.newFolder("createdFolder");
		createdFile = folder.newFile("createdFile.txt");
		assertTrue(createdFolder.exists());
		assertTrue(createdFile.exists());
	}
	
	@AfterClass
	public static void cleanUpAfterAllTestsRan() {
		assertFalse(createdFolder.exists());
		assertFalse(createdFile.exists());
	}
}
