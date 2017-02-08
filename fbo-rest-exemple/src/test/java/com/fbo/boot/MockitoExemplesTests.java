package com.fbo.boot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoExemplesTests {
	@Mock
	private  List mockedList;

	@Test
	public void iterator_will_return_hello_world() {
	// arrange
	final Iterator i = mock(Iterator.class);
	when(i.next()).thenReturn("Hello").thenReturn("World");
	// act
	final String result = i.next() + " " + i.next();
	// assert
	assertEquals("Hello World", result);
	}

	@Test
	public void with_arguments() {
	final Comparable c = mock(Comparable.class);
	when(c.compareTo("Test")).thenReturn(1);
	assertEquals(1, c.compareTo("Test"));
	}

	@Test
	public void with_unspecified_arguments() {
	final Comparable c = mock(Comparable.class);
	when(c.compareTo(anyInt())).thenReturn(-1);
	assertEquals(-1, c.compareTo(5));
	}

	@Test
	public void whenCreateMock_thenCreated() {

	mockedList.add("one");
	Mockito.verify(mockedList).add("one");

	assertEquals(0, mockedList.size());
	}

	@Spy
	List<String> spyList = new ArrayList<String>();

	@Test
	public void whenUsingTheSpyAnnotation_thenObjectIsSpied() {
	MockitoAnnotations.initMocks(this);
	spyList.add("one");
	spyList.add("two");
	spyList.add("three");

	Mockito.verify(spyList).add("one");
	Mockito.verify(spyList).add("two");
	Mockito.verify(spyList).add("three");

	assertEquals(3, spyList.size());
	}

}
