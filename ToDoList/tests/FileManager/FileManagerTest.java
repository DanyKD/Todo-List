package FileManager;

import File.FileManager;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class FileManagerTest {
	FileManager f=new FileManager();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testWrongWrite() {
		String str="Dany";
		Object g = new Object();
		boolean bool=f.write(str, g);
		assertEquals(false,bool);
	}
	
	@Test
	void testCorrectWrite() {
		String str="/Users/tmp-sda-1188/Desktop/Dany.bin";
		String g = "My name is Dany";
		boolean bool=f.write(str, g);
		assertEquals(true,bool);
	}

	@Test
	void testWrongRead() {
		Object o=f.read("Dany");
		assertEquals(null,o);
	}

	@Test
	void testCorrectRead() {
		String str="/Users/tmp-sda-1188/Desktop/Dany.bin";
		Object o=f.read(str);
		assertEquals("My name is Dany",o);
	}
}
