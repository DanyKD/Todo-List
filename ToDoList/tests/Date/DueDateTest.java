package Date;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Todoly.Inputs;

class DueDateTest {
	
	private ByteArrayInputStream ba;
	private InputStream originalIn;
	
	private DueDate date1;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		originalIn = System.in;
		
		date1 = new DueDate();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setIn(originalIn);
	}


	@Test
	void testGetDue() {
		
		Calendar cal=Calendar.getInstance();
		cal.set(2010, 9, 13,0,0,0);
		String inputs = "13\n" +
		        "10\n" +
		        "2010\n";
		ba = new ByteArrayInputStream(inputs.getBytes());
		System.setIn(ba);
		Inputs in1 = new Inputs();
		DueDate dd = date1.setDue(in1);
		assertEquals(cal.get(Calendar.DAY_OF_MONTH),dd.getDue().get(Calendar.DAY_OF_MONTH));
		assertEquals(cal.get(Calendar.MONTH),dd.getDue().get(Calendar.MONTH));
		assertEquals(cal.get(Calendar.YEAR),dd.getDue().get(Calendar.YEAR));
	}

	@Test
	void testSetDueWrongDate() throws UnsupportedEncodingException {
		String inputs = "fasfaf\n" +
				        "10\n" +
				        "2010\n" + 
				        "13\n" +
				        "10\n" +
				        "2010\n";
		ba = new ByteArrayInputStream(inputs.getBytes());
		System.setIn(ba);
		Inputs in1 = new Inputs();
		DueDate dd = date1.setDue(in1);
		int day = dd.getDue().get(Calendar.DAY_OF_MONTH);
		int month = dd.getDue().get(Calendar.MONTH);
		int year = dd.getDue().get(Calendar.YEAR);
		assertEquals(13, day);
		assertEquals(10, month+1);
		assertEquals(2010, year);
	}
	
	@Test
	void testSetDueCorrectDate() throws UnsupportedEncodingException {
		String inputs = "13\n" +
				        "10\n" +
				        "2010\n";
		ba = new ByteArrayInputStream(inputs.getBytes());
		System.setIn(ba);
		Inputs in1 = new Inputs();
		DueDate dd = date1.setDue(in1);
		int day = dd.getDue().get(Calendar.DAY_OF_MONTH);
		int month = dd.getDue().get(Calendar.MONTH);
		int year = dd.getDue().get(Calendar.YEAR);
		assertEquals(13, day);
		assertEquals(10, month+1);
		assertEquals(2010, year);
	}

	@Test
	void testIsDue() {
		
	}

	@Test
	void testCorrectToString() {
		String d="10-12-2015";
		String inputs = "10\n" +
		        "12\n" +
		        "2015\n";
		ba = new ByteArrayInputStream(inputs.getBytes());
		System.setIn(ba);
		Inputs in1 = new Inputs();
		DueDate dd = date1.setDue(in1);
		assertEquals(d, dd.toString());
	}
	
	@Test
	void testCorrectCompareTo() {
		
		DueDate date2=new DueDate();
		
		assertEquals(0,date1.compareTo(date2));
	}
	@Test
	void testCompareToBigger() {
		
		DueDate date2=new DueDate();
		String inputs = "10\n" +
		        "12\n" +
		        "2018\n";
		ba = new ByteArrayInputStream(inputs.getBytes());
		System.setIn(ba);
		Inputs in1 = new Inputs();
		DueDate dd = date1.setDue(in1);
		
		assertEquals(1,date1.compareTo(date2));
	}

	@Test
	void testCompareToSmaller() {
		
		DueDate date2=new DueDate();
		String inputs = "10\n" +
		        "10\n" +
		        "2010\n";
		ba = new ByteArrayInputStream(inputs.getBytes());
		System.setIn(ba);
		Inputs in1 = new Inputs();
		DueDate dd = date1.setDue(in1);
		
		assertEquals(-1,date1.compareTo(date2));
	}

}
