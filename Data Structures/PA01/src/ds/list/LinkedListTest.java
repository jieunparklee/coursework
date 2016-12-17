package ds.list;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
	
	private LinkedList<String> list;
	
	@Before
	public void setup() {
		this.list = new LinkedList<String>();
		this.list.insert(0, "hello");
		this.list.insert(1, "it's");
		this.list.insert(2, "me");
	}

	@Test
	public void testInsert() {
		list.insert(4, "was");
		System.out.println("testInsert");
		list.printer();
		assertTrue(true);
	}
	 @Test
	 public void testRemove() {
		 assertEquals("it's", list.remove(1));
		 System.out.println("testRemove");
		 list.printer();
		 assertNull(list.remove(2));
		 assertNull(list.remove(3));
	 }
	 @Test
	 public void testGetValue() {
		 assertNull(list.getValue(3));
		 assertNull(list.getValue(4));
		 System.out.println("testGetValue");
		 list.printer();
		 assertEquals("me", list.getValue(2));
	 }
}
